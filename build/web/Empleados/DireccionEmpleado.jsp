<%-- 
    Document   : DireccionEmpleado
    Created on : 4 ago. 2021, 13:55:55
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.entity.pojos.Direccion" %>
<%@page import="com.administracion.enums.Estados" %>
<%@page  import="jakarta.servlet.http.HttpServletRequest" %>
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
            <h1 class="letrass">
                Tu Direccion
            </h1>
            <h2>
                ${mensaje}
            </h2>
            
        </header>
        <div id="AdministradorInfo">
            <%
            Direccion direccion = (Direccion) request.getAttribute("direccionempleado");
    

            %>
            
            
            <div>
                <b>
                    Calle Principal:
                </b>
                <%= direccion.getCallePrincipal() %>
            </div>
            <div>
                <b>Colonia: </b>
                <%= direccion.getColonia() %>
            </div>
            <div>
                <b>Numero Exterior:</b>
              
                <%= direccion.getNumeroExterior()  %>
            </div>
                <div>
                    <b> Numerior Interior:</b>
                    
                    <%= direccion.getNumeroInterior() %>
                </div>
                    <div>
                        <b>Codigo Postal:</b>
                     <%= direccion.getCodigoPostal() %>
                    </div>
                    <div>
                        <b>Estado:</b>
                       <%= direccion.getEstado() %>

                    </div>
            
            
        </div>
        <div id="editarempleado">
            <div>
                
                <a href="/Administracion/EditDireccion?idempleado=<%=direccion.getEmpleadoDir().getIdEmpleado()%>" class="botones"> Editar mi direccion </a>
            </div>
               <div>
                
                   <a class="botones" href="/Administracion/Home"> Cancelar</a>
            </div>
            
        </div>
        
        
        
        
    </body>
</html>
