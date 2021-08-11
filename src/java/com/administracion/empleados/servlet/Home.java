/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.empleados.servlet;

import com.administracion.ejbI.ReporteI;
import com.entity.pojos.Reporte;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ejb.EJB;
import java.time.LocalDate;

/**
 *
 * @author PC
 */
public class Home extends HttpServlet {

    @EJB
    private ReporteI reportes;
    
    private String usernameempleado;
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
            out.println("<title>Servlet Home</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Home at " + request.getContextPath() + "</h1>");
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
HttpSession session = request.getSession();
usernameempleado = (String)   session.getAttribute("UserEmpleado");
Reporte reporteempleado = reportes.findbyUsernameEmpleado(usernameempleado);

if(usernameempleado != null){
    request.setAttribute("FechaActual", LocalDate.now());
    request.setAttribute("reporteempleado", reporteempleado);
    request.getRequestDispatcher("/Empleados/HomeEmpleado.jsp").forward(request, response);
   }
        
        
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
       HttpSession session = request.getSession();
usernameempleado = (String)   session.getAttribute("UserEmpleado");
Reporte reporteempleado = reportes.findbyUsernameEmpleado(usernameempleado);

if(usernameempleado != null){
    request.setAttribute("FechaActual", LocalDate.now());
    request.setAttribute("reporteempleado", reporteempleado);
    request.getRequestDispatcher("/Empleados/HomeEmpleado.jsp").forward(request, response);
   
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
