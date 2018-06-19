import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;	

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//math.random();

public class JogoDaMemoria extends JFrame {
	
	//criar uma matriz pra fazer as cartas nos lugares 
	
	private JLabel text0;
	private JButton[] lvls;
	private String[] lvlstring = {"Level 1" , "Level 2", "Level 3"};
	private JPanel buttonsJPanel;
	private JPanel organizaText0;
	
	public JogoDaMemoria() {
		super("Jogo da Memória");
		setLayout(new FlowLayout());

		text0 = new JLabel("Escolha um nivel de dificuldade para jogar o Jogo da Memória: ");
		add(text0);
		
		lvls = new JButton[lvlstring.length];

		organizaText0 = new JPanel();
		buttonsJPanel = new JPanel();
		
		organizaText0.setLayout(new GridLayout(1,0));
		buttonsJPanel.setLayout(new FlowLayout());
		
		//organizaText0.setBackground(Color.white);
		//buttonsJPanel.setBackground(Color.white);
		
		organizaText0.add(text0, BorderLayout.WEST);
		add(organizaText0,BorderLayout.NORTH);
		add(buttonsJPanel,BorderLayout.CENTER);
		
		
		
		for( int i = 0; i < lvlstring.length; i++) { //Fazendo os botoes
			
			lvls[i] = new JButton(lvlstring[i]);
			lvls[i].setFont(new Font("Arial", Font.BOLD,20));
			lvls[i].addActionListener(new ActionListener() { // dar ação aos botoes
				@Override
				public void actionPerformed(ActionEvent e) {
					Object source = e.getSource();
					JButton button = (JButton)source;
				
					if(button.getText().equals("Level 1")) { //nivel um 
						System.out.println("Level 1 selecionado");
						
						LevelUm um = new LevelUm();
						um.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						um.setLocationRelativeTo(null);
						um.setSize(700,600);
						um.setVisible(true);
					}
					if(button.getText().equals("Level 2")) { // nivel 2
						System.out.println("Level 2 selecionado");
					}
					if(button.getText().equals("Level 3")) { // nivel 3
						System.out.println("Level 3 selecionado");
					}
					
					}//end ActionPerformed
				});//End ActionListener JButtons
			
			buttonsJPanel.add(lvls[i]); // adicionar botoes no grupo JPanel
			
			}//end for JButtons
		}//end constructor
	}//final end
		
//fazer o botao virar
		
	


