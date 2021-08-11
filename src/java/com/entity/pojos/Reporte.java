/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.pojos;

import jakarta.annotation.Generated;
import jakarta.json.bind.annotation.JsonbDateFormat;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Positive;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Calendar;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "reporte", catalog = "adminitracionlogin", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r"),
    @NamedQuery(name = "Reporte.findByIdReporte", query = "SELECT r FROM Reporte r WHERE r.idReporte = :idReporte"),
    @NamedQuery(name = "Reporte.findByHoraEntrada", query = "SELECT r FROM Reporte r WHERE r.horaEntrada = :horaEntrada"),
    @NamedQuery(name= "Reporte.findHoraSalida", query="SELECT reporte FROM Reporte reporte WHERE " +
"reporte.fechaDiaria=:fecha AND reporte.Trabajadores.idEmpleado = :idempleado"),
    @NamedQuery(name= "Reporte.edithorario",query="SELECT reporte FROM Reporte reporte WHERE " +
"reporte.horaSalida IS NULL AND reporte.Trabajadores.idEmpleado = :idempleado" ),
    @NamedQuery(name = "Reporte.findByUsernameEmpleado", query="SELECT reporte FROM Reporte reporte WHERE " +
"  reporte.Trabajadores.idEmpleado IN (SELECT login.idUsuario FROM Login login WHERE login.userEmpleado LIKE :userempleado)  AND reporte.fechaDiaria=:fecha"),
    @NamedQuery(name = "Reporte.findByHoraSalida", query = "SELECT r FROM Reporte r WHERE r.horaSalida = :horaSalida"),
    @NamedQuery(name = "Reporte.findByPagohora", query = "SELECT r FROM Reporte r WHERE r.pagohora = :pagohora")})
public class Reporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdReporte")
    private Integer idReporte;
    @Basic(optional=true)
    @Column(name="Fecha_Diaria", nullable= false,insertable = true,updatable = true, columnDefinition="DATE")
    private LocalDate fechaDiaria;  
    @Basic(optional = false)
    @Column(name = "HoraEntrada")
   private LocalDateTime  horaEntrada;
    @Basic(optional = false )
    @Column(name = "HoraSalida")
    private LocalDateTime  horaSalida;
    @Basic(optional = false)
    @Column(name = "HorasDiariasTrabajadas", nullable=true,insertable = false,updatable = false)
    private  String pagohora;

    
    @ManyToOne(optional = false)
    @JoinColumn(name="IdReporteEmpleado", nullable=false)
    private Empleados Trabajadores; 

    public Empleados getEmpleados() {
        return Trabajadores;
    }

    public void setEmpleados(Empleados empleados) {
        this.Trabajadores = empleados;
    }

  
    
  
 
    public Reporte() {
    }

    public Reporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public Reporte(Integer idReporte,  LocalDateTime horaEntrada, LocalDateTime horaSalida,  String pagohora) {
        this.idReporte = idReporte;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
       
       this.pagohora = pagohora;
    }

   
    public LocalDate getFechaDiaria() {   
        return fechaDiaria;
    }

    public void setFechaDiaria(LocalDate  fechaDiaria) {
   this.fechaDiaria = fechaDiaria;
    }

    public Integer getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada( LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public  LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(  LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    public String getPagohora() {
        return pagohora;
    }

    public void setPagohora(  String pagohora) {
    this.pagohora = pagohora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReporte != null ? idReporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reporte)) {
            return false;
        }
        Reporte other = (Reporte) object;
        if ((this.idReporte == null && other.idReporte != null) || (this.idReporte != null && !this.idReporte.equals(other.idReporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.pojos.Reporte[ idReporte=" + idReporte + " ]";
    }
    
}
