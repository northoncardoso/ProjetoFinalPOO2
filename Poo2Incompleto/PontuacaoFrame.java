import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PontuacaoFrame extends JFrame {

	private JPanel panel;
	private JTextField field;
	private JTextArea area;
	private JButton confirmar;

	JavaDataBaseConnectivity connect;

	public PontuacaoFrame() {
		super("Fim do jogo");
		setLayout(new FlowLayout());
		
		try {
			connect = new JavaDataBaseConnectivity();

		} catch (Exception f) {
			// TODO: handle exception
		}

		
		panel = new JPanel();
		field = new JTextField("Insira seu nome de jogador (apenas 3 caracteres)");
		add(panel);
		panel.add(field);

		confirmar = new JButton("Confirmar Nome");

		area = new JTextArea();
		panel.add(area);
		
		for (int j = 0; j < 1; j++) {

			confirmar.setFont(new Font("Arial", Font.BOLD, 20));
			confirmar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					// facilitacao de codigo
					Object source = e.getSource();
					JButton button = (JButton) source;

					// confirmar.setText("Confirmar Nome");
					if (button.getText().equals("Confirmar Nome")) {
						gamer = nome.getText();

						connect.insertPontuacao(gamer, 0);

					}

				}
			});

		}
	}

}
