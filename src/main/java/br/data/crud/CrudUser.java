/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import br.data.model.User;

/**
 *
 * @author alexandrelerario
 */
public class CrudUser extends AbstractCrud<br.data.model.User> {

    private EntityManager em;

    public CrudUser() {
        super(br.data.model.User.class);
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
            User user = (User) getEntityManager().createNamedQuery("User.findByEmail").setParameter("email", user_email).getSingleResult();
            return user.getId();
        } catch (Exception e) {
          System.out.println(e.getMessage());
          return -1;
        }

    }

     public void changePass(String newPass, String user_email){
        try {
            User user = (User) getEntityManager().createNamedQuery("User.findByEmail").setParameter("email", user_email).getSingleResult();
            user.setPassword(newPass);
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
         
        User user = (User) getEntityManager().createNamedQuery("User.findByEmail").setParameter("email", email).getSingleResult();
        
        codigo =  new br.data.util.Util().getMd5(user.getPassword()+user.getId()).toUpperCase();
        chave = codigo;
        return chave;
     }

    // os metodos abaixo sao opcionais
    public User getAuth(String user_email, String password) {
        try {
            User user = (User) getEntityManager().createNamedQuery("User.findByEmail").setParameter("email", user_email).getSingleResult();
            String md5pass = new br.data.util.Util().getMd5(password).toUpperCase();
            if (user.getPassword().toUpperCase().equals(md5pass)) {
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
    public Exception persist(User entity) {
        entity.setPassword(new br.data.util.Util().getMd5(entity.getPassword()));
        entity.setCreated(new Date());
        return super.persist(entity);
    }
}