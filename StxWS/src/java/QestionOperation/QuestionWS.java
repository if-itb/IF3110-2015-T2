/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QestionOperation;

import java.sql.*;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author Muhtar Hartopo
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {    
       /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getAllQuestion")
    @WebResult(name = "Question")
    public java.util.ArrayList<Question> getAllQuestion() throws Exception {
        //TODO write your implementation code here:
        ArrayList <Question> Questions  = new ArrayList<Question>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
                //new com.mysql.jdbc.Driver();
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename?user=username&password=password");
                String connectionUrl = "jdbc:mysql://localhost:3306/coppeng";
                String connectionUser = "root";
                String connectionPassword = "";
                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                ps = conn.prepareStatement("select * from question");
                rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String topic = rs.getString("topic");
                    String content = rs.getString("content");
                    int vote = rs.getInt("vote");

                    Questions.add(new Question(id, name, email, topic, content,vote));
                }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
          throw e;
        } finally {
          if(rs!= null) rs.close();
          if(ps!= null) ps.close();
        }
        return Questions;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "search")
    @WebResult(name = "Question")
    public ArrayList search(@WebParam(name = "key") String key) {
        //TODO write your implementation code here:
        ArrayList <Question> Questions  = new ArrayList<Question>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //new com.mysql.jdbc.Driver();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename?user=username&password=password");
            String connectionUrl = "jdbc:mysql://localhost:3306/coppeng";
            String connectionUser = "root";
            String connectionPassword = "";
            conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            ps = conn.prepareStatement("select * from question where topic like ? or content like ?;");
            ps.setString(1,"%"+key+"%");
            ps.setString(2, "%"+key+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String topic = rs.getString("topic");
                String content = rs.getString("content");
                int vote = rs.getInt("vote");

                Questions.add(new Question(id, name, email, topic, content,vote));
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
        } finally {
                try { if (rs != null) rs.close(); } catch (SQLException e) {}
                try { if (ps != null) ps.close(); } catch (SQLException e) {}
                try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }

        return Questions;
    }
    
    @WebMethod(operationName = "post")
    public int post(@WebParam(name = "Question") Question Q) {
        Connection conn = null;
        PreparedStatement ps = null;
        int res = 0;
        try {
                //new com.mysql.jdbc.Driver();
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename?user=username&password=password");
                String connectionUrl = "jdbc:mysql://localhost:3306/coppeng";
                String connectionUser = "root";
                String connectionPassword = "";
                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                ps = conn.prepareStatement("insert into question value('',?,?,?,?,0)");
                ps.setString(1, Q.getName());
                ps.setString(2, Q.getEmail());
                ps.setString(3, Q.getTopic());
                ps.setString(4, Q.getContent());
                res = ps.executeUpdate();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
        } finally {
                try { if (ps != null) ps.close(); } catch (SQLException e) {}
                try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
        return res;
    }
    
    @WebMethod(operationName = "update")
    public int update(@WebParam(name = "Question") Question Q) {
        
        Connection conn = null;
        PreparedStatement ps = null;
        int res = 0;
        try {
                //new com.mysql.jdbc.Driver();
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename?user=username&password=password");
                String connectionUrl = "jdbc:mysql://localhost:3306/coppeng";
                String connectionUser = "root";
                String connectionPassword = "";
                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                ps = conn.prepareStatement("update question set name = ?, email = ?, topic = ?, content = ? where id = ?;");
                ps.setString(1, Q.getName());
            
                ps.setString(2, Q.getEmail());
                ps.setString(3, Q.getTopic());
                ps.setString(4, Q.getContent());
                ps.setInt(5, Q.getId());
                res = ps.executeUpdate();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            
        } finally {
                try { if (ps != null) ps.close(); } catch (SQLException e) {}
                try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
        return res;
    }
    @WebMethod(operationName = "patchVote")
    public int patchVote(@WebParam(name = "id") int id, @WebParam(name = "vote") int vote) {
        Connection conn = null;
        PreparedStatement ps = null;
        int executeUpdate = 0;
        try {
                //new com.mysql.jdbc.Driver();
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename?user=username&password=password");
                String connectionUrl = "jdbc:mysql://localhost:3306/coppeng";
                String connectionUser = "root";
                String connectionPassword = "";
                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                ps = conn.prepareStatement("update question set vote = ? where id = ?");
                ps.setInt(1, vote);
                ps.setInt(2, id);
                executeUpdate = ps.executeUpdate();
                
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            return 0;
        } finally {
                try { if (ps != null) ps.close(); } catch (SQLException e) {}
                try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
        return executeUpdate;
    }
    
    @WebMethod(operationName = "delete")
    public void delete(@WebParam(name = "qid")int qid) {
        String Query = "delete from question where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
                //new com.mysql.jdbc.Driver();
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename?user=username&password=password");
                String connectionUrl = "jdbc:mysql://localhost:3306/coppeng";
                String connectionUser = "root";
                String connectionPassword = "";
                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                ps = conn.prepareStatement("delete from question where id = ?;");
                ps.setInt(1, qid);
                ps.executeUpdate();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
        } finally {
                try { if (ps != null) ps.close(); } catch (SQLException e) {}
                try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }
    @WebMethod(operationName = "getNumAnswer")
    public int getNumAnswer(@WebParam(name = "id") int id) {
        String Query = "delete from question where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int res = -1;
        try {
                //new com.mysql.jdbc.Driver();
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename?user=username&password=password");
                String connectionUrl = "jdbc:mysql://localhost:3306/coppeng";
                String connectionUser = "root";
                String connectionPassword = "";
                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                ps = conn.prepareStatement("SELECT COUNT(id) AS numAns FROM answer where q_id = ?");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                rs.next();
                res = rs.getInt("numAns");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
        } finally {
                try { if (ps != null) ps.close(); } catch (SQLException e) {}
                try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
        return res;
    }
}
