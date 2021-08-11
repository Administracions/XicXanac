/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba;

import com.administracion.ejb.AbstractFacade;
import com.entity.pojos.Administrador;
import com.entity.pojos.Cargo;
import com.administracion.ejb.CargoFacade;
import com.administracion.ejbI.AdministradorI;
import com.administracion.ejbI.Cargoss;
import com.administracion.ejbI.DireccionI;
import com.administracion.ejbI.EmpleadosI;
import com.administracion.ejbI.LoginAdminI;
import com.administracion.ejbI.ReporteI;
import com.administracion.ejbI.ReporteSemanalI;
import com.administracion.enums.Status;
import com.entity.pojos.Direccion;
import com.entity.pojos.Empleados;
import com.entity.pojos.Loginadmin;
import com.entity.pojos.Reporte;
import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.persistence.Tuple;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Pruebas extends HttpServlet {
@EJB
private AdministradorI cf;
@EJB
private LoginAdminI lai;
@EJB
private EmpleadosI d;
@EJB
private Cargoss c;
@EJB
private DireccionI f;
@EJB 
private ReporteI rep;
@EJB 
private ReporteSemanalI z;

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
           
 /* Cargo fc= c.find(1);
 Administrador admin1 = cf.find(2);
  
  
  Empleados e1 = new Empleados(0, "Guillermo","Joaquin", "Vargas",Status.ACTIVE, 5576235799L);    
//  Direccion ds = new Direccion( 0L, "Av.Palomas", 2041, "501", 07300, "Puebla", "MX");
 //e1.setDirection(ds);
 e1.setCargo(fc);
  e1.setIdAdministracion(admin1);
//  ds.setEmpleadoDir(e1);
   cf.addEmpleado(e1);
 // f.create(ds);
   
   /*Reporte repo= new Reporte(6, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 1420);
   rep.create(repo);
   
   
    /* Cargo de = new Cargo(0,"A012","Limpieza");
     Cargo sa = new Cargo(0, "A015", "Recepcionista");
     
     c.create(de);
     c.create(sa);*/
     
Object[] ejemplos = {4,5,6};
cf.ActivarGrupoEmpleado(ejemplos);

    Reporte reporte =   rep.findbyempleado(1);
 
 
     //Double horastotal = rep.getHorasTrabajadas(5, 15);
     
   
 
     String dse = "Hola";
            /* TODO &output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");    
              out.println("<h1>Contrasela at "  + rep.findbyUsernameEmpleado("AnaIsol1454") +  "</h1>");
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
    try {
        processRequest(request, response);
    } catch (Exception ex) {
        Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
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
    try {
        processRequest(request, response);
    } catch (Exception ex) {
        Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
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
