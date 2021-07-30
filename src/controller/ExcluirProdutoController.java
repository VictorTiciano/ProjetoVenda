/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.ProdutoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Produto;
import view.ExcluirProdutoView;

/**
 *
 * @author victo
 */
public class ExcluirProdutoController {
    
    private ExcluirProdutoView view;
    
    public ExcluirProdutoController(ExcluirProdutoView view){
        this.view = view;
    }
    
    public void excluirproduto() {
        
        int id = Integer.parseInt(view.getjTextFieldId().getText());
        
        Produto marca = new Produto(id);
       view.getjTextFieldId().setText("");
        
        try {
            Connection conexao = new Conexao().getConnection();
            ProdutoDAO produtoDao = new ProdutoDAO(conexao);
            produtoDao.delete(marca);
            JOptionPane.showMessageDialog(null, "Produto Excluido com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(ExcluirProdutoView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não é possivel excluir esse produto no momento!");
        }
    }
}
