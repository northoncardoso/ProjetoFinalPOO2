
public class Pontuacao {
		private String nome;
		private int pontuacao;
		private int colocacao;

		public Pontuacao(String nome, int pontuacao, int colocacao) {
			this.nome = nome;
			this.pontuacao = pontuacao;
			this.colocacao = colocacao;
		}

		public String getNome() {
			return nome;
		}

		public int getPontuacao() {
			return pontuacao;
		}

		public int getColocacao() {
			return colocacao;
		}

	}