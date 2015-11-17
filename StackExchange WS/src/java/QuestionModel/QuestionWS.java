/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionModel;

import DB.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author M. Fauzan Naufan
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {    
    /**
     * Web service operation
     * @param access_token
     * @param title
     * @param content
     * @return 
     */
    @WebMethod(operationName = "createQuestion")
    public String createQuestion(@WebParam(name = "access_token") String access_token, @WebParam(name = "title") String title, @WebParam(name = "content") String content) {
        Connection conn = new Database().connect();
        //1.HTTP Request connection ke Identity Service, untuk memastikan pemilik access_token
        //2a.Jika access token kadaluarsa, respons expired token
        //2b.Jika access token tidak valid, respons error
        //2c.Jika access token valid, ambil user ID
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO question VALUES (0,1,?,?,0,?,0)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            SimpleDateFormat ft = new SimpleDateFormat("y-M-d H:m:s");
            pstmt.setString(3, ft.format(new Date()));
            int a = pstmt.executeUpdate();
            stmt.close();
            return "Respons oke!";
        } catch (SQLException se) {
            return "Gagal!";
        }
    }

    /**
     * Web service operation
     * @param qid
     * @param access_token
     * @param title
     * @param content
     * @return 
     */
    @WebMethod(operationName = "editQuestion")
    public String editQuestion(@WebParam(name = "qid") int qid, @WebParam(name = "access_token") String access_token, @WebParam(name = "title") String title, @WebParam(name = "content") String content) {
        Connection conn = new Database().connect();
        //1.HTTP Request connection ke Identity Service, untuk memastikan pemilik access_token
        //2a.Jika access token kadaluarsa, respons expired token
        //2b.Jika access token tidak valid, respons error
        //2c.Jika access token valid, ambil user ID
        //Update ke DB : UPDATE question SET topic = title, content = new content, datetime = new datetime WHERE qid = 'qid'
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE question SET topic=?, content=?, datetime=? WHERE qid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            SimpleDateFormat ft = new SimpleDateFormat("y-M-d H:m:s");
            pstmt.setString(3, ft.format(new Date()));
            pstmt.setInt(4,qid);
            int a = pstmt.executeUpdate();
            stmt.close();
            return "Respons oke!";
        } catch (SQLException se) {
            return "Gagal!";
        }
    }

    /**
     * Web service operation
     * @param qid
     * @param access_token
     * @return 
     */
    @WebMethod(operationName = "deleteQuestion")
    public String deleteQuestion(@WebParam(name = "qid") int qid, @WebParam(name = "access_token") String access_token) {
        Connection conn = new Database().connect();
        //1.HTTP Request connection ke Identity Service, untuk memastikan pemilik access_token
        //2a.Jika access token kadaluarsa, respons expired token
        //2b.Jika access token tidak valid, respons error
        //2c.Jika access token valid, ambil user ID
        try {
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM question WHERE qid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, qid);
            int a = pstmt.executeUpdate();
            stmt.close();
            return "Respons oke!";
        } catch (SQLException se) {
            return "Gagal!";
        }
    }

}
