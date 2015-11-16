/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.stackx;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import static java.lang.System.out;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author natanelia
 */
public class Question {
    private int questionId;
    private int userId;
    private String title;
    private String content;
    private int vote;
    private int createDate;

    public Question(int questionId, int userId, String title, String content, int vote, int createDate) {
        this.questionId = questionId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.vote = vote;
        this.createDate = createDate;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getVote() {
        return vote;
    }

    public int getCreateDate() {
        return createDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
    
    public void voteUp() {
        this.vote = vote + 1;
    }
    
    public void voteDown() {
        this.vote = vote - 1;
    }
}
