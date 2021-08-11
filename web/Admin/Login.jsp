<%-- 
    Document   : Login
    Created on : 22 jul. 2021, 9:34:58
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/formStyle.css" />
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js" ></script>
         <script src="${pageContext.request.contextPath}/JS/UserAdminVerification.js"></script>   
        <title>Hotel Xic Xanac</title>
    </head>
    <body>
        <header>
            <h1>
                Ingresa un Usuario al empleado <c:out value="${empleado.nombre}"></c:out>
            </h1>        
               <c:if test="${mensaje != null}">  
            <h2>${mensaje}</h2>           
            </c:if>
        </header>
            
        
            
            <div id="formempleados">
                <form name="userform" method="POST" action="/Administracion/admin/addUserEmpleado">   
                <label class="letrass">Username empleado:</label><br>
                    <input class="inputs" type="text" name="nameAdmin"  />
                    <br>
                    <br>
                    <label class="letrass">Password empleado:</label><br>
                    <input class="inputs" type="password" name="passwordAdmin" />
                    <br>
                    <br>
                    <input id="envioform" type="submit" value="Añadir Username" /> 
                </form>
 
            </div>
                    
                    
          <footer align="center" >
            <p class="letrass">
           NOTA: El nombre de usuario debe llevar al menos una letra mayuscula y dos numeros. Minimo 4 caracteres
           Contraseña: Debe llevar minimo 8 caracteres. Incluye Mayusculas, minimo 2 numeros y un caracter como @!?#&%
            </p>    
        </footer>
            
         
        
    </body>
</html>
