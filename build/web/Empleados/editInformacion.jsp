<%-- 
    Document   : EditInformacion
    Created on : 4 ago. 2021, 11:16:44
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.entity.pojos.Empleados" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/formStyle.css" />
        <title>Hotel Xic Xanac</title>
    </head>
    <body>
        <jsp:include page="HeaderEmpleado.jsp" />
        <header>
            <h1 class="letrass"> Editar tu informacion:</h1>
        </header>
        <%
          Empleados empleado =(Empleados) request.getAttribute("Empleadoinfo");  
        %>
        
        <div id="formEmpleado">
            <form method="POST" action="/Administracion/EditedEmpleado">
                <input type="hidden" name="idEmpleado" value="${Empleadoinfo.idEmpleado}"/>
                <div>
                    <label class="letrass"> Nombre: </label>                
                <input class="inputs" type="text" name="Nombre" value="${Empleadoinfo.nombre}" />
                </div>
                <div>
                    <label class="letrass"> Apellido Paterno: </label>
                <input class="inputs" type="text" name="apellidoPaterno" value="${Empleadoinfo.apellidoPat}" />  
                </div>
                <div>
                    <label class="letrass"> Apellido Materno</label>
                <input class="inputs" type="text" name="apellidoMaterno" value="${Empleadoinfo.apellidoMat}" />
                </div>
              
                <div>
                    <label class="letrass"> Telefono</label>
                <input class="inputs" type="text" name="TelefonoEmpleado" value="${Empleadoinfo.telefono}" />   
                </div>
                 <div>
                    <label class="letrass"> Correo:</label>
                    <input class="inputs" type="email" name="CorreoEmpleado" value="<%= empleado.getCorreoEmpleado() %>" required="" />   
                </div>
                <div>
                      <div id="menubotones">
                <input id="envioform" type="submit" value="Editar mi informacion" />
                   <button id="envioform" onclick="javascript:history(-1)">Cancelar</button>
                </div>
                </div>
            </form>
           
        </div>
        
    </body>
</html>
