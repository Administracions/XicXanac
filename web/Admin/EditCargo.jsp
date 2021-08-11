<%-- 
    Document   : EditCargo
    Created on : 12 jul. 2021, 14:26:52
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.entity.pojos.Cargo" %>
<%@page import="jakarta.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/formStyle.css"/>
        <title>Hotel Xic Xanac</title>
    </head>
    <body>
           <jsp:include page="HeaderAdmin.jsp" />
        
        <header> 
            <h1 id="cargonuevo"> Editar Cargo </h1>
        </header>
        <%! 
        private Cargo cargo;
        %>   
        
        <% 
        cargo = (Cargo)request.getAttribute("CargoEdit");  
        if(cargo != null){
        %>
          
           
        <div id="formulariocargo" align="center" action="">
            <form method="POST" action="/Administracion/admin/CargoEdited" >
                <fieldset>
                     <label class="letras" > Id Cargo: </label><br>
                     <input type="text" name="IdCargo" class="inputs" value="<%= cargo.getIdCargo()%>" readonly/><br>
                <br>
                <br>
                    
                    <label class="letras" > Nombre Cargo: </label><br>
                <input type="text" name="NombreCargo" class="inputs" value="<%= cargo.getCargo()%>"/><br>
                <br>
                <br>
                <label class="letras"> Area Cargo: </label>  <br>       
                <input type="text" name="AreaCargo"  class="inputs" value="<%=cargo.getArea()%>"/> <br> <br>
                <input  id="envioform" type="submit" name="cargoformulario" value="Editar Cargo"/>
                <br>
                <button id="envioform" value="Cancelar" onclick="javascript:history(-1)" > Cancelar</button>
                </fieldset>
            </form>     
        </div>
        
        
        <% }%>
        
    </body>
</html>
