/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackExchangeWS;

import javax.xml.bind.annotation.*;

/**
 *
 * @author Calvin
 */
@XmlRootElement(name="Question")
public class Question {
    @XmlElement(name="id", required=true)
    private int id;
    
    @XmlElement(name="userId", required=true)
    private int userId;
    
    @XmlElement(name="topic", required=true)
    private String topic;
    
    @XmlElement(name="content", required=true)
    private String content;
    
    @XmlElement(name="vote", required=true)
    private int vote;
    
    public Question() {
        id = 0;
        userId = 0;
        vote = 0;
    }
    
    public Question(int id, int userId, String topic, String content, int vote) {
        this.id = id;
        this.userId = userId;
        this.topic = topic;
        this.content = content;
        this.vote = vote;
    }
}
