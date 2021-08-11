/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    
   $("form[name='editdireccion']").validate({
      rules: {
          
          Calleprincipal:{
              required:true,
              minlength:2,
              maxlength:100
          },  
            Colonia:{
              required:true,
              minlength:2,
              maxlength:50  
            }
            ,
            CodigoPostal:{
                  required:true,
                  number:true,
                 maxlength:5,
                 minlength:5
            },
            estado:{
               required:true
            }
            ,
            NumeroInterior:{
                required:true,
                maxlength:10
   
            },
            
            NumeroExterior:{
                required:true, 
                maxlength: 10,
                number:true
                
            },
            pais:{
                required:true,
                maxlength: 25
            }} ,
           messages: {
                   calleprincipal: {
                           required: "Este campo es obligatorio",
                           minlength: "Necesitamos por lo menos 2 caracteres",
                           maxlength: "Los caracteres son demasiados!"
                   },
                   
                   Colonia:{
                       required: "Este campo es obligatorio",
                       minlength: "Este campo debe tener minimo 2 caracteres",
                       maxlength: "Este campo debe tener maximo 50 caracteres"
                       
                   }
                   , CodigoPostal:{
                       required: "Este campo es obligatorio",
                      maxlength: "Este campo solo debe tener 5 digitos",
                       minlength: "Este campo solo debe tener 5 digitos",
                      number:"Este campo solo pueden ir numeros"
                       
                   }, numerointerior:{
               required:"Este campo es obligatorio",
              maxlength: "Este campo debe tener maximo 10 caracteres"
              
            },numeroexterior:{
               required:"Este campo es obligatorio",
                number:"Este campo solo pueden ir numeros",
                  maxlength: "Este campo debe tener maximo 10 caracteres"
              
            } ,   pais:{
                required:"Este campo es obligatorio",
                maxlength:"Solo debe tener 25 carcteres maximo"
          
            },
             direccionAdmin:{
                required:"Este campo es obligatorio", 
                maxlength: "este campo solo admite 200 caracteres maximo"
                
            },  estado:{
                required:"Este campo es obligatorio"
            },
            submitHandler: function(form) {
      form.submit();
    }   
            
            
            
            
           }
       
   });
    
   
});



