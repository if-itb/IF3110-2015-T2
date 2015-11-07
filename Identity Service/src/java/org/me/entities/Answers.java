/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "answers")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Answers.findAll", query = "SELECT a FROM Answers a"),
  @NamedQuery(name = "Answers.findById", query = "SELECT a FROM Answers a WHERE a.id = :id"),
  @NamedQuery(name = "Answers.findByIdUser", query = "SELECT a FROM Answers a WHERE a.idUser = :idUser"),
  @NamedQuery(name = "Answers.findByTimestamp", query = "SELECT a FROM Answers a WHERE a.timestamp = :timestamp")})
public class Answers implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "id_user")
  private int idUser;
  @Basic(optional = false)
  @NotNull
  @Lob
  @Size(min = 1, max = 65535)
  @Column(name = "content")
  private String content;
  @Basic(optional = false)
  @NotNull
  @Column(name = "timestamp")
  @Temporal(TemporalType.TIMESTAMP)
  private Date timestamp;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "answers")
  private Collection<VoteAnswer> voteAnswerCollection;
  @JoinColumn(name = "id_question", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Questions idQuestion;

  public Answers() {
  }

  public Answers(Integer id) {
    this.id = id;
  }

  public Answers(Integer id, int idUser, String content, Date timestamp) {
    this.id = id;
    this.idUser = idUser;
    this.content = content;
    this.timestamp = timestamp;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  @XmlTransient
  public Collection<VoteAnswer> getVoteAnswerCollection() {
    return voteAnswerCollection;
  }

  public void setVoteAnswerCollection(Collection<VoteAnswer> voteAnswerCollection) {
    this.voteAnswerCollection = voteAnswerCollection;
  }

  public Questions getIdQuestion() {
    return idQuestion;
  }

  public void setIdQuestion(Questions idQuestion) {
    this.idQuestion = idQuestion;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Answers)) {
      return false;
    }
    Answers other = (Answers) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "org.me.entities.Answers[ id=" + id + " ]";
  }
  
}
