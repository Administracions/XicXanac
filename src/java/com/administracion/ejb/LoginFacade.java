/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejb;

import com.administracion.ejbI.LoginI;
import com.entity.pojos.Login;
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
public class LoginFacade extends AbstractFacade<Login> implements LoginI{
    
    @PersistenceContext(unitName="AdministracionsPU")
   private EntityManager em;
    
    public LoginFacade(){
        super(Login.class);
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }

    @Override
  public String getPassword(Object idAdministrador) throws NonUniqueResultException, NoResultException {
      
return   
        getEntityManager().createNamedQuery("Login.getPassword", String.class).setParameter("idUser", "%" + idAdministrador + "%").getSingleResult();
  }
  
     @Override
    public Integer getNombreUsuario(String idEmpleado)  throws NoResultException, NonUniqueResultException {
     
        return getEntityManager().createNamedQuery("Login.findByUserEmpleado", Integer.class)
                .setParameter("userEmpleado", "%" + idEmpleado + "%")
              .getSingleResult();
    }

    @Override
    public boolean IsUserRegistered(String username) {
       boolean IsRegisterUser = false;
        String UserNameDB;
       try{ 
      UserNameDB = getEntityManager().createNamedQuery("Login.getUserEmple", String.class)
          .setParameter("userEmpleado", "%" + username.toLowerCase() + "%").getSingleResult();
       }
    catch(NoResultException | NonUniqueResultException noencontrad)
    {
     return false; 
    }
 return (IsRegisterUser  = true);
   
}

    @Override
    public String getUserName(String username) {
     String UserNameDB;   
        try{ 
      UserNameDB = getEntityManager().createNamedQuery("Login.getPassword", String.class)
          .setParameter("idUser", "%" + username + "%").getSingleResult();
       }
    catch(NoResultException | NonUniqueResultException noencontrad)
    {
     return "No Existe"; 
    }
        
  return UserNameDB;
    }

    @Override
    public Integer getIdByUsername(String userempleado) {
try{
    
  return getEntityManager().createNamedQuery("Login.findByUserEmpleado", Integer.class)
          .setParameter("userEmpleado","%" + userempleado + "%").getSingleResult();
    
}catch(NonUniqueResultException | NoResultException e){
    return null;
    
}      
    }
}