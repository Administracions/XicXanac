<%-- 
    Document   : index
    Created on : 7 jul. 2021, 12:46:56
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/indexStyle.css" />
        <title>Xic Xanac</title>
    </head>
    <body>
        
        <header>
            <h1 class="letras"> Bienvenido a Hotel Xic Xanac </h1>
          
        </header>
        
        
        
        <div>
        <div id="menu">
            <a href="/Administracion/Registro/Horarios">
                <label class="letras">Registrar Horarios</label><br>
                <img id="horario"  src="${pageContext.request.contextPath}/imagenes/registro.png" alt="regitrohorario" height="200px" width="200px"/>
                
            </a>
                 <br>
                <br>
            <a href="/Administracion/admin/AdministradorHome">
                <label class="letras">Ingresa al administrador </label><br>
                <img src="${pageContext.request.contextPath}/imagenes/administrador.png" alt="admnistrador" height="200px" width="200px" /> 
                
            </a>
                <br>
                <br>
                <a href="/Administracion/Empleados/login.jsp">
                    <label class="letras" >Ingresar empleado</label><br>
                    <img src="${pageContext.request.contextPath}/imagenes/personal.png" alt="empleado" height="200px" width="200px" />
            </a>
 
        </div>
        </div>

        
    </body>
</html>
