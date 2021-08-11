<%-- 
    Document   : Index
    Created on : 6 jul. 2021, 14:14:50
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/AdminHome.css" />
        <title>Hotel Xic Xanac</title>
 
    </head>
    <body>
        
        <jsp:include page="HeaderAdmin.jsp" />
        
  
        <header>
            <h1 class="letras"> Bienvenido al panel Administrativo</h1>
        </header>
        
        <div id="tablaempleados">
            <h2 class="letras"> Lista de todos los empleados</h2> 
            <div align="center">
            <table>
                <thead>
                    <tr>
                        <td>
                            IdEmpleado
                        </td>
                        <td>
                            Apellido Paterno
                        </td>
                        <td>
                            Apellido Materno
                        </td>
                        <td>
                            Nombre         
                        </td>
                        <td>
                            Telefono
                        </td>
                        <td>
                            Estatus Empleado 
                        </td> 
                    </tr>
                </thead>
                <tbody>
                       <c:forEach var="empleados" items="${listaempleados}"  >
                    <tr>
                        
                       
                            <td>
                         ${empleados.idEmpleado}       
                            </td>  
                            <td>
                                ${empleados.apellidoPat}
                                
                            </td>
                            <td>
                                ${empleados.apellidoMat}
                                
                            </td>
                            <td>
                                ${empleados.nombre}         
                            </td>
                            <td>
                                
                                ${empleados.telefono}
                            </td>
                            <td>
                                ${empleados.statusempleados}   
                            </td>

                     
                    </tr>
                       </c:forEach>
                    
         
                </tbody>
                
                    
                
            </table>
            </div>
            
          
            
        </div>
        
        
  
    </body>
    
    
    
</html>
