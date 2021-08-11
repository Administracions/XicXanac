<%-- 
    Document   : EditarDireccion
    Created on : 4 ago. 2021, 19:42:05
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.administracion.enums.Estados" %>
<%@page import="com.entity.pojos.Direccion" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/formStyle.css" />
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js" ></script>
         <script src="${pageContext.request.contextPath}/JS/DireccionVerfication.js"></script>
         
        <title>Hotel Xic Xanac</title>
        <style>
            label.error{
    font-size: 18px;
    color:red;
    display: inline-block;
    font-family: "Times New Roman";
   
}
        </style>
    </head>
    <body>
        <jsp:include page="HeaderEmpleado.jsp" />
        <header>
            <h1 class="letrass"> Editar Direccion </h1>
            
        </header>
        <div id="formEmpleado">
              <%
            Direccion direccion = (Direccion) request.getAttribute("direccionempleado");
            Estados[] estados  = (Estados[])  request.getAttribute("Estados");

            %>
            
            <form method="POST" action="/Administracion/EditedDireccion" name="editdireccion">
                <div>
                    <input type="hidden" name="idEmpleado" value="<%= direccion.getEmpleadoDir().getIdEmpleado() %>" />
                <label class="letrass">Calle Principal:</label>    
                <input class="inputs" type="text" name="Calleprincipal" value="<%= direccion.getCallePrincipal() %>" />
                </div>
                <div>
                    <label class="letrass">Colonia:</label>
                    <input class="inputs" type="text" name="Colonia" value="<%= direccion.getColonia() %>" />
                              
                </div>
                   <div>
                       <label class="letrass"> Numero Exterior:</label>
                       <input class="inputs" type="text" name="NumeroExterior" value="<%= direccion.getNumeroExterior() %>" />
                       
                   </div>
                     <div>
                     <label class="letrass"> Numero Interior: </label>
                     <input class="inputs" type="text" name="NumeroInterior" value="<%= direccion.getNumeroInterior() %>" />
                     </div>
                     <div>
                         <label class="letrass"> Codigo Postal: </label>
                          <input class="inputs" type="text" name="CodigoPostal" value="<%= direccion.getCodigoPostal() %>" />
                         
                     </div>
                                <div>
                                    <label class="letrass">Estado:</label>
                        <select class="inputs" name="estado">
                            <%
                            for(Estados estado: estados){            
                             if(estado.toString().equals(direccion.getEstado())){
                          %>      
                               
                          <option value="<%=estado%>" selected><%= estado %></option>
                         
                           <%}else if(estado.toString() != direccion.getEstado()){%>
                                
                           <option value="<%=estado%>"><%= estado %></option> 
                           
                            <%    
                                }
                            }   
                            %>
                            
                  
                        </select>

                    </div>
                            <div id="botonesmenu">
                                <div>
                                    <input type="submit" name="editar direccion" id="envioform" value="Editar Direccion">  
                                </div>
                                <div>
                                    <button onclick="javascript:history(-1)" id="envioform"> Cancelar </button> 
                                </div>
                            </div>
                
            </form>
            
            
            
            
        </div>
        
        
        
        
    </body>
</html>
