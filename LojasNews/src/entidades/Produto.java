package entidades;

import java.security.InvalidParameterException;

public class Produto {

	private Long codigo;

	private String nome;
	private double preco;

	public Produto() {

	}

	public Produto(String nome, double preco) {
		if (nome.isBlank() || preco < 0)
			throw new InvalidParameterException("Atributo(s) invalido(s)");
		else {
			this.nome = nome;
			this.preco = preco;
		}
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.isBlank())
			throw new InvalidParameterException("Nome do produto \"" + this.nome + "\" e invalido");
		else
			this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco <= 0)
			throw new InvalidParameterException("Preco do produto \"" + this.nome + "\" e invalido");
		else
			this.preco = preco;
	}

	public void aplicarDesconto(double desconto) {
		if (desconto > 100 || desconto <= 0)
			throw new InvalidParameterException("Desconto para o produto \"" + this.nome + "\" e invalido");
		else
			preco *= (desconto / 100);
	}
	
}
