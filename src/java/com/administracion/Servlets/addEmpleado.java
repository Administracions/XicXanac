/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.Servlets;

import com.administracion.ejbI.AdministradorI;
import com.administracion.ejbI.Cargoss;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.ejb.EJB;
import java.util.List;
import com.entity.pojos.Administrador;
import com.entity.pojos.Cargo;
import jakarta.ejb.EJBs;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class addEmpleado extends HttpServlet {
    
    
    @EJB
    private AdministradorI administrador;
    
    @EJB
    private Cargoss cargosFacade;

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
     List<Administrador> administradores = administrador.findAll();
     List<Cargo> cargos = cargosFacade.findAll();
    

     request.setAttribute("listaAdministradores", administradores);
     request.setAttribute("listacargos", cargos);
     request.getRequestDispatcher("/Admin/newEmpleado.jsp").forward(request, response);
       
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
       
           List<Administrador> administradores = administrador.findAll();
     List<Cargo> cargos = cargosFacade.findAll();
    

     request.setAttribute("listaAdministradores", administradores);
     request.setAttribute("listacargos", cargos);
     request.getRequestDispatcher("/Admin/newEmpleado.jsp").forward(request, response);
        
        
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
