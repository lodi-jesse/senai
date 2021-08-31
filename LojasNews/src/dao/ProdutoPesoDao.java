package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conecta.Conecta;
import principal.ProdutoPeso;

public class ProdutoPesoDao implements IGerenciamentoDao {

	private static Connection conexao = Conecta.getConnection();
	private ProdutoPeso produtoP;
	
	public ProdutoPesoDao(ProdutoPeso produtoP) {
		this.produtoP = produtoP;
	}

	public ProdutoPeso getProdutop() {
		return produtoP;
	}

	public void setProdutop(ProdutoPeso produtoP) {
		this.produtoP = produtoP;
	}

	@Override
	public boolean inserir() {
		String sql = "INSERT INTO produtos " 
					  + "(nome, preco, quantidade, is_peso) " 
				   + "VALUES " 
					  + "(?, ?, ?, ?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, produtoP.getNome());
			stmt.setDouble(2, produtoP.getPreco());
			stmt.setDouble(3, produtoP.getQuantidadeEstoqueKg());
			stmt.setInt(4, 1);
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				int codigo = rs.getInt(1);
				this.produtoP.setCodigo((long)codigo);	
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
		String sql = "UPDATE produtos SET " 
					  + "nome = ?, preco = ?, quantidade = ? "
				   + "WHERE codigo  = ? AND is_peso = 1";
		
		try {
			PreparedStatement smmt = conexao.prepareStatement(sql);
			smmt.setString(1, produtoP.getNome());
			smmt.setDouble(2, produtoP.getPreco());
			smmt.setDouble(3, produtoP.getQuantidadeEstoqueKg());
			smmt.setLong(4, codigo);

			smmt.execute();
			smmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	@Override
	public boolean excluir(Long codigo) {
		String sql = "DELETE FROM produtos WHERE codigo = ? AND is_peso = 1";

		try {
			PreparedStatement smmt = conexao.prepareStatement(sql);
			smmt.setLong(1, codigo);

			smmt.execute();
			smmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

}
