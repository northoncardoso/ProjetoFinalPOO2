import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class JogoMain {
public static void main(String[] args) {
	
	
	
	JogoDaMemoria jogo = new JogoDaMemoria();
	jogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jogo.setLocationRelativeTo(null);
	jogo.setSize(450,80);
	jogo.setVisible(true);
	

	

	}
}
// GUARDANDO
//bbotoes = new JButton[icons.length];
//
//final String[] imgs = new String[coloridas.length * 2]; // duplicou o numero de imagens
//for (int i = 0; i < coloridas.length; i++) {
//	imgs[i] = coloridas[i];
//	imgs[coloridas.length + i] = coloridas[i];
//}
//
//Random r = new Random();
//for (int i = 0; i < matriz.length; i++) {
//	for (int j = 0; j < matriz[i].length; j++) { // populou a matriz com Random
//
//		int max = imgs.length - (i * matriz[i].length) - j;
//		int value = r.nextInt(max);
//		matriz[i][j] = imgs[value];
//		String aux = imgs[max - 1];
//		imgs[max - 1] = imgs[value];
//		imgs[value] = aux;
//	}
//}
//for (int i = 0; i < matriz.length; i++) {
//	for (int j = 0; j < matriz[i].length; j++) {
//		System.out.print(matriz[i][j] + " ");
//	}
//	System.out.println();
//}
//
//trd.start();
//
//for (int i = 0; i < icons.length; i++) {
//	// fazer a imagem virar e ter outra imagem
//	// fazer o botao virar contendo uma imagem de cada lado7
//	//usando o metodo virar do grid exemplo professora
//	
//	bbotoes[i] = new JButton(imgs[i]);
//	bbotoes[i].setActionCommand("" + i);
//	bbotoes[i].addActionListener(new ActionListener() {
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			String cmd = e.getActionCommand();
//			int id = Integer.parseInt(cmd);
//
//			if (virar) {
//				((JButton) e.getSource()).setIcon(botoesInterrogacao);
//			} else {
//				((JButton) e.getSource()).setIcon(new ImageIcon(getClass().getResource(coloridas[id])));
//				virar = !virar;
//
//			}
//		}
//	});// end Listener
//} // end for