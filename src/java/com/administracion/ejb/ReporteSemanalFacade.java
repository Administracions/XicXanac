/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.administracion.ejb;

import com.administracion.ejbI.ReporteSemanalI;
import com.administracion.ejbI.SemanasI;
import com.entity.pojos.ReporteSemanal;
import com.entity.pojos.Semanas;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author PC
 */

@Stateless
public class ReporteSemanalFacade  extends AbstractFacade<ReporteSemanal> implements ReporteSemanalI{
  @Inject
  private SemanasI semanasFacade;
   
    
    @PersistenceContext(unitName= "AdministracionsPU") 
   private EntityManager entity;
  
    public ReporteSemanalFacade(){
        super(ReporteSemanal.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entity;
    }

    @Override
    public List<Object[]> findReportesByEmpleado(Integer idEmpleado) {

     return   getEntityManager()
       .createQuery("SELECT Semanas.inicioSemana, Semanas.FinSemana, reporte.PagoHoraUnitario, "
               + "reporte.HorasTrabajadas, reporte.PagaSemana FROM ReporteSemanal reporte "
               + "INNER JOIN reporte.semanas Semanas INNER JOIN reporte.empleados empleado  "
               + "WHERE  empleado.idEmpleado = :idEmp", Object[].class).setParameter("idEmp", idEmpleado).setMaxResults(15).getResultList();
        
    }

    
    @Override
    public List<Object[]> findReporteByEmpleadoFecha(LocalDateTime DiaABuscar) {
    return  getEntityManager().createQuery("SELECT Semanas.inicioSemana, Semanas.FinSemana,empleado.idEmpleado,  empleado.nombre, empleado.apellidoPat, "
              + " reportSem.HorasTrabajadas,reportSem.PagoHoraUnitario, reportSem.PagaSemana FROM ReporteSemanal reportSem "
              + "INNER JOIN reportSem.semanas Semanas INNER JOIN reportSem.empleados empleado WHERE :SemanaBuscar"
             
            + " BETWEEN Semanas.FinSemana AND  Semanas.inicioSemana", Object[].class).setParameter("SemanaBuscar", DiaABuscar).getResultList();
    }

    @Override
    public List<Object[]> getReporteSemanalGeneral() {
    return   getEntityManager().createQuery("SELECT semana.inicioSemana, semana.FinSemana,empleado.idEmpleado, empleado.nombre, "
                + "empleado.apellidoPat, reportesem.HorasTrabajadas, reportesem.PagoHoraUnitario, reportesem.PagaSemana FROM Semanas semana "
                + "INNER JOIN  semana.idSemana reportesem INNER JOIN  reportesem.empleados empleado", Object[].class).getResultList();
        
    
    }

    @Override
    public ReporteSemanal findbyidempleado(Integer idempleado) {
    
        
        try{
            
            return getEntityManager().createNamedQuery("Reportesemanal.FindByEmpleado", ReporteSemanal.class).setParameter("idemp", idempleado).getSingleResult();
        }catch(NonUniqueResultException | NoResultException e){
            
        }return null;
        
         
    }

    @Override
    public Integer UpdateSueldo(Integer idEmpleado, BigDecimal sueldoempleado, String Finsemana, String Iniciosemana) {
 
        return  getEntityManager().createNativeQuery("UPDATE ReporteSemanal reportesem SET reportesem.PagoPorHora = ?1 " +
" WHERE  reportesem.idEmpleado  = ?2 AND (SELECT semanas.InicioSemana FROM fecha_semanas semanas WHERE " +
"semanas.FinSemana LIKE ?3  AND semanas.InicioSemana LIKE ?4)")
            .setParameter(1, sueldoempleado).setParameter(2, idEmpleado).setParameter(4, '%'+Finsemana+'%')
            .setParameter(3, '%'+Iniciosemana+'%').executeUpdate();
      
        
    }

    @Override
    public void ActualizarRegistrosSemanales( Semanas semana) {
      getEntityManager().createNamedStoredProcedureQuery("ActualizarRegistros").execute();
     semanasFacade.create(semana);
     getEntityManager().createNamedStoredProcedureQuery("PonerRegistrosNuevos").execute();
        
    }

   

 
    
    
    
    
}
