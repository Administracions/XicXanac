/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.pojos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author PC
 */

@Entity
@XmlRootElement
@Table(name="Direccion", catalog="adminitracionlogin" , schema="")
@NamedQueries({
    @NamedQuery(name = "Direccion.findByIdEmpleado", query = "SELECT direccion FROM Direccion direccion WHERE direccion.empleadoDir.idEmpleado = :idempleado")
    
})
public class Direccion  implements Serializable{
    
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)  
  @Column(name="ID", nullable=false)
  private Long id;  
  
 @Column(name="CallePrincipal", nullable= false) 
 @Size(min=5, max=200)
 @NotNull
private String CallePrincipal;

 
 @Column(name="Colonia", nullable= false) 
 @Size(min=5, max=200)
 @NotNull
 private String Colonia;
 
 
@Column(name="NumeroExterior", nullable=true)
@NotNull 
@Positive
private Integer NumeroExterior;


@Column(name = "NumeroInterior", nullable= false, length = 45)
@NotEmpty
@Size(min=1, max=5)
private String NumeroInterior;
 

@Column(name= "CodigoPostal", nullable = false)
@NotNull
//@Max(5)
//@Min(4)
private Integer CodigoPostal;

@Column(name="Estado", nullable = false, length= 50)
@NotEmpty
private String Estado;

@Column(name= "Pais", nullable = false, length = 45)
@NotEmpty
private String Pais;


@OneToOne(optional=false)
@JoinColumn(name = "EmpleadosId", nullable = false, updatable= false ,insertable = true, referencedColumnName="IdEmpleado", unique=false)
private Empleados empleadoDir;

   public Direccion(){      
       
   }

    public Direccion(Long id, String CallePrincipal, Integer NumeroExterior, String NumeroInterior, Integer CodigoPostal, String Estado, String Pais) {
        this.id = id;
        this.CallePrincipal = CallePrincipal;
        this.NumeroExterior = NumeroExterior;
        this.NumeroInterior = NumeroInterior;
        this.CodigoPostal = CodigoPostal;
        this.Estado = Estado;
        this.Pais = Pais;
    }

    public Empleados getEmpleadoDir() {
        return empleadoDir;
    }

    public void setEmpleadoDir(Empleados empleadoDir) {
        this.empleadoDir = empleadoDir;
    }
 
public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCallePrincipal() {
        return CallePrincipal;
    }

    public void setCallePrincipal(String CallePrincipal) {
        this.CallePrincipal = CallePrincipal;
    }

    public Integer getNumeroExterior() {
        return NumeroExterior;
    }

    public void setNumeroExterior(Integer NumeroExterior) {
        this.NumeroExterior = NumeroExterior;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public String getNumeroInterior() {
        return NumeroInterior;
    }

    public void setNumeroInterior(String NumeroInterior) {
        this.NumeroInterior = NumeroInterior;
    }

    public Integer getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(Integer CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Direccion other = (Direccion) obj;
        return true;
    }
    







  
    
}
