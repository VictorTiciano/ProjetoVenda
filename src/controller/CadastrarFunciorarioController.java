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
import view.CadastrarFuncionarioView;

/**
 *
 * @author victo
 */
public class CadastrarFunciorarioController {
    private CadastrarFuncionarioView view;

    public CadastrarFunciorarioController(CadastrarFuncionarioView view) {
        this.view = view;
    }
    
    public void cadastrarFuncionario(){
        
        String nome = view.getjTextFieldnome().getText();
        String telefone = view.getjTextFieldtelefone().getText();
        String cpf = view.getjTextFieldcpf().getText();
        String cargo = view.getjTextFieldcargo().getText();
        double salario = Double.parseDouble(view.getjTextFieldsalario().getText());
        String email = view.getjTextFieldemail().getText();
        String usuario = view.getjTextFieldusuario().getText();
        String senha = view.getjPasswordFieldsenha().getText();
        
        Funcionario funcionario = new Funcionario(nome, telefone,cpf, cargo, salario, email, usuario, senha);
        
        view.getjTextFieldnome().setText("");
        view.getjTextFieldtelefone().setText("");
        view.getjTextFieldcpf().setText("");
        view.getjTextFieldcargo().setText("");
        view.getjTextFieldsalario().setText("");
        view.getjTextFieldemail().setText("");
        view.getjTextFieldusuario().setText("");
        view.getjPasswordFieldsenha().setText("");
        
        try {
            Connection conexao = new Conexao().getConnection();
            FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);
            funcionarioDao.insert(funcionario);
            JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarFuncionarioView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionario");
        }
    } 
}
