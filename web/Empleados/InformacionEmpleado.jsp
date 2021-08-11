<%-- 
    Document   : InformacionEmpleado
    Created on : 4 ago. 2021, 9:34:06
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.entity.pojos.Empleados" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Informacion.css" />
        <title>Hotel Xic Xanac</title>
    </head>
    <body>
        <jsp:include page="HeaderEmpleado.jsp" />
        <header>
            <h1>
                Tu informacion personal
            </h1>
            <h2>
                ${mensaje}
            </h2>
            
        </header>
            
                <%
                    Empleados empleado =(Empleados) request.getAttribute("EmpleadoInformacion");    
                
                %>
            
            <div class="imagenes">
                     <img src="${pageContext.request.contextPath}/imagenes/personal.png" alt="AdminLogo" width="105px" height="105px"  />
            </div>
   
        <div id="AdministradorInfo">
            <div>
                <b> Nombre: </b>
                ${EmpleadoInformacion.nombre}
            </div>
            <div>
                <b> Apellido Paterno: </b>
                ${EmpleadoInformacion.apellidoPat}
                
            </div>
            <div>
                <b>Apellido Materno: </b>
                ${EmpleadoInformacion.apellidoMat}
            </div>
            <div>
                <b>Status empleado:</b>
   
                ${EmpleadoInformacion.statusempleados}
            </div>
            <div>
                <b>Telefono:</b>     
                ${EmpleadoInformacion.telefono}
            </div>
            <div>
                <b>Correo:</b>     
                <%=  empleado.getCorreoEmpleado() %>
            </div>
        </div>
            <div id="editarempleado">
            <div>
                <a href="/Administracion/EditInformacion" class="botones">Editar Mi Informacion</a> 
            </div>
          <div>
              <a href="/Administracion/Direccion" class="botones">Consultar Tu Direccion</a>        
        </div>
           
        </div>
        
        
        
    </body>
</html>
