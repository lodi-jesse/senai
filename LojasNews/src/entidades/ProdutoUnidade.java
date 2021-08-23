package entidades;

import entidades.Produto;
import java.security.InvalidParameterException;

public class ProdutoUnidade extends Produto {

	private int quantidadeEstoqueUn;

	public ProdutoUnidade() {

	}

	public ProdutoUnidade(String nome, double preco, int quantidadeEstoqueUn) {
		super(nome, preco);
		this.quantidadeEstoqueUn = quantidadeEstoqueUn;
	}

	public int getQuantidadeEstoqueUn() {
		return quantidadeEstoqueUn;
	}

	public void setQuantidadeEstoqueUn(int quantidadeEstoqueUn) {
		if (quantidadeEstoqueUn < 0)
			throw new InvalidParameterException(
					"Quantidade no estoque do produto \"" + super.getNome() + "\" � inv�lida");
		else
			this.quantidadeEstoqueUn = quantidadeEstoqueUn;
	}

}
