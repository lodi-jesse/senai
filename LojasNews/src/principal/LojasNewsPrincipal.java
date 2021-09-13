package principal;

import java.sql.SQLException;
import java.util.Scanner;

import views.CompraEstoqueView;
import views.PedidoView;
import views.PessoaView;
import views.ProdutoView;

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
				PessoaView.iniciar();
				break;
			case 2:
				ProdutoView.iniciar();
				break;
			case 3:	
				PedidoView.iniciar();
				break;
			case 4:
				CompraEstoqueView.iniciar();
				break;
			case 0:
				break;
			default:
				System.out.println("\nErro: Acao invalida ou inexistente XXX\n");
			}
		}
		System.out.println("Obrigado pela preferencia");

	}

}
