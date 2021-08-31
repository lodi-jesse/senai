package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conecta.Conecta;
import entidades.Pedido;

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
