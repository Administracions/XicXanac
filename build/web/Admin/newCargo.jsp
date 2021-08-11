<%-- 
    Document   : newCargo
    Created on : 8 jul. 2021, 14:01:55
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/formStyle.css" />
        <title>Hotel Xic Xanac</title>
    </head>
    <body>
        
        <jsp:include page="HeaderAdmin.jsp" />
        
        <header> 
            <h1 id="cargonuevo"> Añadir Cargo </h1>
        </header>
        <div id="formulariocargo" align="center" action="">
            <form method="POST" action="/Administracion/admin/newCargo" >
                <fieldset>
                <label class="letras"> Nombre Cargo: </label><br>
                <input type="text" name="NombreCargo" class="inputs"/><br>
                <br>
                <br>
                <label class="letras"> Area Cargo: </label>  <br>       
                <input type="text" name="AreaCargo"  class="inputs"/> <br> <br>
                <input  id="envioform" type="submit" name="cargoformulario" value="Agregar Cargo"/>
               </fieldset>
         
            </form>     
        </div>
        
      
    </body>
</html>
