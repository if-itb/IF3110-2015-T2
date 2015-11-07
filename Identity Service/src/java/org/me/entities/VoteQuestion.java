/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "vote_question")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "VoteQuestion.findAll", query = "SELECT v FROM VoteQuestion v"),
  @NamedQuery(name = "VoteQuestion.findByIdUser", query = "SELECT v FROM VoteQuestion v WHERE v.voteQuestionPK.idUser = :idUser"),
  @NamedQuery(name = "VoteQuestion.findByIdQuestion", query = "SELECT v FROM VoteQuestion v WHERE v.voteQuestionPK.idQuestion = :idQuestion"),
  @NamedQuery(name = "VoteQuestion.findByValue", query = "SELECT v FROM VoteQuestion v WHERE v.value = :value")})
public class VoteQuestion implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected VoteQuestionPK voteQuestionPK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "value")
  private int value;
  @JoinColumn(name = "id_user", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Users users;
  @JoinColumn(name = "id_question", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Questions questions;

  public VoteQuestion() {
  }

  public VoteQuestion(VoteQuestionPK voteQuestionPK) {
    this.voteQuestionPK = voteQuestionPK;
  }

  public VoteQuestion(VoteQuestionPK voteQuestionPK, int value) {
    this.voteQuestionPK = voteQuestionPK;
    this.value = value;
  }

  public VoteQuestion(int idUser, int idQuestion) {
    this.voteQuestionPK = new VoteQuestionPK(idUser, idQuestion);
  }

  public VoteQuestionPK getVoteQuestionPK() {
    return voteQuestionPK;
  }

  public void setVoteQuestionPK(VoteQuestionPK voteQuestionPK) {
    this.voteQuestionPK = voteQuestionPK;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  public Questions getQuestions() {
    return questions;
  }

  public void setQuestions(Questions questions) {
    this.questions = questions;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (voteQuestionPK != null ? voteQuestionPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof VoteQuestion)) {
      return false;
    }
    VoteQuestion other = (VoteQuestion) object;
    if ((this.voteQuestionPK == null && other.voteQuestionPK != null) || (this.voteQuestionPK != null && !this.voteQuestionPK.equals(other.voteQuestionPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "org.me.entities.VoteQuestion[ voteQuestionPK=" + voteQuestionPK + " ]";
  }
  
}
