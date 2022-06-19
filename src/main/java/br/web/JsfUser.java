/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import br.data.model.User;
import br.data.crud.CrudUser;

/**
 *
 * @author Victor
 */
@Named(value = "jsfUser")
@RequestScoped
public class JsfUser {

    /**
     * Creates a new instance of JsfUser
     */
    public JsfUser() {
    }

    private String nome;
    private String email;
    private String password;
    // variaveis usadas para trocar senha

    public List<User> getAll() {
        return new CrudUser().getAll();
    }

    public void turnActive(User user) {
        if (user.getId() != null) {
            user.setEnable(!user.getEnable());

            if (new CrudUser().merge(user) == null) {
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}