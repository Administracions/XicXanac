/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.empleados.servlet;

import com.administracion.ejbI.EmpleadosI;
import com.administracion.service.EmpleadoService;
import com.entity.pojos.Empleados;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ejb.EJB;

/**
 *
 * @author PC
 */
@WebServlet(name = "EditedEmpleado", urlPatterns = {"/EditedEmpleado"})
public class EditedEmpleado extends HttpServlet {

    
    @EJB
  private EmpleadosI empleadoFacade;
    
    
    private Empleados empleado;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditedEmpleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditedEmpleado at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
     Integer idempleado = Integer.parseInt(request.getParameter("idEmpleado"));   
     Empleados empleados= empleadoFacade.find(idempleado);
     
   if(empleados != null){     
   EmpleadoService.getEditEmployeeFields(request, response);
  empleado = EmpleadoService.fillEditEmployeefields(empleados);
  empleadoFacade.edit(empleado);
  request.setAttribute("mensaje", "Ha sido actualizado tu informacion");
  request.getRequestDispatcher("/Informacion").forward(request, response);
 
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
