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

@Named(value = "jsfPerfil")
@ApplicationScoped

public class JsfPerfil {
    private String nomeAluno;
    private String raAluno;
    
    public String nomeAluno() {
        this.setNomeAluno("Vanessa");
        return this.getNomeAluno();
    }
    
    public String raAluno() {
        this.setRaAluno("2268132");
        return this.getRaAluno();
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public void setRaAluno(String raAluno) {
        this.raAluno = raAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getRaAluno() {
        return raAluno;
    }
    
}


