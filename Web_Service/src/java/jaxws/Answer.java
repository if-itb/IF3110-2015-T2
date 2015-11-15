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
@XmlRootElement(name = "Answer") public class Answer {  
  @XmlElement(name="id", required=true)  
  private int id;  
  @XmlElement(name="qid", required=true)  
  private int qid;   
  @XmlElement(name="username", required=true)   
  private String username;   
  @XmlElement(name="isi", required=true)   
  private String isi;   
  @XmlElement(name="datetime", required=true)  
  private String datetime;        
  public Answer() { 
      id = 0;     
      qid = 0;      
  }      
  public Answer(int id, int qid, String username, 
          String isi, String datetime) {
      this.id = id;     
      this.qid = qid;     
      this.username = username;     
      this.isi = isi;     
      this.datetime = datetime;   
  }    
  public int getId(){
      return id;
  }
  public int getQId(){
      return qid;
  }
  public String getUsername(){
      return username;
  }
  public String getIsi(){
      return isi;
  }
  public String getDatetime(){
      return datetime;
  }
  
   
  
}
