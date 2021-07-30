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
public class Funcionario {
    private int idfuncionario;
    private String nome;
    private String telefone;
    private String cpf;
    private String Cargo;
    private double salario;
    private String email;
    private String usuario;
    private String senha;

    public Funcionario(int id, String nome, String telefone, String cpf, String Cargo, double salario, String email, String usuario, String senha) {
        this.idfuncionario = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.Cargo = Cargo;
        this.salario = salario;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Funcionario(String nome, String telefone, String cpf, String Cargo, double salario, String email, String usuario, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.Cargo = Cargo;
        this.salario = salario;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Funcionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Funcionario(String Cargo, String usuario, String senha) {
        this.Cargo = Cargo;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    

    
    
    public int getId() {
        return idfuncionario;
    }

    public void setId(int id) {
        this.idfuncionario = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
