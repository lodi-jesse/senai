package lojasnews;

import entidades.ProdutoUnidade;
import entidades.ProdutoPeso;

public interface ComportamentosPessoa {

	public String toString();

	public void comprar(ProdutoUnidade produto, int quantidade);

	public void comprar(ProdutoPeso produto, double quantidade);

	public void comprimentar();

}
