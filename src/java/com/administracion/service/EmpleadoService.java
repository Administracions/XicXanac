/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.service;

import com.administracion.enums.Status;
import com.entity.pojos.Direccion;
import com.entity.pojos.Empleados;
import com.entity.pojos.Login;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 *
 * @author PC
 */
public class EmpleadoService {
    private static String appellidopaterno, apellidomaterno, nombre,StatusString, Correo;
    private static String calleprincipal, colonia,estado,pais ,NumInterior; 
    private static Integer idCargo, idAdministrador;
    private static Integer CP,NumExterior;
    private static Long  telefono;
    private static HttpServletRequest request;
    private static HttpServletResponse response;
    private static Passwords passwords = new Passwords();
    
    public static void getInformacionempleado(HttpServletRequest request,HttpServletResponse response){
        appellidopaterno = request.getParameter("apellidoPaterno");
        apellidomaterno  = request.getParameter("apellidoMaterno");
        Correo           =  request.getParameter("CorreoEmpleado");
        nombre           = request.getParameter("Nombre");
        telefono         = Long.valueOf(request.getParameter("TelefonoEmpleado"));
        idCargo          = Integer.parseInt(request.getParameter("idCargo"));
        idAdministrador  = Integer.parseInt(request.getParameter("idAdministrador"));
        StatusString          =request.getParameter("statusempleado");
    
    }
    public static void getDireccionempleado(HttpServletRequest request, HttpServletResponse response){
    calleprincipal = request.getParameter("calleprincipal");
    colonia = request.getParameter("Colonia");
    estado = request.getParameter("estado");
    pais = request.getParameter("pais");
    CP = Integer.parseInt(request.getParameter("CodigoPostal"));
    NumInterior = request.getParameter("numerointerior"); 
    NumExterior = Integer.parseInt(request.getParameter("numeroexterior"));    
    
    }
    
    public static void getEditEmployeeFields(HttpServletRequest request, HttpServletResponse response){
         appellidopaterno = request.getParameter("apellidoPaterno");
        apellidomaterno  = request.getParameter("apellidoMaterno");
        nombre           = request.getParameter("Nombre");
        telefono         = Long.valueOf(request.getParameter("TelefonoEmpleado"));   
         Correo           =  request.getParameter("CorreoEmpleado");
   
        
    }
    
    
   
  public static Empleados fillemployeefields(){
      Empleados newEmpleado = new Empleados();
      newEmpleado.setIdEmpleado(1);
      newEmpleado.setApellidoMat(apellidomaterno);
      newEmpleado.setApellidoPat(appellidopaterno);
      newEmpleado.setNombre(nombre);
      newEmpleado.setTelefono(telefono);
      newEmpleado.setStatusempleados(getStatus(StatusString));
      newEmpleado.setCorreoEmpleado(Correo);
    
return newEmpleado;     
    }
  
  
  
  
  
  
  public static Login fillloginfield(String username, String password){
  Login newLogin = new Login();
  newLogin.setUserEmpleado(username);
  newLogin.setPassword(passwords.EncryptPassword(password));
  newLogin.setIdUsuario(0);

  return newLogin;

  }
  
  public static Direccion fillDireccionempleadosfields(){
     Direccion newDireccion = new Direccion();
     newDireccion.setId(0L);
     newDireccion.setCallePrincipal(calleprincipal);
     newDireccion.setPais(pais);
     newDireccion.setEstado(estado);
     newDireccion.setCodigoPostal(CP);
     newDireccion.setNumeroExterior(NumExterior);
     newDireccion.setNumeroInterior(NumInterior);
     newDireccion.setColonia(colonia);
    
     return newDireccion;
  }
  
  public static Empleados fillEditEmployeefields(Empleados empleado){
      empleado.setApellidoMat(apellidomaterno);
      empleado.setApellidoPat(appellidopaterno);
      empleado.setNombre(nombre);
      empleado.setTelefono(telefono);
      empleado.setCorreoEmpleado(Correo);
       
  return empleado;
  }
      
    
  
    
  private static Status getStatus(String nameStatus){
       if(nameStatus.equals("ACTIVE")){
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
