/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dazzlesquad.question_package;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="Answer")

/**
 *
 * @author ryanyonata
 */
public class Question {
    @XmlElement(name="id", required=true)
    private int id;
    
    @XmlElement(name="user_id", required=true)
    private int userId;
    
    @XmlElement(name="topic", required=true)
    private String topic;
    
    @XmlElement(name="content", required=true)
    private String content;
    
    @XmlElement(name="vote", required=true)
    private int vote;
    
    @XmlElement(name="date", required=true)
    private String date;
    
    public Question() {
        id=0;
        userId = 0;
    }
    
    public Question(int id, int uid, String topic, String content, int vote, String date){
        this.id=id;
        this.userId = uid;
        this.topic = topic;
        this.content = content;
        this.vote=vote;
        this.date = date;
    }
    
    
    /* Getter */
    public int getQuestionId() {
        return this.id;
    }
    
    public int getQuestionUserId() {
        return this.userId;
    }
    
    public String getQuestionTopic() {
        return this.topic;
    }
    
    public String getQuestionContent() {
        return this.content;
    }
    
    public int getQuestionVote() {
        return this.vote;
    }
    
    public String getQuestionDate() {
        return this.date;
    }
}
