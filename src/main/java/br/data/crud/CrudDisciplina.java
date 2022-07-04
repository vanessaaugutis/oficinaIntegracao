/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.data.model.Disciplina;

/**
 *
 * @author Victor
 */
public class CrudDisciplina extends AbstractCrud<br.data.model.Disciplina> {

    private EntityManager em;

    public CrudDisciplina() {
        super(br.data.model.Disciplina.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(EMNames.EMN1, EMNames.getEMN1Props()).createEntityManager();
        }
        return em;
    }
    
    
    @Override
    public Exception persist(Disciplina entity) {
        return super.persist(entity);
    }
    
}