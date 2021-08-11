/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.empleados.servlet;

import com.administracion.ejbI.LoginI;
import com.administracion.service.Passwords;
import com.entity.pojos.Login;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ejb.EJB;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
public class login extends HttpServlet {
    
    @EJB
private LoginI login;
    
    private Login usuario;
    private String password;

    
  private Passwords passwords;  
    
    
    
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
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
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
        String mensaje;
       HttpSession session = request.getSession();
        passwords = new Passwords();
        String userempleado = request.getParameter("usuario");
      String password     = request.getParameter("pass");
      
      if(passwords.IsPasswordValid(password) && passwords.IsUsernameValid(userempleado)){
          if(login.IsUserRegistered(userempleado)){
              
       this.password = login.getPassword(userempleado);
       
       if(passwords.CheckPassword(password, this.password)){
           
           session.setAttribute("UserEmpleado", userempleado);
           session.setMaxInactiveInterval(60*60);
        request.getRequestDispatcher("/Home").forward(request, response);
       }else{
           mensaje = "Usuario o contraseña incorrectos";
           request.setAttribute("mensaje", mensaje);
           request.getRequestDispatcher("/Empleados/login.jsp").forward(request, response);
           
       }
       
                  
          }else{
           mensaje = "Usuario o contraseña incorrectos";
           request.setAttribute("mensaje", mensaje);
           request.getRequestDispatcher("/Empleados/login.jsp").forward(request, response);
           
       }
          
          
     
          
          
      }else{
           mensaje = "Usuario o contraseña incorrectos";
           request.setAttribute("mensaje", mensaje);
           request.getRequestDispatcher("/Empleados/login.jsp").forward(request, response);
           
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
