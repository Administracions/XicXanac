<%-- 
    Document   : Cargos
    Created on : 8 jul. 2021, 11:48:09
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel Xic Xanac</title>
        <style>
            body{

    background:url(../imagenes/xic.jpg);
  background-repeat: no-repeat; 
    background-attachment: fixed;
    background-position: center center;
    background-size: cover;
        -moz-background-size: cover;
        -webkit-background-size: cover;
        -o-background-size: cover;
}
.letras{
    color:white;
    font-family: "Helvetica", "Times New Roman", "Arial";
    font-size: 32px;
    font-style: italic;
    text-decoration: none;
}
 #tablaempleados{
    padding-top: 35px;
   
}

header h1{
    text-align: center;
}
#tablaempleados table{
 
    background-color: purple;
    border-color: red;
    border-collapse: separate;
    
    
}
#tablaempleados table td{  
      background-color: violet;
    border-color: red;
    border-collapse: separate;
    border-style: solid;
    color: black;
    text-align: center;
    font-size: 22px;
    font-family: "Helvetica", "Times New Roman";
    font-style: italic;   
    
}
#addcargo{

  text-align: center;
}
#addcargo a{
    width: 100px;
    height: 50px;
    border-radius: 60px;
     background-color: green;
    text-align: center;
    color: white;
    text-decoration: none;
    font-size: 31px;
     padding-right: 5px;
             padding: 15px;
    
}

.botones{
    
     width: 50px;
    height: 25px;
    border-radius: 60px;
    background-color:#21a9fa;
    text-align: center;
    color: white;
    text-decoration: none;
    font-size: 21px;
    padding: 3px;
   
    
}
#mensajes{
    text-align: center;
   color: white; font-size: 22px; font-style:italic; font-family: "Helvetica", "Times New Roman"; 
}
        </style>
    </head>
    <body>
        <jsp:include page="HeaderAdmin.jsp" />
        <header>
            <h1 class="letras"> Lista de cargos </h1>
        </header>
        <div id="addcargo">
            
            <a href="/Administracion/Admin/newCargo.jsp" > Añadir Cargo </a>
         
        </div>
        <div>
            <c:if test="${mensaje != null}">
                <h2 id="mensajes">${mensaje}</h2>   
   
            </c:if>
            
        </div>
        
        
        <div id="tablaempleados">
        <div  align="center">
            <table>
                <thead>
                    <tr>
                        <td>             
                         ID Cargo:   
                        </td>    
                        <td>      
                            Cargo:
                        </td>
                        <td>   
                            Area:
                        </td>
                        <td>
                            Acciones:
                            
                        </td>
                    </tr> 
                    
                    
                </thead>
                <tbody>
                    <c:forEach items="${listacargos}" var="cargos">
                        <tr>
                            <td>
                              ${cargos.idCargo}   
                            </td>
                            <td>
                                ${cargos.cargo}
                                
                            </td>
                            <td>
                                ${cargos.area}
                            </td>
                            <td>
                                <a  class="botones" href="/Administracion/admin/EditCargo?idCargo=${cargos.idCargo}">
                                    Editar
                                    
                                </a >
                                
                                <a class="botones" onclick="DeleteCargo(${cargos.idCargo})"> Eliminar </a>
                                
                                
                            </td>
                            
                        </tr>
                    </c:forEach>
                </tbody>
               
            </table>      
        </div>
        </div>
        
        
        <script>
            
            function DeleteCargo(idCargo){
                if(confirm("Estas Seguro de borrar el Cargo con ID?" + idCargo)){
                    
                    window.location = "/Administracion/admin/DeleteCargo?idCargo=" + idCargo;
                    
                }
                
                
            }
            
            
        </script>
        
    </body>
</html>
