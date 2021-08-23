package entidades;

import entidades.Pessoa;
import java.util.Date;
import lojasnews.ComportamentosPessoa;

public class Fornecedor extends Pessoa implements ComportamentosPessoa {

	public Fornecedor() {
		super();
	}

	public Fornecedor(String nome, String telefone) {
		super(nome, telefone);
	}

	public Fornecedor(String cpf, String nome, String email, String telefone, Date nascimento) {
		super(cpf, nome, email, telefone, nascimento);
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
		System.out.println("\nOl� seu Jos�! Gostaria de comprar o que hoje?\n");
	}

}
