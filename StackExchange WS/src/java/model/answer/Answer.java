/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.answer;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Venny
 */
public class Answer {
    @XmlElement(name="answer_id", required=true)
    private int answer_id;
    @XmlElement(name="question_id", required=true)
    private int question_id;
    @XmlElement(name="user_id", required=true)
    private int user_id;
    @XmlElement(name="content", required=true)
    private String content;
    @XmlElement(name="vote", required=false)
    private int vote;
    @XmlElement(name="create_time", required=true)
    private String create_time;
    
    public Answer(){
        answer_id=0;
        question_id=0;
        user_id=0;
        vote=0;
    }
    
    public Answer(int aid, int qid, int uid, String content, int vote, String create_time) {
           answer_id = aid;
           question_id = qid;
           user_id = uid; 
           this.vote = vote;
           this.content = content;
           this.create_time = create_time; 
    }
}
