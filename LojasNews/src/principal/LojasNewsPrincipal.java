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

public class LojasNewsPrincipal {

	public static void main(String[] args) throws SQLException {

		Cliente cliente = new Cliente("Joao", "Lima", "(00)90000-0000");
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
		fornecedor.comprar(produtoKg, 2.0);

	}

}
