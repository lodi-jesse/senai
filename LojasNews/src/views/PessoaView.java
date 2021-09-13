package views;

import java.util.Scanner;

import dao.ClienteDao;
import dao.FornecedorDao;
import principal.Cliente;
import principal.Fornecedor;

public class PessoaView implements IGerenciamentoView {

	private static Scanner input = new Scanner(System.in);
	ClienteDao daoCliente = new ClienteDao(null);
	FornecedorDao daoFornecedor = new FornecedorDao(null);
	ProdutoView p = new ProdutoView();

	public static void iniciar() {
		new PessoaView().menu();
	}

	public void menu() {
		int escolha = -1;

		while (escolha != 0) {
			System.out.println("\n||||| PESSOAS |||||\n");
			System.out.println("1 => Consultar");
			System.out.println("2 => Inserir");
			System.out.println("3 => Atualizar");
			System.out.println("4 => Excluir");
			System.out.println("\n0 => Voltar\n");
			System.out.print("## Informe o codigo da acao que deseja realizar: ");
			escolha = input.nextInt();

			switch (escolha) {
			case 1:
				consultar();
				break;
			case 2:
				inserir();
				break;
			case 3:
				atualizar();
				break;
			case 4:
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
		System.out.println("\n/// Consultar");

		int resposta = p.opcoes("Clientes", "Fornecedores", "Todos");
		if (resposta == -1)
			return;

		if (resposta == 1) {
			daoCliente.consultar();
		} else if (resposta == 2) {
			daoFornecedor.consultar();
		} else {
			System.out.println("\nClientes:");
			daoCliente.consultar();
			System.out.println("\nFornecedores:");
			daoFornecedor.consultar();
		}
		System.out.println("");
	}

	@Override
	public void inserir() {
		System.out.println("\n/// Inserir");

		int resposta = p.opcoes("Cliente", "Fornecedor");
		if (resposta == -1)
			return;

		if (resposta == 1) {
			System.out.println("Informe os dados do cliente:");

			input.nextLine(); // INPUT PARA EVITAR BUG
			System.out.print("Digite o CPF: ");
			String cpf = input.nextLine();
			System.out.print("Digite o nome: ");
			String nome = input.nextLine();
			System.out.print("Digite o sobrenome: ");
			String sobrenome = input.nextLine();
			System.out.print("Digite o Telefone: ");
			String telefone = input.nextLine();
			System.out.print("Digite o email: ");
			String email = input.nextLine();
			System.out.print("Digite o nascimento (yyyy-mm-dd): ");
			String nascimento = input.nextLine();

			Cliente cliente = new Cliente(cpf, nome, sobrenome, email, telefone, nascimento);
			daoCliente.setCliente(cliente);
			daoCliente.inserir();

		} else if (resposta == 2) {
			System.out.println("Informe os dados do fornecedor:");

			input.nextLine(); // INPUT PARA EVITAR BUG
			System.out.print("Digite o CPF: ");
			String cpf = input.nextLine();
			System.out.print("Digite o nome: ");
			String nome = input.nextLine();
			System.out.print("Digite o sobrenome: ");
			String sobrenome = input.nextLine();
			System.out.print("Digite o Telefone: ");
			String telefone = input.nextLine();
			System.out.print("Digite o email: ");
			String email = input.nextLine();
			System.out.print("Digite o nascimento (yyyy-mm-dd): ");
			String nascimento = input.nextLine();

			Fornecedor fornecedor = new Fornecedor(cpf, nome, sobrenome, email, telefone, nascimento);
			daoFornecedor.setFornecedor(fornecedor);
			daoFornecedor.inserir();

		}
		System.out.println("Cadastramento com sucesso!!");
	}

	@Override
	public void atualizar() {
		System.out.println("\n/// Atualizar");
		
		int resposta = p.opcoes("Clientes", "Fornecedores");
		if (resposta == -1)
			return;

		if (resposta == 1) {
			daoCliente.consultar();
		} else if (resposta == 2) {
			daoFornecedor.consultar();
		}
		
		System.out.print("\ninforme o codigo da pessoa: ");
		Long codigo = input.nextLong();

		System.out.println("Informe os novos dados:");

		input.nextLine(); // INPUT PARA EVITAR BUG
		System.out.print("Digite o CPF: ");
		String cpf = input.nextLine();
		System.out.print("Digite o nome: ");
		String nome = input.nextLine();
		System.out.print("Digite o sobrenome: ");
		String sobrenome = input.nextLine();
		System.out.print("Digite o Telefone: ");
		String telefone = input.nextLine();
		System.out.print("Digite o email: ");
		String email = input.nextLine();
		System.out.print("Digite o nascimento (yyyy-mm-dd): ");
		String nascimento = input.nextLine();

		if (resposta == 1) {
			Cliente cliente = new Cliente(cpf, nome, sobrenome, email, telefone, nascimento);
			daoCliente.setCliente(cliente);
			daoCliente.atualizar(codigo);
		} else if (resposta == 2) {
			Fornecedor fornecedor = new Fornecedor(cpf, nome, sobrenome, email, telefone, nascimento);
			daoFornecedor.setFornecedor(fornecedor);
			daoFornecedor.atualizar(codigo);
		}
		System.out.println("Pessoa atualizada com sucesso!!");
	}

	@Override
	public void excluir() {
		System.out.println("\n/// Excluir");
		int resposta = p.opcoes("Cliente", "Fornecedor");
		if (resposta == -1)
			return;
		
		System.out.print("\nInforme o codigo da pessoa: ");
		Long codigo = input.nextLong();

		if (resposta == 1) 
			daoCliente.excluir(codigo);
		else 
			daoFornecedor.excluir(codigo);
		
		System.out.println("Excluido com sucesso!!");
	}

}
