/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    
   $("form[name='form']").validate({
      rules: {
          
          apellidoPaterno:{
              required:true,
              minlength:2,
              maxlength:80
          },  
            apellidoMaterno:{
              required:true,
              minlength:2,
              maxlength:80        
            }
            ,
            Nombre:{
                  required:true,
              minlength:2,
              maxlength:80    
            },
            CorreoAdmin:{
               required:true,
               email:true
            }
            ,
            TelefonoAdmin:{
                required:true,
                maxlength:10,
                number:true
          
            },
            
            direccionAdmin:{
                required:true, 
                maxlength: 200
                
            },
            StatusAdmin:{
                required:true
            }  ,
            idCargo:{
                required:true
            }
            ,
            idAdministrador:{
                required:true
            }
           },
           messages: {
                   Nombre: {
                           required: "Hey vamos, por favor, dános tu nombre",
                           minlength: "Necesitamos por lo menos {0} caracteres",
                           maxlength: "{0} caracteres son demasiados!"
                   },
                   
                   apellidoPaterno:{
                       required: "Este campo es obligatorio",
                       minlength: "Este campo debe tener minimo 2 caracteres",
                       maxlength: "Este campo debe tener maximo 80 caracteres"
                       
                   }
                   , apellidoMaterno:{
                       required: "Este campo es obligatorio",
                       minlength: "Este campo debe tener minimo 2 caracteres",
                       maxlength: "Este campo debe tener maximo 80 caracteres"
                       
                   }, CorreoAdmin:{
               required:"Este campo es obligatorio",
               email:"Este campo solo admite correo electronico, Verifica nuevamente"
            },    TelefonoAdmin:{
                required:"Este campo es obligatorio",
                maxlength:"Solo debe tener 10 digitos maximo"
          
            },
             direccionAdmin:{
                required:"Este campo es obligatorio", 
                maxlength: "este campo solo admite 200 caracteres maximo"
                
            },  StatusAdmin:{
                required:"Este campo es obligatorio"
            },
              idCargo:{
                required:"Este campo es obligatorio"
            },
              idAdministrador:{
                required:"Este campo es obligatorio"
            },
            submitHandler: function(form) {
      form.submit();
    }   
            
            
            
            
           }
       
   });
    
   
});
    
    
    
    





