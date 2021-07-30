/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author victo
 */
public class Venda {
    private int  idvenda;
    private int codvenda;
    private Date data;
    private double total;
    private int cliente;
    private int funcionario;

    public Venda(int idvenda, int codvenda, Date data, double total, int cliente, int funcionario) {
        this.idvenda = idvenda;
        this.codvenda = codvenda;
        this.data = data;
        this.total = total;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Venda(int codvenda, Date data, double total, int cliente, int funcionario) {
        this.codvenda = codvenda;
        this.data = data;
        this.total = total;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Venda(int codvenda, Date data, int cliente, int funcionario) {
        this.codvenda = codvenda;
        this.data = data;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Venda(int idvenda, double total) {
        this.idvenda = idvenda;
        this.total = total;
    }

    public Venda(int idvenda, int codvenda) {
        this.idvenda = idvenda;
        this.codvenda = codvenda;
    }
    
    

   
    
    
    
    

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
    
    
    
    

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public int getCodvenda() {
        return codvenda;
    }

    public void setCodvenda(int codvenda) {
        this.codvenda = codvenda;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(int funcionario) {
        this.funcionario = funcionario;
    }
    
    
}
