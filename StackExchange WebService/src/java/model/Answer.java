/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.*;

/**
 *
 * @author vanyadeasysafrina
 */
public class Answer {
    @XmlElement(name="a_id", required=true)
    private int aId;
    @XmlElement(name="u_id", required=true)
    private int uId;
    @XmlElement(name="content", required=true)
    private String content;
    @XmlElement(name="vote", required=true)
    private int vote;
    @XmlElement(name="date_created", required=true)
    private String dateCreated;
    @XmlElement(name="q_id", required=true)
    private int qId;
    
    public Answer() {
        
    }

    public Answer(int aId, int uId, String content, int vote, String dateCreated, int qId) {
        this.aId = aId;
        this.uId = uId;
        this.content = content;
        this.vote = vote;
        this.dateCreated = dateCreated;
        this.qId = qId;
    }

    /**
     * @return the aId
     */
    public int getaId() {
        return aId;
    }

    /**
     * @return the uId
     */
    public int getuId() {
        return uId;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the vote
     */
    public int getVote() {
        return vote;
    }

    /**
     * @return the dateCreated
     */
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     * @return the qId
     */
    public int getqId() {
        return qId;
    }
}
