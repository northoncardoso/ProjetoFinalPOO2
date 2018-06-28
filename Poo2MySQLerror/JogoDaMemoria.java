import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JogoDaMemoria extends JFrame {

	private JLabel text0;
	private JButton[] lvls;
	private String[] lvlstring = { "Level 1", "Level 2", "Level 3", "Top 10" };
	private JPanel buttonsJPanel;
	private JPanel organizaText0;

	JavaDataBaseConnectivity connect;

	public JogoDaMemoria() {
		super("Jogo da Memória");
		setLayout(new FlowLayout());

		try {
			connect = new JavaDataBaseConnectivity();

		} catch (Exception f) {
			// TODO: handle exception
		}

		// organizando e criando panels

		lvls = new JButton[lvlstring.length];

		text0 = new JLabel("Escolha um nivel de dificuldade para jogar o Jogo da Memória ou veja o Top10: ");
		add(text0);

		organizaText0 = new JPanel();
		buttonsJPanel = new JPanel();

		organizaText0.setLayout(new GridLayout(1, 0));
		buttonsJPanel.setLayout(new FlowLayout());

		organizaText0.add(text0, BorderLayout.WEST);

		add(organizaText0, BorderLayout.NORTH);
		add(buttonsJPanel, BorderLayout.CENTER);

		for (int i = 0; i < lvlstring.length; i++) { // Fazendo os botoes

			lvls[i] = new JButton(lvlstring[i]);
			lvls[i].setFont(new Font("Arial", Font.BOLD, 20));
			lvls[i].addActionListener(new ActionListener() { // dar ação aos botoes
				@Override
				public void actionPerformed(ActionEvent e) {

					// facilitacao de codigo
					Object source = e.getSource();
					JButton button = (JButton) source;

					// nivel 1
					if (button.getText().equals("Level 1")) {
						System.out.println("Level 1 selecionado");

						LevelUm um = new LevelUm();
						um.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						um.setLocationRelativeTo(null);
						um.setSize(700, 600);
						um.setVisible(true);

					} // nivel 2
					if (button.getText().equals("Level 2")) {
						System.out.println("Level 2 selecionado");

						LevelDois dois = new LevelDois();
						dois.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						dois.setLocationRelativeTo(null);
						dois.setSize(700, 600);
						dois.setVisible(true);

					} // nivel 3
					if (button.getText().equals("Level 3")) {
						System.out.println("Level 3 selecionado");

						LevelTres tres = new LevelTres();
						tres.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						tres.setLocationRelativeTo(null);
						tres.setSize(700, 600);
						tres.setVisible(true);

					} // TOP 10
					if (button.getText().equals("Top 10")) {
						System.out.println("Top 10 selecionado");

						List<ListPontuacao> list = null;
						try {
							list = connect.getTop10();

							connect.close();
						} catch (Exception f) {
							// TODO: handle exception
						}
						if (list != null)
							for (ListPontuacao p : list) {
								System.out.println(
										p.getColocacao() + "º lugar - " + p.getNome() + " - Pts: " + p.getPontuacao());
							}
					}

				}// end ActionPerformed
			});// End ActionListener JButtons

			buttonsJPanel.add(lvls[i]); // adicionar botoes no grupo JPanel

		} // end for JButtons
	}// end constructor
}// final end
