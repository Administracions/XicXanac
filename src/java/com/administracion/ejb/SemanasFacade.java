/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejb;

import com.administracion.ejbI.SemanasI;
import com.entity.pojos.Semanas;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author PC
 */
@Stateless
public class SemanasFacade extends AbstractFacade<Semanas> implements  SemanasI{

    @PersistenceContext(unitName="AdministracionsPU")
private EntityManager em;
  
    
    public SemanasFacade(){
        
        super(Semanas.class);
    }
    
    
    
 @Override
    protected EntityManager getEntityManager() {
     return em;  
        
    }

   
    
}
