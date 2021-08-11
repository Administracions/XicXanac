/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.Servlets;

import com.administracion.ejbI.DireccionI;
import java.io.IOException;
import java.io.PrintWriter;
import com.administracion.ejbI.EmpleadosI;
import com.administracion.ejbI.LoginI;
import com.administracion.service.EmpleadoService;
import com.administracion.service.Passwords;
import com.entity.pojos.Direccion;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ejb.EJB;
import com.entity.pojos.Empleados;
import com.entity.pojos.Login;

/**
 *
 * @author PC
 */
public class addUserEmpleado extends HttpServlet {
private Empleados empleadoId;
private Direccion direccion;
private String    userempleado, passwordempleado,mensaje;
private Passwords passwords;
private Login     login;
@EJB
private EmpleadosI empleados;    

@EJB 
private LoginI loginempleado;


@EJB
private DireccionI direcciones;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


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
       passwords = new Passwords();
       empleadoId = (Empleados) session.getAttribute("usuario");
       direccion  = (Direccion) session.getAttribute("direccion");
        userempleado = request.getParameter("nameAdmin");
        passwordempleado = request.getParameter("passwordAdmin");
        
        if(passwords.IsUsernameValid(userempleado) && passwords.IsPasswordValid(passwordempleado)){
        
         if(empleados.IsUserRegistered(userempleado)){       
         login = EmpleadoService.fillloginfield(userempleado, passwordempleado);      
       empleados.create(empleadoId);
 
       direccion.setEmpleadoDir(empleadoId);
       login.setEmpleados(empleadoId);
       
       
       loginempleado.create(login);
       direcciones.create(direccion);
       session.removeAttribute("usuario");
       
      mensaje = "Ha sido registrado el empleado con el usuario "+ userempleado;
     request.setAttribute("mensaje", mensaje );
     request.getRequestDispatcher("/admin/listaempleados").forward(request, response);
      
         }else{
          
          mensaje = "Ya existe un usuario con este username. Intenta nuevamente";
          request.setAttribute("mensaje", mensaje );
           request.getRequestDispatcher("/Admin/Login.jsp").forward(request, response);
         }
         

        }else{
          mensaje = "El usuario o contraseña no son validos. Intenta nuevamente";  
          request.setAttribute("mensaje", mensaje );
           request.getRequestDispatcher("/Admin/Login.jsp").forward(request, response);
          
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
