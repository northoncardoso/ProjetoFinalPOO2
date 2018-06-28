import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PontuacaoFrame extends JFrame {

	private JTextArea nome;
	private JButton confirmarButton;
	private JLabel inserirNome;
	private JPanel areaBaixo;
	private JPanel areaCima;
	List<ListPontuacao> list = null;
	
	private String gamer;

	JavaDataBaseConnectivity connect;

	public PontuacaoFrame() {
		super("Fim do jogo");
		setLayout(new BorderLayout());
		
		//conexao DB
		try {
			connect = new JavaDataBaseConnectivity();
			list = connect.getTop10();

		} catch (Exception f) {
			// TODO: handle exception
		}
		
		inserirNome = new JLabel("Insira o nome do Jogador: ");
		confirmarButton = new JButton("Confirmar Nome");
		nome = new JTextArea("AAA");
		areaBaixo = new JPanel();
		areaCima = new JPanel();
		
		inserirNome.setLayout(new FlowLayout());
		
		areaCima.add(inserirNome);
		areaBaixo.add(nome);
		areaBaixo.add(confirmarButton);
		add(areaBaixo, BorderLayout.CENTER);
		add(areaCima, BorderLayout.NORTH);

		System.out.println("Top 10 selecionado");

		
		for (int j = 0; j < 1; j++) {

			confirmarButton.setFont(new Font("Arial", Font.BOLD, 20));
			confirmarButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					// facilitacao de codigo
					Object source = e.getSource();
					JButton button = (JButton) source;

					if (button.getText().equals("Confirmar Nome")) {
						gamer = nome.getText();
						connect.insertBBBPontuacao(gamer);
						
						if (list != null)
							for (ListPontuacao p : list) {
								System.out.println(
										p.getColocacao() + "º lugar - " + p.getNome() + " - Pts: " + p.getPontuacao());
							}
						
						

					}

				}
			});

		}
	}

}
