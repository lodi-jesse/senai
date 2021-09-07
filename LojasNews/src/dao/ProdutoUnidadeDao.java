package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conecta.Conecta;
import principal.ProdutoUnidade;

public class ProdutoUnidadeDao implements IGerenciamentoDao {

	private Connection conexao = Conecta.getConnection();
	private ProdutoUnidade produtoU;

	public ProdutoUnidadeDao(ProdutoUnidade produtoU) {
		this.produtoU = produtoU;
	}

	public ProdutoUnidade getProduto() {
		return produtoU;
	}

	public void setProduto(ProdutoUnidade produtoU) {
		this.produtoU = produtoU;
	}
	
	@Override
	public void consultar() {
		String sql = "SELECT * FROM produtos WHERE is_peso = 0";
		
		try {
			Statement stmt = conexao.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			
			while(resultado.next()) {
				long codigo = resultado.getInt("codigo");
				String nome = resultado.getString("nome");
				double preco = resultado.getDouble("preco");
				int quantidade = resultado.getInt("quantidade");
				
				ProdutoUnidade produto = new ProdutoUnidade(nome, preco, quantidade);
				produto.setCodigo(codigo);
				
				System.out.println(produto.toString());
			}
			resultado.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

	}
	
	public ProdutoUnidade obterProduto(Long codigo) {
		ProdutoUnidade produto = null;
		String sql = "SELECT * FROM produtos WHERE is_peso = 0 AND codigo = ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, codigo);
			ResultSet resultado = stmt.executeQuery();
			
			if (resultado.next()) {
				String nome = resultado.getString("nome");
				double preco = resultado.getDouble("preco");
				int quantidade = resultado.getInt("quantidade");
				
				produto = new ProdutoUnidade(nome, preco, quantidade);
				produto.setCodigo(codigo);
				
			}
			resultado.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return produto;
	}

	@Override
	public boolean inserir() {
		String sql = "INSERT INTO produtos " 
					  + "(nome, preco, quantidade, is_peso) " 
				   + "VALUES " 
					  + "(?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, produtoU.getNome());
			stmt.setDouble(2, produtoU.getPreco());
			stmt.setInt(3, produtoU.getQuantidadeEstoqueUn());
			stmt.setInt(4, 0);
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				int codigo = rs.getInt(1);
				this.produtoU.setCodigo((long)codigo);	
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
					  + "nome = ?, preco = ? "
				   + "WHERE codigo  = ? AND is_peso = 0";
		
		try {
			PreparedStatement smmt = conexao.prepareStatement(sql);
			smmt.setString(1, produtoU.getNome());
			smmt.setDouble(2, produtoU.getPreco());
			smmt.setLong(3, codigo);

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
		String sql = "DELETE FROM produtos WHERE codigo = ? AND is_peso = 0";

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
