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
			System.out.println("Produto Inválido");
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
			System.out.println("Nome inválido");
			return;
		} else
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco <= 0) {
			System.out.println("Preço inválido");
			return;
		} else
			this.preco = preco;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		if (quantidadeEstoque < 0) {
			System.out.println("Quantidade de Estoque Inválida");
			return;
		} else
			this.quantidadeEstoque = quantidadeEstoque;
	}

}
