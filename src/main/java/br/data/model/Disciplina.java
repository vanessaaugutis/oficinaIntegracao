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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d"),
    @NamedQuery(name = "Disciplina.findById", query = "SELECT d FROM Disciplina d WHERE d.id_disciplina = :id_disciplina"),
    @NamedQuery(name = "Disciplina.findByTurma", query = "SELECT d FROM Disciplina d WHERE d.turma = :turma"),
    @NamedQuery(name = "Disciplina.findBySemestre", query = "SELECT d FROM Disciplina d WHERE d.semestre = :semestre"), 
    @NamedQuery(name = "Disciplina.findByCargaHoraria", query = "SELECT d FROM Disciplina d WHERE d.carga_horaria = :carga_horaria")
})

public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_disciplina")
    private Integer id_disciplina;

    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;

    @Size(min = 1, max = 50)
    @Column(name = "turma")
    private String turma;

    @Column(name = "semestre")
    private Integer semestre;

    @Column(name = "carga_horaria")
    private Integer carga_horaria;

    public Disciplina() {
    }

    public Disciplina(Integer id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public Integer getId() {
        return id_disciplina;
    }

    public void setId(Integer id_disciplina) {
        this.id_disciplina = id_disciplina;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_disciplina != null ? id_disciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.id_disciplina == null && other.id_disciplina != null) || (this.id_disciplina != null && !this.id_disciplina.equals(other.id_disciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.model.Disciplina[ id_disciplina=" + id_disciplina + " ]";
    }
    
}