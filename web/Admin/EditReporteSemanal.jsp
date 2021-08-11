<%-- 
    Document   : EditReporteSemanal
    Created on : 2 ago. 2021, 15:10:28
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/formStyle.css" />
        <title>Hotel Xic Xanac</title>
    </head>
    <body>
    <jsp:include page="HeaderAdmin.jsp" />
    <header>
        <h1 class="letrass">
            Cambiar el sueldo
        </h1>
    </header>
    <div align="center">
        <form method="POST" action="/Administracion/admin/EditedReporte">
            <input type="hidden" name="Idempleado" value="${reporteempleado.empleados.idEmpleado}"/>
              <input type="hidden" name="iniciosemana" value="${iniciosemana}"/>
                <input type="hidden" name="finsemana" value="${Finsemana}"/>
            <label>Sueldo del empleado</label>
            <input class="inputs" type="text" name="SueldoReporte" value="${pagounitario}"/> <br>
            <input id="envioform" type="submit" value="Editar Sueldo"/>
            <button id="envioform" style="margin: 10px;"  onclick="javascript:history(-1)"><a>Cancelar</a></button>
        </form>
    </div>
    
    </body>
</html>
