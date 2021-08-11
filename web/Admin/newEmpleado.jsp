<%-- 
    Document   : newEmpleado
    Created on : 21 jul. 2021, 19:18:11
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
         <script src="${pageContext.request.contextPath}/JS/UserVerification.js"></script>   
        <title>Hotel Xic Xanac</title>
    </head>
    <body>
        
        <jsp:include page="HeaderAdmin.jsp" />
        

        <header>
            <h1>
            Añadir Empleado              
            </h1>
            
        </header>
        
        <div id="formempleados">
            <form method="POST" action="/Administracion/admin/detailEmpleado" name="form">
                 <label class="letrass">Apellido Paterno:</label><br>
                <input class="inputs" type="text" name="apellidoPaterno" value="${Administrador.apellidoPat}" />
                <br>
                <br>
                <label class="letrass">Apellido Materno:</label>  <br>
                <input class="inputs" type="text" name="apellidoMaterno" value="${Administrador.apellidoMat}" />
                <br>
                <br>
                <label class="letrass">Nombre </label>  <br>
                <input class="inputs" type="text" name="Nombre"  value="${Administrador.nombre}"/>
                 <br>
                <br>
                <label class="letrass">Telefono:</label>  <br>
                <input  class="inputs" type="text" name="TelefonoEmpleado"  value="${Administrador.telefono}"/>
                   <br>
                <br>
                 <br>
                <br>
                <label class="letrass">Correo:</label>  <br>
                <input  class="inputs" type="email" name="CorreoEmpleado"  value="${Administrador.CorreoEmpleado}"/>
                   <br>
                <br>
                <label class="letrass"> Status Empleado: </label><br>
                <select class="inputs" name="statusempleado">
                    <option>
                        ACTIVE
                    </option>
                    <option>
                        INACTIVE
                    </option>
                    <option>
                        SUSPENDED
                    </option>            
                </select>
                <br>
                <br>
                <label class="letrass">Cargo:</label> <br>
                <select class="inputs" name="idCargo">
                    <c:forEach items="${listacargos}" var="cargos">
                        <option value="${cargos.idCargo}">
                            ${cargos.cargo} ${cargos.area}
                        </option>
                    </c:forEach>
                </select>
                   <br>
                <br>
                <label class="letrass">Administrador:</label> <br>
                <select class="inputs" name="idAdministrador">
                    <c:forEach items="${listaAdministradores}" var="administradores">
                        <option   value="${administradores.idAdministrador}">
                            ${administradores.nombre} ${administradores.apellidoPat}
                        </option>
                    </c:forEach>
                </select>
                <br>
                <br>
                <input id="envioform" type="submit" name="enviodatos" value="Agregar datos personales"  />
                <br>
                <br>
               <button id="envioform"> <a href="/Administracion/admin/listaempleados">Cancelar</a></button>

            </form> 
            
            
  
            
        </div>
        
        
        
        
        
        
        
        
        
        
    </body>
</html>
