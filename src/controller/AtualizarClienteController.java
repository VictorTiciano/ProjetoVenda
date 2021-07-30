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
import javax.swing.JOptionPane;
import model.Cliente;
import view.AtualizarClienteView;
/**
 *
 * @author victo
 */
public class AtualizarClienteController {
    private AtualizarClienteView view;
    
    public AtualizarClienteController(AtualizarClienteView view){
        this.view = view;
    }
    
    public void atualizarcliente() throws SQLException{
        
        
        int id = Integer.parseInt(view.getjTextFieldid().getText());
        String nome = view.getjTextFieldnome().getText();
        String telefone = view.getjTextFieldtelefone().getText();
        String email = view.getjTextFieldemail().getText();
        String cpf = view.getjTextFieldcpf().getText();
        
        Cliente cliente = new Cliente(id, nome, telefone, email, cpf);
        view.getjTextFieldid().setText("");
        view.getjTextFieldnome().setText("");
        view.getjTextFieldtelefone().setText("");
        view.getjTextFieldemail().setText("");
        view.getjTextFieldcpf().setText("");
        
        JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
        
        Connection conexao = new Conexao().getConnection();
            ClienteDAO clienteDao = new ClienteDAO(conexao);
            clienteDao.update(cliente);
    }
}
