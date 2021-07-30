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
public class Marca {
    private int idmarca;
    private String nome;

    public Marca(int idmarca, String nome) {
        this.idmarca = idmarca;
        this.nome = nome;
    }

    public Marca(String nome) {
        this.nome = nome;
    }

    public Marca(int idmarca) {
        this.idmarca = idmarca;
    }
    
    
    
    
    
    

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
