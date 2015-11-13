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
    
    public Question(int _id, String _topic, String _content, String _username, String _timestamp, int _votes) {
        q_id = _id;
        q_topic = _topic;
        q_content = _content;
        q_name = _username;
        q_datetime = _timestamp;
        q_vote = _votes;
    }
    
    public String getContent() {
        return q_content;
    }
}
