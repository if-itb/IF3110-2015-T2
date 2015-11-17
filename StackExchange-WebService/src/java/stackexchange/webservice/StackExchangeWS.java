/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackexchange.webservice;

import stackexchange.webservice.util.Database;
import stackexchange.webservice.model.Question;
import stackexchange.webservice.model.Answer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author fauzanrifqy
 */
@WebService(serviceName = "StackExchangeWS")
public class StackExchangeWS {

    /**
     * Web service operations
     */
    @WebMethod(operationName = "getQuestions")
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<Question>();
        Database db = new Database();
        try{
            String sql="select * from questions";
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setErrorMessage("");
                question.setId(rs.getInt("id"));
                question.setName(rs.getString("name"));
                question.setEmail(rs.getString("email"));
                question.setTopic(rs.getString("topic"));
                question.setContent(rs.getString("content"));
                question.setDateMade(rs.getDate("dateMade"));
                questions.add(question);
            }
            return questions;
        }catch(Exception e){
            Question question = new Question();
            question.setErrorMessage(e.getMessage());
            questions.add(question);
            return questions;
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "getQuestions")
    public List<Question> getQuestions(int id) {
        List<Question> questions = new ArrayList<Question>();
        Database db = new Database();
        try{
            String sql="select * from questions where id=" + id;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setErrorMessage("");
                question.setId(rs.getInt("id"));
                question.setName(rs.getString("name"));
                question.setEmail(rs.getString("email"));
                question.setTopic(rs.getString("topic"));
                question.setContent(rs.getString("content"));
                question.setDateMade(rs.getDate("dateMade"));
                questions.add(question);
            }
            return questions;
        }catch(Exception e){
            Question question = new Question();
            question.setErrorMessage(e.getMessage());
            questions.add(question);
            return questions;
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "addQuestion")
    public void addQuestion(Question question) {
        Database db = new Database();
        try{
            String values="(";
            values+= question.getId() +",";
            values+= "'"+ question.getName() +"',";
            values+= "'"+ question.getEmail() +"',";
            values+= "'"+ question.getTopic() +"',";
            values+= "'"+ question.getContent() +"',";
            values+= "'"+ question.getDateMade() +"',";
            values+= question.getVote() +",";
            values+= question.getAnswer() +")";
            String sql="insert into questions values " + values;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "updateQuestion")
    public void updateQuestion(Question question) {
        Database db = new Database();
        try{
            int id = question.getId();
            String values="";
            values+= "topic='"+ question.getTopic() +"',";
            values+= "content='"+ question.getContent() +"',";
            values+= "dateMade='"+ question.getDateMade() +"',";
            values+= "vote="+ question.getVote() +",";
            values+= "answer="+ question.getAnswer();
            String sql="update questions set " + values + " where id=" + id;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "deleteQuestion")
    public void deleteQuestion(int id) {
        Database db = new Database();
        try{
            String sql="delete from questions where id=" + id;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "deleteQuestion")
    public void deleteQuestion(Question question) {
        int id = question.getId();
        Database db = new Database();
        try{
            String sql="delete from questions where id=" + id;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "voteQuestion")
    public void voteQuestion(Question question, boolean inc) {
        Database db = new Database();
        try{
            int val=0;
            if (inc) {
                val++;
            }else{
                val--;
            }
            int id = question.getId();
            String values="";
            values+= "vote=val+("+ val + ")";
            String sql="update question set " + values + " where id=" + id;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "voteQuestion")
    public void voteQuestion(int id, boolean inc) {
        Database db = new Database();
        try{
            int val=0;
            if (inc) {
                val++;
            }else{
                val--;
            }
            String values="";
            values+= "vote=val+("+ val + ")";
            String sql="update question set " + values + " where id=" + id;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "getAnswers")
    public List<Answer> getAnswers() {
        List<Answer> answers = new ArrayList<Answer>();
        Database db = new Database();
        try{
            String sql="select * from answers";
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Answer answer = new Answer();
                answer.setErrorMessage("");
                answer.setId(rs.getInt("id"));
                answer.setQuestionId(rs.getInt("questionId"));
                answer.setName(rs.getString("name"));
                answer.setEmail(rs.getString("email"));
                answer.setContent(rs.getString("content"));
                answer.setDateMade(rs.getDate("dateMade"));
                answer.setVote(rs.getInt("vote"));
                answers.add(answer);
            }
            return answers;
        }catch(Exception e){
            Answer answer = new Answer();
            answer.setErrorMessage(e.getMessage());
            answers.add(answer);
            return answers;
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "getAnswers")
    public List<Answer> getAnswers(int questionId) {
        List<Answer> answers = new ArrayList<Answer>();
        Database db = new Database();
        try{
            String sql="select * from answers where questionId=" + questionId;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Answer answer = new Answer();
                answer.setErrorMessage("");
                answer.setId(rs.getInt("id"));
                answer.setQuestionId(rs.getInt("questionId"));
                answer.setName(rs.getString("name"));
                answer.setEmail(rs.getString("email"));
                answer.setContent(rs.getString("content"));
                answer.setDateMade(rs.getDate("dateMade"));
                answer.setVote(rs.getInt("vote"));
                answers.add(answer);
            }
            return answers;
        }catch(Exception e){
            Answer answer = new Answer();
            answer.setErrorMessage(e.getMessage());
            answers.add(answer);
            return answers;
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "addAnswer")
    public void addAnswer(Answer answer) {
        Database db = new Database();
        try{
            String values="(";
            values+= answer.getId() +",";
            values+= answer.getQuestionId() +",";
            values+= "'"+ answer.getName() +"',";
            values+= "'"+ answer.getEmail() +"',";
            values+= "'"+ answer.getContent() +"',";
            values+= "'"+ answer.getDateMade() +"',";
            values+= answer.getVote() +")";
            String sql="insert into answers values " + values;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "addAnswer")
    public void addAnswer(Answer answer, int questionId) {
        Database db = new Database();
        try{
            answer.setQuestionId(questionId);
            String values="(";
            values+= answer.getId() +",";
            values+= answer.getQuestionId() +",";
            values+= "'"+ answer.getName() +"',";
            values+= "'"+ answer.getEmail() +"',";
            values+= "'"+ answer.getContent() +"',";
            values+= "'"+ answer.getDateMade() +"',";
            values+= answer.getVote() +")";
            String sql="insert into answers values " + values;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "updateAnswer")
    public void updateAnswer(Answer answer) {
        Database db = new Database();
        try{
            int id = answer.getId();
            int questionId = answer.getQuestionId();
            String values="";
            values+= "content='"+ answer.getContent() +"',";
            values+= "dateMade='"+ answer.getDateMade() +"',";
            String sql="update answers set " + values + " where id=" + id + "and questionId=" + questionId;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "deleteAnswer")
    public void deleteAnswer(int questionId) {
        Database db = new Database();
        try{
            String sql="delete from questions where questionId=" + questionId;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "deleteAnswer")
    public void deleteAnswer(int id, int questionId) {
        Database db = new Database();
        try{
            String sql="delete from questions where id=" + id + " and questionId=" + questionId;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "deleteAnswer")
    public void deleteAnswer(Answer answer) {
        int id = answer.getId();
        int questionId = answer.getQuestionId();
        Database db = new Database();
        try{
            String sql="delete from questions where id=" + id + " and questionId=" + questionId;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "voteAnswer")
    public void voteAnswer(Answer answer, boolean inc) {
        Database db = new Database();
        try{
            int val=0;
            if (inc) {
                val++;
            }else{
                val--;
            }
            int id = answer.getId();
            int questionId = answer.getQuestionId();
            String values="";
            values+= "vote=val+("+ val + ")";
            String sql="update answers set " + values + " where id=" + id + "and questionId=" + questionId;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
    @WebMethod(operationName = "voteAnswer")
    public void voteAnswer(int id, int questionId, boolean inc) {
        Database db = new Database();
        try{
            int val=0;
            if (inc) {
                val++;
            }else{
                val--;
            }
            String values="";
            values+= "vote=val+("+ val + ")";
            String sql="update answers set " + values + " where id=" + id + "and questionId=" + questionId;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }
    
}
