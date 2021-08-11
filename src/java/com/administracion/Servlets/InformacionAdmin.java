/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.Servlets;

import com.administracion.ejbI.AdministradorI;
import com.administracion.service.Passwords;
import jakarta.ejb.EJB;
import com.administracion.ejbI.LoginAdminI;
import com.administracion.enums.Status;
import com.entity.pojos.Administrador;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
public class InformacionAdmin extends HttpServlet {
    
    private String nameuser, password, passwordhashed;
    private Passwords passwords;
    
    
    @EJB
    private LoginAdminI loginAdmin;
    
    
    @EJB
    private AdministradorI administrador;

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
            out.println("<title>Servlet InformacionAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InformacionAdmin at " + request.getContextPath() + "</h1>");
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
  
   try{
         HttpSession sessionAdmin =  request.getSession();
          nameuser = (String) sessionAdmin.getAttribute("nameAdmin");
  
 if(nameuser != null){
     Administrador administrador = this.administrador.findBynameAdmin(nameuser);
    
    request.setAttribute("Administrador", administrador);
    request.setAttribute("statusAdministradores", Status.values());
    request.getRequestDispatcher("/Admin/newAdmin.jsp").forward(request, response);
  
     
 }
 else{
     throw new IllegalArgumentException();
 }
                    
        }catch(Exception e){
            request.setAttribute("mensaje", "Usuario o contraseña incorrectos. Intenta nuevamente");
         request.getRequestDispatcher("/Security/AdminLogin.jsp").forward(request,response);
       
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
