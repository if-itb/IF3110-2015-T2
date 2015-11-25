/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackexchange.webservice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import stackexchange.webservice.model.Question;
import stackexchange.webservice.util.Database;

/**
 *
 * @author fauzanrifqy
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getQuestions")
    @WebResult(name="Question")
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<Question>();
        Database db = new Database();
        try{
            String sql="select * from questions";
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question(rs.getInt("id"), rs.getInt("userid"), rs.getString("name"), rs.getString("email"), rs.getString("topic"), rs.getString("content"), rs.getDate("dateMade"), rs.getInt("vote"), rs.getInt("answer"));
                questions.add(question);
            }
            return questions;
        }catch(Exception e){
            Question question = new Question();
            questions.add(question);
            return questions;
        }finally{
            db.closeConnection();
            db = null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getQuestions_1")
    @RequestWrapper(className = "stackexchange.getQuestions_1")
    @ResponseWrapper(className = "stackexchange.getQuestions_1Response")
    @WebResult(name="Question")
    public List<Question> getQuestions(@WebParam(name="id") int id) {
        List<Question> questions = new ArrayList<Question>();
        Database db = new Database();
        try{
            String sql="select * from questions where id=" + id;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question(rs.getInt("id"), rs.getInt("userid"), rs.getString("name"), rs.getString("email"), rs.getString("topic"), rs.getString("content"), rs.getDate("dateMade"), rs.getInt("vote"), rs.getInt("answer"));
                questions.add(question);
            }
            return questions;
        }catch(Exception e){
            Question question = new Question();
            questions.add(question);
            return questions;
        }finally{
            db.closeConnection();
            db = null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addQuestion")
    @Oneway
    public void addQuestion(@WebParam(name = "question") Question question) {
        Database db = new Database();
        try{
            String values="(";
            values+= "'"+ question.getName() +"',";
            values+= "'"+ question.getEmail() +"',";
            values+= "'"+ question.getTopic() +"',";
            values+= "'"+ question.getContent() +"',";
            values+= "'"+ question.getDateMade() +"',";
            values+= question.getVote() +",";
            values+= question.getAnswer() +")";
            String sql="insert into questions values " + values;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteQuestion")
    @Oneway
    public void deleteQuestion(@WebParam(name = "id") int id) {
        Database db = new Database();
        try{
            String sql="delete from questions where id=" + id;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteQuestion")
    @Oneway
    public void voteQuestion(@WebParam(name = "question") Question question, @WebParam(name = "inc") boolean inc) {
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
            ps.executeUpdate();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteQuestion_1")
    @Oneway
    @RequestWrapper(className = "stackexchange.voteQuestion_1")
    public void voteQuestion(@WebParam(name = "id") int id, @WebParam(name = "inc") boolean inc) {
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
            ps.executeUpdate();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }
}
