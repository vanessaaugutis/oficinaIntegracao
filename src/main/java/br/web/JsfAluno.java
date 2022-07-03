/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.data.crud.CrudAluno;
import br.data.model.Aluno;

/**
 *
 * @author Victor
 */
@Named(value = "jsfAluno")
@RequestScoped
public class JsfAluno {

    /**
     * Creates a new instance of JsfAluno
     */
    public JsfAluno() {
    }

    private String nome;
    private String email;
    private String senha;

    public List<Aluno> getAll() {
        return new CrudAluno().getAll();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}