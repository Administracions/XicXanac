/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.Servlets;

import com.administracion.ejbI.ReporteSemanalI;
import com.entity.pojos.ReporteSemanal;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ejb.EJB;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author PC
 */
public class EditedReporte extends HttpServlet {

    private Integer idEmpleado;
    
    private String semanaInicio, semanaFinal;
    
    
    private ReporteSemanal reporteSemanal;
    
    
    @EJB
    private ReporteSemanalI reporteSemanalFacade;
    
    
    /**
     * 
     * 
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
            out.println("<title>Servlet EditedReporte</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditedReporte at " + request.getContextPath() + "</h1>");
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
        
        semanaInicio = formatdate(request.getParameter("iniciosemana"));
        semanaFinal = formatdate(request.getParameter("finsemana"));
        
        double sueldoempleado = Double.valueOf(request.getParameter("SueldoReporte"));
        BigDecimal  salarioempleado = BigDecimal.valueOf(sueldoempleado);   
   idEmpleado =  Integer.parseInt(request.getParameter("Idempleado"));
   reporteSemanalFacade.UpdateSueldo(idEmpleado, salarioempleado, semanaFinal, semanaInicio);
   

   request.setAttribute("mensaje", "Ha sido Actualizado el empleado");
   request.getRequestDispatcher("/admin/ReporteSemanal").forward(request, response);
   
    }

    private String formatdate(String fechas){
        
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
   
        return   LocalDateTime.parse(fechas).format(DateTimeFormatter.ISO_DATE);    
        
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
