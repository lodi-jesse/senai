package lojasnews;

import java.util.Date;

public class Cliente extends Pessoa implements ComportamentosPessoa {

	private Pedido pedido = new Pedido();

	public Cliente() {
		super();
	}

	public Cliente(String nome, String telefone) {
		super(nome, telefone);
	}

	public Cliente(String cpf, String nome, String email, String telefone, Date nascimento) {
		super(cpf, nome, email, telefone, nascimento);
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		String mensagem = super.getNome() + ", com o pedido: " + pedido.getCodigo();

		for (Item item : pedido.getItens()) {
			if (item.getProduto().getClass() == ProdutoUnidade.class)
				mensagem += "\n" + item.getQuantidade() + " Unidades: " + item.getProduto().getNome();
			else
				mensagem += "\n" + item.getQuantidade() + " Kg: " + item.getProduto().getNome();
		}

		return mensagem += "\ntotal: R$" + pedido.getValorTotal();
	}

	@Override
	public void comprar(ProdutoUnidade produto, int quantidade) {
		Item item = new Item(produto, quantidade);
		pedido.getItens().add(item);
	}

	@Override
	public void comprar(ProdutoPeso produto, double quantidade) {
		Item item = new Item(produto, quantidade);
		pedido.getItens().add(item);
	}

	@Override
	public void comprimentar() {
		System.out.println("\nooopah! Fala aí Zé, hoje eu vou querer...\n");
	}

}
