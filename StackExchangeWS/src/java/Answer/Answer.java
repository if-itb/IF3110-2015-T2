/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Answer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmad Naufal Farhan
 */
@XmlRootElement(name="Answer")
public class Answer {
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
    public Answer() {
       answer_id = 0;
    }
    
    public Answer(int _id, int _uid, int _qid, String _content, String _timestamp) {
        answer_id = _id;
        answer_uid = _uid;
        answer_qid = _qid;
        answer_content = _content;
        answer_timestamp = _timestamp;
    }

    /**
     * @return the answer_id
     */
    public int getAnswer_id() {
        return answer_id;
    }

    /**
     * @param answer_id the answer_id to set
     */
    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    /**
     * @return the answer_uid
     */
    public int getAnswer_uid() {
        return answer_uid;
    }

    /**
     * @param answer_uid the answer_uid to set
     */
    public void setAnswer_uid(int answer_uid) {
        this.answer_uid = answer_uid;
    }

    /**
     * @return the answer_qid
     */
    public int getAnswer_qid() {
        return answer_qid;
    }

    /**
     * @param answer_qid the answer_qid to set
     */
    public void setAnswer_qid(int answer_qid) {
        this.answer_qid = answer_qid;
    }

    /**
     * @return the answer_content
     */
    public String getAnswer_content() {
        return answer_content;
    }

    /**
     * @param answer_content the answer_content to set
     */
    public void setAnswer_content(String answer_content) {
        this.answer_content = answer_content;
    }

    /**
     * @return the answer_timestamp
     */
    public String getAnswer_timestamp() {
        return answer_timestamp;
    }

    /**
     * @param answer_timestamp the answer_timestamp to set
     */
    public void setAnswer_timestamp(String answer_timestamp) {
        this.answer_timestamp = answer_timestamp;
    }

}
