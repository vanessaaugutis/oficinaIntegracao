/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.data.model.Aluno;

/**
 *
 * @author alexandrelerario
 */
public class CrudAluno extends AbstractCrud<br.data.model.Aluno> {

    private EntityManager em;

    public CrudAluno() {
        super(br.data.model.Aluno.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(EMNames.EMN1, EMNames.getEMN1Props()).createEntityManager();
        }
        return em;
    }
    
    
    public int getIdByEmail(String user_email) { // 21.04.2021
        try {
            Aluno user = (Aluno) getEntityManager().createNamedQuery("Aluno.findByEmail").setParameter("email", user_email).getSingleResult();
            return user.getId();
        } catch (Exception e) {
          System.out.println(e.getMessage());
          return -1;
        }

    }

     public void changePass(String newPass, String user_email){
        try {
            Aluno user = (Aluno) getEntityManager().createNamedQuery("Aluno.findByEmail").setParameter("email", user_email).getSingleResult();
            user.setSenha(newPass);
            this.persist(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
      
    
    public String geraChave(String email){

        String chave;
        String codigo;
        
        if (getIdByEmail(email) == -1) {
            return "";
        }
         
        Aluno user = (Aluno) getEntityManager().createNamedQuery("Aluno.findByEmail").setParameter("email", email).getSingleResult();
        
        codigo =  new br.data.util.Util().getMd5(user.getSenha()+user.getId()).toUpperCase();
        chave = codigo;
        return chave;
     }

    // os metodos abaixo sao opcionais
    public Aluno getAuth(String user_email, String senha) {
        try {
            Aluno user = (Aluno) getEntityManager().createNamedQuery("Aluno.findByEmail").setParameter("email", user_email).getSingleResult();
            String md5pass = new br.data.util.Util().getMd5(senha).toUpperCase();
            if (user.getSenha().toUpperCase().equals(md5pass)) {
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    //sobrescrever persist para gravar a md5 da senha
    @Override
    public Exception persist(Aluno entity) {
        entity.setSenha(new br.data.util.Util().getMd5(entity.getSenha()));
        return super.persist(entity);
    }
}