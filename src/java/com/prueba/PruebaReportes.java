/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba;

import com.administracion.ejbI.AdministradorI;
import com.administracion.ejbI.DireccionI;
import com.administracion.ejbI.EmpleadosI;
import com.administracion.ejbI.LoginI;
import com.administracion.ejbI.ReporteI;
import com.administracion.ejbI.ReporteSemanalI;
import com.entity.pojos.Direccion;
import com.entity.pojos.Empleados;
import com.entity.pojos.Reporte;
import com.entity.pojos.ReporteSemanal;
import com.lambdaworks.crypto.SCryptUtil;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author PC
 */
public class PruebaReportes extends HttpServlet {


@EJB 
private ReporteSemanalI z;
 
@EJB 
private EmpleadosI emp;
   
@EJB 
private ReporteI rep;
@EJB
 private LoginI log;
@EJB
private AdministradorI admin;

@EJB 
private DireccionI direccionFacade;

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
         //  ReporteSemanal reporteSemanal = new ReporteSemanal(); 
            
          // ReporteSemanal fr = z.find(1L);
          // Empleados empleado = emp.find(1);
          // Reporte fd = rep.find(2);
            // BigDecimal d = z.getSumaTotalHorasSemana();  
       
    /*   ReporteSemanal reporteSemanal = new ReporteSemanal();
       reporteSemanal.setPagoHoraUnitario(60.0);
       reporteSemanal.setIdReporteSemanal(1L);
       reporteSemanal.setEmpleados(empleado);
      // reporteSemanal.setHorasTrabajadas(d);
     // reporteSemanal.setPagaSemana(2500D);
           
   //  z.create(reporteSemanal); 
 
 
       
      Reporte rp = new Reporte(); 
      
      rp.setIdReporte(3);
     rp.setFechaDiaria(LocalDate.now(Clock.systemUTC()));
       ZoneId zoneIdMx = ZoneId.of("America/Mexico_City");
     rp.setHoraEntrada(LocalDateTime.of(2021, Month.FEBRUARY, 17, 8, 30, 00).atZone(zoneIdMx).toLocalDateTime());
     rp.setHoraSalida(LocalDateTime.of(2021, Month.FEBRUARY, 17,15 , 30, 00).atZone(zoneIdMx).toLocalDateTime());
     rp.setPagohora(LocalDateTime.now());
   rp.setReporteSemanal(fr);
   rp.setEmpleados(empleado);
   // rp.setReporteSemanal(reporteSemanal);
     
// reporteSemanal.AddReporteSemanal(rp);
 //z.create(reporteSemanal);  
 //rep.create(rp); */

 
String d = log.getUserName("carlosvalentin1405");
                  
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PruebaReportes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PruebaReportes at " + direccionFacade.findByIdEmpleado(2)+ "</h1>");
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
