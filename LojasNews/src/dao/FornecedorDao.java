package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conecta.Conecta;
import principal.Fornecedor;

public class FornecedorDao implements IGerenciamentoDAO {

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
	public boolean inserir() {
		String sql = "INSERT INTO pessoas " 
					  + "(nome, sobrenome, telefone, cfp, email, nascimento, is_fornecedor) "
				   + "VALUES " 
					  + "(?, ?, ?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, fornecedor.getNome());
			stmt.setString(2, fornecedor.getSobrenome());
			stmt.setString(3, fornecedor.getTelefone());
			stmt.setString(4, fornecedor.getCpf());
			stmt.setString(5, fornecedor.getEmail());
			stmt.setDate(6, (Date) fornecedor.getNascimento());
			stmt.setInt(7, 1);

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
			stmt.setDate(6, (Date) fornecedor.getNascimento());
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
