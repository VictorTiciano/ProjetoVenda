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
import model.Funcionario;

/**
 *
 * @author victo
 */
public class FuncionarioDAO {
    private final Connection connection;

    public FuncionarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Funcionario funcionario) throws SQLException{
            String sql = "insert into funcionario (nome, telefone, cpf, cargo, salario, email, usuario, senha) values (?,?,?,?,?,?,?,?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,funcionario.getNome());
            statement.setString(2, funcionario.getTelefone());
            statement.setString(3, funcionario.getCpf());
            statement.setString(4, funcionario.getCargo());
            statement.setDouble(5, funcionario.getSalario());
            statement.setString(6, funcionario.getEmail());
            statement.setString(7, funcionario.getUsuario());
            statement.setString(8, funcionario.getSenha());
            statement.execute();
            
            connection.close();
    }
    
    
    public ArrayList<Funcionario> selectAllfuncionario() throws SQLException{
        String sql = "select * from funcionario";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisafuncionario(statement); 
      }
    
    private ArrayList<Funcionario> pesquisafuncionario (PreparedStatement statement) throws SQLException {
        ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();
        
        statement.execute(); 
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()){
            int id = resultSet.getInt("idfuncionario");
            String nome = resultSet.getString("nome");
            String telefone =  resultSet.getString("telefone");
            String cpf = resultSet.getString("cpf");
            String cargo = resultSet.getString("cargo");
            double salario = Double.parseDouble(resultSet.getString("salario"));
            String email = resultSet.getString("email");
            String usuario = resultSet.getString("usuario");
            String senha = resultSet.getString("senha");
            
            Funcionario funcionarioComDadosDoBanco = new Funcionario(id,nome,telefone,cpf,cargo,salario,email,usuario,senha);
            funcionario.add(funcionarioComDadosDoBanco);
        }
        
        return funcionario;
    }
    
    public void delete(Funcionario funcionario) throws SQLException{
        String sql = "delete from funcionario where idfuncionario = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, funcionario.getId());
        statement.execute();  
      }
    
    
    public void update(Funcionario funcionario) throws SQLException{
        String sql = "update funcionario set nome = ?, telefone = ?, cpf = ?, cargo = ?, salario = ?, email = ?, usuario = ?, senha = ? where idfuncionario = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,funcionario.getNome());
            statement.setString(2, funcionario.getTelefone());
            statement.setString(3, funcionario.getCpf());
            statement.setString(4, funcionario.getCargo());
            statement.setDouble(5, funcionario.getSalario());
            statement.setString(6, funcionario.getEmail());
            statement.setString(7, funcionario.getUsuario());
            statement.setString(8, funcionario.getSenha());
            statement.setInt(9, funcionario.getId());
        statement.execute();  
    }
    
    public boolean autenticarFuncionarioPorUsuarioESenha(Funcionario funcionario) throws SQLException {
        String sql = "select * from funcionario where usuario = ? and senha = ? and cargo = ? ";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, funcionario.getUsuario());
        statement.setString(2, funcionario.getSenha());
        statement.setString(3, funcionario.getCargo());
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        return resultSet.next();  
   }
}
