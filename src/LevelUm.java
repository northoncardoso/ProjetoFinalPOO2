import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelUm extends JFrame {
	// preciso aprender a fazer um array de imagens e implementar as imagens por um
	// for + random position

	//declarações 

	private double pontuacao;
	private Random randonn = new Random();

	private JButton[] bbotoes;																				  
	private JLabel score;
	private JLabel tempo;
	private JPanel panelcima = new JPanel();
	private JPanel buttonsPanel = new JPanel();
	private int counter = 300;
	private boolean running = true;
	private boolean virar = true;

	private Icon[][] matriz = new Icon[4][4];
	private String[] stringImgs = { "powerosas.jpg", "ben.jpg", "pony.png", "winx.jpg", "bravo.jpg", "coragem.jpg",
								   "trol.png", "jake.gif" };
	
	private Icon[] icons = { new ImageIcon(getClass().getResource(stringImgs[0])),
							 new ImageIcon(getClass().getResource(stringImgs[1])), 
							 new ImageIcon(getClass().getResource(stringImgs[2])),
							 new ImageIcon(getClass().getResource(stringImgs[3])) };
	
	private ImageIcon botoesInterrogacao = new ImageIcon(getClass().getResource("ponti.jpg"));	
	private IconNum[] arrayIconNum = new IconNum[16];

	
	
	//tempo de jogo 
	private Thread trdTempo = new Thread(new Runnable() { 
		@Override
		public void run() {
			while (running) {
				// set text no label de contador
				//System.out.println(counter + " segundos");
				tempo.setText(Integer.toString(counter));
				counter--;
				if (counter < 0)
					running = false;
				try {
					Thread.sleep(1000); // um segundo
				} catch (Exception e) {
				}
			}
		}
	});//end Thread
	
//	private void pontuar(int pontuacao) {			 //clicar no botao
//		this.pontuacao = pontuacao;
//		
//		score.setText(Integer.toString(pontuacao));
//	}
	public LevelUm() {
		super("Jogo da Memória - Facil");
		setLayout(new BorderLayout());
		
		score = new JLabel(); 							//fazer o score/ sistema de pontuação
		tempo = new JLabel();
		
		for( int j = 0; j < counter; j++) {
			tempo.setText("" + counter);
			getContentPane();

		}
		
		panelcima = new JPanel();
		buttonsPanel = new JPanel();
														//borderlayout
		panelcima.setLayout(new BorderLayout(1, 0)); 		// ainda nao arrumei o layout certo
		panelcima.setLayout(new BorderLayout(1, 0));	//por que nao funcionou os botoes para eu ver
		
		panelcima.add(tempo, BorderLayout.WEST);		//arrumando os layouts
		panelcima.add(score,BorderLayout.EAST);
		
		add(panelcima,BorderLayout.NORTH);
		add(buttonsPanel,BorderLayout.CENTER); 			//.center

		
		trdTempo.start();
		
		final Icon[] imgs = new Icon[icons.length * 2]; // duplicou o numero de imagens //string\\
		for (int i = 0; i < icons.length; i++) {
			imgs[i] = icons[i];										//mudei imgs de string para icons
			imgs[icons.length + i] = icons[i];
		}
		
		Random r = new Random();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) { // populou a matriz com Random
														 // existe um método chamado shuffle para isso
				
				for(int q = 0; q < 15; q++) {
					IconNum obj = new IconNum(imgs[q], q); //colocar numero para cada carta
					arrayIconNum[q] = obj;				   // 10 + 10 = 20/2 = 10
				}
		
				int max = imgs.length - (i * matriz[i].length) - j;
				int value = r.nextInt(max);
				matriz[i][j] = imgs[value];							//mudei matriz de String para Icon, aux tbm
				Icon aux = imgs[max - 1];
				imgs[max - 1] = imgs[value];
				imgs[value] = aux;
			}
		}
		for (int i = 0; i < matriz.length; i++) { 		//matriz de icones
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.	out.println();  // vendo se a matriz funciona
		}
		
		trdTempo.start();
		bbotoes = new JButton[imgs.length];
		
		for (int i = 0; i < imgs.length; i++) { //imgs.length
			// fazer a imagem virar e ter outra imagem
			// fazer o botao virar contendo uma imagem de cada lado
			// um lado com imagem "?" e outra com imagem para acertar
			//usando o metodo virar do grid, exemplo de slide da professora
			
			bbotoes[i] = new JButton(imgs[i]);
			//bbotoes[i].setActionCommand("" + i);
			bbotoes[i].addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					int id = Integer.parseInt(cmd);
		
					if (virar) {
						((JButton) e.getSource()).setIcon(botoesInterrogacao);
					} else {
						((JButton) e.getSource()).setIcon(new ImageIcon(getClass().getResource(imgs[id])));//recurso imagens?
																										  //de onde pego as imagens agora?
						virar = !virar;
		
					}
				}
			});// end Listener
			buttonsPanel.add(bbotoes[i]); // adicionando os botoes no
										  // panel de baixo 
			
		} // end for
		
	}// end construtor

}// end class


// tentando pegar as imagens direto do diretorio
//// String src = "";
//// java.io.File diretorio = new java.io.File(src);
//// String[] templates = diretorio.list();
//// ImageIcon[] icons = new ImageIcon[templates.length];
//// LevelUm[] listaImagens = new LevelUm[templates.length];
