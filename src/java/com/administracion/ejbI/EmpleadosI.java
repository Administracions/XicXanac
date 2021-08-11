/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejbI;


import com.entity.pojos.Empleados;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author PC
 */
@Local
public interface EmpleadosI {
public void create(Empleados empleado);
public void edit( Empleados empleado);
public void remove( Empleados empleado);
public Empleados find(Object id);
public List<Empleados> findAll();
public List<Empleados> findRange(int[] range);  
//public void ActualizarOrCreateUser(Integer idUser);
//public List<Object[]> getDireccion(Integer idEmpleado);
public Integer getLastIdFromEmpleados();
public Integer getLastIdFromEmpleado();
public Boolean IsUserRegistered(String username);
}