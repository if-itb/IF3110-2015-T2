/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSModule;

/**
 *
 * @author Jessica
 */
public class QuestionClass {
    private int questionId;
    private String title;
    private String content;
    private int vote;
    private String date;
    private int userID;

    public QuestionClass (int questionId, String title, String content, int vote, String date, int userID ) {
        this.questionId = questionId;
        this.title = title;
        this.content = content;
        this.vote = vote;
        this.date = date;
        this.userID = userID;
    }
    public int getQuestionId() {
        return questionId;
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

    public String getDate() {

        return date;
    }

    public int getUserID() {

        return userID;
    }
}

