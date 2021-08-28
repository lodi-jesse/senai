package principal;

import entidades.Pessoa;
import java.util.Date;

public class Fornecedor extends Pessoa implements ComportamentosPessoa {

	public Fornecedor() {
		super();
	}

	public Fornecedor(String nome, String sobrenome, String telefone) {
		super(nome, sobrenome, telefone);
	}

	public Fornecedor(String cpf, String nome, String sobrenome, String email, String telefone, Date nascimento) {
		super(cpf, nome, sobrenome, email, telefone, nascimento);
	}

	@Override
	public String toString() {
		return "\nFornecedor " + super.getCodigo() + ": " + super.getNome() + "\ncontato: " + super.getTelefone();
	}

	@Override
	public void comprar(ProdutoUnidade produto, int quantidade) {
		int estoqueAtual = produto.getQuantidadeEstoqueUn();
		produto.setQuantidadeEstoqueUn(estoqueAtual + quantidade);
	}

	@Override
	public void comprar(ProdutoPeso produto, double quantidade) {
		double estoqueAtual = produto.getQuantidadeEstoqueKg();
		produto.setQuantidadeEstoqueKg(estoqueAtual + quantidade);
	}

	@Override
	public void comprimentar() {
		System.out.println("\nOla seu Josevaldo! Gostaria de comprar o que hoje?\n");
	}

}
