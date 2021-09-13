package principal;

import entidades.Item;
import entidades.Pedido;
import entidades.Pessoa;

public class Cliente extends Pessoa implements ComportamentosPessoa {

	private Pedido pedido;

	public Cliente(String nome, String sobrenome, String telefone) {
		super(nome, sobrenome, telefone);
	}

	public Cliente(String cpf, String nome, String sobrenome, String email, String telefone, String nascimento) {
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
		return getCodigo() + " - " + getNome() + " " + getSobrenome() + " - " + getTelefone();
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
