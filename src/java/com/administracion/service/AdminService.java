/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.service;

import com.administracion.enums.Status;
import com.entity.pojos.Administrador;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */


public class AdminService {
    
    private static Integer idAdministrador;
    private static String AMaterno, APaterno, Nombre, CorreoAdmin, Direccion,StatusEmpleado;
    private static Long  telefono;
    private static HttpServletRequest request;
    private static HttpServletResponse response;
    

    
    public static void GetInformation(HttpServletRequest request, HttpServletResponse response){
      
    idAdministrador = Integer.parseInt(request.getParameter("idAdmin"));
    APaterno = request.getParameter("apellidoPaterno");
    AMaterno = request.getParameter("apellidoMaterno");
    Nombre   = request.getParameter("Nombre");
     Direccion = request.getParameter("direccionAdmin");
    CorreoAdmin  = request.getParameter("CorreoAdmin");
    StatusEmpleado = request.getParameter("StatusAdmin");
  telefono  = Long.valueOf( request.getParameter("TelefonoAdmin"));        
  
  
    }
    public static Administrador fillAdministrador(){
        Administrador newAdministrador = new Administrador();
        newAdministrador.setApellidoPat(APaterno);
        newAdministrador.setApellidoMat(AMaterno);
        newAdministrador.setNombre(Nombre);
        newAdministrador.setDireccion(Direccion);
        newAdministrador.setIdAdministrador(0);
       newAdministrador.setCorreo(CorreoAdmin);
       newAdministrador.setStatusempleados(getStatus(StatusEmpleado));
       newAdministrador.setTelefono(telefono);
        return newAdministrador;
    }
    
    public static Administrador fillupdateAdministrador(Administrador administrador){
     administrador.setApellidoPat(APaterno);
        administrador.setApellidoMat(AMaterno);
        administrador.setNombre(Nombre);
        administrador.setDireccion(Direccion);
        administrador.setIdAdministrador(idAdministrador);
       administrador.setCorreo(CorreoAdmin);
       administrador.setStatusempleados(getStatus(StatusEmpleado));
       administrador.setTelefono(telefono);
  return administrador;
    }
     
     
   
      private static Status getStatus (String nameStatus){
    if(nameStatus.equals( "ACTIVE")){
      return Status.ACTIVE;
    }else if(nameStatus.equals("INACTIVE")){
        
        return Status.INACTIVE;
     
    } else if(nameStatus.equals("SUSPENDED")){
        return Status.SUSPENDED;
    }else{
       throw new NullPointerException();
    }
 
    }
    
    
    
    
    
    
    
    
}
