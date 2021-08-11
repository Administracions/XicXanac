<%-- 
    Document   : Empleados
    Created on : 21 jul. 2021, 12:17:10
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/InformacionStyle.css" />
        <title>Hotel Xic Xanac</title>
    </head>
    <body>
        <jsp:include page="HeaderAdmin.jsp"/>
        <header> 
            <h1>
                Tus Empleados 
            </h1>
            
            <c:if test="${mensaje != null}">
          
                <h2 style="color: red;">${mensaje}</h2>           
            </c:if>
        </header>
        
        <div id="addcargo">
            <a href="/Administracion/admin/addEmpleado">
                Añadir Empleado
            </a>
        </div>
        
 
        <div id="TablaEmpleados">
            <table>
                <thead>
                    <tr>
                        <td>
                            Id Empleado:
                            
                        </td>
                        <td>
                           Nombre:
                            
                        </td>
                        <td>
                            Apellido Paterno:
                            
                        </td>
                        <td>
                            
                            Apellido Materno: 
                            
                        </td>
                        <td>
                            
                            Telefono: 
                            
                        </td>
                        <td>
                            Status Empleados:
                        </td>
                        <td>
                            Area:
                            
                        </td>
                        <td>
                            Cargo:
                        </td> 
                        <td>
                            Acciones:
                            
                        </td>
                    </tr> 
                    
                </thead>
                <tbody> 
                    <c:forEach items="${listaempleados}" var="listaempleado">
                 
                    
                    <tr>
                        <td>
                            ${listaempleado[0]}
                        </td>  
                        <td>
                            ${listaempleado[1]}
                            
                        </td>
                        <td>
                            ${listaempleado[2]}
                        </td>
                        <td>
                            ${listaempleado[3]}
                        </td>
                        <td>
                            ${listaempleado[4]}
                        </td>
                        <td>
                            ${listaempleado[5]}
                        </td>
                          <td>
                            ${listaempleado[6]}
                        </td>
                        <td>
                            ${listaempleado[7]}
                        </td>
                        <td>
                            <a class="botones" href="/Administracion/admin/editempleados?idempleado=${listaempleado[0]}" >
                                Editar
                            </a>
                            <a class="botones" onclick="DeleteEmpleado(${listaempleado[0]})">
                                Eliminar
                                
                            </a>
                            
                            
                        </td>
                    </tr>      
                </c:forEach> 
 
                </tbody>
                
            </table>
      
        </div>
        <script>
            function DeleteEmpleado(idAdmin){
                if(confirm("¿Estas seguro de borrar el usuario " + idAdmin + "?")){
                window.location = "/Administracion/admin/Deleteempleado?idempleado=" + idAdmin;
            }
            }
               
        </script>
        
    </body>
</html>
