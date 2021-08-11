/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.empleados.servlet;

import com.administracion.ejbI.EmpleadosI;
import com.administracion.ejbI.ReporteI;
import com.administracion.service.ReporteService;
import com.entity.pojos.Empleados;
import com.entity.pojos.Reporte;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ejb.EJB;
import java.time.LocalDateTime;

/**
 *
 * @author PC
 */
public class NuevoHorario extends HttpServlet {

    @EJB
    private ReporteI reportes;
    
    @EJB
    private EmpleadosI empleados;
    
    
  private Empleados empleado;
  
  
  private Reporte reporte;
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
            out.println("<title>Servlet NuevoHorario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NuevoHorario at " + request.getContextPath() + "</h1>");
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
     Integer idempleado  = Integer.parseInt(request.getParameter("CodEmpleado"));
     String   typeAccion = request.getParameter("Entrada");
     String   editaraccion = request.getParameter("Editar");
     
     
  if(editaraccion != null && typeAccion == null){
    Reporte reporte =   reportes.findbyempleado(idempleado);
    if(reporte != null){
    if(reporte.getHoraSalida() == null)    {
    reporte.setHoraSalida(LocalDateTime.now());
    reportes.edit(reporte);      
      request.getRequestDispatcher("/Hotel/index.jsp").forward(request, response);
    }else{
           request.setAttribute("mensaje", "Este usuario ya ha sido registrado como horario salida por hoy");
   request.getRequestDispatcher("/Registro/Horarios").forward(request, response); 
    }
      
    }else{
      
          request.setAttribute("mensaje", "Este usuario aun no ha sido registrado como entrada por hoy");
   request.getRequestDispatcher("/Registro/Horarios").forward(request, response);  
    }
      
  }else if(reportes.IsRegisteredtodayemployee(idempleado) == false && typeAccion != null){
        if(reportes.findbyempleado(idempleado) == null){
      
     empleado = empleados.find(idempleado);
     reporte =  ReporteService.fillreportefields();
     reporte.setEmpleados(empleado);
     reportes.create(reporte);
    request.getRequestDispatcher("/Hotel/index.jsp").forward(request, response);
        }else{
             request.setAttribute("mensaje", "Este  usuario ha sido registrado como entrada pero no ha registrado su salida");
    
    request.getRequestDispatcher("/Registro/Horarios").forward(request, response);  
        }
  } else{   
      request.setAttribute("mensaje", "Este  usuario ya ha sido registrado por hoy");
    
    request.getRequestDispatcher("/Registro/Horarios").forward(request, response);       
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
