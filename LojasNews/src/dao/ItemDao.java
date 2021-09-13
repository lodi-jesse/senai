package dao;

import conecta.Conecta;
import entidades.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemDao implements IGerenciamentoDao {

	private static Connection conexao = Conecta.getConnection();
	private Item item;

	public ItemDao(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public void consultar() {
		String sql = "SELECT * FROM itens";
		
		try {
			Statement stmt = conexao.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);

			while (resultado.next()) {
				// TODO terminar consulta!
			}

			resultado.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}

	@Override
	public boolean inserir() {
		String sql = "INSERT INTO itens " 
					  + "(pedidos_codigo, produtos_codigo, quantidade) " 
				   + "VALUES " 
					  + "(?, ?, ?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setLong(1, item.getPedido().getCodigo());
			stmt.setLong(2, item.getProduto().getCodigo());
			stmt.setDouble(3, item.getQuantidade());

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			System.out.println("\nErro: Produto duplicado XXX");
			return false;
		}

		return false;
	}

	@Override
	public boolean atualizar(Long codigo) {
		String sql = "UPDATE itens SET " 
					  + "pedidos_codigo = ?, produtos_codigo = ?, quantidade = ? " 
				   + "WHERE codigo = ?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, item.getPedido().getCodigo());
			stmt.setLong(2, item.getProduto().getCodigo());
			stmt.setDouble(3, item.getQuantidade());
			stmt.setLong(4, codigo);

			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean excluir(Long codigo) {
		String sql = "DELETE FROM itens WHERE codigo = ?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, codigo);

			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
