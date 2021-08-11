<%-- 
    Document   : Usuario
    Created on : 9 ago. 2021, 12:56:14
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Informacion.css" />
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/formStyle.css" />
        <title>Hotel Xic Xanac </title>
    </head>
    <body>
        
        <jsp:include page="HeaderEmpleado.jsp" />
        <header>
            
            <h1> Usuario </h1>
        </header>
        <div>
            <div id="Usuarioinfo">
                <div class="imagenes">
                    
                    <img src="${pageContext.request.contextPath}/imagenes/administrador.png" alt="Administrador logo" width="100px" height="100px"  /> 
                    
                </div>
                <div id="usuario" class="letrass">
                    <b class="letrass">Tu Usuario</b> <br> <br>
                    
                  ${UsuarioEmpleado.userEmpleado}  
                    
                </div>
               
                
                
            </div>
            <div>
               
                <div id="restablecer">
                    <a class="botones">Restablecer Contraseña </a>
                    
                </div>
                
            </div>
            
        </div>
        
        
        
        
        
    </body>
</html>
