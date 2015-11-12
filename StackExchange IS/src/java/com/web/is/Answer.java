/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.is;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "answer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a"),
    @NamedQuery(name = "Answer.findByIDAns", query = "SELECT a FROM Answer a WHERE a.iDAns = :iDAns"),
    @NamedQuery(name = "Answer.findByIdq", query = "SELECT a FROM Answer a WHERE a.idq = :idq"),
    @NamedQuery(name = "Answer.findByNama", query = "SELECT a FROM Answer a WHERE a.nama = :nama"),
    @NamedQuery(name = "Answer.findByVote", query = "SELECT a FROM Answer a WHERE a.vote = :vote")})
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAns")
    private Integer iDAns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDQ")
    private int idq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nama")
    private String nama;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Answer")
    private String answer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vote")
    private int vote;

    public Answer() {
    }

    public Answer(Integer iDAns) {
        this.iDAns = iDAns;
    }

    public Answer(Integer iDAns, int idq, String nama, String email, String answer, int vote) {
        this.iDAns = iDAns;
        this.idq = idq;
        this.nama = nama;
        this.email = email;
        this.answer = answer;
        this.vote = vote;
    }

    public Integer getIDAns() {
        return iDAns;
    }

    public void setIDAns(Integer iDAns) {
        this.iDAns = iDAns;
    }

    public int getIdq() {
        return idq;
    }

    public void setIdq(int idq) {
        this.idq = idq;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDAns != null ? iDAns.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        if ((this.iDAns == null && other.iDAns != null) || (this.iDAns != null && !this.iDAns.equals(other.iDAns))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.is.Answer[ iDAns=" + iDAns + " ]";
    }
    
}
