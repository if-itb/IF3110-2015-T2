/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnswerModel;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Devina
 */
@XmlRootElement(name = "Answer")

public class Answer {
  @XmlElement(name="id_answer", required=true)
  private int idAnswer;
  @XmlElement(name="id_question", required=true)
  private int idQuestion;
  @XmlElement(name="id_user", required=true)
  private int idUser;
  @XmlElement(name="content", required=true)
  private String content;
  @XmlElement(name="datetime", required=true)
  private String datetime;
  
  public Answer() { 
    idAnswer = 0; 
    idQuestion = 0; 
    idUser = 0; 
  } 
  
  public Answer(int idAnswer, String content, String datetime, int uid, int qid) {
    this.idAnswer = idAnswer; 
    idQuestion = qid; 
    idUser = uid; 
    this.content = content; 
    this.datetime = datetime; 
  }
}
