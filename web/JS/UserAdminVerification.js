/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    
       $("form[name='userform']").validate({
           rules:{
            nameAdmin:{
                required:true,
                maxlength: 50
            }, 
            passwordAdmin:{
                required:true,
                maxlength:65
            }
            
            
           },messages:{
              nameAdmin:{
                required:"Este campo es obligatorio ",
                maxlength: "Maximo 50 caracteres"
            },passwordAdmin:{
                required:"Este campo es obligatorio",
                maxlength:"Maximo son 65 caracteres para la contraseña"
            }
             
            
            
           }
              
       });
    
    
});

