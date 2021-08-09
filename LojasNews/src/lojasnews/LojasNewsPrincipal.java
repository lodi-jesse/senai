package lojasnews;

public class LojasNewsPrincipal {

	public static void main(String[] args) {

		ProdutoUnidade produto1 = new ProdutoUnidade("notebook", 3.599, 5);
		ProdutoPeso produto2 = new ProdutoPeso("fruta", 0.50, 10);

		Cliente cliente = new Cliente("Joãozinho", "(48)91111-2222");
		cliente.comprimentar();
		cliente.comprar(produto1, 2);
		cliente.comprar(produto2, 1.5);

		System.out.println(cliente.toString());

		Fornecedor fornecedor = new Fornecedor("Marquinhos", "(47)92222-1111");
		System.out.println(fornecedor.toString());
		fornecedor.comprimentar();
		fornecedor.comprar(produto1, 2);

		System.out.println(produto1.getNome() + "\nEstoque atual: " + produto1.getQuantidadeEstoqueUn());

	}

}
