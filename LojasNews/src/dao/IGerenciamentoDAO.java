package dao;


public interface IGerenciamentoDAO {
    
    public boolean inserir();
    
    public boolean atualizar (Long codigo);
    
    public boolean excluir (Long codigo);
    
}
