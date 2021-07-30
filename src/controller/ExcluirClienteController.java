/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;
import view.ExcluirClienteView;

/**
 *
 * @author victo
 */
public class ExcluirClienteController {
    
    private ExcluirClienteView view;
    
    
    public ExcluirClienteController(ExcluirClienteView view){
        this.view = view;
    }
    
    
    public void excluircliente() {
        
        int id = Integer.parseInt(view.getjTextFieldid().getText());
        
        Cliente cliente = new Cliente(id);
        view.getjTextFieldid().setText("");
        
        
        
        try {
            Connection conexao = new Conexao().getConnection();
            ClienteDAO clienteDao = new ClienteDAO(conexao);
            clienteDao.delete(cliente);
            JOptionPane.showMessageDialog(null, "Cliente Excluido com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(ExcluirClienteView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não é possivel excluir esse cliente no momento!");
        }
    }
    
}
