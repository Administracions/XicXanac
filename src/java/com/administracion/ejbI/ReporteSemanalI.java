/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejbI;

import com.entity.pojos.ReporteSemanal;
import com.entity.pojos.Semanas;
import jakarta.ejb.Local;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


/**
 *
 * @author PC
 */
@Local
public interface ReporteSemanalI {
 public void create(ReporteSemanal reporteSemanal); 
 public void edit( ReporteSemanal  logina);
public void remove( ReporteSemanal logina);
public ReporteSemanal findbyidempleado(Integer idempleado);
public Integer UpdateSueldo(Integer idempleado, BigDecimal preciounitario, String iniciosemana, String finsemana);
public void ActualizarRegistrosSemanales(Semanas semana);
public ReporteSemanal find(Object idReporte);
public List<ReporteSemanal> findAll();
public List<ReporteSemanal> findRange(int[] range);
public List<Object[]> findReportesByEmpleado(Integer idEmpleado);
public List<Object[]>  getReporteSemanalGeneral();
public List<Object[]>findReporteByEmpleadoFecha(LocalDateTime DiaABuscar);   
}
