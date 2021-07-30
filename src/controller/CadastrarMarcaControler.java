/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import dao.Conexao;
import dao.MarcaDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Marca;
import view.CadastarCliente;
import view.CadastrarMarca;

/**
 *
 * @author victo
 */
public class CadastrarMarcaControler {
    private CadastrarMarca view;
    
    public CadastrarMarcaControler(CadastrarMarca view){
        this.view = view;
    }
    
    public void cadastrarMarca(){
        
        String nome = view.getjTextFieldnome().getText();
        
        Marca marca = new Marca(nome);
        view.getjTextFieldnome().setText("");
        
        JOptionPane.showMessageDialog(null, "Marca cadastrado com sucesso!");
        
        try {
            Connection conexao = new Conexao().getConnection();
            MarcaDao MarcaDAO = new MarcaDao(conexao);
            MarcaDAO.insert(marca);
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarMarca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

