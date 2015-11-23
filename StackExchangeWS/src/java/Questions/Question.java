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
    
    @XmlElement(name="question-id", required=true)
    private int question_id;
    @XmlElement(name="question-uid", required=true)
    private int question_uid;
    @XmlElement(name="question-topic", required=true)
    private String question_topic;
    @XmlElement(name="question-content", required=true)
    private String question_content;
    @XmlElement(name="question-timestamp", required=true)
    private String question_timestamp;
    
    
    /**
     * Constructor for Answer
     */
    public Question() {
       question_id = 0;
    }
    
    public Question(int _id, int _uid, String _topic, String _content, String _timestamp) {
        question_id = _id;
        question_uid = _uid;
        question_topic = _topic;
        question_content = _content;
        question_timestamp = _timestamp;
    }

    /**
     * @return the id
     */
    public int getQuestionId() {
        return question_id;
    }

    /**
     * @param id the id to set
     */
    public void setQuestionId(int id) {
        this.question_id = id;
    }

    /**
     * @return the uid
     */
    public int getQuestionUid() {
        return question_uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setQuestionUid(int uid) {
        this.question_uid = uid;
    }

    /**
     * @return the topic
     */
    public String getQuestionTopic() {
        return question_topic;
    }

    /**
     * @param topic the topic to set
     */
    public void setQuestionTopic(String topic) {
        this.question_topic = topic;
    }

    /**
     * @return the content
     */
    public String getQuestionContent() {
        return question_content;
    }

    /**
     * @param content the content to set
     */
    public void setQuestionContent(String content) {
        this.question_content = content;
    }

    /**
     * @return the timestamp
     */
    public String getQuestionTimestamp() {
        return question_timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setQuestionTimestamp(String timestamp) {
        this.question_timestamp = timestamp;
    }

    
}
