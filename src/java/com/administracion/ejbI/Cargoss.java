/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejbI;

import com.entity.pojos.Cargo;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author PC
 */
@Local
public interface Cargoss {
   public void create(Cargo f);
   public void edit(Cargo f);
   public void remove(Cargo f);
   public Cargo find(Object idCargo);
   public List<Cargo> findAll();
    Boolean IsCargoRegistered(String Cargo);
   
}
