/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.web;

import javax.enterprise.context.ApplicationScoped;
/**
 *
 * @author default
 */
import javax.inject.Named;

import br.data.crud.CrudAluno;

@Named(value = "jsfPerfil")
@ApplicationScoped

public class JsfPerfil {
    private String nomeAluno;
    private String emailAluno;

    public String getByEmail(String email) {
        return new CrudAluno().show(email).getNome();
    }

    public String emailAluno() {
        return this.getEmailAluno();
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public void setEmailAluno(String raAluno) {
        this.emailAluno = raAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getEmailAluno() {
        return emailAluno;
    }
    
}


