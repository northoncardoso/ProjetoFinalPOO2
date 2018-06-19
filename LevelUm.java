import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelUm extends JFrame {
	// declarações

	private int pontuacao;
	private JButton[] bbotoes;
	private JLabel score;
	private JLabel tempo;
	private JPanel panelcima = new JPanel();
	private JPanel buttonsPanel = new JPanel();
	private int counter = 180;
	private boolean botaoclicado = false;
	private boolean running = true;
	private boolean virar = true;

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

	// tempo de jogo
	private Thread trdTempo = new Thread(new Runnable() {
		@Override
		public void run() {
			while (running) {
				//System.out.println(counter + " segundos");
				tempo.setText(Integer.toString(counter));
				counter--;
				
					if(counter == 178) { 
					for (int i = 0; i < imgs.length; i++) {
						bbotoes[i].setIcon(botaoInterrogacao);
						System.out.println("entrando");
					}
				}
				if (counter < 0)
					running = false;
				try {
					Thread.sleep(1000); // um segundo
				} catch (Exception e) {
				}
			}
		}
	});// end Thread

	private Thread trdScore = new Thread(new Runnable() {
		@Override
		public void run() {
			while (running) {
				score.setText(Integer.toString(pontuacao));
				if (botaoclicado)
					pontuacao += 20;

			}
		}
	});

	public LevelUm() {
		super("Jogo da Memória - Facil");
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
			System.out.println("" + imgs[i]);
		}

		List<Icon> list = Arrays.asList(imgs);
		Collections.shuffle(list);
		// embaralhando a matriz

		trdTempo.start();
		trdScore.start();

		// tamanho dos botoes
		bbotoes = new JButton[imgs.length];

		// tempo
		for (int j = 0; j < counter; j++) {
			tempo.setText("" + counter);
			getContentPane();

		}
		
		for (int i = 0; i < 16; i++) {
			bbotoes[i] = new JButton(imgs[i]); // icons
			bbotoes[i].setActionCommand(i + "");
			bbotoes[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					int id = Integer.parseInt(cmd);
					System.out.println(id + "");

					if (virar) {// botaointerrogacao
						((JButton) e.getSource()).setIcon(botaoInterrogacao);
						virar = false;

					} else { // n esta retornando

						((JButton) e.getSource()).setIcon(imgs[id]);

						virar = !virar;
					}

					if (((JButton) e.getSource()).equals(imgs[id])) {
						// ((JButton) imgs[id]).setIcon();
						System.out.println("É o mesmo");
					}

					// imagem selecionada
					// System.out.println("" + imgs[id]);
				}
			});

			buttonsPanel.add(bbotoes[i]);
		}
		

	}// end construtor

	private void pontuar(int pontuacao) { // clicar no botao
		this.pontuacao = pontuacao;

		score.setText(Integer.toString(pontuacao));
		score.setBackground(Color.RED); // fail
	}
}// end class

// for (int i = 0; i < matriz.length; i++) {
// for (int j = 0; j < matriz[i].length; j++) { // populou a matriz com Random
//
// // for(int q = 0; q < 15; q++) {
// // IconNum obj = new IconNum(imgs[q], q); //colocar numero para cada carta
// // arrayIconNum[q] = obj; // 10 + 10 = 20/2 = 10
// // }
// }
// }
