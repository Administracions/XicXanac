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
import com.lambdaworks.crypto.SCryptUtil;
import jakarta.ejb.EJB;
import jakarta.ejb.EJBs;
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
public class loginAdmin extends HttpServlet {
    private String nameuser, password, passwordhashed,mensaje;
    private Passwords passwords;
    private Integer idAdmin;
    private Loginadmin loginadmin;
    
    
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
            out.println("<title>Servlet loginAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginAdmin at " + request.getContextPath() + "</h1>");
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
        
        
        boolean Checkpassword;
       
    
        passwords = new Passwords();
        nameuser = request.getParameter("nameAdmin");
        password = request.getParameter("passAdmin");
        try{
       if(passwords.IsUsernameValid(nameuser) && passwords.IsPasswordValid(password)){
       
           if(loginAdmin.IsUserRegistered(nameuser)){
        passwordhashed = loginAdmin.getUserNameAdmin(nameuser);
               
        Checkpassword = passwords.CheckPassword(password, passwordhashed);
      if(Checkpassword){
            if(session == null || session.getAttribute("nameAdmin") == null){
         
                SetUserSessionandFoward(nameuser, request, response);
           
            }else{
      
                mensaje="Editar Usuario o contraseña";
                request.setAttribute("Username", nameuser);
                request.setAttribute("Password", password);
                request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("/Admin/newUserAdmin.jsp").forward(request, response); 
            }
            
            
        }else{
           throw new IllegalArgumentException();
        } 
                
           }else{
                throw new IllegalArgumentException();
          }
            
    
       }else
           throw new IllegalArgumentException();
        
        }catch(Exception e){
            request.setAttribute("mensaje", "Usuario o contraseña incorrectos. Intenta nuevamente");
         request.getRequestDispatcher("/Security/AdminLogin.jsp").forward(request,response);
       
        }
    }
    
    
    private void SetUserSessionandFoward(String nameuser, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
         session.setAttribute("nameAdmin", nameuser);
         session.setMaxInactiveInterval(10*60);
         request.getRequestDispatcher("/admin/AdministradorHome").forward(request,response);
   
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
