/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejb;

import com.administracion.ejb.AbstractFacade;
import com.entity.pojos.Cargo;
import com.administracion.ejbI.Cargoss;
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
public class CargoFacade extends AbstractFacade<Cargo> implements Cargoss{
    

    @PersistenceContext(unitName="AdministracionsPU")
    private EntityManager em;
    
    
    @Override
   protected EntityManager getEntityManager() {
        return em;
    }

    public CargoFacade() {
        super(Cargo.class);
    }

    @Override
    public Boolean IsCargoRegistered(String cargo) {
       
        try{
        getEntityManager().createNamedQuery("Cargo.findByCargo", Cargo.class).setParameter("cargo", cargo).getSingleResult();
        
        
        return  false;
        }catch(NonUniqueResultException | NoResultException e){
            
           return true;
            
        }
            
    }
    
    
    

}
