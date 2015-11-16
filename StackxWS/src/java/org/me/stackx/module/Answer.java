/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.stackx.module;

/**
 *
 * @author natanelia
 */
public class Answer {
    private final int answerId;
    private final int questionId;
    private final int userId;
    private String content;
    private int vote;
    private final int createDate;

    public Answer(int answerId, int questionId, int userId, String content, int vote, int createDate) {
        this.answerId = answerId;
        this.questionId = questionId;
        this.userId = userId;
        this.content = content;
        this.vote = vote;
        this.createDate = createDate;
    }

    public int getAnswerId() {
        return answerId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getUserId() {
        return userId;
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

    public int getCreateDate() {
        return createDate;
    }
}
