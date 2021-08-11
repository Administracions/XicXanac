/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.pojos;

import com.administracion.enums.Status;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
    import java.util.LinkedList;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "administrador", catalog = "adminitracionlogin", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByIdAdministrador", query = "SELECT a FROM Administrador a WHERE a.idAdministrador = :idAdministrador"),
    @NamedQuery(name = "Administrador.findByNombre", query = "SELECT a FROM Administrador a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Administrador.findByApellidoPat", query = "SELECT a FROM Administrador a WHERE a.apellidoPat = :apellidoPat"),
    @NamedQuery(name = "Administrador.findByApellidoMat", query = "SELECT a FROM Administrador a WHERE a.apellidoMat = :apellidoMat"),
    @NamedQuery(name = "Administrador.findByDireccion", query = "SELECT a FROM Administrador a WHERE a.direccion = :direccion"),
    @NamedQuery(name = "Administrador.findByTelefono", query = "SELECT a FROM Administrador a WHERE a.telefono = :telefono"),
    @NamedQuery(name = "Administrador.findByCorreo", query = "SELECT a FROM Administrador a WHERE a.correo = :correo"),
    @NamedQuery(name = "Administrador.findByIdEmpleado", query = "SELECT admin "
            + "FROM Administrador admin JOIN admin.empleadosList empleados WHERE empleados.idEmpleado = :IdEmpleado ") 

})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdAdministrador")
    private Integer idAdministrador;
    @Basic(optional = false)
    @Column(name = "Nombre",nullable =false, length = 80)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ApellidoPat", nullable = false, length = 60)
    @NotEmpty
    private String apellidoPat;
    @Basic(optional = false)
    @Column(name = "ApellidoMat", nullable=false, length = 60)
     @NotEmpty 
    private String apellidoMat;
    @Basic(optional = false)
    @Column(name = "Direccion", nullable = false, length = 180)
    @NotEmpty
    private String direccion;
    @Basic(optional = false)  
    @Column(name = "Telefono")
    private Long telefono;
    @Enumerated(EnumType.STRING)
    @Column(name="EstatusEmpleado", nullable=false)
   private Status statusempleados;    
    
    @Basic(optional = false)
    @Column(name = "Correo", nullable = false, length = 75)
    @NotEmpty
    @Email
    private String correo;
    @OneToMany(mappedBy = "idAdministracion")
    private List<Empleados> empleadosList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "administrador")
    private Loginadmin loginadmin;

    public Administrador() {
    }

    public Administrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Administrador(Integer idAdministrador, String nombre, String apellidoPat, String apellidoMat, String direccion,Status statusAdministrador, long telefono, String correo) {
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.statusempleados = statusAdministrador;
    }

    public void AddEmpleados(Empleados empleado){
     List<Empleados> empleados = this.getEmpleadosList();
     if(empleado == null)
    throw new NullPointerException("Errot en agregar el empleado");
  empleados.add(empleado); 
        
    }

    public Status getStatusempleados() {
        return statusempleados;
    }

    public void setStatusempleados(Status statusempleados) {
        this.statusempleados = statusempleados;
    }
    
    
    
    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    public Loginadmin getLoginadmin() {
        return loginadmin;
    }

    public void setLoginadmin(Loginadmin loginadmin) {
        loginadmin.setAdministrador(this);
        this.loginadmin = loginadmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdministrador != null ? idAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.idAdministrador == null && other.idAdministrador != null) || (this.idAdministrador != null && !this.idAdministrador.equals(other.idAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.pojos.Administrador[ idAdministrador=" + idAdministrador + " ]";
    }
    
}
