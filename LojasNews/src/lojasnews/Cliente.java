package lojasnews;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {

	private static Long contadorCodigo = 1l;
	private Long codigo;

	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private Date nascimento;

	private List<Pedido> pedidos = new ArrayList<>();

	public Cliente() {

	}

	public Cliente(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;

		codigo = contadorCodigo;
		contadorCodigo += 1;
	}

	public Cliente(String cpf, String nome, String email, String telefone, Date nascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.nascimento = nascimento;

		codigo = contadorCodigo;
		contadorCodigo += 1;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		double total = 0;
		String mensagem = nome + ", com o(s) pedido(s): ";

		for (Pedido pedido : pedidos) {
			mensagem += pedido.getCodigo() + ", ";
			total += pedido.getValorTotal();
		}

		return mensagem += "\n--> R$:" + total;
	}

}
