/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionModel;


import Config.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author FiqieUlya
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {

   private final DB db = new DB();
    private Connection conn;

    /**
     *
     * @param qid
     * @return
     */
    @WebMethod(operationName = "getQuestionByQID")
    @WebResult(name = "Question")
    public List<Question> getQuestionByQID(@WebParam(name = "qid") int qid) {
        
        List<Question> question = new ArrayList<Question>();
        
        conn = db.connect();
        
        try {
            Statement stmt;
            stmt = conn.createStatement();
            
            String sql;
            sql = "SELECT * FROM question where id_question = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);

            ResultSet rs;
            rs = dbStatement.executeQuery();            
            /* Get every data returned by SQLquery */
            while(rs.next()) {
                question.add( new Question(
                    rs.getInt("id_question"),
                    rs.getInt("vote"),
                    rs.getString("topic"),    
                    rs.getString("content"),
                    rs.getString("date"),
                    rs.getString("username")));
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException ex) {
           Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
        return question;
    }
    
    @WebMethod(operationName = "insertQuestion")
    public void insertQuestion(@WebParam(name = "username") String username , @WebParam(name = "topic") String topic, @WebParam(name = "content") String content){
        try {
            Statement stmt;
            stmt = conn.createStatement();
            
            String sql;
            sql = "INSERT INTO question(topic, username,content,vote,date) VALUES('topic','fiqie','isi',0,'0000-00-00 00:00:00') ";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            //dbStatement.setString(1, topic);
            //dbStatement.setString(2, username);
            //dbStatement.setString(3, content);
            //dbStatement.setInt(4, 0);
            //dbStatement.setString(5, "0000-00-00 00:00:00");
            
            dbStatement.execute();
            
            stmt.close();
            conn.close();
        }
        catch(SQLException ex) {
           Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
    }
    
    @WebMethod(operationName = "getQuestions")
    @WebResult(name = "Questions")
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<Question>();
        conn = db.connect();
        try {
            Statement stmt;
            stmt = conn.createStatement();
            
            String sql;
            sql = "SELECT * FROM question";
            PreparedStatement dbStatement = conn.prepareStatement(sql);

            ResultSet rs;
            rs = dbStatement.executeQuery();            
            /* Get every data returned by SQLquery */
            while(rs.next()) {
                questions.add( new Question(
                    rs.getInt("id_question"),
                    rs.getInt("vote"),
                    rs.getString("topic"),    
                    rs.getString("content"),
                    rs.getString("date"),
                    rs.getString("username")));
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException ex) {
           Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
        return questions;
    }
    
    
}
