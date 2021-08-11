/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejbI;

import com.entity.pojos.ControladorPeticiones;
import java.util.List;

/**
 *
 * @author PC
 */
public interface ControladorPeticionesI {
    public void create( ControladorPeticiones login);
public void edit( ControladorPeticiones  login);
public void remove( ControladorPeticiones login);
public ControladorPeticiones find(Object id);
public List<ControladorPeticiones> findAll();
public List<ControladorPeticiones> findRange(int[] range); 
  

 
    
}
