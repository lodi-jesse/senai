package views;

import java.sql.Connection;
import java.util.Scanner;

import conecta.Conecta;
import dao.FornecedorDao;
import dao.ProdutoPesoDao;
import dao.ProdutoUnidadeDao;
import principal.Fornecedor;
import principal.ProdutoPeso;
import principal.ProdutoUnidade;

public class Produto implements IGerenciamentoView {
	
	private static Scanner input = new Scanner(System.in);
	Connection conexao = Conecta.getConnection();
	ProdutoUnidadeDao daoUnidade = new ProdutoUnidadeDao(null);
	ProdutoPesoDao daoPeso = new ProdutoPesoDao(null);
	FornecedorDao daoFornecedor = new FornecedorDao(null);

	public static void iniciar() {
		new Produto().menu();
	}
	
	@Override
	public void menu() {
		int escolha = -1;
		
		while (escolha != 0) {
			System.out.println("\n||||| PRODUTOS |||||\n");
			System.out.println("1 => Consultar");
			System.out.println("2 => Inserir");
                        System.out.println("3 => Atualizar/Comprar");
                        System.out.println("4 => Excluir");
                        System.out.println("\n0 => Voltar\n");
			System.out.print("## Informe o codigo da acao que deseja realizar: ");
			escolha = input.nextInt();
			
			switch(escolha) {
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
		daoUnidade.consultar();
		daoPeso.consultar();
		System.out.println("");
	}
	
	@Override
	public void inserir() {
		System.out.println("\n/// Inserir");
		int resposta = opcao1ou2("ProdutoUnidade", "ProdutoPeso");
		
		if (resposta == -1) return;
		
		input.nextLine(); // INPUT PARA EVITAR BUG
		
		System.out.print("\nNome: ");
		String nome = input.nextLine();
		System.out.print("Preco: ");
		double preco = input.nextDouble();

		if(resposta == 1) {
			System.out.print("Quantidade (Unidades): ");
			int quantidade = input.nextInt();
			daoUnidade.setProduto(new ProdutoUnidade(nome, preco, quantidade));
			daoUnidade.inserir();
			
		} else if (resposta == 2) {
			System.out.print("Quantidade (Kg): ");
			double quantidade = input.nextDouble();
			daoPeso.setProduto(new ProdutoPeso(nome, preco, quantidade));
			daoPeso.inserir();
			
		}
		System.out.println("\n>>> Produto inserido com sucesso\n");
	}
	
	@Override
	public void atualizar() {
		System.out.println("\n/// Atualizar ou Comprar");

		int resposta = opcao1ou2("\nProdutoUnidade", "ProdutoPeso");
		if (resposta == -1) return;
		
		if (resposta == 1) {
			daoUnidade.consultar();
			System.out.print("\nInforme o codigo do produto: ");
			long codigo = input.nextLong();
			ProdutoUnidade produto = daoUnidade.obterProduto(codigo);
			
			resposta = opcao1ou2("Atualizar", "Comprar");
			
			if (resposta == 1) {
				input.nextLine(); //INPUT PARA EVITAR BUG
				
				System.out.print("\nNome: ");
				String nome = input.nextLine();
				produto.setNome(nome);

				System.out.print("Preco: ");
				double preco = input.nextDouble();
				produto.setPreco(preco);
				
				daoUnidade.setProduto(produto);
				daoUnidade.atualizar(codigo);

				System.out.println("\n>>> Produto atualizado com sucesso\n");
			
			} else if (resposta == 2) {
				System.out.println("");
				
				daoFornecedor.consultar();
				System.out.print("\nInforme o codigo do fornecedor: ");
				long codigoFornecedor = input.nextLong();
				Fornecedor fornecedor = daoFornecedor.obterFornecedor(codigoFornecedor);
				
				System.out.print("Quantas unidades deseja comprar: ");
				int quantidade = input.nextInt();
				
				fornecedor.comprar(produto, quantidade);
				
				System.out.println("\n>>> Compra realizada com sucesso");
			}

		}
		else if (resposta == 2) {
			daoPeso.consultar();
			System.out.print("\nInforme o codigo do produto: ");
			long codigo = input.nextLong();
			ProdutoPeso produto = daoPeso.obterProduto(codigo);
			
			resposta = opcao1ou2("Atualizar", "Comprar");
			
			if (resposta == 1) {
				input.nextLine(); //INPUT PARA EVITAR BUG
				
				System.out.print("\nNome: ");
				String nome = input.nextLine();
				produto.setNome(nome);
				
				System.out.print("Preco: ");
				double preco = input.nextDouble();
				produto.setPreco(preco);
				
				daoPeso.setProduto(produto);
				daoPeso.atualizar(codigo);
				
				System.out.println("\n>>> Produto atualizado com sucesso\n");
			}
			else if (resposta == 2) {
				System.out.println("");
				
				daoFornecedor.consultar();
				System.out.print("\nInforme o codigo do fornecedor: ");
				long codigoFornecedor = input.nextLong();
				Fornecedor fornecedor = daoFornecedor.obterFornecedor(codigoFornecedor);
				
				System.out.print("Quantos quilogramas deseja comprar: ");
				double quantidade = input.nextDouble();
				
				fornecedor.comprar(produto, quantidade);
				
				System.out.println("\n>>> Compra realizada com sucesso");
			}
		}

	}
	
	public int opcao1ou2(String opcao1, String opcao2) {
		System.out.print(opcao1 + " [1] / " + opcao2 + " [2] : ");
		int resposta = input.nextInt();
		
		if (resposta != 1 && resposta != 2) {
			System.out.println("Erro: Resposta Invalida XXX\n");
			return -1;
		}
		return resposta;
	}
	
	@Override
	public void excluir() {
		System.out.println("/// Excluir");
		
	}
	
}
