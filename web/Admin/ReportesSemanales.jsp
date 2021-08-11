<%-- 
    Document   : ReportesSemanales
    Created on : 31 jul. 2021, 11:15:53
    Author     : PC
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1> Lista de reporte de semanales </h1>
            <h2 style="text-align: center; color: white;">${mensaje}</h2>
        </header>
        
        <div align="center">
            <c:if test="${diadeSemana == 6}">
            <a class="botones" href="/Administracion/admin/ActualizarRegistros"> Actualizar Reportes Manualmente </a> 
            </c:if>
        </div>
        
        
        
        <div id="menureportesemanal">
            <div id="busquedaempleado">
                <form method="GET" action="/Administracion/admin/BuscarReporte">
                    <input class="textinput" type="text" name="idEmpleado"   placeholder="Escriba el IdEmpleado"/>
                    <input class="inputtype" type="submit" name="busquedaempleado" value="Buscar" />
                </form>
            </div>
            <div id="busquedafecha">
                <form method="GET" action="/Administracion/admin/Buscar">
                    <b>SEMANA:</b>
                    <input class="textinput" type="Date" name="Fecha"   placeholder="Inicio de busqueda"/>
                    <input  class="inputtype" type="submit" name="busquedaempleado" value="Buscar" />
       
                </form>
                
            </div>
        </div>
        
        <div>
            <div id="TablaReportes">
                <table>
                    <thead>
                        <tr>
                            <td>
                                    Inicio Semana:
                            </td>
                            <td>
                                Fin Semana
                            </td>
                            <td>
                                Id Empleado: 
                                
                            </td>
                            <td>
                                
                                Nombre
                            </td>
                            <td>
                                Apellido Paterno: 
                            </td>
                               <td>
                                Horas trabajadas:
                            </td>
                            <td>
                                Pago de la Hora:
                            </td>
                         
                
                            <td>
                                
                                Total Pago:
                            </td>
                            <td>
                                Acciones:
                            </td>
                        </tr> 
                    </thead>
                    <tbody>
                        <c:forEach items="${reportesemanales}" var="reportesemana">
                        <tr>
                            
                            <td> 
                              <fmt:parseDate value="${reportesemana[1]}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                              <fmt:formatDate type="both" pattern="yyyy-MM-dd" value="${ parsedDateTime }" />
                            
                            </td>
                            <td>
                                   <fmt:parseDate value="${reportesemana[0]}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                                   <fmt:formatDate type="both" pattern="yyyy-MM-dd" value="${ parsedDateTime }" />
    
                     
                            </td>
                            <td> ${reportesemana[2]} </td>
                            <td> ${reportesemana[3]} 
                            </td>
                            <td>  ${reportesemana[4]}</td>
                            <td>  ${reportesemana[5]} </td>
                            <td> $ ${reportesemana[6]} MXN </td>
                            <td> $ ${reportesemana[7]} MXN </td>    
                            <td>
  
                                <a href="/Administracion/admin/EditReporteSemanal?idEmpleado=${reportesemana[2]}&InicioSemana=${reportesemana[1]}&Finsemana=${reportesemana[0]}">Editar</a>
                            </td>
                        </tr>
                        
                    </c:forEach>
                        
   
                    </tbody>
                  
                </table>
                
                
            </div>
            
            
        </div>
        
        
        
        
    </body>
</html>
