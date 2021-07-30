/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author victo
 */
public class ItensVenda {
    private int id;
    private int produto;
    private int venda;
    private int quantidade;
    private double subtotal;

    public ItensVenda(int id, int produto, int venda, int quantidade, double subtotal) {
        this.id = id;
        this.produto = produto;
        this.venda = venda;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }

    public ItensVenda(int produto, int venda, int quantidade, double subtotal) {
        this.produto = produto;
        this.venda = venda;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }

    public ItensVenda(int venda) {
        this.venda = venda;
    }


    
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
