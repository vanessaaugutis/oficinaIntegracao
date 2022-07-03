/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "grade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grade.findAll", query = "SELECT g FROM Grade g"),
    @NamedQuery(name = "Grade.findById", query = "SELECT g FROM Grade g WHERE g.id = :id"),
    @NamedQuery(name = "Grade.findByAluno", query = "SELECT g FROM Grade g WHERE g.id_aluno = :id_aluno"),
    @NamedQuery(name = "Grade.findByDisciplina", query = "SELECT g FROM Grade g WHERE g.id_disciplina = :id_disciplina")})
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grade")
    private Integer id_grade;

    @JoinColumn(name = "aluno", referencedColumnName = "id_aluno")
    @ManyToOne
    private Aluno aluno;
    
    @JoinColumn(name = "disciplina", referencedColumnName = "id_disciplina")
    @ManyToOne
    private Disciplina disciplina;

    public Grade() {
    }

    public Grade(Integer id_grade) {
        this.id_grade = id_grade;
    }

    public Integer getId() {
        return id_grade;
    }

    public void setId(Integer id_grade) {
        this.id_grade = id_grade;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_grade != null ? id_grade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Grade)) {
            return false;
        }
        Grade other = (Grade) object;
        if ((this.id_grade == null && other.id_grade != null) || (this.id_grade != null && !this.id_grade.equals(other.id_grade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.model.Grade[ id_grade=" + id_grade + " ]";
    }
    
}