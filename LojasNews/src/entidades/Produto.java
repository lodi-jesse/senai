package entidades;

import java.security.InvalidParameterException;

public class Produto {

	private static Long contadorCodigo = 1l;
	private Long codigo;

	private String nome;
	private double preco;

	public Produto() {

	}

	public Produto(String nome, double preco) {
		if (nome.isBlank() || preco < 0)
			throw new InvalidParameterException("Atributo(s) inv�lido(s)");
		else {
			this.nome = nome;
			this.preco = preco;
			codigo = contadorCodigo;
			contadorCodigo += 1l;
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
		if (nome.isBlank())
			throw new InvalidParameterException("Nome do produto \"" + this.nome + "\" � inv�lido");
		else
			this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco <= 0)
			throw new InvalidParameterException("Pre�o do produto \"" + this.nome + "\" � inv�lido");
		else
			this.preco = preco;
	}

	public void aplicarDesconto(double desconto) {
		if (desconto > 100 || desconto <= 0)
			throw new InvalidParameterException("Desconto para o produto \"" + this.nome + "\" � inv�lido");
		else
			preco *= (desconto / 100);
	}

}
