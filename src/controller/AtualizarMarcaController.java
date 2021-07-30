/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.MarcaDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Marca;
import view.AtualizarMarca;
import view.CadastrarMarca;

/**
 *
 * @author victo
 */
public class AtualizarMarcaController {
    private AtualizarMarca view;
    
    public AtualizarMarcaController(AtualizarMarca view){
        this.view = view;
    }
    
    public void atualizarmarca(){
        
        int id = Integer.parseInt(view.getjTextFieldid().getText());
        String nome = view.getjTextFieldnome().getText();
        
        Marca marca = new Marca(id, nome);
        
        view.getjTextFieldid().setText("");
        view.getjTextFieldnome().setText("");
        
        JOptionPane.showMessageDialog(null, "Marca atualizada com sucesso!");
        
        try {
            Connection conexao = new Conexao().getConnection();
            MarcaDao MarcaDAO = new MarcaDao(conexao);
            MarcaDAO.update(marca);
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarMarca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
