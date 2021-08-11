<%-- 
    Document   : Reportesemanal
    Created on : 31 jul. 2021, 18:31:08
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/ReportesSemanal.css" />
        <title>Hotel Xic Xanac</title>
    </head>
    <body>
        <jsp:include page="HeaderAdmin.jsp" />
        <header>
            <h1> Reportes del empleado ${empleado.nombre}  </h1>
            <h2><b>${mensaje}</b></h2>
        </header>
        
        <div id="TablaReportes">
            <table>
                <thead>
                    <tr>
                        <td>
                            Inicio de Semana
                        </td>
                        <td>
                            Fin de Semana 
                            
                        </td>
                        <td>
                            Pago de la Hora:
                        </td>
                        <td> Horas Trabajadas:</td>
                        <td>
                           Pago Total: 
                        </td>
                    </tr>
             
                </thead>
                <tbody>
                    
                    <c:forEach items="${reportesbusqueda}" var="listareporte">
                        <tr>
                            <td>
                                 <fmt:parseDate value=" ${listareporte[1]}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                              <fmt:formatDate type="both" pattern="yyyy-MM-dd" value="${ parsedDateTime }" />
                        
                         
                            
                            </td> 
                            <td>
                                  <fmt:parseDate value=" ${listareporte[0]}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                              <fmt:formatDate type="both" pattern="yyyy-MM-dd" value="${ parsedDateTime }" />
                            </td>
                            <td>  $ ${listareporte[2]} MXN  </td> 
                            <td> ${listareporte[3]}  </td>
                            <td> $ ${listareporte[4]} MXN</td>
                            
                 
                            
                        </tr>
                        
                        
                    </c:forEach>     
                </tbody>
                
                
                
            </table> 
            
            
            
            
            
        </div>
        
        
        
        
        
        
        
        
        
        
        
        
        
    </body>
</html>
