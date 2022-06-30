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
    private String emailAluno;
    
    public String nomeAluno() {
        /*
        var emailLogado = auth.login;
        var todosAlunos = Alunos.all();
        
        todosAlunos.forEach((aluno)=> {
            if(aluno.email == emailLogado) {
                this.setNomeAluno(aluno.nome);
            }
        }) 
        */
        
        return this.getNomeAluno();
    }
    
    public String emailAluno() {
        /*var emailLogado = auth.login;
        this.setEmailAluno(emailLogado);*/
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


