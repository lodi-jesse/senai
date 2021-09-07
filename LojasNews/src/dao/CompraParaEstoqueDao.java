package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conecta.Conecta;
import entidades.Produto;
import principal.Fornecedor;

// Este DAO em específico, se comporta um pouco diferente dos de mais
// por seus objetos no Banco de Dados serem criados a partir de uma Função presente na Classe Fornecedor.

public class CompraParaEstoqueDao implements IGerenciamentoDao {

	private static Connection conexao = Conecta.getConnection();
	private Fornecedor fornecedor;
	private Produto produto;
	private double quantidade;
	
	public CompraParaEstoqueDao(Fornecedor fornecedor, Produto produto, double quantidade) {
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public void consultar() {
		String sql = "SELECT * FROM compras_para_estoque";
		
		try {
			Statement stmt = conexao.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			
			while(resultado.next()) {
				Fornecedor fornecedor = new FornecedorDao(null).obterFornecedor(resultado.getLong("pessoas_codigo"));
//				Produto produto = resultado.; ????????
				double quantidade = resultado.getDouble("quantidade");
				
				CompraParaEstoqueDao compra = new CompraParaEstoqueDao(fornecedor, produto, quantidade);
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
		String sql = "INSERT INTO compras_para_estoque "
					  + "(pessoas_codigo, produtos_codigo, quantidade) "
				   + "VALUES "
				   	  + "(?, ?, ?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, fornecedor.getCodigo());
			stmt.setLong(2, produto.getCodigo());
			stmt.setDouble(3, this.quantidade);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	@Override
	public boolean atualizar(Long codigo) {
		String sql = "UPDATE compras_para_estoque SET "
					   + "pessoas_codigo = ?, produtos_codigo = ?, quantidade = ? "
				   + "WHERE codigo = ?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, fornecedor.getCodigo());
			stmt.setLong(2, produto.getCodigo());
			stmt.setDouble(3, this.quantidade);
			stmt.setLong(4, codigo);

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
		String sql = "DELETE FROM compras_para_estoque WHERE codigo = ?";
		
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
	
	@Override
	public String toString() {
		return fornecedor.getNome() + produto.getNome() + quantidade;
	}
		
}
