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
import model.Cliente;

/**
 *
 * @author victo
 */
public class ClienteDAO {
    private final Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Cliente cliente ) throws SQLException{
            String sql = "insert into cliente (nome, telefone, email, cpf) values (?,?,?,?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getCpf());
            statement.execute();
            
            connection.close();
    }
    
    
    public ArrayList<Cliente> selectAllcliente() throws SQLException{
        String sql = "select * from cliente";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisacliente(statement); 
      }
    
    private ArrayList<Cliente> pesquisacliente (PreparedStatement statement) throws SQLException {
        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        
        statement.execute(); 
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()){
            int id = resultSet.getInt("idcliente");
            String nome = resultSet.getString("nome");
            String telefone =  resultSet.getString("telefone");
            String email = resultSet.getString("email");
            String cpf = resultSet.getString("cpf");
            
            Cliente clienteComDadosDoBanco = new Cliente(id,nome,telefone,email,cpf);
            cliente.add(clienteComDadosDoBanco);
        }
        
        return cliente;
    }
    
    public void delete(Cliente cliente) throws SQLException{
        String sql = "delete from cliente where idcliente = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, cliente.getId());
        statement.execute();  
      }
    
    public void update(Cliente cliente) throws SQLException{
        String sql = "update cliente set nome = ?, telefone = ?, email = ?, cpf = ? where idcliente = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getTelefone());
        statement.setString(3, cliente.getEmail());
        statement.setString(4, cliente.getCpf());
        statement.setInt(5, cliente.getId());
        statement.execute();  
    }
}
