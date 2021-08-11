/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejbI;


import com.entity.pojos.Direccion;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author PC
 */
@Local
public interface DireccionI {
public void create(Direccion admin);
public void edit( Direccion admin);
public void remove( Direccion admin);
public Direccion find(Object id);
public Direccion findByIdEmpleado(Integer idEmpleado);
public List<Direccion> findAll();
public List<Direccion> findRange(int[] range);  

}
