package principal;

import dao.CompraParaEstoqueDao;
import entidades.Pessoa;

public class Fornecedor extends Pessoa implements ComportamentosPessoa {

	public Fornecedor() {
		super();
	}

	public Fornecedor(String nome, String sobrenome, String telefone) {
		super(nome, sobrenome, telefone);
	}

	public Fornecedor(String cpf, String nome, String sobrenome, String email, String telefone, String nascimento) {
		super(cpf, nome, sobrenome, email, telefone, nascimento);
	}

	@Override
	public String toString() {
		return getCodigo() + " - " + getNome() + " " + getSobrenome() + " - " + getTelefone();
	}

	@Override
	public void comprar(ProdutoUnidade produto, int quantidade) {
		int estoqueAtual = produto.getQuantidadeEstoqueUn();
		produto.setQuantidadeEstoqueUn(estoqueAtual + quantidade);
		
		new CompraParaEstoqueDao(this, produto, quantidade).inserir();
	}

	@Override
	public void comprar(ProdutoPeso produto, double quantidade) {
		double estoqueAtual = produto.getQuantidadeEstoqueKg();
		produto.setQuantidadeEstoqueKg(estoqueAtual + quantidade);
		
		new CompraParaEstoqueDao(this, produto, quantidade).inserir();
	}

	@Override
	public void comprimentar() {
		System.out.println("\nOla seu Josevaldo! Gostaria de comprar o que hoje?\n");
	}

}
