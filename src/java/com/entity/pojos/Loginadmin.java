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
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "loginadmin", catalog = "adminitracionlogin", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loginadmin.findAll", query = "SELECT l FROM Loginadmin l"),
    @NamedQuery(name = "Loginadmin.findByIdLoginAdmin", query = "SELECT l FROM Loginadmin l WHERE l.idLoginAdmin = :idLoginAdmin"),
    @NamedQuery(name = "Loginadmin.findByNombreAdmin", query = "SELECT l.nombreAdmin FROM Loginadmin l WHERE l.nombreAdmin LIKE :nombreAdmin"),
    @NamedQuery(name = "Loginadmin.findByPassword", query = "SELECT l FROM Loginadmin l WHERE l.password = :password"),
    @NamedQuery(name = "Loginadmin.getPassByUser", query="SELECT l.password as pass FROM Loginadmin l WHERE l.nombreAdmin  LIKE  :idAdmin"), 
    @NamedQuery(name = "Loginadmin.getIdAdminByUser", query="SELECT login.idLoginAdmin FROM  Loginadmin login WHERE  login.nombreAdmin LIKE :nombreUser")    

})
public class Loginadmin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdLoginAdmin")
    private Integer idLoginAdmin;
    @Basic(optional = false)
    @Column(name = "NombreAdmin", nullable = false,  length=80)
    @NotEmpty
    private String nombreAdmin;
    @Basic(optional = false)
    @Column(name = "Password", nullable = false)
    //@Pattern(regexp="^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8,65}$")
    private String password;
    @JoinColumn(name = "IdLoginAdmin", referencedColumnName = "IdAdministrador", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Administrador administrador;

    public Loginadmin() {
    }

    public Loginadmin(Integer idLoginAdmin) {
        this.idLoginAdmin = idLoginAdmin;
    }

    public Loginadmin(Integer idLoginAdmin, String nombreAdmin, String password) {
        this.idLoginAdmin = idLoginAdmin;
        this.nombreAdmin = nombreAdmin;
        this.password = password;
    }

    public Integer getIdLoginAdmin() {
        return idLoginAdmin;
    }

    public void setIdLoginAdmin(Integer idLoginAdmin) {
        this.idLoginAdmin = idLoginAdmin;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLoginAdmin != null ? idLoginAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loginadmin)) {
            return false;
        }
        Loginadmin other = (Loginadmin) object;
        if ((this.idLoginAdmin == null && other.idLoginAdmin != null) || (this.idLoginAdmin != null && !this.idLoginAdmin.equals(other.idLoginAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.pojos.Loginadmin[ idLoginAdmin=" + idLoginAdmin + " ]";
    }
    
}
