/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.stackx.model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import static java.lang.System.out;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.me.stackx.Question;

/**
 *
 * @author natanelia
 */
public class QuestionModel {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/stackx";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
 
    public static boolean create(String access_token, String title, String content) {
        //TODO: request to oauth to get who is the requester
        boolean valid = true;
        int userId = 1;
        if (valid) {
            Connection conn = null;
            Statement stmt = null;
            try {
               //STEP 2: Register JDBC driver
               Class.forName("com.mysql.jdbc.Driver");

               //STEP 3: Open a connection
               conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);

               //STEP 4: Execute a query
               stmt = (Statement) conn.createStatement();
               String sql;
               sql = "INSERT INTO question (user_id, title, content, create_date) VALUES ('" + userId + "', '" + title + "', '" + content + "', CURRENT_TIMESTAMP)";
               stmt.executeUpdate(sql);
               
               stmt.close();
               conn.close();
            } catch(SQLException se) {
               //Handle errors for JDBC
               se.printStackTrace();
               valid = false;
            } catch(Exception e) {
               //Handle errors for Class.forName
               e.printStackTrace();
               valid = false;
            } finally {
               //finally block used to close resources
               try {
                  if (stmt!=null)
                    stmt.close();
               } catch(SQLException se2) { }// nothing we can do
               try {
                  if (conn!=null) {
                    conn.close();
                  }
               } catch (SQLException se) {
                    se.printStackTrace();
               }//end finally try
            }//end try
        }
        return valid;
    }
    
    public static Question getById(int id) {
        Connection conn = null;
        Statement stmt = null;
        try {
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);

           //STEP 4: Execute a query
           stmt = (Statement) conn.createStatement();
           String sql;
           sql = "SELECT question_id, user_id, title, content, vote, create_date FROM question WHERE question_id=" + id;
            //STEP 5: Extract data from result set
            try (ResultSet rs = stmt.executeQuery(sql)) {
                //STEP 5: Extract data from result set
                rs.next();
                //Retrieve by column name
                int questionId  = rs.getInt("question_id");
                int userId = rs.getInt("user_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int vote = rs.getInt("vote");
                int createDate = rs.getInt("create_date");

                return new Question(questionId, userId, title, content, vote, createDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
           stmt.close();
           conn.close();
        } catch(SQLException se) {
           //Handle errors for JDBC
           se.printStackTrace();
        } catch(Exception e) {
           //Handle errors for Class.forName
           e.printStackTrace();
        } finally {
           //finally block used to close resources
           try {
              if (stmt!=null)
                 stmt.close();
           } catch(SQLException se2){ }// nothing we can do
           try {
              if (conn!=null)
                 conn.close();
           } catch (SQLException se) {
              se.printStackTrace();
           }//end finally try
        }//end try
        return null;
    }
    
    public static Question[] getAll() {
        //TODO: request to oauth to get who is the requester
        ArrayList<Question> questionList = new ArrayList<>();
        Question[] r = null;
        Connection conn = null;
        Statement stmt = null;
        try {
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);

           //STEP 4: Execute a query
           stmt = (Statement) conn.createStatement();
           String sql;
           sql = "SELECT question_id, user_id, title, content, vote, create_date FROM question";
            //STEP 5: Extract data from result set
            try (ResultSet rs = stmt.executeQuery(sql)) {
                //STEP 5: Extract data from result set
                while (rs.next()) {
                    //Retrieve by column name
                    int questionId  = rs.getInt("question_id");
                    int userId = rs.getInt("user_id");
                    String title = rs.getString("title");
                    String content = rs.getString("content");
                    int vote = rs.getInt("vote");
                    int createDate = rs.getInt("create_date");

                    questionList.add(new Question(questionId, userId, title, content, vote, createDate));
                }
                out.println(questionList);
                r = new Question[questionList.size()];
                r = questionList.toArray(r);
            } catch (Exception e) {
                e.printStackTrace();
            }
           stmt.close();
           conn.close();
        } catch(SQLException se) {
           //Handle errors for JDBC
           se.printStackTrace();
        } catch(Exception e) {
           //Handle errors for Class.forName
           e.printStackTrace();
        } finally {
           //finally block used to close resources
           try {
              if (stmt!=null)
                 stmt.close();
           } catch(SQLException se2){ }// nothing we can do
           try {
              if (conn!=null)
                 conn.close();
           } catch (SQLException se) {
              se.printStackTrace();
           }//end finally try
        }//end try
        return r;
    }
}
