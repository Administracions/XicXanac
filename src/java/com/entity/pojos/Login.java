/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.pojos;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "login", catalog = "adminitracionlogin", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByIdUsuario", query = "SELECT l FROM Login l WHERE l.idUsuario = :idUsuario"),
    @NamedQuery(name = "Login.findByUserEmpleado", query = "SELECT l.idUsuario FROM Login l WHERE l.userEmpleado LIKE :userEmpleado"),
    @NamedQuery(name = "Login.findByPassword", query = "SELECT l FROM Login l WHERE l.password = :password"),
    @NamedQuery(name = "Login.getPassword", query="SELECT l.password FROM Login l WHERE  l.userEmpleado LIKE :idUser"),
    @NamedQuery(name =  "Login.getUserEmpleado", query ="SELECT l.userEmpleado FROM Login l WHERE l.idUsuario = :idEmpleado" ), 
    @NamedQuery(name =  "Login.getUserEmple", query ="SELECT l.userEmpleado FROM Login l WHERE LOWER(l.userEmpleado) LIKE :userEmpleado" ),
   
 })
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @Column(name = "UserEmpleado", nullable = false, length =80)
    private String userEmpleado;
    @Basic(optional = false)
    @Column(name = "Password" , nullable = false)
    @NotEmpty
    @Size(min=8, max=255)
    private String password;
    @JoinColumn(name = "IdUsuario", referencedColumnName = "IdEmpleado", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empleados empleados;

    public Login() {
    }

    public Login(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Login(Integer idUsuario, String userEmpleado, String password) {
        this.idUsuario = idUsuario;
        this.userEmpleado = userEmpleado;
        this.password = password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUserEmpleado() {
        return userEmpleado;
    }

    public void setUserEmpleado(String userEmpleado) {
        this.userEmpleado = userEmpleado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.pojos.Login[ idUsuario=" + idUsuario + " ]";
    }
    
}
