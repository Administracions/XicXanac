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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import  jakarta.ejb.EJB;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.List;

/**
 *
 * @author PC
 */
@WebServlet(name = "BusquedaSemana", urlPatterns = {"/admin/Buscar"})
public class BusquedaSemana extends HttpServlet {
@EJB
 private  ReporteSemanalI reportesemanalFacade;   

private LocalDateTime localdate;
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
            out.println("<title>Servlet BusquedaSemana</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BusquedaSemana at " + request.getContextPath() + "</h1>");
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
            DateTimeFormatter formatofecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  
         localdate= LocalDate.parse(request.getParameter("Fecha"),  formatofecha).atStartOfDay();  
        List<Object[]> reportesemanal = reportesemanalFacade.findReporteByEmpleadoFecha(localdate);  
        
       
        if(reportesemanal != null){
        request.setAttribute("reportesemanales", reportesemanal);
        request.getRequestDispatcher("/Admin/ReportesSemanales.jsp").forward(request, response);
        }else{
            request.setAttribute("mensaje","No se han encontrado reporte de esa fecha");
                    request.getRequestDispatcher("/Admin/ReportesSemanales.jsp").forward(request, response);
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
