/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Answer;

import javax.xml.bind.annotation.*;
/**
 *
 * @author mochamadtry
 */
@XmlRootElement(name="Answer")
public class Answers {
    @XmlElement(name="a_id", required=true)
    private int a_id;
    @XmlElement(name="a_name", required=true)
    private String a_name;
    @XmlElement(name="a_email", required=true)
    private String a_email;
    @XmlElement(name="a_qid", required=true)
    private int a_qid;
    @XmlElement(name="a_content", required=true)
    private String a_content;
    @XmlElement(name="a_datetime", required=true)
    private String a_datetime;
    @XmlElement(name="a_vote", required=true)
    private int a_vote;
    
    /**
     * Constructor for Answer
     */
    public Answers() {
       a_id = 0;
    }
    
    public Answers(int _id, int _qid, String _content, String _name, String _email, String _timestamp, int _votes) {
        a_id = _id;
        a_content = _content;
        a_name = _name;
        a_email = _email;
        a_datetime = _timestamp;
        a_vote = _votes;
        a_qid = _qid; 
    }

    /**
     * @return the q_id
     */
    public int getId() {
        return a_id;
    }

    /**
     * @return the q_topic
     */
    /*public String getTopic() {
        return a_topic;
    }*/

    /**
     * @return the q_content
     */
    public String getContent() {
        return a_content;
    }

    /**
     * @return the q_name
     */
    public String getName() {
        return a_name;
    }

    /**
     * @return the q_email
     */
    public String getEmail() {
        return a_email;
    }
    
     /**
     * @return the q_datetime
     */
    public String getDatetime() {
        return a_datetime;
    }

    /**
     * @return the q_datetime
     */
    public int getQid() {
        return a_qid;
    }

    /**
     * @return the q_vote
     */
    public int getVote() {
        return a_vote;
    }
    
}
