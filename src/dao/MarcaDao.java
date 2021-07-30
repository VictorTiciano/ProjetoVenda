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
import java.util.ArrayList;
import model.Marca;

/**
 *
 * @author victo
 */
public class MarcaDao {
    private final Connection connection;

    public MarcaDao(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Marca marca ) throws SQLException{
        
            String sql = "insert into marca (nome) values (?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, marca.getNome());
            statement.execute();
            
            connection.close();
    }
    
    public ArrayList<Marca> selectAllmarca() throws SQLException{
        String sql = "select * from marca";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisamarca(statement); 
      }
    
    
    private ArrayList<Marca> pesquisamarca (PreparedStatement statement) throws SQLException {
        ArrayList<Marca> marca = new ArrayList<Marca>();
        
        statement.execute(); 
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()){
            int id = resultSet.getInt("idmarca");
            String nome = resultSet.getString("nome");
            
            Marca marcaComDadosDoBanco = new Marca(id, nome);
            marca.add(marcaComDadosDoBanco);
        }
        
        return marca;
    }
    
    public void delete(Marca marca) throws SQLException{
        String sql = "delete from marca where idmarca = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, marca.getIdmarca());
        statement.execute();  
      }
    
    public void update(Marca marca) throws SQLException{
        String sql = "update marca set nome = ? where idmarca = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, marca.getNome());
        statement.setInt(2, marca.getIdmarca());
        statement.execute();  
    }
}
