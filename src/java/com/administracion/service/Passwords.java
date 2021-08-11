/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.service;

import com.lambdaworks.crypto.SCryptUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author PC
 */
public class Passwords {
    
    private final String REGEXUSER ="^[A-Za-z]*\\d{2,}[A-Za-z]*[!@#$&*]?$|"
                + "^[A-Za-z]*\\d{2,}[A-Za-z]*\\d*[!@#$&*]?$";
    
    private boolean CheckPassword;
 
    
    private final String REGEXPASSWORD = "^(?=(.*[A-Z])*)(?=(.*[!@#$&*])?)(?=(.*[0-9]){2,5})(?=(.*[a-z]){2,25}).{8,65}$";
    
    public boolean IsUsernameValid(String username){
     Pattern patrondiseno =    Pattern.compile(REGEXUSER);
     Matcher matcher = patrondiseno.matcher(username);
     if(matcher.matches()){
         return  true;
     }
     return false;
 
    }
    public boolean IsPasswordValid(String password){
        Pattern patronpassword = Pattern.compile(REGEXPASSWORD);
        Matcher matcher = patronpassword.matcher(password);
        if(matcher.matches()){
            return true;
        }else{
            return false;
            
        }
    }
    
    
    public boolean CheckPassword(String password, String hashpassword){
       CheckPassword = SCryptUtil.check(password, hashpassword);
        
       if(CheckPassword){
           
return true;
           
       }else{
           return false;
           
       }

    }
    
    
    

    public String EncryptPassword(String password){
       String passwordEncrypted;
       passwordEncrypted = SCryptUtil.scrypt(password, 2 << 14, 8, 1);
        return passwordEncrypted;
    }
    
    
    
}
