/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.Servlets;

import com.administracion.ejbI.AdministradorI;
import com.administracion.ejbI.Cargoss;
import com.administracion.enums.Estados;
import com.administracion.service.EmpleadoService;
import com.entity.pojos.Administrador;
import com.entity.pojos.Cargo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ejb.EJB;
import jakarta.ejb.EJBs;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
public class Empleados extends HttpServlet {
@EJB
    private Cargoss cargos;

@EJB
private  AdministradorI administrador;


private Integer idcargo, idAdministrador;




    
    
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
            out.println("<title>Servlet Empleados</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Empleados at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        
        
        idcargo = Integer.parseInt(request.getParameter("idCargo"));
    
        idAdministrador = Integer.parseInt(request.getParameter("idAdministrador"));
       EmpleadoService.getInformacionempleado(request, response);
    com.entity.pojos.Empleados empleado = EmpleadoService.fillemployeefields();
    empleado.setCargo(getCargo(idcargo));
    empleado.setIdAdministracion(getAdministrador(idAdministrador));
    
    if(empleado != null){
   request.setAttribute("empleado", empleado);
   request.setAttribute("listaestados", Estados.values());
   session.setAttribute("usuario", empleado);
request.getRequestDispatcher("/Admin/Direccionempleado.jsp").forward(request, response);
    }
    
    }
    
    
    
    
    
    private Cargo getCargo(Integer idCargo){
        Cargo cargo = this.cargos.find(idCargo);
       if(cargo == null){
           return null;
       } 
       return  cargo;
    }
    private Administrador getAdministrador(Integer idAdministrador){  

      Administrador administrador = this.administrador.find(idAdministrador);
       if(administrador == null){
           return null;
       } 
       return  administrador; 
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
