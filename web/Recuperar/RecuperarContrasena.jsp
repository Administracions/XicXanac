<%-- 
    Document   : RecuperarContrasena
    Created on : 8 ago. 2021, 11:42:32
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/formStyle.css" 
        <title>Hotel Xic Xanac</title>
    </head>
    <body>
        <header>
            
            <h1>Hotel Xic Xanac: </h1>
            
        </header>
        <div id="menu">
            <form method="POST" action="/Administracion/Confirmar">
                <input type="hidden" name="UserEmpleado" value="${userEmpleado}" />  
                <h2 id="mensajeerror">${mensaje}</h2>
                
                <div class="contrasena">
                <label class="letrass"> Contraseña Nueva: </label>
                <input class="inputs" type="password" name="contrasena"  required/>
                </div>
                <div class="contrasena">
                <label class="letrass"> Escribalo de nuevo: </label>
                <input class="inputs" type="password" name="contrasenaConfirmacion"  required/>                 
                </div>
      
                <input id="envioform" type="submit" value="Cambiar Contraseña" /> <br> <br>
                        
                
            </form>
                          <button id="envioform"><a href="/Administracion/admin/login.jsp">Cancelar</a></button>
      
        </div>
        
        
   
    </body>
</html>
