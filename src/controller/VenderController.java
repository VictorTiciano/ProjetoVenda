/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.ItensVendaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ItensVenda;
import view.VenderView;
import view.CriarVenda;

/**
 *
 * @author victo
 */
public class VenderController {
    private VenderView view;
    
    public VenderController(VenderView view){
        this.view = view;
        view.getjTextFieldtotal().setText("0");
    }

    public void adicionaritem(){
        
        int produto = Integer.parseInt(view.getjTextFieldproduto().getText());
        int quantidade = Integer.parseInt(view.getjTextFieldQuantidade().getText());
        int venda = Integer.parseInt(view.getjTextFieldcodvenda().getText());
        double preco = Double.parseDouble(view.getjTextFieldpreco().getText());
        double subtotal = (preco * quantidade);
                
        ItensVenda itemvenda = new ItensVenda(produto, venda, quantidade, subtotal);
        double totalaux = Double.parseDouble(view.getjTextFieldtotal().getText());
        double total = subtotal + totalaux;
        String valortotal = Double.toString(total);
        view.getjTextFieldtotal().setText(valortotal);
        view.getjTextFieldQuantidade().setText("");
        view.getjTextFieldpreco().setText("");
        view.getjTextFieldproduto().setText("");
        
        try {
            Connection conexao = Conexao.getConnection();
            ItensVendaDAO itensvendaDAO = new ItensVendaDAO(conexao);
            itensvendaDAO.insert(itemvenda);
        JOptionPane.showMessageDialog(null, "item adicionado com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(VenderView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
