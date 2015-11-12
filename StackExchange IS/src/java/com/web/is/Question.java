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
@Table(name = "question")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findByIdq", query = "SELECT q FROM Question q WHERE q.idq = :idq"),
    @NamedQuery(name = "Question.findByNama", query = "SELECT q FROM Question q WHERE q.nama = :nama"),
    @NamedQuery(name = "Question.findByQuestionTopic", query = "SELECT q FROM Question q WHERE q.questionTopic = :questionTopic"),
    @NamedQuery(name = "Question.findByVote", query = "SELECT q FROM Question q WHERE q.vote = :vote")})
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDQ")
    private Integer idq;
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
    @Size(min = 1, max = 30)
    @Column(name = "QuestionTopic")
    private String questionTopic;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vote")
    private int vote;

    public Question() {
    }

    public Question(Integer idq) {
        this.idq = idq;
    }

    public Question(Integer idq, String nama, String email, String questionTopic, String content, int vote) {
        this.idq = idq;
        this.nama = nama;
        this.email = email;
        this.questionTopic = questionTopic;
        this.content = content;
        this.vote = vote;
    }

    public Integer getIdq() {
        return idq;
    }

    public void setIdq(Integer idq) {
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

    public String getQuestionTopic() {
        return questionTopic;
    }

    public void setQuestionTopic(String questionTopic) {
        this.questionTopic = questionTopic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        hash += (idq != null ? idq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.idq == null && other.idq != null) || (this.idq != null && !this.idq.equals(other.idq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.web.is.Question[ idq=" + idq + " ]";
    }
    
}
