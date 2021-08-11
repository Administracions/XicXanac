<%-- 
    Document   : AdminLogin
    Created on : 17 jul. 2021, 13:41:05
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/AdminLogin.css" />
        <title>Hotel XicXanac </title>
        <style>
            
 
            #contra{
                padding: 15px;
                text-align: center;
            }          

#contrasena a{
 margin:15px;
  text-align: center;
  text-decoration: none;
  font-size: 12px;
  line-height: 20px;
  color: #000;
}
        </style>
    </head>
    <body>
        
        <div align="center">
        <img src="${pageContext.request.contextPath}/imagenes/administrador.png" alt="adminLogo" width="200px" height="200px" />
        </div>
        <header>
            <c:if test="${mensaje != null}">
         
                 <h1 class="letras" >${mensaje}</h1>
                 
            </c:if>
                 <c:if test="${mensaje == null}">
                  <h1 class="letras">Administracion Login</h1> 
            </c:if>
               
        </header>
   
        
        <div id="adminlogin">
             
            <form method="POST" action="/Administracion/security/login">
           
                <fieldset>
            
                <label>Nombre Usuario Admin:</label>
                <input class="inputs" type="text" name="nameAdmin"  required value="${nameAdmin}"/>
                <br>
                <br>
                <label> Password:</label>
                <input class="inputs" type="password" name="passAdmin" required />
                <br>
                <br>
                <input  id="enviologin" type="submit" name="enviologin" value="Login"/>
                </fieldset>
                
               
            </form>  
                   
        </div>
                <div id="contra">
                <button id="contrasena"> <a href="/Administracion/Recuperar/UserAdmin.jsp">¿Olvidaste tu contraseña? </a> </button>
                </div>
        
    </body>
</html>
