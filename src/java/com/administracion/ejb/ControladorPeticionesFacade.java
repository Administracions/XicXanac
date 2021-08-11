/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejb;

import com.administracion.ejbI.ControladorPeticionesI;
import com.entity.pojos.ControladorPeticiones;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author PC
 */
@Stateless
public class ControladorPeticionesFacade extends AbstractFacade<ControladorPeticiones> implements ControladorPeticionesI {
@PersistenceContext(unitName="AdministracionsPU")
 private EntityManager entity;

    protected ControladorPeticionesFacade() {
        super(ControladorPeticiones.class);
    }
  
     @Override
    protected EntityManager getEntityManager() {
    return entity;
    } 
    
}
