<%-- 
    Document   : Direccionempleado
    Created on : 22 jul. 2021, 17:45:51
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/formStyle.css" />
              <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js" ></script>
        <script src="${pageContext.request.contextPath}/JS/DireccionVerification.js" type="text/javascript"></script>
        <title>Hotel Xic Xanac</title>
    </head>
    <style>
        
        #formdireccion div{
            text-align: left;
            padding-left: 4%;
            
        }
    </style>
    
    
    <body>
        <jsp:include page="HeaderAdmin.jsp" />
        
        
        <div>
            <h1 id="iniciodireccion">
                Agrega una direccion del empleado
            </h1>
            
        </div>
        
        <div id="formdireccion" align="center">
            <form method="POST" action="/Administracion/admin/direccionempleado" name="formdireccion">
                <div>
                <label class="letrass"> Calle o Avenida Principal  y Colonia </label><br>
                <input class="inputs"  type="text"  name="calleprincipal" placeholder="Calle Principal" /><br>
                 <label class="letrass">  Colonia </label><br>
                <input class="inputs"  type="text"  name="Colonia" placeholder="Colonia" /><br>
                <label class="letrass"> Codigo Postal:  </label><br>
                <input  class="inputs" type="text" name="CodigoPostal"  placeholder="Codigo postal"/> <br>
                <label class="letrass">Estado:</label><br>
                <select class="inputs" name="estado">
                    <c:forEach items="${listaestados}" var="estados">
                        <option value="${estados}"> ${estados} 
                        
                    </c:forEach>
                    
                   </option>
                </select><br> <br>
                <label class="letrass">Numero Exterior:</label>
                <input class="inputs"  type="text" name="numeroexterior" placeholder="Numero exterior" /><br><br>
                <label class="letrass"> Numero Interior:</label>
                <input class="inputs"  type="text" name="numerointerior"  placeholder="Numero interior"/><br><br>
                <label class="letrass">Pais</label><br>
                <input class="inputs" type="text" name="pais"  placeholder="Pais"/> <br> <br>
                <input type="submit" id="envioform" value="Agregar direccion" /> <br> <br>
                <button id="envioform">   <a style="color:white; text-decoration: none;" href="/Administracion/admin/listaempleados">Cancelar</a></button>
                </div>
            </form>
        </div>
      
    </body>
</html>
