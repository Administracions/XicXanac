/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejb;

import com.administracion.ejbI.EmpleadosI;
import com.entity.pojos.Empleados;
import com.entity.pojos.Login;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author PC
 */

@Stateless
public class EmpleadosFacade extends AbstractFacade<Empleados> implements EmpleadosI{
   
    @PersistenceContext(unitName ="AdministracionsPU")
    private EntityManager em;
    
    public EmpleadosFacade(){
       super(Empleados.class); 
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }

 
    @Override
   public Integer getLastIdFromEmpleados()  throws NonUniqueResultException, NoResultException{
  Integer idUltimoEmpleado =  getEntityManager().
      createQuery("SELECT MAX(emp.idEmpleado) FROM Empleados emp "
         + " WHERE emp.idEmpleado NOT IN(SELECT direccion.empleadoDir.idEmpleado FROM Direccion direccion)", Integer.class).getSingleResult();
 
        return idUltimoEmpleado;
    }

    @Override
    public Integer getLastIdFromEmpleado() {
      Integer ultimoIdEmpleado;  
        try{
       ultimoIdEmpleado = getEntityManager()
              .createQuery("SELECT  MAX(emp.idEmpleado) FROM Empleados emp "
                      + "WHERE emp.idEmpleado "
                      + "NOT IN(SELECT login.empleados.idEmpleado FROM Login login )",Integer.class).getSingleResult();
        }catch(NoResultException | NonUniqueResultException exception){
            
            return 0;
        }
        return ultimoIdEmpleado;
    }

    @Override
    public Boolean IsUserRegistered(String username) {
       try{
           getEntityManager()
                   .createNamedQuery("Login.findByUserEmpleado", Login.class).setParameter("userEmpleado","%" +username+ "%").getSingleResult();
          
           return false;
       }catch(NonUniqueResultException | NoResultException e){
           
           return true;
           
       }
       
    }
    
    
}
