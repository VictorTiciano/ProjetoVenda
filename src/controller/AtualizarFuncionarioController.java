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
import javax.swing.JOptionPane;
import model.Funcionario;
import view.AtualizarFuncionarioView;

/**
 *
 * @author victo
 */
public class AtualizarFuncionarioController {
    private AtualizarFuncionarioView view;
    
    public AtualizarFuncionarioController(AtualizarFuncionarioView view){
        this.view = view;
    }
    
    public void atualizarfuncionario() throws SQLException{
        
        int id = Integer.parseInt(view.getjTextFieldid().getText());
        String nome = view.getjTextFieldnome().getText();
        String telefone = view.getjTextFieldtelefone().getText();
        String cpf = view.getjTextFieldcpf().getText();
        String cargo = view.getjTextFieldcargo().getText();
        double salario = Double.parseDouble(view.getjTextFieldsalario().getText());
        String email = view.getjTextFieldemail().getText();
        String usuario = view.getjTextFieldusuario().getText();
        String senha = view.getjTextFieldsenha().getText();
        
        Funcionario funcionario = new Funcionario(id, nome, telefone, cpf, cargo, salario, email, usuario, senha);
        view.getjTextFieldid().setText("");
        view.getjTextFieldnome().setText("");
        view.getjTextFieldtelefone().setText("");
        view.getjTextFieldcpf().setText("");
        view.getjTextFieldcargo().setText("");
        view.getjTextFieldsalario().setText("");
        view.getjTextFieldemail().setText("");
        view.getjTextFieldusuario().setText("");
        view.getjTextFieldsenha().setText("");
        
        JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso!");
        
        Connection conexao = Conexao.getConnection();
            FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);
            funcionarioDao.update(funcionario);
    }
    
}
