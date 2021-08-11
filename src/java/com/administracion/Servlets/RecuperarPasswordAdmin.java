/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.Servlets;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import com.administracion.ejbI.LoginAdminI;
import com.administracion.service.LoginService;
import com.entity.pojos.Login;
import com.entity.pojos.Loginadmin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "RecuperarPasswordAdmin", urlPatterns = {"/Recuperar/RecuperarAdmin"})
public class RecuperarPasswordAdmin extends HttpServlet {
@EJB
private LoginAdminI loginAdminFacade;

private String contrasena, confirmarcontrasena;
    
    
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
            out.println("<title>Servlet RecuperarPasswordAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RecuperarPasswordAdmin at " + request.getContextPath() + "</h1>");
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
        
      String userAdministrador = request.getParameter("UsuarioAdmin");
      contrasena = request.getParameter("contrasena");
      confirmarcontrasena = request.getParameter("contrasenaConfirmacion");
      
      
       
       boolean IsEqualpassword =  contrasena.equals(confirmarcontrasena);
       
  
       Integer idEmpleado = loginAdminFacade.getIdUserByNameUser(userAdministrador);
       
     try{  
     if(IsEqualpassword){
         Loginadmin loginempleado = loginAdminFacade.find(idEmpleado); 
     loginempleado =  LoginService.UpdatePassword(loginempleado, contrasena);
     
     if(loginempleado != null){
   loginAdminFacade.edit(loginempleado);
      request.setAttribute("mensaje", " Contrasena cambiada. Ingrese nuevamente.");
      request.getRequestDispatcher("/Admin/Login.jsp").forward(request, response);
   
   
     }else{
         throw new NullPointerException();
     }
   
     }else{
         throw new IllegalArgumentException();   
     }
           
           
        }catch(NullPointerException e){
            request.setAttribute("UsuarioAdmin", userAdministrador );
            request.setAttribute("mensaje", "Esta Contraseña no es valida. Intenta nuevamente");
            request.getRequestDispatcher("/Recuperar/RecuperarContrasenaAdmin.jsp").forward(request, response);
            
            
        }catch(IllegalArgumentException illegal){
                     request.setAttribute("UsuarioAdmin", userAdministrador );
              request.setAttribute("mensaje", "Las contraseñas no coinciden");
            request.getRequestDispatcher("/Recuperar/RecuperarContrasenaAdmin.jsp").forward(request, response);
            
            
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
