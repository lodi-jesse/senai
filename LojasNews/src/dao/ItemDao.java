package dao;

import conecta.Conecta;
import entidades.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
			e.printStackTrace();
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