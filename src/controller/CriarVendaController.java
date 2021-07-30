/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.VendaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Venda;
import org.postgresql.util.JdbcBlackHole;
import view.CriarVenda;

/**
 *
 * @author victo
 */
public class CriarVendaController {
    private CriarVenda view;
    
    public CriarVendaController(CriarVenda view){
        this.view = view;
    }
    
    public void criarvenda() throws ParseException, SQLException {
        
        int codvenda = Integer.parseInt(view.getjTextFieldcodvenda().getText());
        java.util.Date data = new java.util.Date();
        java.sql.Date datasql = new java.sql.Date(data.getTime());
        int funcionario = Integer.parseInt(view.getjTextFieldidfuncionario().getText());
        int cliente = Integer.parseInt(view.getjTextFieldidcliente().getText());
        
        Venda venda = new Venda(codvenda, datasql, cliente, funcionario);
        view.getjTextFieldcodvenda().setText("");
        view.getjTextFieldidcliente().setText("");
        view.getjTextFieldidfuncionario().setText("");
        
        try {
            Connection conexao = Conexao.getConnection();
            VendaDAO vendaDao = new VendaDAO(conexao);
            vendaDao.insert(venda);
            
        } catch (SQLException ex) {
            Logger.getLogger(CriarVenda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao criar venda!");
        }
    }
    
}
