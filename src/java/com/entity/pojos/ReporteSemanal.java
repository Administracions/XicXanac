/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.pojos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author PC
 */

@Entity 
@Table(name="ReporteSemanal" , catalog="adminitracionlogin", schema="")
@NamedStoredProcedureQueries({
  @NamedStoredProcedureQuery(name = "ActualizarRegistros", procedureName = "SetHorasTrabajadasSemanaleS"),
  @NamedStoredProcedureQuery(name="PonerRegistrosNuevos", procedureName = "setReportesEnBlancos") 
    
})
@NamedQueries({
    @NamedQuery(name="Reportesemanal.FindByEmpleado",
            query = "SELECT ReporteSem FROM ReporteSemanal ReporteSem WHERE ReporteSem.empleados.idEmpleado = :idemp")
    
})
@XmlRootElement
public class ReporteSemanal  implements Serializable{
   
    @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long idReporteSemanal;
   
   @Column(name="PagoPorHora", nullable = false, precision=15, scale= 2)
   private BigDecimal PagoHoraUnitario;
   
   @Column(name="HorasTrabajadasSemana", nullable= true, precision=15, scale= 2)
   private String HorasTrabajadas;
   
   @Column(name = "PagoSemana", nullable = true, columnDefinition = " DECIMAL(15,2) AS (HorasTrabajadasSemana * PagoPorHora)", precision=15, scale= 2)
   private BigDecimal PagaSemana;
   
   

  
   @ManyToOne(optional=false)
   @JoinColumn(name="IdEmpleado", nullable = false)
   private Empleados empleados;

   @ManyToOne(optional=false)
   @JoinColumn(name="IdSemanaReporteSem" , nullable = false , updatable=false)
   private Semanas semanas;

    public Semanas getSemanas() {
        return semanas;
    }

    public void setSemanas(Semanas semanas) {
        this.semanas = semanas;
    }
    
   
    public ReporteSemanal() {
    }

    public ReporteSemanal(Long idReporteSemanal) {
        this.idReporteSemanal = idReporteSemanal;
    }
   
    public ReporteSemanal(Long idReporteSemanal, BigDecimal PagoHoraUnitario, String  HorasTrabajadas, BigDecimal PagaSemana, Empleados empleados) {
        this.idReporteSemanal = idReporteSemanal;
        this.PagoHoraUnitario = PagoHoraUnitario;
        this.HorasTrabajadas = HorasTrabajadas;
        this.PagaSemana = PagaSemana;
        this.empleados = empleados;
    }

    
    public Long getIdReporteSemanal() {
        return idReporteSemanal;
    }

    public void setIdReporteSemanal(Long idReporteSemanal) {
        this.idReporteSemanal = idReporteSemanal;
    }

    public BigDecimal getPagoHoraUnitario() {
        return PagoHoraUnitario;
    }

    public void setPagoHoraUnitario(BigDecimal PagoHoraUnitario) {
        this.PagoHoraUnitario = PagoHoraUnitario;
    }

    public String  getHorasTrabajadas() {
        return HorasTrabajadas;
    }

    public void setHorasTrabajadas(String HorasTrabajadas) {
        this.HorasTrabajadas = HorasTrabajadas;
        
    }

    public BigDecimal getPagaSemana() {
        return PagaSemana;
    }

    public void setPagaSemana(BigDecimal PagaSemana) {
        this.PagaSemana = PagaSemana;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }


   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idReporteSemanal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReporteSemanal other = (ReporteSemanal) obj;
        return true;
  
}
   
   
    
    
    
    
}
