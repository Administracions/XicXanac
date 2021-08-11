<%-- 
    Document   : UserAdmin
    Created on : 9 ago. 2021, 9:29:02
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/formStyle.css" />
        <title>Hotel Xic Xanac </title>
    </head>
    <body>
        <header>
            <h1>
                Hotel Xic Xanac 
            </h1>
        </header>
        
        <div id="menu">
            
            <form method="POST" action="/Administracion/UserAdmin">
                <label class="letrass">Escriba su Usuario de Administrador:</label> <br><br>
                <input  class="inputs" type="text" name="UserAdmin"  required /> <br><br>
                <input id="envioform" type="submit" value="Recuperar Contraseña" /> <br><br>
           
            </form>
            <button id="envioform"><a href="/Administracion/Admin/Login.jsp"> Cancelar</a> </button>
            
        </div>
        
        
        
    </body>
</html>