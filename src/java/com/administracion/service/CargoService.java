/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.service;

import com.entity.pojos.Cargo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class CargoService {
    private  static HttpServletRequest request;
    private static HttpServletResponse response;
    
    public static void CargoService(HttpServletRequest request, HttpServletResponse response){   
       CargoService.request = request;
        CargoService.response = response;}
    
    public static Cargo CreateCargo(){
    String NombreCargo =  request.getParameter("NombreCargo");
      String AreaCargo   = request.getParameter("AreaCargo");
      Cargo newCargo = new Cargo();
      newCargo.setIdCargo(0);
      newCargo.setArea(AreaCargo);
      newCargo.setCargo(NombreCargo);
        return newCargo;
    }
    
 
    
}
