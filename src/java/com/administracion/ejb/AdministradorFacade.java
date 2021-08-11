/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejb;

import com.administracion.ejbI.AdministradorI;
import com.administracion.ejbI.Cargoss;
import com.administracion.ejbI.EmpleadosI;
import com.administracion.ejbI.ReporteI;
import com.administracion.enums.Status;
import com.entity.pojos.Administrador;
import com.entity.pojos.Cargo;
import com.entity.pojos.Empleados;
import com.entity.pojos.Loginadmin;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author PC
 */
@Stateless
public class AdministradorFacade extends AbstractFacade<Administrador> implements AdministradorI {
@Inject 
private EmpleadosI empleados;

@Inject
private Cargoss cargosss;

@Inject
private ReporteI reportes;

    
    @PersistenceContext(unitName = "AdministracionsPU")
   private EntityManager em; 
    
    public AdministradorFacade() {
        super(Administrador.class);
    }

    @Override
    protected EntityManager getEntityManager() {
    return em;
    }

    
   @Override
    public List<Object[]> getEmpleados(Integer idAdministrador) {
     return   getEntityManager().createQuery("SELECT "
            +       "empleados.idEmpleado as IdEmpleado, empleados.nombre as NombreEmpleado, empleados.apellidoPat, "
             + "empleados.apellidoMat,empleados.telefono,empleados.statusempleados,Cargo.area,Cargo.cargo "
             + "FROM Administrador Admin INNER JOIN Admin.empleadosList empleados "
             + "INNER JOIN empleados.cargo Cargo WHERE  Admin.idAdministrador = :idAdmin", Object[].class).
             setParameter("idAdmin", idAdministrador).getResultList();
    }
    @Override
    public List<Object[]> getLoginadmin(Integer idAdmin) {
      return getEntityManager().createQuery("SELECT admin.idAdministrador, admin.nombre, admin.apellidoPat, "
              + "admin.apellidoMat, admin.statusempleados, loginadmins.nombreAdmin FROM Administrador admin "
              + "INNER JOIN admin.loginadmin loginadmins WHERE admin.idAdministrador = :idAdministrador ",Object[].class)
              .setParameter("idAdministrador", idAdmin).getResultList();
    }
    
    
    

    @Override
    public void addEmpleado(Empleados idEmpleado) {  
       if(idEmpleado==null){
         throw new NullPointerException("Empleado Faltante");  
       } 
       /*if(idEmpleado.getDirection() == null)
       throw new NullPointerException("Falta direccion del Empleado");    */ 
        
    this.empleados.create(idEmpleado);  
    }

    @Override
    public void DarBajaEmpleado(Integer empleado) {
      Empleados removerEmpleado = this.empleados.find(empleado);       
     this.empleados.remove(removerEmpleado);
    }

   
    @Override
    public void SuspenderEmpleado(Integer idEmpleado) {     
      Empleados resultadoEmpleado = this.empleados.find(idEmpleado);   
        resultadoEmpleado.setStatusempleados(Status.SUSPENDED);
this.empleados.edit(resultadoEmpleado);
        
        
        /*  Empleados empleadoss = this.empleados.find(idEmpleado);
 //   empleadoss.setStatusempleados(Status.SUSPENDED);
     this.empleados.edit(empleadoss);*/
    }

    @Override
    public void ActivarEmpleado(Integer idEmpleado) {
  Empleados empleadoActivar = this.empleados.find(idEmpleado);
   empleadoActivar.setStatusempleados(Status.ACTIVE); 
       this.empleados.edit(empleadoActivar);
        
    }

    @Override
    public void DarBajaGrupoEmpleado(Object[] idsEmpleados) {
      List<Object[]> empleados =  getEntityManager().createQuery("SELECT emp.idEmpleado, emp.nombre FROM Empleados emp",Object[].class).getResultList();  
     ListIterator<Object[]> lista =   empleados.listIterator();
     while(lista.hasNext())
    {
   Object[] IdEmpleados = lista.next();
for(Object idEntrantes: idsEmpleados){
    if(IdEmpleados[0] == idEntrantes){
       this.empleados.remove(em.find(Empleados.class, idEntrantes));
         }
       
   }   
    
}      

    }

    @Override
    public void ActivarGrupoEmpleado(Object[] id) {
     List<Object[]> empleados  = getEntityManager()
             .createQuery("SELECT empleado.idEmpleado, empleado.statusempleados FROM Empleados empleado", Object[].class).
             getResultList();
      for(Object[] ListaEmpleados: empleados)           
      {
        for(Object idEntrante: id){
          if(ListaEmpleados[0] == idEntrante) 
       em.find(Empleados.class, idEntrante).setStatusempleados(Status.ACTIVE);     
              
        }       
          
      }     
     }
    @Override
    public void SuspenderGrupoEmpleado(Object[] os) {
    List<Object[]> empleados  = getEntityManager()
             .createQuery("SELECT empleado.idEmpleado, empleado.statusempleados FROM Empleados empleado", Object[].class).
             getResultList();
      for(Object[] ListaEmpleados: empleados)           
      {
        for(Object idEntrante: os){
          if(ListaEmpleados[0] == idEntrante) 
       em.find(Empleados.class, idEntrante).setStatusempleados(Status.SUSPENDED);     
          
        }  
        
        
    }
     
    }

    @Override
    public String  getPassword(Integer idAdmin) throws Exception {
        try{
      return   getEntityManager().createNamedQuery("Loginadmin.getPassById", String.class)
              .setParameter("idAdmin", idAdmin).getSingleResult();
        }catch(Exception e ){
            e.getMessage();
        return null;    
        }
        
        
      }

    @Override
    public Integer getLastIdAdminLogin() {
   return    this.getEntityManager().createQuery("SELECT MAX(administrador.idAdministrador) FROM  Administrador administrador "
              + "WHERE administrador.idAdministrador "
              + "NOT IN(SELECT loginAdmins.idLoginAdmin FROM Loginadmin loginAdmins)", Integer.class).getSingleResult();
        
    }

    @Override
    public Administrador findBynameAdmin(String nameAdmin) {
        try{
      return this.getEntityManager()
              .createQuery("SELECT Admin FROM Administrador AS Admin INNER JOIN Admin.loginadmin loginAdmin "
       + " WHERE loginAdmin.nombreAdmin LIKE :nameAdmin", Administrador.class).setParameter("nameAdmin",nameAdmin).getSingleResult();
        }catch(NoResultException | NonUniqueResultException e){
            
        return null;    
       
        }
        
    }

    @Override
    public Administrador findByIdEmpleado(Integer idempleado) {
    
        try{
        return  getEntityManager().createNamedQuery("Administrador.findByIdEmpleado", Administrador.class)
                .setParameter("IdEmpleado", idempleado).getSingleResult();
        }catch(NonUniqueResultException | NoResultException e){
            
            return null;
        }
    }


     
     
    }
    

    
    

