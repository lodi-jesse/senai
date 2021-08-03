package lojasnews;

public class Produto {

	private static Long contadorCodigo = 1l;
	
	private Long codigo;
	private String nome;
	private double preco;
	private int quantidadeEstoque;

	public Produto() {

	}

	public Produto(String nome, double preco, int quantidadeEstoque) {
		if (nome.isBlank() || preco < 0 || quantidadeEstoque < 0) {
			System.out.println("Produto Inv�lido");
		} else {
			this.nome = nome;
			this.preco = preco;
			this.quantidadeEstoque = quantidadeEstoque;
			this.codigo = contadorCodigo;
			contadorCodigo += 1;
		}
	}

	public Long getCodigo() {
		return codigo;
	}

	protected void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.isBlank()) {
			System.out.println("Nome inv�lido");
			return;
		} else
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco <= 0) {
			System.out.println("Pre�o inv�lido");
			return;
		} else
			this.preco = preco;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		if (quantidadeEstoque < 0) {
			System.out.println("Quantidade de Estoque Inv�lida");
			return;
		} else
			this.quantidadeEstoque = quantidadeEstoque;
	}

}
