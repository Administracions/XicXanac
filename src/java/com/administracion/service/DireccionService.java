/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.service;

import com.entity.pojos.Direccion;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.xml.security.stax.ext.XMLSecurityConstants;

/**
 *
 * @author PC
 */
public class DireccionService {
    private static String callePrincipal;
    private static String Colonia,Estado, NumeroInterior;
    private static Integer numeroExterior, CP;
    
    

    public static void getDireccionEmpleado(HttpServletRequest request,HttpServletResponse response){
        callePrincipal = request.getParameter("Calleprincipal");
        Colonia    = request.getParameter("Colonia");
        NumeroInterior = request.getParameter("NumeroInterior");
        numeroExterior  = Integer.parseInt(request.getParameter("NumeroExterior"));
        CP              = Integer.parseInt(request.getParameter("CodigoPostal"));
        Estado           = request.getParameter("estado");
        
    }
    
    
    
    public static Direccion filleditdireccionempleado(Direccion direccion){
        
       direccion.setCallePrincipal(callePrincipal);
       direccion.setColonia(Colonia);
       direccion.setNumeroInterior(NumeroInterior);
       direccion.setNumeroExterior(numeroExterior);
       direccion.setCodigoPostal(CP);
       direccion.setEstado(Estado);
        
return direccion;
    }
    
    
    
    
}
