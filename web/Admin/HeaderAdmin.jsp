

<div align="center">
   

<div>
    <img  src="${pageContext.request.contextPath}/imagenes/administrador.png" width="200px" height="200px;" />
    
</div>
    <div>
        <p style="color: white; font-size: 22px; font-style:italic; font-family: "Helvetica", "Times New Roman"; "> Bienvenido a la consola de administrador | <b> <%= session.getAttribute("nameAdmin")%> </b>   </p>        
    </div>
    <div>
        <a href="/Administracion/admin/logout" style="background-color:olive; color: white; text-align: center; width: 80px; 
              height: 40px; font-size: 15px; 
              text-decoration: none;
              border-radius: 60px;
              padding-right: 5px;
             padding: 15px;
              font-family: "Times New Roman", "Helvetica", "Arial"; font-style:normal; padding-left: 15px;"> SALIR </a>

    </div>
    
    
    <div style="padding-left: 10px; padding-top: 45px;">
       <nav>
           <a href="/Administracion/admin/listaempleados" style="background-color: blueviolet; color: white; text-align: center; width: 80px; 
              height: 40px; font-size: 31px; 
              text-decoration: none;
              border-radius: 4px;
              padding-right: 5px;
             padding: 15px;
              font-family: "Times New Roman", "Helvetica", "Arial"; font-style:normal; padding-left: 15px; " >Empleados</a>
           <a href="/Administracion/admin/ReporteSemanal" style="background-color: blueviolet; color: white; text-align: center; width: 80px; 
              height: 40px; font-size: 31px; 
              text-decoration: none;
              border-radius: 4px;
              padding-right: 5px;
             padding: 15px;
              font-family: "Times New Roman", "Helvetica", "Arial"; font-style:normal; padding-left: 15px;">Reportes</a>
              <a href="/Administracion/admin/HorarioEmpleados" style="background-color: blueviolet; color: white; text-align: center; width: 80px; 
              height: 40px; font-size: 31px; 
              text-decoration: none;
              border-radius: 4px;
              padding-right: 5px;
             padding: 15px;
              font-family: "Times New Roman", "Helvetica", "Arial"; font-style:normal; padding-left: 15px;">Horarios</a> 
              <a href="/Administracion/admin/Cargos" style="background-color: blueviolet; color: white; text-align: center; width: 80px; 
              height: 40px; font-size: 31px; 
              text-decoration: none;
              border-radius: 4px;
              padding-right: 5px;
             padding: 15px;
              font-family: "Times New Roman", "Helvetica", "Arial"; font-style:normal; padding-left: 15px;">Cargos</a>
              
           <a href="/Administracion/admin/AdminHome" style="background-color: blueviolet; color: white; text-align: center; width: 80px; 
              height: 40px; font-size: 31px; 
              text-decoration: none;
              border-radius: 4px;
              padding-right: 5px;
             padding: 15px;
              font-family: "Times New Roman", "Helvetica", "Arial"; font-style:normal; padding-left: 15px;"> Administradores </a>
       </nav>  
        
   </div> 
   
</div>