/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxws;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;


@WebService(serviceName = "QuestionWS")
public class QuestionWS {
    DB database;
    Question model;
    
    public QuestionWS() throws Throwable {
      database = new DB();
      model = new Question();
    }
    /**
     * Web service operation
     * @param 
     * @return 
     */
    @WebMethod(operationName = "getQuestion")
    @WebResult(name="Questions")
    public ArrayList<Question> getQuestion() {
      ArrayList<Question> questions = new ArrayList<>();  
      String query = "SELECT * FROM question";
      ResultSet rs = database.getResultQuery(query);
      return model.fetchQuestions(rs);
    }
    
    /**
     * Web service operation
     * @param qid
     * @return 
     */
    @WebMethod(operationName = "getQuestionByQID")
    @WebResult(name="Question")
    public ArrayList<Question> getQuestionByQID(@WebParam(name = "qid") int qid) {
      ArrayList<Question> questions = new ArrayList<>();  
      String query = "SELECT * FROM question WHERE id = " + qid;
      ResultSet rs = database.getResultQuery(query);
      return model.fetchQuestions(rs);
    }
    
    /**
     * Web service operation
     * @param uid
     * @param topic
     * @param content
     * @return 
     */
    @WebMethod(operationName = "insertQuestion")
    @WebResult(name="saveQuestion")
    public void insertQuestion(@WebParam(name = "uid") int uid,@WebParam(name = "topic") int topic,@WebParam(name = "content") String content) {
      String query = "INSERT INTO `question` (`uid`, `topic`, `content`) VALUES ('"+uid+"','"+topic+"', '"+content+")";
      database.executeQuery(query);
    }
        /**
     * Web service operation
     * @param id
     * @param topic
     * @param content
     * @return 
     */
    @WebMethod(operationName = "UpdateQuestion")
    @WebResult(name="updQuestion")
    public void updateQuestion(@WebParam(name = "id") int id,@WebParam(name = "topic") String topic,@WebParam(name = "content") String content) {
      String query = "UPDATE question SET topic='" + topic + "', content='" + content + "' WHERE id = " + id + "";
      database.executeQuery(query);
    }
    /**
     * Web service operation
     * @param qid
     * @return 
     */
    @WebMethod(operationName = "deleteQuestion")
    @WebResult(name="delQuestion")
    public void deleteQuestion(@WebParam(name = "qid") int qid) {
      String query = "DELETE FROM question WHERE id = "+qid;
      database.executeQuery(query);  
    }
    /**
     * Web service operation
     * @param qid
      * @param uid  
      * @param type
     * @return 
     */
    @WebMethod(operationName = "voteQuestion")
    @WebResult(name="vtQuestion")
    public void voteQuestion(@WebParam(name = "qid") int qid,@WebParam(name = "uid") int uid,@WebParam(name = "type") int type) {
      String query = "SELECT * FROM vote_question WHERE qid=" + qid + " AND uid=" + uid;
      ResultSet tmp = database.getResultQuery(query);
      try {
        if(tmp.next()) return;  // user pernah melakukan vote
      } catch(Throwable e) {
        e.printStackTrace();
      }
      query = "INSERT INTO `vote_question` (`qid`, `uid`, `type`) VALUES ('"+qid+"','"+uid+"','"+type+"')";
      database.executeQuery(query);
    }
}
