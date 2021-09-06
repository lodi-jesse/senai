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
import java.util.Scanner;

public class LojasNewsPrincipal {
    
    public static Scanner input;

	public static void main(String[] args) throws SQLException {
                
            
            input = new  Scanner(System.in);
            
            while (true) {                
                
                System.out.println("  Informe o número da operação que deseja: ");
                System.out.println("1 => Cliente"); 
                System.out.println("2 => Estoque");
                System.out.println("3 => Produto");
                System.out.println("4 => Pedido");
                System.out.println("5 => Itens");
                System.out.println("0 => Sair/Voltar");
                
                int escolha = input.nextInt();
                
                if(escolha == 0)
                    break;
                if(escolha == 1) {
                    acessoCliente();
                }
                /*if(escolha == 2)
                    acessoEstoque();
                if(escolha == 3)
                    acessoProduto();
                if(escolha == 4)
                    acessoPedido();
                if(escolha == 5)
                    acessoItem();*/
            }
            
            System.out.println("Obrigado pela preferência");
		/*Cliente cliente = new Cliente("Joao", "Lima", "(00)90000-0000");
		ClienteDao cDao = new ClienteDao(cliente);
		cDao.inserir();

		cliente.setEmail("joao123@gmail.com");
		cDao.atualizar(cliente.getCodigo());
		
		
		Fornecedor fornecedor = new Fornecedor("Maria", "Alves", "(00)90000-0000");
		FornecedorDao fDao = new FornecedorDao(fornecedor);
		fDao.inserir();
		
		fornecedor.setCpf("123.123.123-44");
		fDao.atualizar(fornecedor.getCodigo());
		
		
		ProdutoUnidade produtoUn = new ProdutoUnidade("konput4ddor", 3000, 5);
		ProdutoUnidadeDao puDao = new ProdutoUnidadeDao(produtoUn);
		puDao.inserir();
		
		produtoUn.setNome("computador");
		puDao.atualizar(produtoUn.getCodigo());
		
		
		ProdutoPeso produtoKg = new ProdutoPeso("fruta", 150.0, 5.5);
		ProdutoPesoDao pkDao = new ProdutoPesoDao(produtoKg);
		pkDao.inserir();
		
		produtoKg.setPreco(0.50);
		pkDao.atualizar(produtoKg.getCodigo());
		
		
		Pedido pedido = new Pedido(cliente);
		PedidoDao pDao = new PedidoDao(pedido);
		pDao.inserir();
		
		pedido.setDataCompra("2021-08-30");
		pDao.atualizar(pedido.getCodigo());
		
		
		Item itemUn = new Item(pedido, produtoUn, 2);
		ItemDao iDao1 = new ItemDao(itemUn);
		iDao1.inserir();

		Item itemKg = new Item(pedido, produtoKg, 0.5);
		ItemDao iDao2 = new ItemDao(itemKg);
		iDao2.inserir();
		
		
		fornecedor.comprar(produtoUn, 2);
		fornecedor.comprar(produtoUn, 5);
		fornecedor.comprar(produtoKg, 3.0);
		fornecedor.comprar(produtoKg, 2.0);*/

	}

    private static void acessoCliente() {

        while (true) {

            System.out.println("## Informe o código do cadastro que deseja realizar!");
            System.out.println("1 => Cadastar");
            System.out.println("2 => Atualizar");
            System.out.println("3 => Excluir");
            System.out.println("4 => Consutar");
            System.out.println("0 => Voltar");

            int escolha = input.nextInt();

            if(escolha == 0)
                break;

            switch(escolha){

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
