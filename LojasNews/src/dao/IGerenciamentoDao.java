package dao;

public interface IGerenciamentoDao {

	public boolean inserir();

	public boolean atualizar(Long codigo);

	public boolean excluir(Long codigo);

}
