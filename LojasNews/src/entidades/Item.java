package entidades;

import principal.ProdutoPeso;
import principal.ProdutoUnidade;

import java.security.InvalidParameterException;

public class Item {

	private Pedido pedido;
	private Produto produto;
	private double quantidade;

	public Item() {

	}

	public Item(Pedido pedido, ProdutoUnidade produto, int quantidade) {
		if (pedido == null || quantidade <= 0 || quantidade > produto.getQuantidadeEstoqueUn())
			throw new InvalidParameterException("Atributo(s) inválido(s)");
		else {
			this.pedido = pedido;
			this.produto = produto;
			this.quantidade = quantidade;
			int estoqueAtual = produto.getQuantidadeEstoqueUn();
			produto.setQuantidadeEstoqueUn(estoqueAtual - quantidade);
		}
	}

	public Item(Pedido pedido, ProdutoPeso produto, double quantidade) {
		if (quantidade <= 0 || quantidade > produto.getQuantidadeEstoqueKg())
			throw new InvalidParameterException("Atributo(s) inválido(s)");
		else {
			this.pedido = pedido;
			this.produto = produto;
			this.quantidade = quantidade;
			double estoqueAtual = produto.getQuantidadeEstoqueKg();
			produto.setQuantidadeEstoqueKg(estoqueAtual - quantidade);
		}
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
