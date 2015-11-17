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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.me.stackx.module.Question;
import org.me.stackx.module.User;

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
 
    public static int create(User user, String title, String content) {
        int r = -1;
        if (user.isValid()) {
            Connection conn = null;
            PreparedStatement stmt = null;
            try {
               //STEP 2: Register JDBC driver
               Class.forName("com.mysql.jdbc.Driver");

               //STEP 3: Open a connection
               conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);

               //STEP 4: Execute a query
               String sql;
               sql = "INSERT INTO question (user_id, title, content, create_date) VALUES(?, ?, ?, CURRENT_TIMESTAMP)";
               stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
               stmt.setInt(1, user.getUserId());
               stmt.setString(2, title);
               stmt.setString(3, content);
               
               int affectedRows = stmt.executeUpdate();
               if (affectedRows == 0) {
                   r = -1;
               } else {
                    try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            r = generatedKeys.getInt(1);
                        }
                        else {
                            r = -1;
                        }
                    }
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
        
        return r;
    }
    
    public static int edit(User user, int questionId, String title, String content) {
        int r = -1;
        if (user.isValid()) {
            Connection conn = null;
            PreparedStatement stmt = null;
            try {
               //STEP 2: Register JDBC driver
               Class.forName("com.mysql.jdbc.Driver");

               //STEP 3: Open a connection
               conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);

               //STEP 4: Execute a query
               String sql;
               sql = "UPDATE question SET title=?, content=? WHERE question_id=? AND user_id=?";
               stmt = conn.prepareStatement(sql);
               
               stmt.setString(1, title);
               stmt.setString(2, content);
               stmt.setInt(3, questionId);
               stmt.setInt(4, user.getUserId());
               
               int affectedRows = stmt.executeUpdate();
               if (affectedRows == 0) {
                   r = -1;
               } else {
                   r = questionId;
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
        return r;
    }
    
    public static int vote(User user, int questionId, int inc) {
        int r = -1;
        if (user.isValid()) {
            Connection conn = null;
            PreparedStatement stmt = null;
            try {
               //STEP 2: Register JDBC driver
               Class.forName("com.mysql.jdbc.Driver");

               //STEP 3: Open a connection
               conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);

               //STEP 4: Execute a query
               String sql;
               sql = "UPDATE question SET vote=vote+? WHERE question_id=? AND user_id=?";
               stmt = conn.prepareStatement(sql);
               
               stmt.setInt(1, inc);
               stmt.setInt(2, questionId);
               stmt.setInt(3, user.getUserId());
               
               int affectedRows = stmt.executeUpdate();
               if (affectedRows == 0) {
                   r = -1;
               } else {
                   r = questionId;
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
        return r;
    }
    
    public static String delete(User user, int questionId) {
        String r = "ERROR";
        if (user.isValid()) {
            Connection conn = null;
            PreparedStatement stmt = null;
            try {
               //STEP 2: Register JDBC driver
               Class.forName("com.mysql.jdbc.Driver");

               //STEP 3: Open a connection
               conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);

               //STEP 4: Execute a query
               String sql;
               sql = "DELETE FROM question WHERE question_id=? AND user_id=?";
               stmt = conn.prepareStatement(sql);
               
               stmt.setInt(1, questionId);
               stmt.setInt(2, user.getUserId());
               
               int affectedRows = stmt.executeUpdate();
               if (affectedRows == 0) {
                   r = "ERROR";
               } else {
                   r = "SUCCESS";
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
        return r;
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
                Timestamp createDate = rs.getTimestamp("create_date");

                return new Question(questionId, userId, title, content, vote, createDate.toString());
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
                    Timestamp createDate = rs.getTimestamp("create_date");

                    questionList.add(new Question(questionId, userId, title, content, vote, createDate.toString()));
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
