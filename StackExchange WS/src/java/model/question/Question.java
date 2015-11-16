/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.question;

import javax.xml.bind.annotation.*;

/**
 *
 * @author visat
 */
@XmlRootElement(name = "Question")
public class Question {
    @XmlElement(name = "id", required = true)
    private int id;
    @XmlElement(name = "id_user", required = true)
    private int idUser;
    @XmlElement(name = "topic", required = true)
    private String topic;
    @XmlElement(name = "content", required = true)
    private String content;
    @XmlElement(name = "votes", required = true)
    private int votes;
    @XmlElement(name = "date", required = true)
    private String date;    
    
    private Question() {
        
    }
    
    public Question(int id, int id_user, String topic, String content,
            int votes, String date) {
        this.id = id;
        this.idUser = id_user;
        this.topic = topic;
        this.content = content;
        this.votes = votes;
        this.date = date;
    }    
}
