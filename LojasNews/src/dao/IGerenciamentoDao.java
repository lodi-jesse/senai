package dao;

public interface IGerenciamentoDao {

	public void consultar();

	public boolean inserir();

	public boolean atualizar(Long codigo);

	public boolean excluir(Long codigo);

}
