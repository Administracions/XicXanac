/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejbI;

import com.entity.pojos.Administrador;
import com.entity.pojos.Cargo;
import com.entity.pojos.Empleados;
import com.entity.pojos.Loginadmin;
import jakarta.ejb.Local;

import java.util.List;

/**
 *
 * @author PC
 */
@Local
public interface AdministradorI {
public void create(Administrador admin);
public void edit(Administrador admin);
public void remove(Administrador admin);
public Administrador find(Object id);
public List<Administrador> findAll();
public Administrador findByIdEmpleado(Integer idEmpleado);
public List<Administrador> findRange(int[] range);
public List<Object[]> getEmpleados(Integer idAdministrador);
public List<Object[]> getLoginadmin(Integer idLogin);
public void addEmpleado(Empleados empleado);    
public void DarBajaEmpleado(Integer empleado);
public void SuspenderEmpleado(Integer IdEmpleado);
public void ActivarEmpleado(Integer Idempleado);
public void DarBajaGrupoEmpleado(Object[] idsEmpleados);
public void ActivarGrupoEmpleado(Object[] idsEmpleados);
public void SuspenderGrupoEmpleado(Object[] idsEmpleados);
public String getPassword(Integer IdAdministrador) throws Exception;
public  Integer getLastIdAdminLogin();
public Administrador findBynameAdmin(String nameAdmin);
}
