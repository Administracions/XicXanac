/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejb;

import com.administracion.ejbI.ReporteI;
import com.entity.pojos.Reporte;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
@Stateless
public class ReporteFacade extends AbstractFacade<Reporte> implements ReporteI {
    @PersistenceContext(unitName="AdministracionsPU")
    private EntityManager em;

  public ReporteFacade()
 {
 super(Reporte.class);     
  }
    @Override
    protected EntityManager getEntityManager() {
      return em;
    }

   @Override
    public boolean ActualizarRegistroDiario(LocalDateTime horaSalida , LocalDate diaActual, Integer idEmpleado){   
   try{
   Reporte reporte = getEntityManager().
createQuery("SELECT reporte FROM Reporte reporte WHERE reporte.Trabajadores.idEmpleado = :idEmp AND (reporte.fechaDiaria = :Fecha) AND reporte.horaSalida IS NULL", Reporte.class)
.setParameter("idEmp", idEmpleado)
.setParameter("Fecha", diaActual)
           .getSingleResult();
  reporte.setHoraSalida(horaSalida);
  this.edit(reporte); 
  return true;
   }catch(NoResultException  | NonUniqueResultException es){
       es.printStackTrace();
       es.getMessage(); 
       return false;
  
   }    
    }

    @Override
    public List<Object[]> getReportesDiariosByEmpleado(Integer idEmpleado, LocalDate Fecha1, LocalDate diaUltimo) {
    return getEntityManager().createQuery("SELECT empleados.nombre, empleados.apellidoPat,reportes.fechaDiaria, reportes.horaEntrada, "
             + "reportes.horaSalida, reportes.pagohora  FROM Reporte reportes "
             + "INNER JOIN reportes.Trabajadores empleados WHERE empleados.idEmpleado = :idEmpleado "
             + "AND (reportes.fechaDiaria BETWEEN :FechaUno AND  :FechaUltimo)", Object[].class)
             .setParameter("idEmpleado", idEmpleado)
             .setParameter("FechaUno", Fecha1)
             .setParameter("FechaUltimo", diaUltimo).getResultList(); 
    }

    @Override
    public List<Object[]> getReportesDiariosByEmpleados(LocalDate inicioBusqueda, LocalDate FinBusqueda) {
    return  getEntityManager().createQuery("SELECT empleados.nombre, empleados.apellidoPat,reportes.fechaDiaria, reportes.horaEntrada, "
             + "reportes.horaSalida, reportes.pagohora  FROM Reporte reportes "
             + "INNER JOIN reportes.Trabajadores empleados WHERE "
             + "reportes.fechaDiaria BETWEEN :FechaUno AND  :FechaUltimo", Object[].class)
              .setParameter("FechaUno", inicioBusqueda)
              .setParameter("FechaUltimo", FinBusqueda)
              .getResultList();
    }

    @Override
    public List<Object[]> getReporteHoy() {
      return getEntityManager().createQuery("SELECT empleados.nombre, empleados.apellidoPat,reportes.fechaDiaria, reportes.horaEntrada, "
             + "reportes.horaSalida, reportes.pagohora FROM Reporte reportes "
              + "INNER JOIN reportes.Trabajadores empleados WHERE reportes.fechaDiaria IN(CURRENT_DATE)", Object[].class).getResultList();
      
    }

    @Override
    public boolean IsRegisteredtodayemployee(Integer idEmpleado) {
      try{
        getEntityManager().createNamedQuery("Reporte.findHoraSalida", Reporte.class)
                .setParameter("fecha", LocalDate.now())
                .setParameter("idempleado", idEmpleado).getSingleResult();
        return true;
      }catch(NonUniqueResultException | NoResultException exception){
  
          return false;
    }
   
   
}
 @Override
public Reporte findbyempleado(Integer idempleado){
    
    try{
      return  getEntityManager().createNamedQuery("Reporte.edithorario", Reporte.class)
                .setParameter("idempleado", idempleado).getSingleResult();
    
      }catch(NonUniqueResultException | NoResultException exception){
  
          return null;
    }
    
    
}

    @Override
    public Reporte findbyUsernameEmpleado(String username) {
        
        try{
      return getEntityManager().createNamedQuery("Reporte.findByUsernameEmpleado", Reporte.class)
              .setParameter("fecha", LocalDate.now())
              .setParameter("userempleado", "%" + username + "%").getSingleResult();
        }catch(NonUniqueResultException | NoResultException exception){
            return null;
        }
        
        
    }
   
        
      
    
}