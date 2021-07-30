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
public class Produto {
    private int id;
    private String nome;
    private int estoque;
    private double preco;
    private int marca;

    public Produto(int id, String nome, int estoque, double preco, int marca) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.marca = marca;
    }

    public Produto(String nome, int estoque, double preco, int marca) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.marca = marca;
    }

    public Produto(double preco) {
        this.preco = preco;
    }
    
    

    public Produto(int id) {
        this.id = id;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }
    
    
    
}
