/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.data.crud.CrudDisciplina;
import br.data.model.Disciplina;

/**
 *
 * @author Victor
 */
@Named(value = "jsfDisciplina")
@RequestScoped
public class JsfDisciplina {

    /**
     * Creates a new instance of JsfDisciplina
     */
    public JsfDisciplina() {
    }

    private String nome;
    private String turma;
    private Integer semestre;
    private Integer carga_horaria;

    public List<Disciplina> getAll() {
        return new CrudDisciplina().getAll();
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getCargaHoraria() {
        return carga_horaria;
    }

    public void setCargaHoraria(Integer carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

}