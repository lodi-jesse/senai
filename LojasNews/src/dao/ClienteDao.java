package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conecta.Conecta;
import principal.Cliente;

public class ClienteDao implements IGerenciamentoDao {

	private static Connection conexao = Conecta.getConnection();
	private Cliente cliente;

	public ClienteDao(Cliente cliente) {
		this.cliente = cliente;
	}

   
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public boolean inserir() {
		String sql = "INSERT INTO pessoas "
					   + "(nome, sobrenome, telefone, cpf, email, nascimento, is_fornecedor) "
				   + "VALUES "
					   + "(?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getSobrenome());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getCpf());
			stmt.setString(5, cliente.getEmail());
			stmt.setString(6, cliente.getNascimento());
			stmt.setInt(7, 0);
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				int codigo = rs.getInt(1);
				this.cliente.setCodigo((long)codigo);	
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
				   + "WHERE codigo = ? AND is_fornecedor = 0";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getSobrenome());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getCpf());
			stmt.setString(5, cliente.getEmail());
			stmt.setString(6, cliente.getNascimento());
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
		String sql = "DELETE FROM pessoas WHERE codigo = ? AND is_fornecedor = 0";

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
