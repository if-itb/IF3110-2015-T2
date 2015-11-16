/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import javax.xml.bind.annotation.*;

/**
 *
 * @author Ahmad Naufal Farhan
 */
@XmlRootElement(name="Question")
public class Question {
    
    @XmlElement(name="q_id", required=true)
    private int q_id;
    @XmlElement(name="q_topic", required=true)
    private String q_topic;
    @XmlElement(name="q_content", required=true)
    private String q_content;
    @XmlElement(name="q_name", required=true)
    private String q_name;
    @XmlElement(name="q_email", required=true)
    private String q_email;
    @XmlElement(name="q_datetime", required=true)
    private String q_datetime;
    @XmlElement(name="q_vote", required=true)
    private int q_vote;
    
    /**
     * Constructor for Answer
     */
    public Question() {
       q_id = 0;
    }
    
    public Question(int _id, String _topic, String _content, String _name, String _email, String _timestamp, int _votes) {
        q_id = _id;
        q_topic = _topic;
        q_content = _content;
        q_name = _name;
        q_email = _email;
        q_datetime = _timestamp;
        q_vote = _votes;
    }

    /**
     * @return the q_id
     */
    public int getId() {
        return q_id;
    }

    /**
     * @return the q_topic
     */
    public String getTopic() {
        return q_topic;
    }

    /**
     * @return the q_content
     */
    public String getContent() {
        return q_content;
    }

    /**
     * @return the q_name
     */
    public String getName() {
        return q_name;
    }

    /**
     * @return the q_email
     */
    public String getEmail() {
        return q_email;
    }

    /**
     * @return the q_datetime
     */
    public String getDatetime() {
        return q_datetime;
    }

    /**
     * @return the q_vote
     */
    public int getVote() {
        return q_vote;
    }
}
