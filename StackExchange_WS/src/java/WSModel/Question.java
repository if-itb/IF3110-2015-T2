/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSModel;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import static java.lang.System.out;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import WSModule.QuestionClass;
import java.util.ArrayList;


/**
 *
 * @author Jessica
 */
public class Question {
    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final static String localhost = "jdbc:mysql://localhost:3306/wbd2";
    final static String USER = "root";
    final static String PASS = "";
    
    public static Boolean addQuestion(String questionTitle, String questionContent, int userID ) {
        boolean success;
        Connection conn = null;
        Statement statement = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            statement = conn.createStatement();
            String query = "INSERT INTO questions(`title`, `content`, `userID`, `date`) VALUES ('" + questionTitle + "','" + questionContent + "'," + userID + ",now())";
            statement.executeUpdate(query);
            System.out.println(query);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }               
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return success;
    }
     
    public static QuestionClass getQuestionByID(int questionId) {
        Connection conn = null;
        Statement statement = null;
        ArrayList<QuestionClass> questionList = new ArrayList<QuestionClass>();
        QuestionClass[] questionArray = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            String query = "SELECT * FROM questions WHERE questionId=" + questionId;
            statement = conn.prepareStatement(query, statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                //Retrieve by column name
                int question_Id  = rs.getInt("questionId");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int vote  = rs.getInt("vote");
                String date = rs.getDate("date").toString();
                int userID  = rs.getInt("userID");
                
                QuestionClass questionRecord = new QuestionClass(question_Id,title,content,vote,date,userID);
                questionList.add(questionRecord);
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }               
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return questionList.get(0);
    }
            
    public static ArrayList<QuestionClass> getAllQuestion(){
        Connection conn = null;
        PreparedStatement statement = null;
        ArrayList<QuestionClass> questionList = new ArrayList<QuestionClass>();
        QuestionClass[] questionArray = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            String query = "SELECT questionId, title, content, vote, `date`, userID FROM questions";
            statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                //Retrieve by column name
                int questionId  = rs.getInt("questionId");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int vote  = rs.getInt("vote");
                String date = rs.getDate("date").toString();
                int userID  = rs.getInt("userID");

                QuestionClass questionRecord = new QuestionClass(questionId,title,content,vote,date,userID);
                questionList.add(questionRecord);
            }
            rs.close();
            statement.close();
            conn.close();
        } catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(statement != null)
                    conn.close();
            }catch(SQLException se){
                
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return questionList;
    }
    
    public static Boolean updateQuestion(int questionId, String questionTitle, String questionContent) {
        boolean success;
        Connection conn = null;
        Statement statement = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            statement = conn.createStatement();
            String query = "UPDATE questions SET `title`='" + questionTitle + "',`content` ='" + questionContent + "', `date` = now()  WHERE questionId =" + questionId;
            statement.executeUpdate(query);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }               
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return success;
    }
    
    public static Boolean deleteQuestion(int questionId) {
        boolean success;
        Connection conn = null;
        Statement statement = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            statement = conn.createStatement();
            String query = "DELETE FROM questions where questionId=" + questionId;
            statement.executeUpdate(query);
            //System.out.println(query);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }               
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return success;
    }
    
    public static String getQuestionUserName(int userID) {
        Connection conn = null;
        Statement statement = null;
        String userName = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            String query = "SELECT userName FROM account WHERE userID=" + userID;
            statement = conn.prepareStatement(query, statement.RETURN_GENERATED_KEYS);
            userName = (statement.executeQuery(query)).toString();
            System.out.println(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }               
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userName;
    }
    
    public static Boolean voteUpQuestion(int questionId, int userID) {
        boolean success = false;
        Connection conn = null;
        Statement statement = null;
        int value = 0;
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            statement = conn.createStatement();
            String insertVote = "INSERT INTO vote(`userID`, `questionID`) VALUES (" + userID + "," + questionId + ")";
            statement.executeUpdate(insertVote);
            String checkVote = "SELECT `value` FROM vote WHERE questionID=" + questionId + " AND userID=" + userID;
            ResultSet rs = statement.executeQuery(checkVote);
            if(rs.next()) {
                value = rs.getInt("value");
            }
            // cek value dari vote
            if (value >= -1 && value < 1) {
                String query = "UPDATE questions SET `vote` = `vote`+1 WHERE questionId =" + questionId;
                statement.executeUpdate(query);
                String query2 = "UPDATE vote SET `value` = `value`+1 WHERE questionId =" + questionId + "And userID=" + userID;
                statement.executeUpdate(query2);
                success = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }               
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return success;
    }
    
    public static Boolean voteDownQuestion(int questionId, int userID) {
        boolean success = false;
        Connection conn = null;
        Statement statement = null;
        int value = 0;
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            statement = conn.createStatement();
            String insertVote = "INSERT INTO vote(`userID`, `questionID`) VALUES (" + userID + "," + questionId + ")";
            statement.executeUpdate(insertVote);
            String checkVote = "SELECT `value` FROM vote WHERE questionID=" + questionId + " AND userID=" + userID;
            ResultSet rs = statement.executeQuery(checkVote);
            if(rs.next()) {
                value = rs.getInt("value");
            }
            // cek value dari vote
            if (value > -1 && value <= 1) {
                String query = "UPDATE questions SET `vote` = `vote`-1 WHERE questionId =" + questionId;
                statement.executeUpdate(query);
                String query2 = "UPDATE vote SET `value` = `value`-1 WHERE questionID =" + questionId + "AND userID=" + userID;
                statement.executeUpdate(query2);
                success = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }               
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return success;
    }
    
    public static int getSumVotes(int questionId) {
        Connection conn = null;
        Statement statement = null;
        int voteQuestion = 0;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            statement = conn.createStatement();
            String query = "SELECT `vote` FROM questions WHERE questionId=" + questionId;
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()) {
                voteQuestion = rs.getInt("vote");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }               
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();    
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return voteQuestion;
    }
}