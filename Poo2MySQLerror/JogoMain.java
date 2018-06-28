import javax.swing.JFrame;

public class JogoMain {
	public static void main(String[] args) {

		JogoDaMemoria jogo = new JogoDaMemoria();

		jogo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jogo.setLocationRelativeTo(null);
		jogo.setSize(570, 150);
		jogo.setVisible(true);

	}
}