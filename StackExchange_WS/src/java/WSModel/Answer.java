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

/**
 *
 * @author Jessica
 */
public class Answer {
    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final static String localhost = "jdbc:mysql://localhost:3306/wbd2";
    final static String USER = "root";
    final static String PASS = "";
    
     public static Boolean addAnswer(int question_id, String answerContent, int answerVote, int userID ) {
        boolean success;
        Connection conn = null;
        Statement statement = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            statement = conn.createStatement();
            String query = "INSERT INTO answers(`question_id`, `content`, `vote`, `userID`, `date`) VALUES (" + question_id + ",\"" + answerContent + "\"," + answerVote + "," + userID + " ,now())";
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
    
     /*
    public static AnswerClass getAnswerByID(int answer_id) {
        Connection conn = null;
        Statement statement = null;
        AnswerClass answer = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            statement = conn.createStatement();
            String query = "SELECT * FROM answers WHERE answer_id=" + answer_id;
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                answer = new AnswerClass(rs.getInt("answer_id"), rs.getInt("question_id"), rs.getString("content"), rs.getInt("vote"), rs.getString("date"), rs.getInt("userID"));
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
        return answer;
    }
    
*/

    public static Boolean voteUpAnswer(int question_id) {
        boolean success;
        Connection conn = null;
        Statement statement = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            statement = conn.createStatement();
            String query = "UPDATE answers SET vote = vote+1 WHERE question_id = " + question_id;
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
    
    public static Boolean voteDownAnswer(int question_id) {
        boolean success;
        Connection conn = null;
        Statement statement = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(localhost, USER, PASS);
            statement = conn.createStatement();
            String query = "UPDATE answers SET vote = vote-1 WHERE question_id = " + question_id;
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
