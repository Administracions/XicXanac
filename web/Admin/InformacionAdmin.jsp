<%-- 
    Document   : InformacionAdmin
    Created on : 20 jul. 2021, 11:08:43
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel Xic Xanac</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Informacion.css" />
        
    </head>
    <body>
        <jsp:include page="HeaderAdmin.jsp" />
       
        <header>
            <h1>
                Tu Informacion 
            </h1>
            <c:if test="${mensaje != null}">
                <h2>
                    <b>${mensaje}</b>
                </h2>
                
                
            </c:if>
            
        </header>
        <div id="AdministradorInfo">
            <div>
                <b>Nombre:</b> <br>
                ${Administrador.nombre}
               
            </div>
            <div>
                <b>Apellido Paterno: </b> <br>
                
               ${Administrador.apellidoPat} 
                
            </div>
            <div>
                <b>Apellido Materno:</b> <br>
                ${Administrador.apellidoMat}
                
            </div>
                    <div>
                    <b>Direccion:</b> <br>
                    ${Administrador.direccion}
                </div>
                <div>
                    <b>Correo:</b> <br>
                   ${Administrador.correo}                   
                </div>
                <div>
                    <b>Telefono:</b> <br>
                   ${Administrador.telefono}                   
                </div>
                    <div>
                        <b>Status:</b> <br>
                   ${Administrador.statusempleados}                   
                </div>
        </div>
                <div id="botonesmenu">
                    <div>
                        <a class="botones" href="/Administracion/admin/Information"> Editar mi Informacion </a>   
                    </div>
                    <div>
                        <a class="botones" href="/Administracion/admin/editlogin"> Editar mi Username o Contraseña </a>
                    </div>
                </div>
                    
     
        
    </body>
</html>
