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
import model.Cliente;
import model.Marca;
import view.ExcluirMarca;

/**
 *
 * @author victo
 */
public class ExcluirMarcaController {
    
    private ExcluirMarca view;
    
    
    public ExcluirMarcaController(ExcluirMarca view){
        this.view = view;
    }
    
    public void excluirmarca() {
        
        int id = Integer.parseInt(view.getjTextFieldId().getText());
        
        Marca marca = new Marca(id);
       view.getjTextFieldId().setText("");
        
        try {
            Connection conexao = new Conexao().getConnection();
            MarcaDao marcaDao = new MarcaDao(conexao);
            marcaDao.delete(marca);
            JOptionPane.showMessageDialog(null, "Marca Excluida com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(ExcluirMarca.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não é possivel excluir essa marca no momento!");
        }
    }
}
