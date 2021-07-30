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
import javax.swing.JOptionPane;
import model.Produto;
import view.AtualizarProdutoView;

/**
 *
 * @author victo
 */
public class AtualizarProdutoController {
    private AtualizarProdutoView view;
    
    public AtualizarProdutoController(AtualizarProdutoView view){
        this.view = view;
    }
    
    public void atualizarproduto() throws SQLException{
        
        int id = Integer.parseInt(view.getjTextFieldid().getText());
        String nome = view.getjTextFieldnome().getText();
        int estoque = Integer.parseInt(view.getjTextFieldquantidade().getText());
        double preco = Double.parseDouble(view.getjTextFieldpreco().getText());
        int marca = Integer.parseInt(view.getjTextFieldmarca().getText());
        
        Produto produto = new Produto(id, nome, estoque, preco, marca);
        view.getjTextFieldid().setText("");
        view.getjTextFieldnome().setText("");
        view.getjTextFieldquantidade().setText("");
        view.getjTextFieldpreco().setText("");
        view.getjTextFieldmarca().setText("");
                
        JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
        
        Connection conexao = new Conexao().getConnection();
            ProdutoDAO produtoDao = new ProdutoDAO(conexao);
            produtoDao.update(produto);
    }
}
