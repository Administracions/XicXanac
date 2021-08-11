<%-- 
    Document   : newAdmin
    Created on : 13 jul. 2021, 13:53:27
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="HomeAdmin.jsp"></a>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/formStyle.css" />
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js" ></script>
         <script src="${pageContext.request.contextPath}/JS/UserVerification.js"></script>   
      <title>Hotel Xic Xanac</title>
        <style>
            #formularioadmin{
    
    text-align: center;
    padding-top: 25px;
    
}
           .letrass{
    color:white;
    font-family: "Helvetica", "Times New Roman", "Arial";
    font-size: 28px;
    font-style: italic;
    text-decoration: none;
}
textarea{
    height: 75px;
    width: 350px;
   font-family:  "Times New Roman", "Arial", "Helvetica"; 
   font-size: 16px;
}
label.error{
    font-size: 15px;
    color:red;
    display: block;
    font-family: "Times New Roman";
   
}
            
        </style>
    </head>
    <body>
        <jsp:include page="HeaderAdmin.jsp" />
        
        <header>
            <c:if test="${Administrador != null}">
           
                 <h1 class="letrass">
                Editar Administrador
            </h1>
             </c:if>
                 <c:if test="${Administrador == null}">
             <h1 class="letrass">
                Nuevo Administrador
            </h1>
             </c:if>
        </header>
      
        <div id="formularioadmin">
            
            
            
            <c:if test="${Administrador == null}">
            <form id="formadmin" name="form" method="POST" action="/Administracion/admin/CreateAdmin" >
                 </c:if >
                <c:if test="${Administrador != null}">
            <form id="formadmin" name="form" method="POST" action="/Administracion/admin/EditedAdmin" >         
             <input class="inputs" type="hidden" name="idAdmin" value="${Administrador.idAdministrador}" />        
               </c:if>
                <label class="letrass">Apellido Paterno:</label><br>
                <input class="inputs" type="text" name="apellidoPaterno" value="${Administrador.apellidoPat}" />
                <br>
                <br>
                <label class="letrass">Apellido Materno:</label>  <br>
                <input class="inputs" type="text" name="apellidoMaterno" value="${Administrador.apellidoMat}" />
                <br>
                <br>
                <label class="letrass">Nombre </label>  <br>
                <input class="inputs" type="text" name="Nombre"  value="${Administrador.nombre}"/>
                 <br>
                <br>
                <label class="letrass ">Correo Electronico:</label>  <br>
                <input class="inputs" type="email" name="CorreoAdmin" value="${Administrador.correo}" />
                 <br>
                <br>
                <label class="letrass">Telefono:</label>  <br>
                <input  class="inputs" type="text" name="TelefonoAdmin"  value="${Administrador.telefono}"/>
                   <br>
                <br>
                <label class="letrass">Direccion Administrador:</label>  <br>
                <textarea maxlength="200" cols="100" name="direccionAdmin">${Administrador.direccion}</textarea>
                  <br>
                <br>
                <label class="letrass">STATUS ADMINISTRADOR</label><br>
                <select class="inputs" name="StatusAdmin">
               
                        <c:forEach items="${statusAdministradores}" var="status">    
                            <c:if test="${status eq Administrador.statusempleados}">    
                      <option value="${status}" selected >${status}
                            </c:if>
                      <c:if  test="${status ne Administrador.statusempleados}">
                              <option value="${status}" >${status}
                      </c:if>
                        </option>
                        </c:forEach>   
                   
                </select>
                   <br>
                <br>
                <input  id="envioform" type="submit" name="enviodatos" value="Añadir Administrador"/>
                <br>
                <br>
                <button id="envioform" onclick="javascript:history(-1)"> <a href="/Administracion/admin/AdminHome">Cancelar</a></button>
                                
            </form>      
            
        </div>
           
    </body>
</html>
