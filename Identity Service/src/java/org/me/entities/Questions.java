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
@Table(name = "questions")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Questions.findAll", query = "SELECT q FROM Questions q"),
  @NamedQuery(name = "Questions.findById", query = "SELECT q FROM Questions q WHERE q.id = :id"),
  @NamedQuery(name = "Questions.findByTopic", query = "SELECT q FROM Questions q WHERE q.topic = :topic"),
  @NamedQuery(name = "Questions.findByTimestamp", query = "SELECT q FROM Questions q WHERE q.timestamp = :timestamp")})
public class Questions implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "topic")
  private String topic;
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
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "questions")
  private Collection<VoteQuestion> voteQuestionCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idQuestion")
  private Collection<Answers> answersCollection;
  @JoinColumn(name = "id_user", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Users idUser;

  public Questions() {
  }

  public Questions(Integer id) {
    this.id = id;
  }

  public Questions(Integer id, String topic, String content, Date timestamp) {
    this.id = id;
    this.topic = topic;
    this.content = content;
    this.timestamp = timestamp;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  @XmlTransient
  public Collection<VoteQuestion> getVoteQuestionCollection() {
    return voteQuestionCollection;
  }

  public void setVoteQuestionCollection(Collection<VoteQuestion> voteQuestionCollection) {
    this.voteQuestionCollection = voteQuestionCollection;
  }

  @XmlTransient
  public Collection<Answers> getAnswersCollection() {
    return answersCollection;
  }

  public void setAnswersCollection(Collection<Answers> answersCollection) {
    this.answersCollection = answersCollection;
  }

  public Users getIdUser() {
    return idUser;
  }

  public void setIdUser(Users idUser) {
    this.idUser = idUser;
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
    if (!(object instanceof Questions)) {
      return false;
    }
    Questions other = (Questions) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "org.me.entities.Questions[ id=" + id + " ]";
  }
  
}
