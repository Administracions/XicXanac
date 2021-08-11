/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.pojos;

import com.administracion.enums.Status;
import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "empleados", catalog = "adminitracionlogin", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findByIdEmpleado", query = "SELECT e FROM Empleados e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleados.findByNombre", query = "SELECT e FROM Empleados e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleados.findByApellidoPat", query = "SELECT e FROM Empleados e WHERE e.apellidoPat = :apellidoPat"),
    @NamedQuery(name = "Empleados.findByApellidoMat", query = "SELECT e FROM Empleados e WHERE e.apellidoMat = :apellidoMat"),
    @NamedQuery(name = "Empleados.findByTelefono", query = "SELECT e FROM Empleados e WHERE e.telefono = :telefono"),

})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdEmpleado", nullable = false) 
    private Integer idEmpleado;
    @Basic(optional = false)
    @Column(name = "Nombre",nullable = false, length = 50)
    @NotEmpty
    @Size(min=3,max=90)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ApellidoPat",nullable = false, length = 80)
    @NotEmpty
    @Size(min=3,max=90)
    private String apellidoPat;
    @Basic(optional = false)
    @NotEmpty
    @Size(min=3,max=90)
    @Column(name = "ApellidoMat", nullable = false,length = 80)
    private String apellidoMat;
    
    @Basic(optional = false)
    @Column(name = "Correo", nullable = false, length = 80)
    private String CorreoEmpleado;
    
    
    
    
    @Enumerated(EnumType.STRING)
    @Column(name="EstatusEmpleado", nullable=false)
   private Status statusempleados;    
    
    @Basic(optional = false)
  //  @Pattern(regexp="^\\d{10}$||^[\\+52]\\d{12}\\w?$")
    @Column(name = "Telefono")
    private Long telefono;
    @JoinColumn(name = "IdAdministracion", referencedColumnName = "IdAdministrador")
    @ManyToOne
    private Administrador idAdministracion;
    @JoinColumns({
       @JoinColumn(name = "Cargo", referencedColumnName = "IdCargo"),
       @JoinColumn(name = "Cargo", referencedColumnName = "IdCargo")})
    @ManyToOne(optional = false)
    private Cargo cargo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleados")
    private Login login;
  
    @OneToMany(cascade=CascadeType.ALL, fetch =FetchType.EAGER, mappedBy ="empleados")
    private  List<ReporteSemanal>  reportesemanal;
    
    @OneToMany(cascade= {CascadeType.REMOVE,CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy="Trabajadores")
     private List<Reporte> reportesempledos = new LinkedList<Reporte>();    

     
    @OneToOne(cascade = CascadeType.ALL, mappedBy= "empleadoDir")
    private Direccion direction;

       
    public List<Reporte> getReportesempledos() {
        return reportesempledos;
    }

    public void setReportesempledos(List<Reporte> reportesempledos) {
        this.reportesempledos = reportesempledos;
    }

    public String getCorreoEmpleado() {
        return CorreoEmpleado;
    }

    public void setCorreoEmpleado(String CorreoEmpleado) {
        this.CorreoEmpleado = CorreoEmpleado;
    }
   
    
    
    public List<ReporteSemanal> getReportesemanal() {
        return reportesemanal;
    }

    public void setReportesemanal(List<ReporteSemanal> reportesemanal) {
        this.reportesemanal = reportesemanal;
    }

    
 
    public Empleados() {
    }

    public Empleados(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Status getStatusempleados() {
        return statusempleados;
    }

    public void setStatusempleados(Status statusempleados) {
        this.statusempleados = statusempleados;
    }
    

    public Empleados(Integer idEmpleado, String nombre, String apellidoPat, String apellidoMat,Status statusEmpleado, long telefono) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.telefono = telefono;
        this.statusempleados = statusEmpleado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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


    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public Administrador getIdAdministracion() {
        return idAdministracion;
    }

    public void setIdAdministracion(Administrador idAdministracion) {
 
        this.idAdministracion = idAdministracion;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    public Direccion getDirection() {
        return direction;
    }

    public void setDirection(Direccion direction) {
     //   direction.setEmpleadoDir(this);
        this.direction = direction;
    }
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.pojos.Empleados[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
