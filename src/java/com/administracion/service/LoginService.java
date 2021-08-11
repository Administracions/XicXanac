/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.service;

import com.entity.pojos.Login;
import com.entity.pojos.Loginadmin;

/**
 *
 * @author PC
 */
public class LoginService {
    private static String passwordEncrypted;
    private static Passwords passwords = new Passwords();
    
    
    
    public static  Login UpdatePassword(Login login, String password){   
        if(IsValidPassword(password)){
     passwordEncrypted =  passwords.EncryptPassword(password); 
    login.setPassword(passwordEncrypted);
     return login;    
        }
            return null;
    }

    
    private static boolean IsValidPassword(String password){
        
        if(passwords.IsPasswordValid(password))
            return true;
        
     return false;
 
   }

  public static  Loginadmin UpdatePassword(Loginadmin login, String password){   
        if(IsValidPassword(password)){
     passwordEncrypted =  passwords.EncryptPassword(password); 
    login.setPassword(passwordEncrypted);
     return login;    
        }
            return null;
    }
}