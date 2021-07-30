/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.chart.PieChart.Data;
import model.Venda;

/**
 *
 * @author victo
 */
public class VendaDAO {
    private final Connection connection;

    public VendaDAO(Connection connection) {
        this.connection = connection;
    }   
    
    public Venda insert(Venda venda ) throws SQLException{
       
                String sql = "insert into venda (codvenda, data, cliente, funcionario) values (?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, venda.getCodvenda());
                statement.setDate(2, venda.getData());
                statement.setInt(3, venda.getCliente());
                statement.setInt(4, venda.getFuncionario());
                statement.execute();
                
                ResultSet resultset = statement.getGeneratedKeys();
            
                if(resultset.next()){
                    int id = resultset.getInt("idvenda");
                    venda.setIdvenda(id); 
                }

                return venda;
    }
    
    public ArrayList<Venda> selectAllvenda() throws SQLException{
        String sql = "select * from venda";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisavenda(statement); 
      }
    
    private ArrayList<Venda> pesquisavenda (PreparedStatement statement) throws SQLException {
        ArrayList<Venda> venda = new ArrayList<Venda>();
        
        statement.execute(); 
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()){
            int id = resultSet.getInt("idvenda");
            int codvenda = resultSet.getInt("codvenda");
            Date data = resultSet.getDate("data");
            Double total = resultSet.getDouble("total");
            int cliente = resultSet.getInt("cliente");
            int funcionario = resultSet.getInt("funcionario");
            
            Venda vendaComDadosDoBanco = new Venda(id, codvenda, data, total, cliente, funcionario);
            venda.add(vendaComDadosDoBanco);
        }
        
        return venda;
    }
    
    public void update(Venda venda) throws SQLException{
        String sql = "update venda set total = ? where idvenda = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, venda.getTotal());
        statement.setInt(2, venda.getIdvenda());
        statement.execute();  
    }
}
