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
import javax.xml.bind.*; import javax.xml.bind.annotation.*;  
@XmlRootElement(name = "Question") public class Question {  
  @XmlElement(name="id", required=true)  
  private int id;    
  @XmlElement(name="uid", required=true)   
  private int uid;   
  @XmlElement(name="username", required=true)   
  private String username; 
  @XmlElement(name="topic", required=true)   
  private String topic;
  @XmlElement(name="content", required=true)   
  private String content;   
  @XmlElement(name="datetime", required=true)  
  private String datetime;   
  @XmlElement(name="vote", required=true)  
  private int vote; 
  @XmlElement(name="sumAns", required=true)  
  private int sumAns; 
  public Question() { 
      id = 0;          
      vote = 0;
      sumAns = 0;
  }      
  public Question(int id, int uid, String username, String topic,
          String content, String datetime, int vote, int sumAns) {
      this.id = id;      
      this.uid = uid; 
      this.username = username;
      this.topic = topic;
      this.content = content;     
      this.datetime = datetime;  
      this.vote = vote;
      this.sumAns = sumAns;
  }    
  public int getId(){
      return id;
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
  public String getTopic(){
      return topic;
  }
  public String getDatetime(){
      return datetime;
  }
  public int getVote(){
      return vote;
  }
  
  
}
