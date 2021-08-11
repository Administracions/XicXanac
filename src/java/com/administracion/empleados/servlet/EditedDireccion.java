/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.empleados.servlet;

import com.administracion.ejbI.DireccionI;
import com.administracion.service.DireccionService;
import com.entity.pojos.Direccion;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "EditedDireccion", urlPatterns = {"/EditedDireccion"})
public class EditedDireccion extends HttpServlet {

    
    @EJB
    private DireccionI direccionFacade;
    
    private Direccion editDireccion;
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

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
      Integer idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
      
       Direccion direccionempleado= direccionFacade.findByIdEmpleado(idEmpleado);
       
       if(direccionempleado != null){
           DireccionService.getDireccionEmpleado(request, response);
           editDireccion = DireccionService.filleditdireccionempleado(direccionempleado);
           direccionFacade.edit(editDireccion);
           request.setAttribute("mensaje", "Ha sido actualizada tu direccion");
           request.getRequestDispatcher("/Direccion").forward(request, response);
   
       }
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
      
      
      
        
        
        
        
        
        
        
        
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
