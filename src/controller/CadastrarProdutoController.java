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
import view.CadastrarProdutoview;

/**
 *
 * @author victo
 */
public class CadastrarProdutoController {
    private CadastrarProdutoview view;
    
    public CadastrarProdutoController(CadastrarProdutoview view){
        this.view = view;
    }

    public void cadastrarProduto() {
        
        String nome = view.getjTextFieldnome().getText();
        int estoque = Integer.parseInt(view.getjTextFieldquantidade().getText());
        double preco = Double.parseDouble(view.getjTextFieldpreco().getText());
        int marca = Integer.parseInt(view.getjTextFieldMarca().getText());
        
        Produto produto = new Produto(nome, estoque, preco, marca);
        view.getjTextFieldnome().setText("");
        view.getjTextFieldquantidade().setText("");
        view.getjTextFieldpreco().setText("");
        view.getjTextFieldMarca().setText("");
        
        try {
            Connection conexao = Conexao.getConnection();
            ProdutoDAO ProdutoDao = new ProdutoDAO(conexao);
            ProdutoDao.insert(produto);
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProdutoview.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto!");
        }
    }
    
}
