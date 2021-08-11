<%-- 
    Document   : AdministradorInfo
    Created on : 6 ago. 2021, 19:09:20
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/AdministradorInfo.css" />
        <title>Hotel Xic Xanac</title>
    </head>
    <body>
       
        <jsp:include page="HeaderEmpleado.jsp" />
        <header>
            
            <h1> Informacion de Tu administrador</h1>
        </header> 
        
        <div id="AdminInfo">
            <div>
                
                <b>Nombre del Administrador:</b>   <br>
                <div class="imagenes">
                <img src="${pageContext.request.contextPath}/imagenes/administrador.png" alt="AdminLogo" width="105px" height="105px"  />
                </div>
               
                    
            
                ${informacionAdmin.apellidoPat} ${informacionAdmin.apellidoMat} ${informacionAdmin.nombre}
                   
            </div>
            <div>
                <b>Telefono:</b> <br>
                <div class="imagenes">
         <img src="${pageContext.request.contextPath}/imagenes/TelefonoIcon.jpg" alt="AdminLogo" width="105px" height="105px"  />
                </div>       
            
                ${informacionAdmin.telefono} 
                   
                
            </div>
            <div>
                <b>Correo:</b> <br>
                <div class="imagenes">
                  <img src="${pageContext.request.contextPath}/imagenes/CorreoIcon.jpg" alt="AdminLogo" width="105px" height="105px"  />
                </div>
          
                ${informacionAdmin.correo}
                  
                
                
            </div>
            
            
     
            
        </div>
        
        
        
        
        
        
    </body>
</html>
