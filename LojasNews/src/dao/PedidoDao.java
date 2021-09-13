package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conecta.Conecta;
import entidades.Item;
import entidades.Pedido;
import principal.Cliente;
import principal.ProdutoPeso;
import principal.ProdutoUnidade;

public class PedidoDao implements IGerenciamentoDao {

	private static Connection conexao = Conecta.getConnection();
	private Pedido pedido;

	public PedidoDao(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public void consultar() {
		String sql = "SELECT * FROM pedidos";
		
		try {
			Statement stmt = conexao.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);

			while (resultado.next()) {
				Long codigo = resultado.getLong("codigo");
				Cliente cliente = new ClienteDao(null).obterCliente(resultado.getLong("pessoas_codigo"));
				String data = resultado.getString("data_compra");
				
				Pedido pedido = new Pedido(cliente);
				pedido.setCodigo(codigo);
				pedido.setDataCompra(data);
				
				System.out.println(pedido.toString());
			}

			resultado.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}
	
	public Pedido obterPedido(Long codigo) {
		String sql = "SELECT * FROM pedidos WHERE codigo = ?";
		Pedido pedido = null;
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, codigo);
			ResultSet resultado = stmt.executeQuery();
			
			if (resultado.next()) {
				Cliente cliente = new ClienteDao(null).obterCliente(resultado.getLong("pessoas_codigo"));
				String data = resultado.getString("data_compra");
				
				pedido = new Pedido(cliente);
				pedido.setCodigo(codigo);
				pedido.setDataCompra(data);
			}
			
			resultado.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return pedido;
	}
	
	public List<Item> obterItens(Long codigo) {
		String sql = "SELECT * FROM itens WHERE pedidos_codigo = ?";
		List<Item> itens = new ArrayList<>();
		Pedido pedido = obterPedido(codigo);

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, codigo);
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				double quantidade = resultado.getDouble("quantidade");
				Item item;

				try {
					ProdutoUnidade produto = new ProdutoUnidadeDao(null).obterProduto(resultado.getLong("produtos_codigo"));
					item = new Item(pedido, produto, (int)quantidade);
				} catch (Exception e) {
					ProdutoPeso produto = new ProdutoPesoDao(null).obterProduto(resultado.getLong("produtos_codigo"));
					item = new Item(pedido, produto, quantidade);
				}
				
				System.out.println(item.toString());
				itens.add(item);
			}
			
			resultado.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return itens;
	}

	@Override
	public boolean inserir() {
		String sql = "INSERT INTO pedidos " 
					  + "(pessoas_codigo, data_compra) "
				   + "VALUES " 
					  + "(?, ?);";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, pedido.getCliente().getCodigo());
			stmt.setString(2, pedido.getDataCompra());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				int codigo = rs.getInt(1);
				this.pedido.setCodigo((long)codigo);	
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean atualizar(Long codigo) {
		String sql = "UPDATE pedidos SET "
					  + "pessoas_codigo = ?, data_compra = ? "
				   + "WHERE codigo = ?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, pedido.getCliente().getCodigo());
			stmt.setString(2, pedido.getDataCompra());
			stmt.setLong(3, codigo);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean excluir(Long codigo) {
		String sql = "DELETE FROM pedidos WHERE codigo = ?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, codigo);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

}
