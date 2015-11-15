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
@Table(name = "QUESTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findByQid", query = "SELECT q FROM Question q WHERE q.qid = :qid"),
    @NamedQuery(name = "Question.findByUid", query = "SELECT q FROM Question q WHERE q.uid = :uid"),
    @NamedQuery(name = "Question.findByTopic", query = "SELECT q FROM Question q WHERE q.topic = :topic"),
    @NamedQuery(name = "Question.findByDatetime", query = "SELECT q FROM Question q WHERE q.datetime = :datetime"),
    @NamedQuery(name = "Question.findByCountanswers", query = "SELECT q FROM Question q WHERE q.countanswers = :countanswers"),
    @NamedQuery(name = "Question.findByCountvotes", query = "SELECT q FROM Question q WHERE q.countvotes = :countvotes")})
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "QID")
    private Integer qid;
    @Column(name = "UID")
    private Integer uid;
    @Size(max = 200)
    @Column(name = "TOPIC")
    private String topic;
    @Lob
    @Size(max = 32700)
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "COUNTANSWERS")
    private Integer countanswers;
    @Column(name = "COUNTVOTES")
    private Integer countvotes;

    public Question() {
    }

    public Question(Integer qid) {
        this.qid = qid;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getCountanswers() {
        return countanswers;
    }

    public void setCountanswers(Integer countanswers) {
        this.countanswers = countanswers;
    }

    public Integer getCountvotes() {
        return countvotes;
    }

    public void setCountvotes(Integer countvotes) {
        this.countvotes = countvotes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qid != null ? qid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.qid == null && other.qid != null) || (this.qid != null && !this.qid.equals(other.qid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simplestackexchange.entity.Question[ qid=" + qid + " ]";
    }
    
}
