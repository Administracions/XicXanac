/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.Servlets;

import com.administracion.ejbI.AdministradorI;
import com.administracion.ejbI.LoginAdminI;
import com.administracion.service.Passwords;
import com.entity.pojos.Administrador;
import com.entity.pojos.Loginadmin;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class createAdminUser extends HttpServlet {

    
    private String nameuser;
    private String password;
  
   private Administrador administrador;
    
    @EJB
    private AdministradorI administradorI;
    
    
    @EJB
    private  LoginAdminI logiadminI;
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
            out.println("<title>Servlet createAdminUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet createAdminUser at " + request.getContextPath() + "</h1>");
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
        Passwords passwords = new Passwords();
       
   nameuser   =  request.getParameter("nameAdmin");
  password = request.getParameter("passwordAdmin"); 

  try{
  if(passwords.IsUsernameValid(nameuser) && passwords.IsPasswordValid(password)){
      if(logiadminI.IsUserRegistered(nameuser) != true){
      Loginadmin loginadmin = new Loginadmin();
      loginadmin.setIdLoginAdmin(administradorI.getLastIdAdminLogin());
      loginadmin.setNombreAdmin(nameuser);
     loginadmin.setPassword(passwords.EncryptPassword(password));
     logiadminI.create(loginadmin);
     
     
     
     
     request.setAttribute("mensaje", nameuser + " creado exitosamente");
     request.getRequestDispatcher("/admin/AdminHome").forward(request, response);
     
      }else{
          throw new NullPointerException("Nombre ya ha sido registrado");
      }
      
     
  }else{
      throw new NullPointerException("Nombre ya ha sido registrado");
  }
  }catch(Exception e){
       String mensaje = "El usuario con el nombre "+ nameuser + " ya ha sido registrado";    
     request.setAttribute("mensaje",mensaje);
     request.getRequestDispatcher("/Admin/newUserAdmin.jsp").forward(request, response);   
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
