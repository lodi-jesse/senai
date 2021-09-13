package views;

import java.util.Scanner;

import dao.ClienteDao;
import dao.ItemDao;
import dao.PedidoDao;
import dao.ProdutoPesoDao;
import dao.ProdutoUnidadeDao;
import entidades.Item;
import entidades.Pedido;
import principal.Cliente;
import principal.ProdutoPeso;
import principal.ProdutoUnidade;

public class PedidoView implements IGerenciamentoView {
	
	ProdutoView p = new ProdutoView();
	private static Scanner input = new Scanner(System.in);
	ClienteDao daoCliente = new ClienteDao(null);
	PedidoDao daoPedido = new PedidoDao(null);
	ItemDao daoItem = new ItemDao(null);
	ProdutoUnidadeDao daoProdUn = new ProdutoUnidadeDao(null);
	ProdutoPesoDao daoProdKg = new ProdutoPesoDao(null);
	
	public static void iniciar() {
		new PedidoView().menu();
	}
	
	@Override
	public void menu() {
		int escolha = -1;
		
		while (escolha != 0) {
			System.out.println("\n||||| PEDIDOS |||||\n");
			System.out.println("1 => Consultar Pedidos");
			System.out.println("2 => Consultar Itens de Pedidos");
			System.out.println("3 => Inserir");
			System.out.println("4 => Atualizar");
			System.out.println("5 => Excluir");
			System.out.println("\n0 => Voltar\n");
			System.out.print("## Informe o codigo da acao que deseja realizar: ");
			escolha = input.nextInt();
			
			switch (escolha) {
			case 1:
				consultar();
				break;
			case 2:
				consultarItens();
				break;
			case 3:
				inserir();
				break;
			case 4:
				atualizar();
				break;
			case 5:
				excluir();
				break;
			case 0:
				break;
			default:
				System.out.println("\nErro: Acao invalida ou inexistente XXX\n");
			}
		}
	}
	
	@Override
	public void consultar() {
		System.out.println("\n/// Consultar Pedidos\n");
		daoPedido.consultar();
	}
	
	public void consultarItens() {
		System.out.println("\n/// Consultar Itens");
		
		System.out.print("Qual o codigo do Pedido: ");
		Long codigo = input.nextLong();
		
		System.out.println("");
		daoPedido.obterItens(codigo);
	}
	
	@Override
	public void inserir() {
		System.out.println("\n/// Inserir\n");
		
		System.out.print("Codigo do cliente: ");
		long codigoCliente = input.nextLong();
		
		input.nextLine(); // INPUT PARA EVITAR BUG
		
		System.out.print("Informe a data da compra (yyyy-mm-dd): ");
		String data = input.nextLine();
		
		Cliente cliente = daoCliente.obterCliente(codigoCliente);
		Pedido pedido = new Pedido(cliente, data);
		cliente.setPedido(pedido);

		daoPedido.setPedido(pedido);
		daoPedido.inserir();
		
		int resposta = -1;
		
		while (resposta != 0) {
			System.out.println("\ndeseja inserir +1 item? sim[1] / nao[0]");
			resposta = input.nextInt();


			if (resposta == 0)
				break;
			else {
				int opcao = p.opcoes("ProdutoUnidade", "ProdutoPeso");
				if (opcao == -1) break;

				Item item = null;

				if (opcao == 1) {
					daoProdUn.consultar();
					
					System.out.print("\nCodigo do produto: ");
					Long codigoProd = input.nextLong();
					ProdutoUnidade produto = daoProdUn.obterProduto(codigoProd);

					System.out.print("Quantidade desejada: ");
					int quantidade = input.nextInt();

					cliente.comprar(produto, quantidade);
					item = new Item(pedido, produto, quantidade);
					
				} else {
				daoProdKg.consultar();
				
				System.out.print("\nCodigo do produto: ");
				Long codigoProd = input.nextLong();
				ProdutoPeso produto = daoProdKg.obterProduto(codigoProd);
				
				System.out.print("Quantidade desejada: ");
				double quantidade = input.nextDouble();

				cliente.comprar(produto, quantidade);
				item = new Item(pedido, produto, quantidade);
					
				}
				daoItem.setItem(item);
				daoItem.inserir();
			}
		}
	}
	
	@Override
	public void atualizar() {
		System.out.println("\n/// Atualizar\n");
		
		daoPedido.consultar();

		System.out.print("\nCodigo do pedido: ");
		Long codigoPedido = input.nextLong();
			
		System.out.print("Codigo do novo cliente: ");
		Long codigoCliente = input.nextLong();
		Cliente cliente = daoCliente.obterCliente(codigoCliente);
		
		input.nextLine(); // INPUT PARA EVITAR BUG
		
		System.out.print("Informe a data da compra (yyyy-mm-dd): ");
		String data = input.nextLine();
			
		daoPedido.setPedido(new Pedido(cliente, data));
		daoPedido.atualizar(codigoPedido);
		
	}
	 
	@Override
	public void excluir() {
		System.out.println("\n/// Excluir");
		
		System.out.print("\nCodigo do pedido: ");
		Long codigo = input.nextLong();
		
		daoPedido.excluir(codigo);
	}
	
}
