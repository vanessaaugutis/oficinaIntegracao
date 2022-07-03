/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.data.crud.CrudGrade;
import br.data.model.Grade;

/**
 *
 * @author Victor
 */
@Named(value = "jsfGrade")
@RequestScoped
public class JsfGrade {

    /**
     * Creates a new instance of JsfGrade
     */
    public JsfGrade() {
    }

    private Integer id_disciplina;
    private Integer id_aluno;

    public List<Grade> getAll() {
        return new CrudGrade().getAll();
    }

    public Integer getDisciplina() {
        return id_disciplina;
    }

    public void setDisciplina(Integer id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public Integer getAluno() {
        return id_aluno;
    }

    public void setAluno(Integer id_aluno) {
        this.id_aluno = id_aluno;
    }

}