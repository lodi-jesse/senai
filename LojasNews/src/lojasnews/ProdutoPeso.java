package lojasnews;

import java.security.InvalidParameterException;

public class ProdutoPeso extends Produto {

	private double quantidadeEstoqueKg;

	public ProdutoPeso() {

	}

	public ProdutoPeso(String nome, double preco, double quantidadeEstoqueKg) {
		super(nome, preco);
		this.quantidadeEstoqueKg = quantidadeEstoqueKg;
	}

	public double getQuantidadeEstoqueKg() {
		return quantidadeEstoqueKg;
	}

	public void setQuantidadeEstoqueKg(double quantidadeEstoqueKg) {
		if (quantidadeEstoqueKg < 0)
			throw new InvalidParameterException
			("Quantidade no estoque do produto \"" + super.getNome() + "\" � inv�lida");
		else
			this.quantidadeEstoqueKg = quantidadeEstoqueKg;
	}

}
