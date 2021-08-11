<%-- 
    Document   : login
    Created on : 28 jul. 2021, 12:22:54
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema de Registro de Asistencia</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/fontello.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estilo.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/menu.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/master.css">
        <script src ="${pageContext.request.contextPath}/JS/loginempleado.js" type="text/javascript"></script>

    </head>
    <body>
        <header>
            <div class="contenedor">
            <h1> Hotel Xic Xanac </h1>
            <input type="checkbox" id="menu-bar">
            <label class="icon-menu" for="menu-bar"></label>
                <nav class="menu">
                <a href="">Ayuda</a>
                <a href="">Contacto</a>

                </nav>
            </div>
    </header>
        <br>
        <br>
       
        <br>
        <br>   
        <h3 style="text-align: center; color: red; padding-top: 5%;"> ${mensaje}</h3>
    <div class="login-box">
       
        <img src="${pageContext.request.contextPath}/imagenes/long.png" class="avatar" alt="Avatar Image">
        <br>
        <form method="post" action="/Administracion/security/loginEmpleado">
      <h2>Iniciar Sesión</h2>
        
        <!-- USERNAME INPUT -->
       <label for="username">Usuario</label>
        <input id="userr" type="text" name="usuario"placeholder="Ingrese Usuario" required>
        <!-- PASSWORD INPUT -->
        <label for="pass">Contraseña</label>
        <input  id="passwords" type="password" name="pass" placeholder="Ingrese Contraseña" required>
          
        <input type="submit" value="Aceptar">
        <input type="submit" value="Cancelar" onclick="regresarindex()">
        <br>
        <br>
        <center><a href="/Administracion/Recuperar/UserEmpleado.jsp">¿Perdiste tu contraseña?</a><br></center>
      </form>
    </div> 
  
    
    </body>
</html>
