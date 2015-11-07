/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Asus
 */
@Embeddable
public class VoteQuestionPK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Column(name = "id_user")
  private int idUser;
  @Basic(optional = false)
  @NotNull
  @Column(name = "id_question")
  private int idQuestion;

  public VoteQuestionPK() {
  }

  public VoteQuestionPK(int idUser, int idQuestion) {
    this.idUser = idUser;
    this.idQuestion = idQuestion;
  }

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public int getIdQuestion() {
    return idQuestion;
  }

  public void setIdQuestion(int idQuestion) {
    this.idQuestion = idQuestion;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) idUser;
    hash += (int) idQuestion;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof VoteQuestionPK)) {
      return false;
    }
    VoteQuestionPK other = (VoteQuestionPK) object;
    if (this.idUser != other.idUser) {
      return false;
    }
    if (this.idQuestion != other.idQuestion) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "org.me.entities.VoteQuestionPK[ idUser=" + idUser + ", idQuestion=" + idQuestion + " ]";
  }
  
}
