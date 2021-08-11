<%-- 
    Document   : AdminHome
    Created on : 13 jul. 2021, 11:44:32
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/InformacionStyle.css"/>
             <title>Hotel Xic Xanac</title>
        <style>
          .mensaje{
            color: white; font-size: 22px; font-style:italic; font-family: "Helvetica", "Times New Roman";
          }
        </style>
    </head>
    <body>
        <jsp:include page="HeaderAdmin.jsp" />
        
        <header>
            <h1 class="letras"> Lista de todos los administradores </h1>
            <c:if test="${mensaje != null}">
                         <h2 class="mensaje"> ${mensaje} </h2>   
            </c:if>
            <nav>
                <ul class="menus">
                    <a href="/Administracion/admin/edit_admin" style="margin:15px;"> Mi Informacion </a>
                    <a href="/Administracion/admin/newAdmin"> Agregar Administrador </a>
                
                </ul>
            </nav>    
        </header>
        <div id="tablaAdmin">
            <table>
                <thead>
                    <tr>
                        <td>
                         Id Administrador:    
                            
                        </td>
                        <td>
                            Apellido Paterno:     
                        </td>
                        <td>
                            Apellido Materno:
                        </td>
                        <td>
                            Nombre:
                        </td>
                        <td>
                            Telefono;
                            
                        </td>
                        <td>
                            
                         Correo: 
                            
                        </td>
                        <td>
                            Status Administrador:
                        </td>
                        <td>
                            Acciones
                            
                        </td>
                      
                        
                    </tr>
                    
                </thead>
                <tbody>
                <c:forEach items="${listaadministradores}" var="admin">
                    <tr>
                        <td>${admin.idAdministrador}</td> 
                        <td>
                           ${admin.apellidoPat}
                        </td>
                        <td>
                              ${admin.apellidoMat}           
                        </td>
                        <td>
                  ${admin.nombre}
                        </td>
                        <td>
                            
                      ${admin.telefono}      
                        </td>
                        <td>
                            ${admin.correo}
                        </td>
                        <td> ${admin.statusempleados}</td>   
                        <td>
                            <a class="botones" onclick="DeleteAdmin(${admin.idAdministrador})" >Eliminar</a>
                        </td>
                    </tr>   
                </c:forEach>
                            
                </tbody>
                
                
            </table>
            
            
            
        </div>
        <script>
            function DeleteAdmin(idAdmin){
                
                if(confirm("¿Esta Seguro de borrar el administrador con ID " + idAdmin + "?"))
                {
                    
                    window.location = "/Administracion/admin/deleteAdmin?idAdmin=" + idAdmin;
                    
                }
                
                
            }
               
        </script>
        
        
    </body>
</html>
