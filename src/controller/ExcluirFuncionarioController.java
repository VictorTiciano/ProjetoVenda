/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.FuncionarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Funcionario;
import view.ExcluirFuncionario;

/**
 *
 * @author victo
 */
public class ExcluirFuncionarioController {
    
    private ExcluirFuncionario view;
    
    public ExcluirFuncionarioController(ExcluirFuncionario view){
        this.view = view;
    }
    
    public void excluirfuncionario() {
        
        int id = Integer.parseInt(view.getjTextFieldId().getText());
        
        Funcionario cliente = new Funcionario(id);
        view.getjTextFieldId().setText("");
        
        
        
        try {
            Connection conexao = new Conexao().getConnection();
            FuncionarioDAO clienteDao = new FuncionarioDAO(conexao);
            clienteDao.delete(cliente);
            JOptionPane.showMessageDialog(null, "Funcionario Excluido com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(ExcluirFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não é possivel excluir esse funcionario no momento!");
        }
    }
    
}
