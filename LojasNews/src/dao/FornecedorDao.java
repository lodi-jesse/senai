package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conecta.Conecta;
import principal.Fornecedor;

public class FornecedorDao implements IGerenciamentoDao {

	private static Connection conexao = Conecta.getConnection();
	private Fornecedor fornecedor;

	public FornecedorDao(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	@Override
	public void consultar() {
		String sql = "SELECT * FROM pessoas WHERE is_fornecedor = 1";
		
		try {
			Statement stmt = conexao.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			
			while (resultado.next()) {
				long codigo = resultado.getLong("codigo");
				String nome = resultado.getString("nome");
				String sobrenome = resultado.getString("sobrenome");
				String telefone = resultado.getString("telefone");
				
				Fornecedor fornecedor = new Fornecedor(nome, sobrenome, telefone);
				fornecedor.setCodigo(codigo);
				
				System.out.println(fornecedor.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		
	}
	
	public Fornecedor obterFornecedor(Long codigo) {
		Fornecedor fornecedor = null;
		String sql = "SELECT * FROM pessoas WHERE is_fornecedor = 1 AND codigo = ?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, codigo);
			ResultSet resultado = stmt.executeQuery();
			
			if (resultado.next()) {
				String nome = resultado.getString("Nome");
				String sobrenome = resultado.getString("sobrenome");
				String telefone = resultado.getString("telefone");
				String cpf = resultado.getString("cpf");
				String email = resultado.getString("email");
				String nascimento = resultado.getString("nascimento");
				
				fornecedor = new Fornecedor(cpf, nome, sobrenome, email, telefone, nascimento);
				fornecedor.setCodigo(codigo);
			}
			stmt.close();
			resultado.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return fornecedor;
	}

	@Override
	public boolean inserir() {
		String sql = "INSERT INTO pessoas " 
					  + "(nome, sobrenome, telefone, cpf, email, nascimento, is_fornecedor) "
				   + "VALUES " 
					  + "(?, ?, ?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getSobrenome());
			stmt.setString(3, fornecedor.getTelefone());
			stmt.setString(4, fornecedor.getCpf());
			stmt.setString(5, fornecedor.getEmail());
			stmt.setString(6, fornecedor.getNascimento());
			stmt.setInt(7, 1);
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				int codigo = rs.getInt(1);
				this.fornecedor.setCodigo((long)codigo);	
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
		String sql = "UPDATE pessoas SET "
					  + "nome = ?, sobrenome = ?, telefone = ?, cpf = ?, email = ?, nascimento = ? "
				   + "WHERE codigo = ? AND is_fornecedor = 1";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getSobrenome());
			stmt.setString(3, fornecedor.getTelefone());
			stmt.setString(4, fornecedor.getCpf());
			stmt.setString(5, fornecedor.getEmail());
			stmt.setString(6, fornecedor.getNascimento());
			stmt.setLong(7, codigo);

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
		String sql = "DELETE FROM pessoas WHERE codigo = ? AND is_fornecedor = 1";

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
