/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplestackexchange.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "ANSWER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a"),
    @NamedQuery(name = "Answer.findByAid", query = "SELECT a FROM Answer a WHERE a.aid = :aid"),
    @NamedQuery(name = "Answer.findByQid", query = "SELECT a FROM Answer a WHERE a.qid = :qid"),
    @NamedQuery(name = "Answer.findByCountvotes", query = "SELECT a FROM Answer a WHERE a.countvotes = :countvotes"),
    @NamedQuery(name = "Answer.findByDatetime", query = "SELECT a FROM Answer a WHERE a.datetime = :datetime"),
    @NamedQuery(name = "Answer.findByUid", query = "SELECT a FROM Answer a WHERE a.uid = :uid")})
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AID")
    private Integer aid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QID")
    private int qid;
    @Lob
    @Size(max = 32700)
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "COUNTVOTES")
    private Integer countvotes;
    @Column(name = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "UID")
    private Integer uid;

    public Answer() {
    }

    public Answer(Integer aid) {
        this.aid = aid;
    }

    public Answer(Integer aid, int qid) {
        this.aid = aid;
        this.qid = qid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCountvotes() {
        return countvotes;
    }

    public void setCountvotes(Integer countvotes) {
        this.countvotes = countvotes;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aid != null ? aid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        if ((this.aid == null && other.aid != null) || (this.aid != null && !this.aid.equals(other.aid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simplestackexchange.entity.Answer[ aid=" + aid + " ]";
    }
    
}
