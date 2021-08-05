package lojasnews;

public class Item {

	private Pedido p1 = new Pedido();
	private Produto prod;
	private int quantidade;

	public Item() {

	}

	public Item(Pedido p1, Produto prod, int quantidade) {
		this.p1 = p1;
		this.prod = prod;
		this.quantidade = quantidade;

	}

	public Pedido getP1() {
		return p1;
	}

	public void setP1(Pedido p1) {
		this.p1 = p1;
	}

	public Produto getProd() {
		return prod;
	}

	public void setProd(Produto prod) {
		this.prod = prod;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
