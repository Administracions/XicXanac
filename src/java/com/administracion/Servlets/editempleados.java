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
import java.util.List;

/**
 *
 * @author PC
 */
public class editempleados extends HttpServlet {

    private Integer idEmpleado;
   
    @EJB
    private EmpleadosI empleados;
    
    
    @EJB
    private AdministradorI administracion;
    
    @EJB
    private Cargoss cargos;
    
    
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
            out.println("<title>Servlet editempleados</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editempleados at " + request.getContextPath() + "</h1>");
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
      
        List<Cargo> cargos = this.cargos.findAll();
      List<Administrador> administradores = administracion.findAll();
       idEmpleado = Integer.parseInt(request.getParameter("idempleado"));
        com.entity.pojos.Empleados empleado = empleados.find(idEmpleado);
        request.setAttribute("empleado", empleado);
        request.setAttribute("administradores", administradores);
        request.setAttribute("cargos", cargos);
        request.setAttribute("Statusempleado",Status.values());
       request.getRequestDispatcher("/Admin/EditEmpleado.jsp").forward(request, response);
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
        processRequest(request, response);
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
