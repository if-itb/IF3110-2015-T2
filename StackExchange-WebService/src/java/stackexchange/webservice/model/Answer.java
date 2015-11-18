/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackexchange.webservice.model;

import java.util.Date;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author fauzanrifqy
 */
@XmlRootElement(name="Answer")
public class Answer {
    @XmlElement(name="id", required=true)
    private int id;
    @XmlElement(name="questionId", required=true)
    private int questionId;
    @XmlElement(name="name", required=true)
    private String name;
    @XmlElement(name="email", required=true)
    private String email;
    @XmlElement(name="content", required=true)
    private String content;
    @XmlElement(name="dateMade", required=true)
    private Date dateMade;
    @XmlElement(name="errorMessage", required=true)
    private String errorMessage;
    @XmlElement(name="vote", required=true)
    private int vote;
    
    public Answer(){
        id = 0;
        questionId = 0;
    }
    
    public Answer(int id, int questionId, String name, String email, String content, Date dateMade, String errorMessage, int vote){
        this.id = id;
        this.questionId = questionId;
        this.name = name;
        this.email = email;
        this.content = content;
        this.dateMade = dateMade;
        this.errorMessage = errorMessage;
        this.vote = vote;
    } 

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the questionId
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the dateMade
     */
    public Date getDateMade() {
        return dateMade;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @return the vote
     */
    public int getVote() {
        return vote;
    }
}
