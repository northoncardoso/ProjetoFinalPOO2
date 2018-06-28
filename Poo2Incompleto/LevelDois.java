import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LevelDois extends JFrame {
	// declarações

	private int pontuacao;
	private JButton[] bbotoes;
	private JLabel score;
	private JLabel tempo;
	private JPanel panelcima = new JPanel();
	private JPanel buttonsPanel = new JPanel();
	private int counter = 180;
	private boolean running = true;

	final Icon[] imgs;

	private String[] stringImgs = { "powerosas.jpg", "ben.jpg", "pony.png", "winx.jpg", "bravo.jpg", "coragem.jpg",
			"trol.png", "show.jpg" };

	private Icon[] icons = { new ImageIcon(getClass().getResource(stringImgs[0])),
			new ImageIcon(getClass().getResource(stringImgs[1])), new ImageIcon(getClass().getResource(stringImgs[2])),
			new ImageIcon(getClass().getResource(stringImgs[3])), new ImageIcon(getClass().getResource(stringImgs[4])),
			new ImageIcon(getClass().getResource(stringImgs[5])), new ImageIcon(getClass().getResource(stringImgs[6])),
			new ImageIcon(getClass().getResource(stringImgs[7])) };

	private String interrogacao = "ponti.jpg";
	private Icon botaoInterrogacao = new ImageIcon(getClass().getResource(interrogacao));
	private int posAbertas = -1;
	// tempo de jogo
	private Thread trdTempo = new Thread(new Runnable() {
		@Override
		public void run() {
			while (running) {
				tempo.setText(Integer.toString(counter));
				counter--;

				// fechar as imagens dps de 2 segundos
				if (counter == 178) {
					for (int i = 0; i < imgs.length; i++) {
						bbotoes[i].setIcon(botaoInterrogacao);
					}
				}
				// se acabar o tempo, rodarTempo = 0;
				if (counter < 0)
					running = false;
				// se rodarTempo = 0, a janela "fecha"
				if (running == false) {
					setVisible(false);
				}
				try {
					Thread.sleep(1000); // um segundo
				} catch (Exception e) {
				}
			}
		}
	});// end Thread

	// pontuacao rodando com o jogo
	private Thread trdScore = new Thread(new Runnable() {
		@Override
		public void run() {
			while (running)
				score.setText(Integer.toString(pontuacao));
		}

	});

	public LevelDois() {
		super("Jogo da Memória - Médio");
		setLayout(new BorderLayout());

		score = new JLabel();
		tempo = new JLabel();

		// arrumando os layouts

		panelcima = new JPanel();
		buttonsPanel = new JPanel();
		panelcima.setLayout(new BorderLayout(1, 0));
		panelcima.setLayout(new BorderLayout(1, 0));
		panelcima.add(tempo, BorderLayout.WEST);
		panelcima.add(score, BorderLayout.EAST);
		add(panelcima, BorderLayout.NORTH);
		add(buttonsPanel, BorderLayout.CENTER);

		// duplicar icons
		imgs = new Icon[icons.length * 2];

		for (int i = 0; i < 8; i++) { // populando icons[]
			imgs[i] = icons[i];
			// adicionar um int para identificar cada imagem
			imgs[i + 8] = icons[i];
			// System.out.println("" + imgs[i]);
		}

		List<Icon> list = Arrays.asList(imgs);
		// embaralhando a matriz
		Collections.shuffle(list);

		// startando as Threads
		trdTempo.start();
		trdScore.start();

		// tamanho dos botoes
		bbotoes = new JButton[imgs.length];

		// tempo
		for (int j = 0; j < counter; j++) {
			tempo.setText("" + counter);
			getContentPane();

		}

		// adicionando os botoes
		for (int i = 0; i < 16; i++) {
			bbotoes[i] = new JButton(imgs[i]); // icons
			bbotoes[i].setActionCommand(i + "");

			bbotoes[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					// facilitação de codigo

					String cmd = e.getActionCommand();
					JButton selecionado = ((JButton) e.getSource());

					int id = Integer.parseInt(cmd);
					selecionado.setIcon(imgs[id]);

					// imagem aberta (botao aberto)
					if (posAbertas < 0) {
						posAbertas = id;
					} else {
						JButton botaoAberto = bbotoes[posAbertas];
						if (imgs[id] == imgs[posAbertas]) {
							// Houve um acerto, mantem aberto
							pontuacao += 40;
						} else {
							// Houve um erro, fecha as duas
							// depois de 1 segundo
							Timer umSegundo = new Timer(1000, new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {

									selecionado.setIcon(botaoInterrogacao);
									botaoAberto.setIcon(botaoInterrogacao);
								}
							});
							umSegundo.setRepeats(false);
							umSegundo.start();
						}
						posAbertas = -1;
					}
				}
			});
			buttonsPanel.add(bbotoes[i]);
		}
	}// end construtor

	private void pontuar(int pontuacao) { 
		this.pontuacao = pontuacao;

		score.setText(Integer.toString(pontuacao));
	}
}// end class