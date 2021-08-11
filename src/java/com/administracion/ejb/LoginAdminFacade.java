/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejb;

import com.administracion.ejbI.LoginAdminI;
import com.entity.pojos.Loginadmin;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author PC
 */
@Stateless
public class LoginAdminFacade extends AbstractFacade<Loginadmin> implements LoginAdminI {
    
@PersistenceContext(unitName="AdministracionsPU")
private EntityManager em;

public LoginAdminFacade(){
    super(Loginadmin.class);
}    

@Override
    protected EntityManager getEntityManager() {
       return em;
    }

    @Override
    public boolean IsUserRegistered(String username) throws NoResultException, NonUniqueResultException  {
       
        String usernamDB;
        try{
 usernamDB =  getEntityManager()
   .createNamedQuery("Loginadmin.findByNombreAdmin", String.class)     
         .setParameter("nombreAdmin","%" + username + "%")
           .getSingleResult();
    }catch(NoResultException | NonUniqueResultException result){
       return false; 
        
    }
     return true;
    }

    @Override
    public String getUserNameAdmin(String username) throws NoResultException,
            NonUniqueResultException {
   return  getEntityManager().createNamedQuery("Loginadmin.getPassByUser", String.class)
           .setParameter("idAdmin", "%" + username + "%")
            .getSingleResult();
        
  }

    @Override
    public Integer getIdUserByNameUser(String UsernameAdmin) {
 
        try{
  return  getEntityManager().createNamedQuery("Loginadmin.getIdAdminByUser", Integer.class)
           .setParameter("nombreUser", "%" + UsernameAdmin + "%")
           .getSingleResult();
        }catch(NoResultException | NonUniqueResultException e){
            return 0;
        }
        
    }

    @Override
    public Loginadmin findBynameUser(String nameAdminuser) {
     try{
        
         return getEntityManager().createNamedQuery("Loginadmin.findByNombreAdmin", Loginadmin.class).setParameter("nombreAdmin", nameAdminuser).getSingleResult();
         
     } catch(NoResultException | NonUniqueResultException e){
       
         
      return null;   
     }
    }
    



    
    
    
}
