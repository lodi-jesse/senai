package entidades;

import principal.ProdutoPeso;
import principal.ProdutoUnidade;

import java.security.InvalidParameterException;

public class Item {

	private Produto produto;
	private double quantidade;

	public Item() {

	}

	public Item(ProdutoUnidade produto, int quantidade) {
		if (quantidade <= 0 || quantidade > produto.getQuantidadeEstoqueUn())
			throw new InvalidParameterException("Atributo(s) inválido(s)");
		else {
			this.produto = produto;
			this.quantidade = quantidade;
			int estoqueAtual = produto.getQuantidadeEstoqueUn();
			produto.setQuantidadeEstoqueUn(estoqueAtual - quantidade);
		}
	}

	public Item(ProdutoPeso produto, double quantidade) {
		if (quantidade <= 0 || quantidade > produto.getQuantidadeEstoqueKg())
			throw new InvalidParameterException("Atributo(s) inválido(s)");
		else {
			this.produto = produto;
			this.quantidade = quantidade;
			double estoqueAtual = produto.getQuantidadeEstoqueKg();
			produto.setQuantidadeEstoqueKg(estoqueAtual - quantidade);
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

}
