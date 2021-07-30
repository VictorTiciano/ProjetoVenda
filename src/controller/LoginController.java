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
import view.LoginView;
import view.MenuFuncionarioView;
import view.MenuGerenteView;

/**
 *
 * @author victo
 */
public class LoginController {
    private final LoginView view;
    
    public LoginController(LoginView view) {
        this.view = view;
    }
    
    public void autenticar() throws SQLException {
        
        String cargo = view.getjComboBoxCargo().getSelectedItem().toString();
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldsenha().getText();
        
        Funcionario funcionarioAutenticar = new Funcionario(cargo, usuario, senha);
    
        Connection conexao = new Conexao().getConnection();
        FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);
        
        boolean autenticar = funcionarioDao.autenticarFuncionarioPorUsuarioESenha(funcionarioAutenticar);
        String funcionario = "Funcionario";
        String gerente = "Gerente";
        boolean autenticar2 = funcionario.equals(cargo);
        boolean autenticar3 = gerente.equals(cargo);
        
        if (autenticar && autenticar3){
          MenuGerenteView telaDeMenu = new MenuGerenteView(); 
          telaDeMenu.setVisible(true); 
        }else
        if (autenticar && autenticar2 ){
            MenuFuncionarioView telaDeMenuFuncionario = new MenuFuncionarioView();
            telaDeMenuFuncionario.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(view, "Dados preenchidos incorretos");
    }
        
  }
    
}
