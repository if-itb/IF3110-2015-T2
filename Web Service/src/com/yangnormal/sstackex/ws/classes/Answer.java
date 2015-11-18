package com.yangnormal.sstackex.ws.classes;

import java.sql.Date;

/**
 * Created by Julio on 11/18/2015.
 */
public class Answer {
    public Answer(){
        user=new User();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    int id;
    int vote;
    String content;
    Date date;
    User user;
    int qid;
}
