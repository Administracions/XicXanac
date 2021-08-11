<%-- 
    Document   : ReporteSemanal
    Created on : 3 ago. 2021, 19:15:09
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/InformacionStyle.css" />
        <title>Hotel Xic Xanac</title>
    </head>
    <body>
        <jsp:include page="HeaderEmpleado.jsp" />
        
        <header>
            <h1>Tus Reportes Semanales</h1>
        </header>
        <div id="tablaAdmin" align="center">
            <table>
                <thead>
                    <tr>
                        <td>
                        Inicio Semana: 
                        </td>
                        <td>
                            Fin Semana:
                        </td>
                        <td>
                            Pago de la hora:
                        </td>
                        <td>
                            Horas Trabajadas:
                        </td>
                        <td> Pago Semana: </td>
                        
                    </tr>
                    
                    
                    
                </thead>
                <tbody>
                    <c:forEach items="${listareportesemanales}" var="listasemanal">
                    
                    <tr>
                        <td>
                            
                            <fmt:parseDate var="fechainicio" pattern="yyyy-MM-dd'T'HH:mm" value="${listasemanal[0]}" />
                            <fmt:formatDate type="both"  pattern="yyyy-MM-dd" value="${fechainicio}" />
                   
                        
                        </td>
                        <td>
                         <fmt:parseDate var="fechainicio" pattern="yyyy-MM-dd'T'HH:mm" value="${listasemanal[1]}" />
                            <fmt:formatDate type="both"  pattern="yyyy-MM-dd" value="${fechainicio}" />
                            
                        </td> 
                        <td>
                         $  ${listasemanal[2]} MXN
                        </td>
                        <td>
                            ${listasemanal[3]} 
                        </td>
                        <td>
                         $   ${listasemanal[4]} MXN 
                            
                        </td>
                    </tr>
                    
                    </c:forEach>      
                    
                </tbody>
                
                
                
                
            </table>
            
            
            
            
            
        </div>
        
        
        
        
        
        
    </body>
</html>
