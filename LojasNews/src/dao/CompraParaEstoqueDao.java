package dao;

import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conecta.Conecta;
import entidades.Produto;
import principal.Fornecedor;
import principal.ProdutoPeso;
import principal.ProdutoUnidade;

// Este DAO em espec?fico, se comporta um pouco diferente dos de mais
// por seus objetos no Banco de Dados serem criados a partir de uma Fun??o presente na Classe Fornecedor.

public class CompraParaEstoqueDao implements IGerenciamentoDao {

	private static Connection conexao = Conecta.getConnection();
	private Long codigo;
	private Fornecedor fornecedor;
	private Produto produto;
	private double quantidade;
	
	public CompraParaEstoqueDao() {
		
	}
	
	public CompraParaEstoqueDao(Fornecedor fornecedor, Produto produto, double quantidade) {
		if (fornecedor == null || produto == null || quantidade < 0)
			throw new InvalidParameterException("Atributo(s) invalido(s)");
		else {
			this.fornecedor = fornecedor;
			this.produto = produto;
			this.quantidade = quantidade;
		}
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
		CompraParaEstoqueDao compra;
		
		try {
			Statement stmt = conexao.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			
			while(resultado.next()) {
				Long codigo = resultado.getLong("codigo");
				Fornecedor fornecedor = new FornecedorDao(null).obterFornecedor(resultado.getLong("pessoas_codigo"));
				double quantidade = resultado.getDouble("quantidade");
				
				try {
					ProdutoUnidade produto = new ProdutoUnidadeDao(null).obterProduto(resultado.getLong("produtos_codigo"));
					compra = new CompraParaEstoqueDao(fornecedor, produto, quantidade);
					compra.setCodigo(codigo);
				} catch (Exception e) {
					ProdutoPeso produto = new ProdutoPesoDao(null).obterProduto(resultado.getLong("produtos_codigo"));
					compra = new CompraParaEstoqueDao(fornecedor, produto, quantidade);
					compra.setCodigo(codigo);
				}
				
				System.out.println(compra.toString());
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
		return getCodigo() + " - fornecedor: " + fornecedor.getNome() + " - " +
				produto.getNome() +
				" (" + quantidade + ")";
	}
		
}
