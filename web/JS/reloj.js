 

 
function gettoday(){
  
    var today = new Date(),
    hours = today.getHours(),
    minutes = today.getMinutes(),
    date = today.getDate(),
    day = today.getDay(),
    month = today.getMonth(),
    seconds = today.getSeconds();
    hours = checkTime(hours);
    minutes = checkTime(minutes);
    console.log(hours);
   console.log(minutes);
JSONEntrada(hours,minutes,seconds);

    return false;
}
function RegistrarHoraSalida(idempleado){
 
    window.location = "/Administracion/edithorario?idEmpleado=" + idempleado;
    
}




function gettodaySalida(){
    var today = new Date(),
    hours = today.getHours(),
    minutes = today.getMinutes(),
    date = today.getDate(),
    year = today.getFullYear(),
    day = today.getDay(),
    month = today.getMonth(),
    seconds = today.getSeconds();
    hours = checkTime(hours);
    minutes = checkTime(minutes);
   var mes = month + 1;
   var dias = day+2;
    console.log(year);
    console.log(mes);
    console.log(dias); 
    
   JSONSalida(year,m,d,hours,minutes,seconds);

    return false;
}

 function startTime() {
            //declaramos las  variables que nos proporcionaran los datos como la hora, minutos etc.
            var today = new Date(),
                hours = today.getHours(),
                minutes = today.getMinutes(),
                date = today.getDate(),
                day = today.getDay(),
                month = today.getMonth(),
                seconds = today.getSeconds()
                ;

              
            //utilizaremos operadores ternarios esto nos ayudara a mostrar la hora solo del 1 al 12
            hours = (hours == 0) ? 12 : hours;
            hours = (hours > 12) ? hours - 12 : hours;

            //pasaremos las horas y minutos a una funcion que crearemos mas adelante
            hours = checkTime(hours);
            minutes = checkTime(minutes);
 
            
            //primero para los dias y meses crearemos un arreglo esto por que la funcion que nos debuelve
            //los dias y meses nos los debuelbe en numero
            var dia = ["Domingo", " Lunes", "Martes", "Miercoles", "Jueves", "viernes", "Sabado"],
                mes = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
            //haora solo imprimimos los datos
            var hr = document.getElementById('time').innerHTML = hours + ":" + minutes,
                dt = document.getElementById('date').innerHTML = dia[day] + ", " + date + " De " + mes[month];


            //esta funcion hara que nuestro escript se ejecute constantemente
            var time = setTimeout(function() {
                startTime();
            }, 500);
        }
        //solo falta crear la funcion que nos diga si tine uno o dos dijitos
        //esto para que si solo tiene uno le agrege u  cero a la izquierda
        function checkTime(e) {
            if (e < 10) {
                e = "0" + e;
            }
            return e;
        }
        
        
      
        
        
function JSONEntrada(hours, minutes,seconds){
let idEmpleados = document.getElementById('codigoempleado').value;
const RegistroEntrada = "http://localhost:8082/Administracion/Cabanas/RegistrosEntrada";
IsImptyChechk(idEmpleados);
let JsonEntrada ={
        id_empleado: idEmpleados,
        local_date: {
          hour: hours,
          minute: minutes,
          second:seconds,
          nano: 0000
        }
}
fetch(RegistroEntrada, {
    mode:"cors",
    headers:{
  "accept": "application/json",
  "Content-Type":"application/json"
    },
  method:"POST",
  cache:"no-cache",
  body: JSON.stringify(JsonEntrada)
}).then(res => res.text()) 
.then(res => console.log(res)) //Muestre letrero Registrado exitosamente. Redireccione al index 
.catch(err => console.log("Error")); //Favor de verificar su idEmpleado inner html 
}
function JSONSalida(year,mouth,day,hour,minute,second){
const RegistroSalida = "http://localhost:8082/Administracion/Cabanas/RegistrosEntrada/Salida";
let idEmpleado = document.getElementById('codigoempleado').value;
IsImptyChechk(idEmpleado);


let JSONSalida={    
        id_empleado: idEmpleado,
        hora_salida: {
          date: {
            year: year,
            month: mouth,
            day: day
          },
          time: {
            hour: hour,
            minute: minute,
            second: second,
            nano: 0000
          }
        }  
}

fetch(RegistroSalida, {
    mode:"cors",
    headers:{
  "accept": "application/json",
  "Content-Type":"application/json"
    },
  method:"PUT",
  cache:"no-cache",
  body: JSON.stringify(JSONSalida)
}).then(res => res.text())
.then(res => console.log(res))// 1 Muestre letrero Registrado exitosamente. 2. Redireccione al index 
.catch(err => console.log("Error")); //Favor de verificar su id 
}
function IsImptyChechk(codigoemp){
if(codigoemp == " ")
{
    //InnerHTML diciendo que debe escribir el codigo. Favor de escribir id Empleado 
}
return codigoemp;
}



