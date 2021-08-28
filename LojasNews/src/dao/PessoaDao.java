package dao;


import conecta.Conecta;

public class PessoaDao implements IGerenciamentoDAO {

    private Conecta conecta;
    
    
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
