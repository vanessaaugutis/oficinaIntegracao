/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.data.model.Aluno;

/**
 *
 * @author alexandrelerario
 */
@Named(value = "auth")
@SessionScoped
public class Auth implements Serializable {

    /**
     * Creates a new instance of JsfPassaporte
     */
    //classe utilizada para efetuar a autenticacao e autorizacao
    public Auth() {
    }

    private Aluno user;
    private boolean auth = false;
    private String login;
    private String senha;


    public String authenticate() {
        user = new br.data.crud.CrudAluno().getAuth(login, senha);
        auth = user != null;
        if (auth) {
            return "perfil";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha inválidos.", "Error"));
        return null;
    }

    public String logout() {
        auth = false;
        user = null;
        return "index.xhtml";
    }

    public Aluno getUser() {
        return user;
    }

    public boolean getAuth() {
        return auth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}