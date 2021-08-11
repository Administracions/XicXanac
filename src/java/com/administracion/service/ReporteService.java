/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.service;

import com.entity.pojos.Reporte;
import com.entity.pojos.Semanas;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author PC
 */
public class ReporteService {
    
    public static Reporte fillreportefields(){
        Reporte newreporte = new Reporte();
        newreporte.setFechaDiaria(LocalDate.now());
        newreporte.setIdReporte(0);
        newreporte.setHoraEntrada(LocalDateTime.now());
        
        
      return newreporte;
    }
    
   public static Semanas createSemana(){
        Semanas semanas = new Semanas();
        semanas.setIdEmpleado(0);
        semanas.setInicioSemana(LocalDateTime.now().plusDays(7));
        semanas.setFinSemana(LocalDateTime.now());
        
        
        return semanas;
          }
    
    
    
    
    
}
