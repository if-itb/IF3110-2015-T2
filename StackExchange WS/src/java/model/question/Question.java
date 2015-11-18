package model.question;

import javax.xml.bind.annotation.*;

/**
 *
 * @author Asanilta
 */

@XmlRootElement(name = "Question")
public class Question {
    
    @XmlElement(name="question_id", required=true)
    private int question_id;
    @XmlElement(name="topic", required=true)
    private String topic;
    @XmlElement(name="content", required=true)
    private String content;
    @XmlElement(name="user_id", required=true)
    private int user_id;
    @XmlElement(name="create_time", required=true)
    private String create_time;
    @XmlElement(name="vote", required=true)
    private int vote;
    
    public Question() {
        question_id = 0;
        user_id = 0;
        vote = 0;
    }
    public Question(int question_id, String topic, String content, int user_id, String create_time, int vote) {
        this.question_id = question_id;
        this.topic = topic;
        this.content = content;
        this.user_id = user_id;
        this.create_time = create_time;
        this.vote = vote;
    }
    
    public int getQuestionID() {
        return question_id;
    }
    
    public String getTopic() {
        return topic;
    }
    
    public String getContent() {
        return content;
    }
    
    public int getUserId() {
        return user_id;
    }
    
    public String getCreateTime() {
        return create_time;
    }
    
    public int getVote() {
        return vote;
    }
}
