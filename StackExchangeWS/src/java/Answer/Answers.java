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
@XmlRootElement(name="Answers")
public class Answers {
    @XmlElement(name="answer-id", required=true)
    private int answer_id;
    @XmlElement(name="answer-uid", required=true)
    private int answer_uid;
    @XmlElement(name="answer-qid", required=true)
    private int answer_qid;
    @XmlElement(name="answer-content", required=true)
    private String answer_content;
    @XmlElement(name="answer-timestamp", required=true)
    private String answer_timestamp;
    
    /**
     * Constructor for Answer
     */
    public Answers() {
       answer_id = 0;
    }
    
    public Answers(int _id, int _uid, int _qid, String _content, String _timestamp) {
        answer_id = _id;
        answer_uid = _uid;
        answer_qid = _qid;
        answer_content = _content;
        answer_timestamp = _timestamp;
    }

    /**
     * @return the id
     */
    public int getAnswerId() {
        return answer_id;
    }

    /**
     * @param id the id to set
     */
    public void setAnswerId(int id) {
        this.answer_id = id;
    }

    /**
     * @return the uid
     */
    public int getAnswerUid() {
        return answer_uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setAnswerUid(int uid) {
        this.answer_uid = uid;
    }

    /**
     * @return the qid
     */
    public int getAnswerQid() {
        return answer_qid;
    }

    /**
     * @param qid the qid to set
     */
    public void setAnswerQid(int qid) {
        this.answer_qid = qid;
    }

    /**
     * @return the content
     */
    public String getAnswerContent() {
        return answer_content;
    }

    /**
     * @param content the content to set
     */
    public void setAnswerContent(String content) {
        this.answer_content = content;
    }

    /**
     * @return the timestamp
     */
    public String getAnswerTimestamp() {
        return answer_timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setAnswerTimestamp(String timestamp) {
        this.answer_timestamp = timestamp;
    }

}
