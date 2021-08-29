package principal;

import java.util.Date;

import entidades.Item;
import entidades.Pedido;
import entidades.Pessoa;

public class Cliente extends Pessoa implements ComportamentosPessoa {

	private Pedido pedido;

	public Cliente(String nome, String sobrenome, String telefone) {
		super(nome, sobrenome, telefone);
	}

	public Cliente() {
		super();
	}

	public Cliente(String cpf, String nome, String sobrenome, String email, String telefone, Date nascimento) {
		super(cpf, nome, sobrenome, email, telefone, nascimento);
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
		Item item = new Item(pedido, produto, quantidade);
		pedido.getItens().add(item);
	}

	@Override
	public void comprar(ProdutoPeso produto, double quantidade) {
		Item item = new Item(pedido, produto, quantidade);
		pedido.getItens().add(item);
	}

	@Override
	public void comprimentar() {
		System.out.println("\nooopah! Fala ai Ze, hoje eu vou querer...\n");
	}

}
