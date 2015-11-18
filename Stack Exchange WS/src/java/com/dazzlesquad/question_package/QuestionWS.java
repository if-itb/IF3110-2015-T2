/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dazzlesquad.question_package;
/**
 *
 * @author ryanyonata
 */
import com.dazzesquad.database_console.DBConnect;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;


@WebService(serviceName = "QuestionWS")
public class QuestionWS {

    Connection conn; 

    public QuestionWS() throws SQLException {
        DBConnect db = new DBConnect();
        conn = db.connect();
    }
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getQuestionById")
    @WebResult(name="Question")
    public Question getQuestionById(@WebParam(name = "id") int id) {
        Question questionresult = null;
        try {
            Statement statement = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Question WHERE id=?";
                    
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1,id);
            
            ResultSet result = dbStatement.executeQuery();
            
            if (result.next())
            {
                questionresult = new Question(result.getInt("id"), result.getInt("user_id"),result.getString("topic"),result.getString("content"), result.getInt("vote"), result.getString("date")); 
            }
            else {
                questionresult = new Question();
            }
            
            result.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return questionresult;
    }
    
    @WebMethod(operationName = "deleteQuestion")
    public int deleteQuestion(@WebParam(name = "id") int id) {
        int deletesuccessful = 1; // nanti diganti fungsi validasi
        if (deletesuccessful == 1) {
            try {
                String sql1, sql2;
                Statement statement1 = conn.createStatement();

                sql1 = "DELETE * FROM Answer WHERE questionId=?";

                PreparedStatement dbStatement1 = conn.prepareStatement(sql1);
                dbStatement1.setInt(1,id);

                ResultSet result1 = dbStatement1.executeQuery(); 

                result1.close();
                statement1.close();

                Statement statement2 = conn.createStatement();

                sql1 = "DELETE * FROM Question WHERE id=?";

                PreparedStatement dbStatement2 = conn.prepareStatement(sql1);
                dbStatement1.setInt(1,id);

                ResultSet result2 = dbStatement1.executeQuery(); 

                result2.close();
                statement2.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return deletesuccessful;
    }
    
    public int insertQuestion(@WebParam(name = "Question") Question q) {
        int insertsuccessful = 1; // nanti diganti fungsi validasi
        
        if (insertsuccessful == 1) {
            try {
                Statement statement = conn.createStatement();
                String sql;
                sql = "INSERT INTO Question (id_user, topic, content) VALUES (?,?,?)";

                PreparedStatement dbStatement = conn.prepareStatement(sql);
                dbStatement.setInt(1,q.getQuestionUserId());
                dbStatement.setString(2,q.getQuestionTopic());
                dbStatement.setString(3,q.getQuestionContent());

                ResultSet result = dbStatement.executeQuery(); 

                result.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return insertsuccessful;
    }
    
    @WebMethod(operationName = "showAllQuestion")
    @WebResult(name="Question")
    public java.util.ArrayList<Question> showAllQuestion() {
        ArrayList<Question> questions = new ArrayList<Question>();
        
        try {
            Statement statement = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Question";
                    
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            
            ResultSet result = dbStatement.executeQuery();
            
           
            while(result.next()) {
               questions.add(new Question(result.getInt("id"), result.getInt("user_id"),result.getString("topic"),result.getString("content"), result.getInt("vote"), result.getString("date"))); 
               
            }
            
            result.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class.getName()).log
            (Level.SEVERE, null, ex);
        }
        return questions;
    }
    
    @WebMethod(operationName = "editQuestion")
    public int editQuestion(@WebParam(name = "id") int id, @WebParam(name = "topic") String newtopic, @WebParam(name = "content") String newcontent) {
        int editsuccessful = 1; // nanti diganti fungsi validasi
        
        if (editsuccessful ==1) {
            try {
                Statement statement = conn.createStatement();
                String sql;
                sql = "UPDATE Question SET topic = ?, content = ? WHERE id = ?";

                PreparedStatement dbStatement = conn.prepareStatement(sql);
                dbStatement.setString(1,newtopic);
                dbStatement.setString(2,newcontent);
                //dbStatement.setString(3,);
                dbStatement.setInt(3,id);

                ResultSet result = dbStatement.executeQuery(); 

                result.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return editsuccessful;
    }
}
