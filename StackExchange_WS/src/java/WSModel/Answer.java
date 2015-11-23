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

import WSModule.AnswerClass;
import java.util.ArrayList;
/**
 *
 * @author Jessica
 */
public class Answer {
    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final static String localhost = "jdbc:mysql://localhost:3306/wbd2";
    final static String USER = "root";
    final static String PASS = "";
    
     public static Boolean addAnswer(int question_id, String answerContent, int userID ) {
        boolean success;
        Connection conn = null;
        Statement statement = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            statement = conn.createStatement();
            String query = "INSERT INTO answers(`question_id`, `content`, `userID`, `date`) VALUES (" + question_id + ",'" + answerContent + "'," + userID + " ,now())";
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
     
    public static ArrayList<AnswerClass> getAnswerByID(int answer_id) {
        Connection conn = null;
        Statement statement = null;
        ArrayList<AnswerClass> answerList = new ArrayList<AnswerClass>();
        AnswerClass[] answerArray = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            String query = "SELECT * FROM answers WHERE answer_id=" + answer_id;
            statement = conn.prepareStatement(query, statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.executeQuery(query);
        
            while (rs.next()) {
                //Retrieve by column name
                int answerId  = rs.getInt("answer_id");
                int question_id  = rs.getInt("question_Id");
                String content = rs.getString("content");
                int vote  = rs.getInt("vote");
                String date = rs.getDate("date").toString();
                int userID  = rs.getInt("userID");

                AnswerClass answerRecord = new AnswerClass(answerId, question_id, content, vote, date, userID);
                answerList.add(answerRecord);
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
        return answerList;
    }
    
    public static ArrayList<AnswerClass> getAnswerByQID(int question_id) {
        Connection conn = null;
        Statement statement = null;
        ArrayList<AnswerClass> answerList = new ArrayList<AnswerClass>();
        AnswerClass[] answerArray = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            String query = "SELECT * FROM answers WHERE question_id=" + question_id;
            statement = conn.prepareStatement(query, statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.executeQuery(query);
        
            while (rs.next()) {
                //Retrieve by column name
                int answer_id  = rs.getInt("answer_Id");
                int questionId  = rs.getInt("question_id");
                String content = rs.getString("content");
                int vote  = rs.getInt("vote");
                String date = rs.getDate("date").toString();
                int userID  = rs.getInt("userID");

                AnswerClass answerRecord = new AnswerClass(answer_id, questionId, content, vote, date, userID);
                answerList.add(answerRecord);
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
        return answerList;
    }
    
    public static Boolean voteUpAnswer(int answer_id) {
        boolean success;
        Connection conn = null;
        Statement statement = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            statement = conn.createStatement();
            String query = "UPDATE answers SET vote = vote+1 WHERE answer_id = " + answer_id;
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
    
    public static Boolean voteDownAnswer(int answer_id) {
        boolean success;
        Connection conn = null;
        Statement statement = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            statement = conn.createStatement();
            String query = "UPDATE answers SET vote = vote-1 WHERE answer_id = " + answer_id;
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

}   