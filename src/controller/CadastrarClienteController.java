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
import view.CadastarCliente;

/**
 *
 * @author victo
 */
public class CadastrarClienteController {
    private CadastarCliente view;
    
    public CadastrarClienteController(CadastarCliente view){
        this.view = view;
    }

    public void cadastrarcliente() {
        
        String nome = view.getjTextFieldnome().getText();
        String telefone = view.getjTextFieldtelefone().getText();
        String cpf = view.getjTextFieldcpf().getText();
        String email = view.getjTextFieldemail().getText();
        
        Cliente cliente = new Cliente(nome, telefone, email,cpf);
        view.getjTextFieldnome().setText("");
        view.getjTextFieldtelefone().setText("");
        view.getjTextFieldemail().setText("");
        view.getjTextFieldcpf().setText("");
        
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        
        try {
            Connection conexao = new Conexao().getConnection();
            ClienteDAO clienteDao = new ClienteDAO(conexao);
            clienteDao.insert(cliente);
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
 