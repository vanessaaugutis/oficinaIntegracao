/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.data.model.Grade;

/**
 *
 * @author Victor
 */
public class CrudGrade extends AbstractCrud<br.data.model.Grade> {

    private EntityManager em;

    public CrudGrade() {
        super(br.data.model.Grade.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(EMNames.EMN1, EMNames.getEMN1Props()).createEntityManager();
        }
        return em;
    }
    
    
    @Override
    public Exception persist(Grade entity) {
        return super.persist(entity);
    }
    
}