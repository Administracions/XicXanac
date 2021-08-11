<%-- 
    Document   : HomeEmpleado
    Created on : 28 jul. 2021, 10:55:29
    Author     : PC
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/HomeEmpleado.css" />
        <title>Hotel Xic Xanac</title>
    </head>
    <body>
        <jsp:include page="HeaderEmpleado.jsp" />
        <header>
            <h1>Bienvenido</h1>
        </header>
        <div>
            <div id="menuhomeempleados">
                <h2 id="titulo"> Tu reporte de hoy </h2>  
                <div>
                    
                    Fecha de hoy: ${FechaActual}
                    
                 
                   
                    
                </div>
                <div>
                    Tu horario de Entrada Hoy:
                    <c:if test="${reporteempleado.horaEntrada != null}">
                   
                       <fmt:parseDate var="fechainicio" pattern="yyyy-MM-dd'T'HH:mm:ss" value="${reporteempleado.horaEntrada}" />
                       <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${fechainicio}" />
                    
                       
                    </c:if>
                    
                    <c:if test="${reporteempleado.horaEntrada == null}">
                        
                        Aun no registras tu horario de Entrada
                        
                    </c:if>
                    
                    
                </div>
                <div>
                    Horario de salida:
                    <c:if test="${reporteempleado.horaEntrada != null && reporteempleado.horaSalida == null}">
                    
                    Aun no registras tu horario de Salida
                    
                    </c:if>  
              <fmt:parseDate var="horasalida" pattern="yyyy-MM-dd'T'HH:mm:ss" value="${reporteempleado.horaSalida}" />
                            <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${horasalida}" />
                    
                </div>
                
                
            </div>
            
            
        </div>
        
        
        
               
        
        <h1></h1>
    </body>
</html>
