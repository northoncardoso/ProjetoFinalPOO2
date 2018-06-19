import javax.swing.JFrame;

public class JogoMain {
public static void main(String[] args) {
	
	JogoDaMemoria jogo = new JogoDaMemoria();
	jogo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	jogo.setLocationRelativeTo(null);
	jogo.setSize(450,80);
	jogo.setVisible(true);
	}
}