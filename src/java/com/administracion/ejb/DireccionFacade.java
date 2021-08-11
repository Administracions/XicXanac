/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejb;

import com.administracion.ejbI.DireccionI;
import com.entity.pojos.Direccion;
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
public class DireccionFacade extends AbstractFacade<Direccion> implements DireccionI {
  
    @PersistenceContext(unitName="AdministracionsPU")
     private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public DireccionFacade(){
     super(Direccion.class);
    }

    @Override
    public Direccion findByIdEmpleado(Integer idEmpleado) {
        
        try{
  return  
          getEntityManager().createNamedQuery("Direccion.findByIdEmpleado", Direccion.class).setParameter("idempleado", idEmpleado).getSingleResult();
    
        }catch(NonUniqueResultException | NoResultException e){
            
            return null;
        }
        
        
    }
    
    
    
    
}
