/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simpleStackExchange.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mfikria
 */
@Entity
@Table(name = "REGISTEREDUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registereduser.findAll", query = "SELECT r FROM Registereduser r"),
    @NamedQuery(name = "Registereduser.findByUid", query = "SELECT r FROM Registereduser r WHERE r.uid = :uid"),
    @NamedQuery(name = "Registereduser.findByName", query = "SELECT r FROM Registereduser r WHERE r.name = :name"),
    @NamedQuery(name = "Registereduser.findByEmail", query = "SELECT r FROM Registereduser r WHERE r.email = :email"),
    @NamedQuery(name = "Registereduser.findByPassword", query = "SELECT r FROM Registereduser r WHERE r.password = :password"),
    @NamedQuery(name = "Registereduser.findByDatetime", query = "SELECT r FROM Registereduser r WHERE r.datetime = :datetime")})
public class Registereduser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UID")
    private Integer uid;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 32)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;

    public Registereduser() {
    }
    
    public Registereduser(Registereduser user) {
        this.uid = user.uid;
        this.name = user.name;
        this.datetime = user.datetime;
        this.email = user.email;
        this.password = user.password;        
    }

    public Registereduser(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registereduser)) {
            return false;
        }
        Registereduser other = (Registereduser) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simpleStackExchange.entity.Registereduser[ uid=" + uid + " ]";
    }
    
}
