/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnswerModel;

import javax.xml.bind.annotation.*;

/**
 *
 * @author user
 */
@XmlRootElement(name = "Answer")
public class Answer {
    
    @XmlElement(name="answerid", required=true)
    private int answerID;
    @XmlElement(name="questionid", required=true)
    private int questionID;
    @XmlElement(name="userid", required=true)
    private int userID;
    @XmlElement(name="content", required=true)
    private String content;
    @XmlElement(name="vote", required=true)
    private int vote;
    @XmlElement(name="timestamp", required=true)
    private String timestamp;
    
    public Answer() {
        answerID = 0;
        questionID = 0;
        userID = 0;
        vote = 0;
    }
    
    public Answer(int aid, int qid, int uid, String content, int vote, String timestamp) {
        answerID = aid;
        questionID = qid;
        userID = uid;
        this.content = content;
        this.vote = vote;
        this.timestamp = timestamp;
    }
    /*
    public void setAnswer(int aid, int qid, int uid, String content, int vote, String timestamp) {
        answerID = aid;
        questionID = qid;
        userID = uid;
        this.content = content;
        this.vote = vote;
        this.timestamp = timestamp;
    }
    
    public void setAID(int aid) {
        answerID = aid;
    }
    
    public void setQID(int qid) {
        questionID = qid;
    }
    
    public void setUID(int uid) {
        userID = uid;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public void setVote(int vote) {
        this.vote = vote;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public int getAID() {
        return answerID;
    }
    
    public int getQID() {
        return questionID;
    }
    
    public int getUID() {
        return userID;
    }
    
    public String getContent() {
        return content;
    }
    
    public int getVote() {
        return vote;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    */
}
