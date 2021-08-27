package dao;


import uteis.Conexao;

public class PessoaDao implements IGerenciamentoDAO {

    private Conexao conexao;
    
    
    @Override
    public boolean inserir() {
        
        try {
            

            
        } catch (Exception e) {
            
            return false;
            
        }
        
        return true;
    }

    @Override
    public boolean atualizar() {
        
        return true;
    }

    @Override
    public boolean excluir() {
        
        return true;
        
    }
    
    
    
}
