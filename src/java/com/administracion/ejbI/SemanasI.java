/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejbI;

import com.entity.pojos.Direccion;
import com.entity.pojos.Semanas;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author PC
 */
@Local
public interface SemanasI {
  public void create(Semanas admin);
public void edit( Semanas admin);
public void remove( Semanas admin);
public Semanas find(Object id);
public List<Semanas> findAll();
public List<Semanas> findRange(int[] range);
  
    
}
