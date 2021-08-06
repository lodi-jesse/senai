package lojasnews;

public class LojasNewsPrincipal {

	public static void main(String[] args) {

		ProdutoUnidade produto1 = new ProdutoUnidade("notebook", 3.599, 5);
		ProdutoPeso produto2 = new ProdutoPeso("fruta", 0.50, 10);

		Item item1 = new Item(produto1, 2);
		Item item2 = new Item(produto2, 1.5);
		
//		item1.setQuantidade(1.5); ???
		
		Pedido pedido = new Pedido(item1, item2);

		Cliente cliente = new Cliente("Joãozinho", "(48)91111-2222");

		cliente.getPedidos().add(pedido);

		System.out.println(cliente.toString());

	}

}
