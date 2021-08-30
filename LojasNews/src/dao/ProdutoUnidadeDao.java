package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conecta.Conecta;
import principal.ProdutoUnidade;

public class ProdutoUnidadeDao implements IGerenciamentoDAO{
	
	private Connection conexao = Conecta.getConnection();
	private ProdutoUnidade produtoU;
	
	
	public ProdutoUnidade getProdutoU() {
		return produtoU;
	}
	public void setProdutoU(ProdutoUnidade produtoU) {
		this.produtoU = produtoU;
	}
	
	@Override
	public boolean inserir() {
		String sql = "INSERT INTO produtos"
				  +"(nome, preco, quantidade, is_peso)"
				    +"VALUES"
				      +"(?, ?, ?, ?)";
		try {
	   PreparedStatement smmt = conexao.prepareStatement(sql);
	    smmt.setString(1, produtoU.getNome());
		smmt.setDouble(2, produtoU.getPreco());
		smmt.setInt(3, produtoU.getQuantidadeEstoqueUn());
		smmt.setInt(4, 0);
		
		smmt.execute();
		smmt.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		 return false;
	}
	       return true;
	      
	} 
	
	  @Override
	public boolean atualizar(Long codigo) {
		  String sql = "UPDATE produtos SET"
				     +"nome = ?, preco = ?, quantidade = ?"
				    +"WHERE codigo  = ? AND is_peso = 0";
		  try {
		  PreparedStatement smmt = conexao.prepareStatement(sql);
			smmt.setString(1, produtoU.getNome());
			smmt.setDouble(2, produtoU.getPreco());
			smmt.setInt(3, produtoU.getQuantidadeEstoqueUn());
			smmt.setLong(4, codigo);
			
			smmt.execute();
			smmt.close(); 
			
		 } catch (SQLException e) {
				e.printStackTrace();
		return false;
	}
		 return true;
 }  
     @Override
    public boolean excluir(Long codigo) {
          String sql = "DELETE FROM produtos WHERE codigo = ? AND is_peso = 0";
		 
		  try {
	        PreparedStatement smmt = conexao.prepareStatement(sql);
	        smmt.setLong(1, codigo);
	        
	        smmt.execute();
			smmt.close();
			
	 } catch (SQLException e) {
			e.printStackTrace();
    	return false;
    }
	 
	 return true;
	 
}


}
	
	


