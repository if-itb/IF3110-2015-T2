/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxws;

/**
 *
 * @author gazandic
 */
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;  

@XmlRootElement(name = "Answer") public class Answer {  
  @XmlElement(name="id", required=true)  
  private int id;  
  @XmlElement(name="qid", required=true)  
  private int qid;   
  @XmlElement(name="uid", required=true)   
  private int uid;   
  @XmlElement(name="username", required=true)   
  private String username; 
  @XmlElement(name="content", required=true)   
  private String content;   
  @XmlElement(name="datetime", required=true)  
  private String datetime;  
  @XmlElement(name="vote", required=true)  
  private int vote;
  public Answer() { 
      id = 0;     
      qid = 0;  
      vote = 0;
  }      
  public Answer(int id, int qid, int uid, String username, 
          String content, String datetime, int vote) {
      this.id = id;     
      this.qid = qid;     
      this.uid = uid; 
      this.username = username;
      this.content = content;     
      this.datetime = datetime;  
      this.vote = vote;
  }    
  public int getId(){
      return id;
  }
  public int getQId(){
      return qid;
  }
  public int getUid(){
      return uid;
  }
  public String getEmail(){
      return username;
  }
  public String getContent(){
      return content;
  }
  public String getDatetime(){
      return datetime;
  }
  public int getVote(){
      return vote;
  }
  
  public ArrayList<Answer> fetchAnswers(ResultSet rs) {
    ArrayList<Answer> ret = new ArrayList<Answer>();
    try {
      DB db = new DB();
      while(rs.next()) {
        ret.add(new Answer( rs.getInt("answer.id"),                                  
                rs.getInt("qid"),                                  
                rs.getInt("uid"), 
                rs.getString("user.username"), 
                rs.getString("content"),                                  
                rs.getString("date"),
                rs.getInt("vote")
        ));  
      }
    } catch(Throwable e) {
      e.printStackTrace();
    }
    return ret;
  }
}
