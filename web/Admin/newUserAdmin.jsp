<%-- 
    Document   : newUserAdmin
    Created on : 15 jul. 2021, 10:17:03
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/formStyle.css"/>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js" ></script>
         <script src="${pageContext.request.contextPath}/JS/UserAdminVerification.js"></script>   
        <title>Hotel Xic Xanac</title>
        <style>
            #formulariouserAdmin{
     padding-left: 4%;
   text-align:  center;
 padding-top: 100px;
    
}
label.error{
    font-size: 15px;
    color:red;
    display: block;
    font-family: "Times New Roman";
   
}
        </style>
    </head>
    
    <body>
        <header>
            <c:if test="${Administrador != null}">
                <h1> Añade un usuario al administrador <c:out value="${Administrador.nombre}"></c:out></h1>     
            </c:if>
            <c:if test="${mensaje != null}">
                <h1>${mensaje}</h1>  
                
            </c:if>   
        </header>
        <div id="formulariouserAdmin">
            
            <c:if test="${Administrador != null}">  
            <form name="userform" method="POST" action="/Administracion/admin/createAdminuser">
                 </c:if>
                <c:if  test="${Administrador == null}">
              <form name="useradminform" method="POST" action="/Administracion/admin/edituser">
                 </c:if>
                <label class="letrass">Nombre Usuario Administrador</label><br>
                <input  class="inputs" type="text" name="nameAdmin" value="${Username}" />
                <br>
                <br>
                <br>
                <label class="letrass">Password Administrador </label> <br>
                <input class="inputs"   type="password" name="passwordAdmin"  value="${Password}"/>
                 <br>
                <br>
                <br>
                <input id="envioform" type="submit" name="envioadminuser"  value="Enviar Usuario"/>
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
