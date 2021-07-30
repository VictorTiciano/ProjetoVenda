/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author victo
 */
public class Conexao {
   public static Connection getConnection() throws SQLException{
       Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Projeto Venda", "postgres", "postgres" );
       return conexao;
   } 
}
