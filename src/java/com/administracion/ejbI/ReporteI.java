/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejbI;

import com.entity.pojos.Reporte;
import jakarta.ejb.Local;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
@Local
public interface ReporteI {
public void create(Reporte reporte);
public void edit( Reporte reporte);
public void remove( Reporte reporte);
public Reporte find(Object id);
public Reporte findbyUsernameEmpleado(String username);
public Reporte findbyempleado(Integer idempleado);
public List<Reporte> findAll();
public List<Reporte> findRange(int[] range);  
public boolean IsRegisteredtodayemployee(Integer idEmpleado);
public boolean ActualizarRegistroDiario(LocalDateTime horaSalida , LocalDate diaActual, Integer idEmpleado) ;
public List<Object[]>  getReportesDiariosByEmpleado(Integer idEmpleado, LocalDate FechaPrimero , LocalDate diaUltimo);
public List<Object[]>  getReportesDiariosByEmpleados(LocalDate FechaPrimero , LocalDate diaUltimo);
public List<Object[]>  getReporteHoy();
 }
