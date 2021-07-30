/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ItensVenda;
/**
 *
 * @author victo
 */
public class ItensVendaDAO {
    private final Connection connection;

    public ItensVendaDAO(Connection connection) {
        this.connection = connection;
    }
    
    public ItensVenda insert(ItensVenda itemvenda ) throws SQLException{
       
                String sql = "insert into itensvenda (produto, venda, qtd, subtotal) values (?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, itemvenda.getProduto());
                statement.setInt(2, itemvenda.getVenda());
                statement.setInt(3, itemvenda.getQuantidade());
                statement.setDouble(4, itemvenda.getSubtotal());
                statement.execute();
                
                ResultSet resultset = statement.getGeneratedKeys();
            
                if(resultset.next()){
                    int id = resultset.getInt("iditensvenda");
                    itemvenda.setId(id); 
                }

                return itemvenda;
    }
    
    public ArrayList<ItensVenda> selectAllitensvenda() throws SQLException{
        String sql = "select * from itensvenda";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisaitensvenda(statement); 
      }
    
    public ArrayList<ItensVenda> selectAllitensvenda1(ItensVenda itemvenda1) throws SQLException{
        String sql = "select * from itensvenda where venda = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,itemvenda1.getVenda() );
        
        return pesquisaitensvenda1(statement); 
      }
    
    private ArrayList<ItensVenda> pesquisaitensvenda (PreparedStatement statement) throws SQLException {
        ArrayList<ItensVenda> itensvenda = new ArrayList<ItensVenda>();
        
        statement.execute(); 
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()){
            int id = resultSet.getInt("iditensvenda");
            int produto = resultSet.getInt("produto");
            int venda = resultSet.getInt("venda");
            int quantidade = resultSet.getInt("qtd");
            double marca = resultSet.getDouble("subtotal");
            
            ItensVenda itensvendaComDadosDoBanco = new ItensVenda(id, produto, venda, quantidade, marca);
            itensvenda.add(itensvendaComDadosDoBanco);
        }
        
        return itensvenda;
    }
    
    private ArrayList<ItensVenda> pesquisaitensvenda1 (PreparedStatement statement) throws SQLException {
        ArrayList<ItensVenda> itensvenda = new ArrayList<ItensVenda>();
        
        statement.execute(); 
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()){
            int venda = resultSet.getInt("venda");
            
            ItensVenda itensvendaComDadosDoBanco = new ItensVenda(venda);
            itensvenda.add(itensvendaComDadosDoBanco);
        }
        
        return itensvenda;
    }
    
}
