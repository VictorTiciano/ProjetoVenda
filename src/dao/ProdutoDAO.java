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
import model.Produto;

/**
 *
 * @author victo
 */
public class ProdutoDAO {
     private final Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public Produto insert(Produto produto ) throws SQLException{
       
                String sql = "insert into produto (nome, estoque, preco, marca) values (?,?,?,?)";
                PreparedStatement ps2 = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps2.setString(1, produto.getNome());
                ps2.setInt(2, produto.getEstoque());
                ps2.setDouble(3, produto.getPreco());
                ps2.setInt(4, produto.getMarca());
                ps2.execute();
                
                ResultSet resultset = ps2.getGeneratedKeys();
            
                if(resultset.next()){
                    int id = resultset.getInt("idproduto");
                    produto.setId(id); 
                }

                return produto;
    }
       
    public ArrayList<Produto> selectAllproduto() throws SQLException{
        String sql = "select * from produto";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisaproduto(statement); 
      }
    
    private ArrayList<Produto> pesquisaproduto (PreparedStatement statement) throws SQLException {
        ArrayList<Produto> produto = new ArrayList<Produto>();
        
        statement.execute(); 
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()){
            int id = resultSet.getInt("idproduto");
            String nome = resultSet.getString("nome");
            int estoque = Integer.parseInt(resultSet.getString("estoque"));
            double preco = Double.parseDouble(resultSet.getString("preco"));
            int marca = Integer.parseInt(resultSet.getString("marca"));
            
            Produto produtoComDadosDoBanco = new Produto(id, nome, estoque, preco, marca);
            produto.add(produtoComDadosDoBanco);
        }
        
        return produto;
    }
    
    
    
    public void delete(Produto produto) throws SQLException{
        String sql = "delete from produto where idproduto = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, produto.getId());
        statement.execute();  
      }
    
    public void update(Produto produto) throws SQLException{
        String sql = "update produto set nome = ?, estoque = ?, preco = ?, marca = ? where idproduto = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, produto.getNome());
        statement.setInt(2, produto.getEstoque());
        statement.setDouble(3, produto.getPreco());
        statement.setInt(4, produto.getMarca());
        statement.setInt(5, produto.getId());
        statement.execute();  
    }
    
}
