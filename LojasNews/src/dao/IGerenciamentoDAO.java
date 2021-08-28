package dao;


public interface IGerenciamentoDAO {
    
    public boolean inserir();
    
    public boolean atualizar(int codigo);
    
    public boolean excluir(int codigo);
    
}
