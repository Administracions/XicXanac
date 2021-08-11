<%-- 
    Document   : HorariosEmpledo
    Created on : 29 jul. 2021, 10:37:12
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/InformacionStyle.css"
        <title>Hotel Xic Xanac</title>
    </head>
    <body>
        <jsp:include page="HeaderAdmin.jsp" />
        
        
        <header>
            <h1>
                Bienvenido
                Lista de reportes de hoy
                
            </h1>
            
        </header>
        <div id="TablaEmpleados">
            <table>
                <thead>
                    <tr>
                        <td> Nombre: </td>
                        <td> Apellido Paterno: </td>
                        <td> Fecha Hoy:   </td>
                        <td>  Hora Entrada: </td>
                        <td> Hora Salida:  </td>
                        <td> Horas trabajadas de hoy:</td>          
                    </tr>
                    
                </thead>
                <tbody>
                    <c:forEach items="${reportesdehoy}" var="reportes">
                        <tr>
                            <td>
                               ${reportes[0]}
                            </td>    
                            <td>
                                ${reportes[1]}
                            </td>
                            <td>
                              ${reportes[2]}  
                            </td>
                            <td>
                                <fmt:parseDate value="${reportes[3]}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                                <fmt:formatDate type="both" timeStyle="medium" dateStyle="medium" value="${ parsedDateTime }" />
                     
                   
                            </td>
                            <td>
                                     <fmt:parseDate value="${reportes[4]}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                                     <fmt:formatDate type="both" timeStyle="medium" dateStyle="medium" value="${ parsedDateTime }" />
                            </td>
                            <td>
                                
                               <fmt:parseDate value="${reportes[5]}" pattern="HH:mm:ss.SSS" var="tiempotrabajado" type="both" />
                                     <fmt:formatDate type="both" pattern="HH:mm:ss" value="${ tiempotrabajado }" />  HRS
                                     
                                 
                            </td>
                          
                        </tr>
                    
                      
                </c:forEach>
                    
                    
                    
                </tbody>
                
                
            </table>
            
            
            
        </div>
        
        
        
        
        
        
    </body>
</html>
