package principal;

import java.sql.SQLException;

import dao.ClienteDao;
import dao.FornecedorDao;
import dao.ItemDao;
import dao.PedidoDao;
import dao.ProdutoPesoDao;
import dao.ProdutoUnidadeDao;
import entidades.Item;
import entidades.Pedido;
import views.Produto;

import java.util.Scanner;

public class LojasNewsPrincipal {

	public static Scanner input;

	public static void main(String[] args) throws SQLException {

		input = new Scanner(System.in);
		int escolha = -1;

		while (escolha != 0) {

			System.out.println("\n||||| PRINCIPAL |||||\n");
			System.out.println("1 => Pessoas");
			System.out.println("2 => Produtos");
			System.out.println("3 => Pedidos dos Clientes");
			System.out.println("4 => Compras para o Estoque");
			System.out.println("\n0 => Sair\n");
			System.out.println("## Informe o numero da operacao que deseja: ");
			escolha = input.nextInt();

			switch (escolha) {
			case 1:
				acessoCliente();
				break;
			case 2:
				Produto.iniciar();
				break;
//			case 3:	
//              implementar...
//              break;
//			case 4:
//              implementar...
//              break;
			case 0:
				break;
			default:
				System.out.println("\nErro: Acao invalida ou inexistente XXX\n");
			}
		}
		System.out.println("Obrigado pela preferencia");

	}

	private static void acessoCliente() {

		while (true) {

			System.out.println("## Informe o codigo do cadastro que deseja realizar: ");
			System.out.println("1 => Cadastar");
			System.out.println("2 => Atualizar");
			System.out.println("3 => Excluir");
			System.out.println("4 => Consutar");
			System.out.println("0 => Voltar");

			int escolha = input.nextInt();

			if (escolha == 0)
				break;

			switch (escolha) {

			case 1:
				cadastrarCliente();
				break;
			case 2:
				alterarCliente();
				break;
			case 3:
				excluirCliente();
				break;
			default:
				consultarCliente();
				break;
			}
		}
	}

	private static void cadastrarCliente() {

		System.out.println("Informe os dados do cliente:");

		System.out.print("Digite o CPF: ");
		input.nextLine();
		String cpf = input.nextLine();
		System.out.print("Digite o nome: ");
		String nome = input.nextLine();
		System.out.print("Digite o sobrenome: ");
		String sobrenome = input.nextLine();
		System.out.print("Digite o Telefone: ");
		String telefone = input.nextLine();
		System.out.print("Digite o email: ");
		String email = input.nextLine();
		System.out.print("Digite o nascimento: ");
		String nascimento = input.nextLine();

		Cliente cliente = new Cliente(cpf, nome, sobrenome, email, telefone, nascimento);
		ClienteDao cDao = new ClienteDao(cliente);
		cDao.inserir();

		System.out.println("Cadastramento com sucesso!!");

	}

	private static void alterarCliente() {

	}

	private static void excluirCliente() {

	}

	private static void consultarCliente() {

	}
}
