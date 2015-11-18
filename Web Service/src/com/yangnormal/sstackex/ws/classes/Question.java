package com.yangnormal.sstackex.ws.classes;
import java.sql.Date;

/**
 * Created by Julio Savigny on 11/17/2015.
 */
public class Question {
    public Question() {
        user = new User();
    }

    String topic;
    String content;
    int answerSum;
    User user;
    int vote;
    int id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public int getAnswerSum() {
        return answerSum;
    }

    public void setAnswerSum(int answerSum) {
        this.answerSum = answerSum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    Date date;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
