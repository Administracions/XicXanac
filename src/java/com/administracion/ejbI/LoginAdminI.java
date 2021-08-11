/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejbI;

import com.entity.pojos.Loginadmin;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author PC
 */
@Local
public interface LoginAdminI {
public void create(Loginadmin logina);
public void edit( Loginadmin  logina);
public void remove( Loginadmin logina);
public Loginadmin find(Object id);
public List<Loginadmin> findAll();
public List<Loginadmin> findRange(int[] range);  
public boolean IsUserRegistered(String username);
public String getUserNameAdmin(String username);
public Integer getIdUserByNameUser(String username);
public Loginadmin findBynameUser(String nameuser);

}
