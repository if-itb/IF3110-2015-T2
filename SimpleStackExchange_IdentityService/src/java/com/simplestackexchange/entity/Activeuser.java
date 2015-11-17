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
@Table(name = "ACTIVEUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activeuser.findAll", query = "SELECT a FROM Activeuser a"),
    @NamedQuery(name = "Activeuser.findByToken", query = "SELECT a FROM Activeuser a WHERE a.token = :token"),
    @NamedQuery(name = "Activeuser.findByUserId", query = "SELECT a FROM Activeuser a WHERE a.userId = :userId"),
    @NamedQuery(name = "Activeuser.findByCreatedTime", query = "SELECT a FROM Activeuser a WHERE a.createdTime = :createdTime")})
public class Activeuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "TOKEN")
    private String token;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    public Activeuser() {
    }

    public Activeuser(String token) {
        this.token = token;
    }

    public Activeuser(String token, int userId, Date createdTime) {
        this.token = token;
        this.userId = userId;
        this.createdTime = createdTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (token != null ? token.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activeuser)) {
            return false;
        }
        Activeuser other = (Activeuser) object;
        if ((this.token == null && other.token != null) || (this.token != null && !this.token.equals(other.token))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simpleStackExchange.entity.Activeuser[ token=" + token + " ]";
    }
    
}
