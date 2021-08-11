<%-- 
    Document   : IngresoEmpleado
    Created on : 24 jul. 2021, 12:31:26
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.entity.pojos.Login" %>
<%@page  import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/reloj.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/fontello.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/menu.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estilo.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/JS/reloj.js"></script>
    <!--esto es opcional son las fuentes de google que boy a utilizar -->
    <link href="https://fonts.googleapis.com/css?family=Bellota&display=swap" rel="stylesheet">
    <title>Hotel Xic Xanac</title>
    </head>
<body onload="startTime()">
    <header>
        <div class="contenedor">
        <h1> Hotel Xic Xanac </h1>
        <input type="checkbox" id="menu-bar">
        <label class="icon-menu" for="menu-bar"></label>
            <nav class="menu">
              <a href="">Ayuda</a>
              <a href="">Contacto</a>
              <a href="../primera/index.html">Salir</a>
            </nav>
        </div>
    </header>
    <br>
  
    <form method="POST" action="/Administracion/Registro/NuevoHorario" >
        <h2> ${mensaje} </h2> 
        <div class="cod-empleado" id="RegistrarHorario">
            <label for="cod-empleado">Seleccione su usuario de empleado</label>
            <select id="codigoempleado" name="CodEmpleado">
                <c:forEach items="${listausername}" var="username">
                    <option value="${username.empleados.idEmpleado}">                   
                        ${username.userEmpleado}
                    </option>
                 
                  </c:forEach>  
            </select>
            </div>
            <br>
    <div class="clockdate">
        <span id="time"></span>
        <span id="date"></span>
    </div>
    <br>
    <div id="RegistroHorarios" class="accion" >
        <input id="RegistroEntrada" name="Entrada" type="submit" value="Registrar Entrada">
      
        <input  type="submit" name="Editar" value="Registrar Salida" >
     
        </div>
    </form>
</body>    
</html>
