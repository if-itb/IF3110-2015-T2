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
import stackexchange.webservice.model.Answer;
import stackexchange.webservice.util.Database;

/**
 *
 * @author fauzanrifqy
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswers")
    @WebResult(name="Answer")
    public List<Answer> getAnswers() {
        List<Answer> answers = new ArrayList<Answer>();
        Database db = new Database();
        try{
            String sql="select * from answers";
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Answer answer = new Answer(rs.getInt("id"), rs.getInt("userid"), rs.getInt("questionId"), rs.getString("name"), rs.getString("email"), rs.getString("content"), rs.getDate("dateMade"), "", rs.getInt("vote"));
                answers.add(answer);
            }
            return answers;
        }catch(Exception e){
            Answer answer = new Answer();
            answers.add(answer);
            return answers;
        }finally{
            db.closeConnection();
            db = null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswers_1")
    @RequestWrapper(className = "stackexchange.getAnswers_1")
    @ResponseWrapper(className = "stackexchange.getAnswers_1Response")
    @WebResult(name="Answer")
    public List<Answer> getAnswers(@WebParam(name="questionId") int questionId) {
        List<Answer> answers = new ArrayList<Answer>();
        Database db = new Database();
        try{
            String sql="select * from answers where questionId=" + questionId;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Answer answer = new Answer(rs.getInt("id"), rs.getInt("userid"), rs.getInt("questionId"), rs.getString("name"), rs.getString("email"), rs.getString("content"), rs.getDate("dateMade"), "", rs.getInt("vote"));
                answers.add(answer);
            }
            return answers;
        }catch(Exception e){
            Answer answer = new Answer();
            answers.add(answer);
            return answers;
        }finally{
            db.closeConnection();
            db = null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addAnswer")
    @Oneway
    public void addAnswer(@WebParam(name = "answer") Answer answer) {
        Database db = new Database();
        try{
            String values="(";
            values+= answer.getQuestionId() +",";
            values+= "'"+ answer.getName() +"',";
            values+= "'"+ answer.getEmail() +"',";
            values+= "'"+ answer.getContent() +"',";
            values+= "'"+ answer.getDateMade() +"',";
            values+= answer.getVote() +")";
            String sql="insert into answers values " + values;
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
    @WebMethod(operationName = "deleteAnswer")
    @Oneway
    public void deleteAnswer(@WebParam(name = "id") int id, @WebParam(name = "questionId") int questionId) {
        Database db = new Database();
        try{
            String sql="delete from questions where questionId=" + questionId + "and id=" + id;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            //db = null;
        }
    }


    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteAnswer")
    @Oneway
    public void voteAnswer(@WebParam(name = "answer") Answer answer, @WebParam(name = "inc") boolean inc) {
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
            ps.executeUpdate();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            //db = null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteAnswer_1")
    @Oneway
    @RequestWrapper(className = "stackexchange.voteAnswer_1")
    public void voteAnswer(@WebParam(name = "id") int id, @WebParam(name = "questionId") int questionId, @WebParam(name = "inc") boolean inc) {
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
    @WebMethod(operationName = "updateAnswer")
    @Oneway
    public void updateAnswer(@WebParam(name = "answer") Answer answer) {
        Database db = new Database();
        try{
            int id = answer.getId();
            int questionId = answer.getQuestionId();
            String values="";
            values+= "content='"+ answer.getContent() +"',";
            values+= "dateMade='"+ answer.getDateMade() +"',";
            String sql="update answers set " + values + " where id=" + id + "and questionId=" + questionId;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            //db = null;
        }
    }
}
