<%-- 
    Document   : EditEmpleado
    Created on : 23 jul. 2021, 11:27:41
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.administracion.enums.Status" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/formStyle.css" />
        <title>Hotel Xic Xanac</title>
        <style>
            #editempleado div{
    margin:15px;
    paddin:15px;
    
}
        </style>
    </head>
    <body>
        <jsp:include page="HeaderAdmin.jsp" />
        <header>
            
            <h1>Editar Empleado</h1>
            
        </header>
        <div id="editempleado">
            <form method="POST" action="/Administracion/admin/Editempleado"> 
                <input type="hidden" name="idempleado" value="${empleado.idEmpleado}" />    
            <div align="center">
                <div>
                    <label class="letrass">Administrador:</label>
                    <select class="inputs" name="administrador">
                        <c:forEach items="${administradores}" var="administrador">
                            <c:if test="${empleado.idAdministracion.idAdministrador eq administrador.idAdministrador}">
                                
                                <option value="${administrador.idAdministrador}" selected>${administrador.nombre} ${administrador.apellidoPat}         
                            </c:if> 
         <c:if test="${empleado.idAdministracion.idAdministrador ne administrador.idAdministrador}">
                                
                                <option value="${administrador.idAdministrador}">${administrador.nombre} ${administrador.apellidoPat}         
                            </c:if> 
                                    </option>
                        </c:forEach>                   
                    </select> 
                    
                </div>
                <div>
                     <label class="letrass">Cargo:</label>
                    <select name="cargos" class="inputs">
                        <c:forEach items="${cargos}" var="cargo">
                            <c:if test="${empleado.cargo.idCargo eq cargo.idCargo}">
                                
                                <option value="${cargo.idCargo}" selected> 
                                    ${cargo.cargo} ${cargo.area}
                               
                            </c:if>
                                      <c:if test="${empleado.cargo.idCargo ne cargo.idCargo}">
                                
                                <option value="${cargo.idCargo}"> 
                                    ${cargo.cargo} ${cargo.area}
                               
                            </c:if>
                </option> 
                    </c:forEach>
                    </select>
                </div>
                <div>
        <label class="letrass">Statu empleados:</label>
                    <select class="inputs" name="statusempleado">
                        <c:forEach items="${Statusempleado}" var="status">    
                            <c:if test="${status eq empleado.statusempleados}">    
                      <option value="${status}" selected >${status}
                            </c:if>
                      <c:if  test="${status ne empleado.statusempleados}">
                              <option value="${status}" >${status}
                      </c:if>
                        </option>
                        </c:forEach>
                         
                    </select>     
                </div>
                <div>
                    <input id="envioform" type="submit" value="Editar empleado" />
                    <br>
                    <br>
                    <button id="envioform" onclick="javascript:history(-1)">
                          Cancelar
                    </button> 
                    
                </div>
                
            </div>
            
    </form>
            
        </div>
        
        
        
        
      
    </body>
</html>
