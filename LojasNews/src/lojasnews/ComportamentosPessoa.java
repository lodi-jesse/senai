package lojasnews;

public interface ComportamentosPessoa {

	public String toString();

	public void comprar(ProdutoUnidade produto, int quantidade);

	public void comprar(ProdutoPeso produto, double quantidade);

	public void comprimentar();

}
