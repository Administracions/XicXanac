/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author PC
 */


@Entity 
@Table(name="Fecha_Semanas", catalog="adminitracionlogin")
@XmlRootElement
public class Semanas implements Serializable{

@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="IdSemana", nullable=false, updatable= false)    
private Integer IdEmpleado;


@Column(name="InicioSemana", nullable = false, updatable = false)
private LocalDateTime inicioSemana;

@Column(name="FinSemana", nullable = false, updatable = false)
private LocalDateTime FinSemana;
@OneToMany(mappedBy = "semanas")
private List<ReporteSemanal> idSemana;

    public Semanas() {
    }

public List<ReporteSemanal> getIdSemana() {
        return idSemana;
    }

    public void setIdSemana(List<ReporteSemanal> idSemana) {
        this.idSemana = idSemana;
    }





    public Semanas(Integer IdEmpleado, LocalDateTime inicioSemana, LocalDateTime FinSemana) {
        this.IdEmpleado = IdEmpleado;
        this.inicioSemana = inicioSemana;
        this.FinSemana = FinSemana;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.IdEmpleado);
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
        final Semanas other = (Semanas) obj;
        return true;
    }

 


public Integer getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(Integer IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public LocalDateTime getInicioSemana() {
        return inicioSemana;
    }

    public void setInicioSemana(LocalDateTime inicioSemana) {
        this.inicioSemana = inicioSemana;
    }

    public LocalDateTime getFinSemana() {
        return FinSemana;
    }

    public void setFinSemana(LocalDateTime FinSemana) {
        this.FinSemana = FinSemana;
    }








}
