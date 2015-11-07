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
@Table(name = "vote_answer")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "VoteAnswer.findAll", query = "SELECT v FROM VoteAnswer v"),
  @NamedQuery(name = "VoteAnswer.findByIdUser", query = "SELECT v FROM VoteAnswer v WHERE v.voteAnswerPK.idUser = :idUser"),
  @NamedQuery(name = "VoteAnswer.findByIdAnswer", query = "SELECT v FROM VoteAnswer v WHERE v.voteAnswerPK.idAnswer = :idAnswer"),
  @NamedQuery(name = "VoteAnswer.findByValue", query = "SELECT v FROM VoteAnswer v WHERE v.value = :value")})
public class VoteAnswer implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected VoteAnswerPK voteAnswerPK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "value")
  private int value;
  @JoinColumn(name = "id_answer", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Answers answers;
  @JoinColumn(name = "id_user", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Users users;

  public VoteAnswer() {
  }

  public VoteAnswer(VoteAnswerPK voteAnswerPK) {
    this.voteAnswerPK = voteAnswerPK;
  }

  public VoteAnswer(VoteAnswerPK voteAnswerPK, int value) {
    this.voteAnswerPK = voteAnswerPK;
    this.value = value;
  }

  public VoteAnswer(int idUser, int idAnswer) {
    this.voteAnswerPK = new VoteAnswerPK(idUser, idAnswer);
  }

  public VoteAnswerPK getVoteAnswerPK() {
    return voteAnswerPK;
  }

  public void setVoteAnswerPK(VoteAnswerPK voteAnswerPK) {
    this.voteAnswerPK = voteAnswerPK;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Answers getAnswers() {
    return answers;
  }

  public void setAnswers(Answers answers) {
    this.answers = answers;
  }

  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (voteAnswerPK != null ? voteAnswerPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof VoteAnswer)) {
      return false;
    }
    VoteAnswer other = (VoteAnswer) object;
    if ((this.voteAnswerPK == null && other.voteAnswerPK != null) || (this.voteAnswerPK != null && !this.voteAnswerPK.equals(other.voteAnswerPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "org.me.entities.VoteAnswer[ voteAnswerPK=" + voteAnswerPK + " ]";
  }
  
}
