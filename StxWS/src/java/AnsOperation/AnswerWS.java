/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnsOperation;

import java.sql.*;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author Asus
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "getAnswer")
    @WebResult(name = "Answer")
    public ArrayList<Answer> getAnswer(@WebParam(name = "q_id") int q_id) throws SQLException {
        ArrayList<Answer> Ans = new ArrayList<Answer>();
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
                ps = conn.prepareStatement("select * from answer where q_id = ?");
                ps.setInt(1, q_id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int qid = rs.getInt("q_id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String content = rs.getString("content");
                    int vote = rs.getInt("vote");
                    Ans.add(new Answer(id, qid, name, email, content,vote));
                }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
        } finally {
          if(rs!= null) rs.close();
          if(ps!= null) ps.close();
        }
        return Ans;
        
    }
        
    @WebMethod(operationName = "post")
    public int post(@WebParam(name = "Ans") Answer Ans) {
        int res = -1;
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
                ps = conn.prepareStatement("insert into Answer value('',?,?,?,?,0)");
                ps.setInt(1, Ans.getQid());
                ps.setString(2, Ans.getNama());
                ps.setString(3, Ans.getEmail());
                ps.setString(4, Ans.getKonten());
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
                ps = conn.prepareStatement("update Answer set vote = ? where id = ?");
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
    public int delete(@WebParam(name = "id")int id) {
        String Query = "delete from answer where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        int res= -1;
        try {
                //new com.mysql.jdbc.Driver();
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename?user=username&password=password");
                String connectionUrl = "jdbc:mysql://localhost:3306/coppeng";
                String connectionUser = "root";
                String connectionPassword = "";
                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                ps = conn.prepareStatement("delete from Answer where id = ?;");
                ps.setInt(1, id);
                res = ps.executeUpdate();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
        } finally {
                try { if (ps != null) ps.close(); } catch (SQLException e) {}
                try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
        return res;
    }
}
