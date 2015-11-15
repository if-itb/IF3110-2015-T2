/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.data;

/**
 *
 * @author user
 */
public class Question {
    private int id;
    private String topic;
    private String content;
    private String date;
    public Question(){}
    public Question(String topic, String content, String date){
        this.topic = topic;
        this.content = content;
        this.date = date;
    }
    public void setID(int id){
        this.id = id;
    }
    public void setTopic(String topic){
        this.topic = topic;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setDate(String date){
        this.date = date;
    }
    public int getID(){
        return id;
    }
    public String getTopic(){
        return topic;
    }
    public String getContent(){
        return content;
    }
    public String getDate(){
        return date;
    }
}
