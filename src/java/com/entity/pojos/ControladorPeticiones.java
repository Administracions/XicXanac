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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author PC
 */

@Entity
@XmlRootElement
@Table(name="ControladorPeticion", catalog="adminitracionlogin", schema="")
public class ControladorPeticiones implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdPeticion", nullable= false, updatable=false)
    private Long idPeticion;
    
    @Column(name="MetodoPeticion", nullable = false, length = 15)
    @NotEmpty
    private String Method;
    
    
    @Column(name="PathPeticion", nullable = false, length = 100)
    @NotEmpty
    private String Path;
    
    @Column(name="TiempoIngreso", nullable = false)
    private LocalTime tiempoIngreso;
    
    @Column(name="TiempoSalida", nullable= true)
    private LocalTime TiempoSalida = LocalTime.now();
    
   
   

    public ControladorPeticiones() {
    }

    
    
    public ControladorPeticiones(Long idPeticion, String Method, String Path, LocalTime tiempoIngreso, LocalTime TiempoSalida) {
        this.idPeticion = idPeticion;
        this.Method = Method;
        this.Path = Path;
        this.tiempoIngreso = tiempoIngreso;
        this.TiempoSalida = TiempoSalida;
    }

    public Long getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(Long idPeticion) {
        this.idPeticion = idPeticion;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String Method) {
        this.Method = Method;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String Path) {
        this.Path = Path;
    }

    public LocalTime getTiempoIngreso() {
        return tiempoIngreso;
    }

    public void setTiempoIngreso(LocalTime tiempoIngreso) {
        this.tiempoIngreso = tiempoIngreso;
    }

    public LocalTime getTiempoSalida() {
        return TiempoSalida;
    }

    public void setTiempoSalida(LocalTime TiempoSalida) {
        this.TiempoSalida = TiempoSalida;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.idPeticion);
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
        final ControladorPeticiones other = (ControladorPeticiones) obj;
        return true;
    }
    
    
    
    
    
    
    
    
}
