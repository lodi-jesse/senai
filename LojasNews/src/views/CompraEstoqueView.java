package views;

import java.util.Scanner;

import dao.CompraParaEstoqueDao;
import dao.FornecedorDao;
import dao.ProdutoPesoDao;
import dao.ProdutoUnidadeDao;
import principal.Fornecedor;
import principal.ProdutoPeso;
import principal.ProdutoUnidade;

public class CompraEstoqueView implements IGerenciamentoView {

	private static Scanner input = new Scanner(System.in);
	CompraParaEstoqueDao daoCompra = new CompraParaEstoqueDao();
	FornecedorDao daoFornecedor = new FornecedorDao(null);
	ProdutoUnidadeDao daoUnidade = new ProdutoUnidadeDao(null);
	ProdutoPesoDao daoPeso = new ProdutoPesoDao(null);
	ProdutoView p = new ProdutoView();
	
	public static void iniciar() {
		new CompraEstoqueView().menu();
	}
	
	@Override
	public void menu() {
		int escolha = -1;

		while (escolha != 0) {
			System.out.println("\n||||| COMPRAS PARA O ESTOQUE |||||\n");
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
		daoCompra.consultar();
	}
	
	@Override
	public void inserir() {
		System.out.println("\n/// Inserir");
		
		int resposta = p.opcoes("\nProdutoUnidade", "ProdutoPeso");
		if (resposta == -1) return;
		
		if (resposta == 1) {
			System.out.println("");
			
			daoFornecedor.consultar();
			System.out.print("\nInforme o codigo do fornecedor: ");
			long codigoFornecedor = input.nextLong();
			Fornecedor fornecedor = daoFornecedor.obterFornecedor(codigoFornecedor);

			System.out.println("");

			daoUnidade.consultar();
			System.out.print("\nInforme o codigo do produto: ");
			long codigo = input.nextLong();
			ProdutoUnidade produto = daoUnidade.obterProduto(codigo);
			
			System.out.print("Quantas unidades deseja comprar: ");
			int quantidade = input.nextInt();
			
			fornecedor.comprar(produto, quantidade);
			
		} 
		else if (resposta == 2) {
			daoFornecedor.consultar();
			System.out.print("\nInforme o codigo do fornecedor: ");
			long codigoFornecedor = input.nextLong();
			Fornecedor fornecedor = daoFornecedor.obterFornecedor(codigoFornecedor);

			System.out.println("");

			daoPeso.consultar();
			System.out.print("\nInforme o codigo do produto: ");
			long codigo = input.nextLong();
			ProdutoPeso produto = daoPeso.obterProduto(codigo);

			System.out.print("Quantos quilogramas deseja comprar: ");
			double quantidade = input.nextDouble();
			
			fornecedor.comprar(produto, quantidade);
			
		}
		System.out.println("\n>>> Compra realizada com sucesso");
	}
	
	@Override
	public void atualizar() {
		System.out.println("\n/// Atualizar");
		
		daoCompra.consultar();
		System.out.print("\nInforme o codigo da compra: ");
		Long codigo = input.nextLong();
		
		daoFornecedor.consultar();
		System.out.print("\nCodigo do novo fornecedor: ");
		Fornecedor fornecedor = daoFornecedor.obterFornecedor(input.nextLong());
		
		int resposta = p.opcoes("ProdutoUnidade", "ProdutoPeso");
		if (resposta == -1) return;

		if (resposta == 1) {
			daoUnidade.consultar();
			System.out.print("\nCodigo do novo Produto: ");
			Long codigoProd = input.nextLong();
			
			System.out.print("Nova Quantidade (Un): ");
			int quantidade = input.nextInt();

			ProdutoUnidade produto = daoUnidade.obterProduto(codigoProd);
			CompraParaEstoqueDao daoCompra = new CompraParaEstoqueDao(fornecedor, produto, quantidade);
			daoCompra.atualizar(codigo);
			
		} else if (resposta == 2) {
			daoPeso.consultar();
			System.out.print("\nCodigo do novo Produto: ");
			Long codigoProd = input.nextLong();
			
			System.out.print("Nova Quantidade (Kg): ");
			double quantidade = input.nextDouble();
			
			ProdutoPeso produto = daoPeso.obterProduto(codigoProd);
			CompraParaEstoqueDao daoCompra = new CompraParaEstoqueDao(fornecedor, produto, quantidade);
			daoCompra.atualizar(codigo);
		}
		System.out.println("\n>>> Compra atualizada com sucesso\n");
		
	}
	
	@Override
	public void excluir() {
		System.out.println("\n/// Excluir");
		
		System.out.println("Codigo da Compra: ");
		daoCompra.excluir(input.nextLong());
		
		System.out.println("\nCompra excluida com sucesso!!");
	}
	
}
