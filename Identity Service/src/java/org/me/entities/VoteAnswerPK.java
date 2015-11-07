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
public class VoteAnswerPK implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Column(name = "id_user")
  private int idUser;
  @Basic(optional = false)
  @NotNull
  @Column(name = "id_answer")
  private int idAnswer;

  public VoteAnswerPK() {
  }

  public VoteAnswerPK(int idUser, int idAnswer) {
    this.idUser = idUser;
    this.idAnswer = idAnswer;
  }

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public int getIdAnswer() {
    return idAnswer;
  }

  public void setIdAnswer(int idAnswer) {
    this.idAnswer = idAnswer;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) idUser;
    hash += (int) idAnswer;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof VoteAnswerPK)) {
      return false;
    }
    VoteAnswerPK other = (VoteAnswerPK) object;
    if (this.idUser != other.idUser) {
      return false;
    }
    if (this.idAnswer != other.idAnswer) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "org.me.entities.VoteAnswerPK[ idUser=" + idUser + ", idAnswer=" + idAnswer + " ]";
  }
  
}
