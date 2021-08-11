/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejbI;

import com.entity.pojos.Login;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author PC
 */
@Local
public interface LoginI {
    
public void create(Login login);
public void edit( Login  login);
public void remove( Login login);
public Login find(Object id);
public Integer getIdByUsername(String username);
public List<Login> findAll();
public List<Login> findRange(int[] range);  
public Integer getNombreUsuario(String idUserEmpleado);
public String getPassword(Object idAdministrador);
public boolean IsUserRegistered(String username);
public String getUserName(String username);
    
}
