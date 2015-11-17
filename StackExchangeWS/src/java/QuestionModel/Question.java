/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionModel;

import javax.xml.bind.annotation.*;

/**
 *
 * @author user
 */
@XmlRootElement(name = "Question")
public class Question {
    
    @XmlElement(name="questionid", required=true)
    private int questionID;
    @XmlElement(name="userid", required=true)
    private int userID;
    @XmlElement(name="topic", required=true)
    private String topic;
    @XmlElement(name="content", required=true)
    private String content;
    @XmlElement(name="vote", required=true)
    private int vote;
    @XmlElement(name="timestamp", required=true)
    private String timestamp;
    @XmlElement(name="answer_count", required=true)
    private int answer_count;
    
    public Question() {
        questionID = 0;
        userID = 0;
        vote = 0;
        answer_count = 0;
    }
    
    public Question(int qid, int uid, String topic, String content, int vote, String timestamp, int ans_count) {
        questionID = qid;
        userID = uid;
        this.topic = topic;
        this.content = content;
        this.vote = vote;
        this.timestamp = timestamp;
        answer_count = ans_count;
    }
    
    public void setQuestion(int qid, int uid, String topic, String content, int vote, String timestamp, int ans_count) {
        questionID = qid;
        userID = uid;
        this.topic = topic;
        this.content = content;
        this.vote = vote;
        this.timestamp = timestamp;
        answer_count = ans_count;
    }
    
    public void setQID(int qid) {
        questionID = qid;
    }
    
    public void setUID(int uid) {
        userID = uid;
    }
    
    public void setTopic(String topic) {
        this.topic = topic;
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
    
    public void setAnswerCount(int ans_count) {
        answer_count = ans_count;
    }
    
    public int getQID() {
        return questionID;
    }
    
    public int getUID() {
        return userID;
    }
    
    public String getTopic() {
        return topic;
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
    
    public int getAnswerCount() {
        return answer_count;
    }
    
}
