/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.Servlets;

import com.administracion.ejbI.AdministradorI;
import com.administracion.ejbI.Cargoss;
import com.administracion.ejbI.EmpleadosI;
import com.administracion.enums.Status;
import com.entity.pojos.Administrador;
import com.entity.pojos.Cargo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ejb.EJB;
import jakarta.ejb.EJBs;

/**
 *
 * @author PC
 */
public class Editempleado extends HttpServlet {

    private Integer idAdministrador, idCargo,idempleado;
    private String  status;
    
    
    @EJB
    private AdministradorI administrador;
    
    @EJB 
 private Cargoss cargos;
    
    @EJB
    private  EmpleadosI empleados;
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
       idempleado     = Integer.parseInt(request.getParameter("idempleado"));
  idAdministrador = Integer.parseInt( request.getParameter("administrador"));
  idCargo    = Integer.parseInt(request.getParameter("cargos"));
  status    = request.getParameter("statusempleado");
  
  
  
   com.entity.pojos.Empleados empleado = empleados.find(idempleado);
        empleado.setIdAdministracion(getAdministrador(idAdministrador));
        empleado.setCargo(getCargo(idCargo));
        empleado.setStatusempleados(getStatus(status));
        empleados.edit(empleado);
        
    String mensaje = "Ha sido actualizado el usuario " + empleado.getNombre();
 request.setAttribute("mensaje", mensaje);
 request.getRequestDispatcher("/admin/listaempleados").forward(request, response);
          
    }
    
    private Administrador getAdministrador(Integer idAdministrador){
        Administrador administrador = this.administrador.find(idAdministrador);   
      return administrador;  
    }
    private Cargo getCargo(Integer idCargo){
     Cargo cargo = this.cargos.find(idCargo);
        
     return cargo;
    }
    private Status getStatus(String status){
        if(status.equals("ACTIVE")){
            return Status.ACTIVE;
        }
        if(status.equals("INACTIVE")){
            return Status.INACTIVE;
        }
        if(status.equals("SUSPENDED")){
            return  Status.SUSPENDED;
        }
        throw new NullPointerException();
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
