import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//classe de conexao JDBC MySQL Jogo da Memória
public class JavaDataBaseConnectivity {

	private Connection connect = null; //conexao

	public JavaDataBaseConnectivity() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
		// Setup the connection with the DB
		connect = DriverManager.getConnection("jdbc:mysql://localhost/Score", "sqluser", "usuario");
	}

	//fechar conexao
	public void close() throws SQLException {
		if (connect != null && !connect.isClosed()) {
			connect.close();
		}
	}
	
	// Inserir jogador e pontuacao( comandos MySQL(DataBase))
	public void insertBBBPontuacao(String player) {
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost/Score", "sqluser", "usuario");
			
			PreparedStatement stmt = connect
					.prepareStatement("UPDATE `tabelaScore` SET (`Jogador`) WHERE `Jogador`= `BBB`");
			stmt.setString(1, player);
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertPontuacao(String player, int pontuacao) {
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost/Score", "sqluser", "usuario");
			
			PreparedStatement stmt = connect
					.prepareStatement("INSERT INTO `tabelaScore`(`Jogador`, `Pontuacao`) VALUES (?, ?)");
			stmt.setString(1,player);
			stmt.setInt(2,pontuacao);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//lista de top10 pontuacao
	public List<ListPontuacao> getTop10() {
		
		// nova list para guardar a tabela
		List<ListPontuacao> list = new ArrayList<>();
		
		try { // organizar a pontuacao em decrescente 
			PreparedStatement stmt = connect.prepareStatement(
					"SELECT `Jogador`, `Pontuacao` FROM `tabelaScore` ORDER BY `Pontuacao` DESC LIMIT 10;");
			
			ResultSet result = stmt.executeQuery();
			int colocacao = 1;
			while (result.next()) {
				String jogador = result.getString("Jogador");
				int pontos = result.getInt("Pontuacao");
				//lista add a nova pontuacao com nome do jogador, os pontos e a sua colocacao
				list.add(new ListPontuacao(jogador, pontos, colocacao));
				colocacao++;
			}
			result.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}	
}
