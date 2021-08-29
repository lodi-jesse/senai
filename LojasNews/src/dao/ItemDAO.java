package dao;

import conecta.Conecta;
import entidades.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ItemDAO implements IGerenciamentoDAO{

    public static Connection conexao = Conecta.getConnection();
    private Item item;

    public ItemDAO(Item item) {
        this.item = item;
    }
    
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean inserir() {

        String sql = "INSERT INTO item"
            +"(produto, quantidade)"
        + "VALUES "
                + "(?, ?)";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setInt(1, item.getProduto());
            stm.setDouble(2, item.getQuantidade());

            stm.execute();
            stm.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    @Override
    public boolean atualizar(int codigo) {
        String sql = "UPDATE item SET"
            +"produto = ?, quantidade = ?"
                + "WHERE codigo = ? AND is_fornecedor = 0";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setInt(1, item.getProduto());
            stm.setDouble(2, item.getQuantidade());

            stm.execute();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean excluir(int codigo) {
        String sql = "DELETE FROM item WHERE codigo = ? AND is_fornecedor = 0";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, codigo);

            stm.execute();
            stm.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
