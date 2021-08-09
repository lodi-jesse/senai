package lojasnews;

import java.util.Date;

public abstract class Pessoa {

	private static Long contadorCodigo = 1l;
	private Long codigo;

	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private Date nascimento;

	public Pessoa() {

	}

	public Pessoa(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;

		codigo = contadorCodigo;
		contadorCodigo += 1;
	}

	public Pessoa(String cpf, String nome, String email, String telefone, Date nascimento) {
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

}
