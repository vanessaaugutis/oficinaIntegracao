/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    // variaveis usadas para trocar senha

    public List<Aluno> getAll() {
        return new CrudAluno().getAll();
    }

    public void turnActive(Aluno user) {
        if (user.getId() != null) {
            if (new CrudAluno().merge(user) == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Estado modificado.", ""));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao modificar estado.", "Error"));
        }
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