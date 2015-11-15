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
    private String name;
    private String topic;
    private String content;
    private String date;
    private int vote;
    private int count;
    public Question(){}
    public Question(String topic, String content, String date){
        this.topic = topic;
        this.content = content;
        this.date = date;
    }
    public void setID(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
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
    public void setVote(int vote){
        this.vote = vote;
    }
    public void setCount(int count){
        this.count = count;
    }
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
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
    public int getVote(){
        return vote;
    }
    public int getCount(){
        return count;
    }
}
