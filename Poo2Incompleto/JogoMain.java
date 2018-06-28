import javax.swing.JFrame;

public class JogoMain {
public static void main(String[] args) {
	
//	JogoDaMemoria jogo = new JogoDaMemoria();
//
//	jogo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//	jogo.setLocationRelativeTo(null);
//	jogo.setSize(570,150);
//	jogo.setVisible(true);
	
	PontuacaoFrame frame = new PontuacaoFrame();

	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setSize(570,150);
	frame.setVisible(true);
	
	}

	//ao final do jogo, adicionar o jogador na tabela
	// tanto com o final do tempo, quanto com a pontuação maxima/todas as cartas viradas
}