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
    
    public static Boolean voteUpQuestion(int questionId, int userID) {
        boolean success = false;
        Connection conn = null;
        Statement statement = null;
        int userID_Exist = 0, questionID_Exist = 0;
        int countVote = 0, value = 0;
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            statement = conn.createStatement();
            //cek email
            String voteTable = "SELECT count(*) FROM votequestion";
            ResultSet rs = statement.executeQuery(voteTable);
            if(rs.next()) {
                countVote = rs.getInt(1);
            }
            int i = 0;
            Boolean found = false;
            while (i < countVote && !found) {
                String checkEmail = "SELECT userID, questionID FROM votequestion WHERE userID=" + userID + " And questionID=" + questionId;
                ResultSet rsVote = statement.executeQuery(checkEmail);
                if (rsVote.next()) {
                    userID_Exist = rsVote.getInt(1);
                    questionID_Exist = rsVote.getInt(2);
                }
                if ((userID == userID_Exist) && (questionId == questionID_Exist)) {
                    found = true;
                } else {
                    i++;
                }
            }
            if (found == false) {
                String insertVote = "INSERT INTO votequestion(`userID`, `questionID`) VALUES (" + userID + "," + questionId + ")";
                statement.executeUpdate(insertVote);
            }
            String checkVote = "SELECT `value` FROM votequestion WHERE questionID=" + questionId + " AND userID=" + userID;
            ResultSet rsVote = statement.executeQuery(checkVote);
            if(rsVote.next()) {
                value = rsVote.getInt("value");
            }
            if (value == 0) {
                String query2 = "UPDATE votequestion SET `value` = 1 WHERE questionId =" + questionId + " And userID =" + userID;
                statement.executeUpdate(query2);
                String query = "UPDATE questions SET `vote` = `vote`+1 WHERE questionId =" + questionId;
            statement.executeUpdate(query);
            } else if (value == 1) {
                String query2 = "UPDATE votequestion SET `value` = 0 WHERE questionId =" + questionId + " And userID =" + userID;
                statement.executeUpdate(query2);
                String query = "UPDATE questions SET `vote` = `vote`-1 WHERE questionId =" + questionId;
            statement.executeUpdate(query);
            } else if (value == -1) {
                String query2 = "UPDATE votequestion SET `value` = 1 WHERE questionId =" + questionId + " And userID =" + userID;
                statement.executeUpdate(query2);
                String query = "UPDATE questions SET `vote` = `vote`+2 WHERE questionId =" + questionId;
                statement.executeUpdate(query);
            }
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
    
    public static Boolean voteDownQuestion(int questionId, int userID) {
        boolean success = false;
        Connection conn = null;
        Statement statement = null;
        int userID_Exist = 0, questionID_Exist = 0;
        int countVote = 0, value = 0;
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            statement = conn.createStatement();
            //cek email
            String voteTable = "SELECT count(*) FROM votequestion";
            ResultSet rs = statement.executeQuery(voteTable);
            if(rs.next()) {
                countVote = rs.getInt(1);
            }
            int i = 0;
            Boolean found = false;
            while (i < countVote && !found) {
                String checkEmail = "SELECT userID, questionID FROM votequestion WHERE userID=" + userID + " And questionID=" + questionId;
                ResultSet rsVote = statement.executeQuery(checkEmail);
                if (rsVote.next()) {
                    userID_Exist = rsVote.getInt(1);
                    questionID_Exist = rsVote.getInt(2);
                }
                if ((userID == userID_Exist) && (questionId == questionID_Exist)) {
                    found = true;
                } else {
                    i++;
                }
            }
            if (found == false) {
                String insertVote = "INSERT INTO votequestion(`userID`, `questionID`) VALUES (" + userID + "," + questionId + ")";
                statement.executeUpdate(insertVote);
            }
            String checkVote = "SELECT `value` FROM votequestion WHERE questionID=" + questionId + " AND userID=" + userID;
            ResultSet rsVote = statement.executeQuery(checkVote);
            if(rsVote.next()) {
                value = rsVote.getInt("value");
            }
            if (value == 0) {
                String query2 = "UPDATE votequestion SET `value` = -1 WHERE questionID =" + questionId + " And userID =" + userID;
                statement.executeUpdate(query2);
                String query = "UPDATE questions SET `vote` = `vote`-1 WHERE questionID =" + questionId;
            statement.executeUpdate(query);
            } else if (value == 1) {
                String query2 = "UPDATE votequestion SET `value` = -1 WHERE questionID =" + questionId + " And userID =" + userID;
                statement.executeUpdate(query2);
                String query = "UPDATE questions SET `vote` = `vote`-2 WHERE questionID =" + questionId;
            statement.executeUpdate(query);
            } else if (value == -1) {
                String query2 = "UPDATE votequestion SET `value` = 0 WHERE questionID =" + questionId + " And userID =" + userID;
                statement.executeUpdate(query2);
                String query = "UPDATE questions SET `vote` = `vote`+1 WHERE questionID =" + questionId;
                statement.executeUpdate(query);
            }
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