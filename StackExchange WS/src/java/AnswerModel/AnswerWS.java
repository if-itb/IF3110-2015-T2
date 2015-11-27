package AnswerModel;

import DB.Database;
import java.io.IOException;
import java.net.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.jws.*;
import javax.servlet.http.Cookie;

/**
 *
 * @author M. Fauzan Naufan
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {

    /**
     * Web service operation
     *
     * @param qid
     * @return
     */
    @WebMethod(operationName = "getAnswerByQID")
    @WebResult(name = "Answer")
    public ArrayList<Answer> getAnswerByQID(@WebParam(name = "qid") int qid) {
        Connection conn = new Database().connect();
        ArrayList<Answer> answers = new ArrayList();
        Statement stmt;
        ResultSet rs;

        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM answer WHERE qid = ? ORDER BY Votes DESC";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, qid);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                answers.add(new Answer(rs.getInt("AID"),
                        rs.getInt("UserID"),
                        rs.getString("content"),
                        rs.getInt("Votes"),
                        qid,
                        rs.getString("DateTime")
                ));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {

        }
        return answers;
    }

    /**
     * Web service operation
     *
     * @param access_token
     * @param qid
     * @param content
     * @return
     * @throws java.net.MalformedURLException
     */
    @WebMethod(operationName = "createAnswer")
    public String createAnswer(@WebParam(name = "access_token") String access_token, @WebParam(name = "qid") int qid, @WebParam(name = "content") String content) throws MalformedURLException, IOException {
        Connection conn = new Database().connect();
        Statement stmt;
        //1.HTTP Request connection ke Identity Service, untuk memastikan pemilik access_token
        URL IS = new URL("http://localhost:8082/Identity_Service/TokenValidator");
        HttpURLConnection connection = null;
        connection = (HttpURLConnection)IS.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        //2a.Jika access token kadaluarsa, respons expired token
        //2b.Jika access token tidak valid, respons error
        //2c.Jika access token valid, ambil user ID 
        int userID = 8;
        try {
            stmt = conn.createStatement();
            String sqlA = "INSERT INTO answer VALUES (0,?,?,0,?,?)";
            String sqlQ = "UPDATE question SET Answers=Answers+1 WHERE qid = ?";
            PreparedStatement pstmtA = conn.prepareStatement(sqlA);
            PreparedStatement pstmtQ = conn.prepareStatement(sqlQ);
            pstmtA.setInt(1, userID);
            pstmtA.setString(2, content);
            pstmtA.setInt(3, qid);
            SimpleDateFormat ft = new SimpleDateFormat("y-M-d H:m:s");
            pstmtA.setString(4, ft.format(new java.util.Date()));
            pstmtQ.setInt(1, qid);
            int a = pstmtA.executeUpdate();
            int b = pstmtQ.executeUpdate();
            stmt.close();
            return "Respons oke!";
        } catch (SQLException se) {
            return "Gagal!";
        }
    }

    /**
     * Web service operation
     * @param access_token
     * @param AID
     * @param voteUp
     * @return 
     */
    @WebMethod(operationName = "voteAnswer")
    public String voteAnswer(@WebParam(name = "access_token") String access_token, @WebParam(name = "AID") int AID, @WebParam(name = "voteUp") boolean voteUp) {
        Connection conn = new Database().connect();
        Statement stmt;
        //1.HTTP Request connection ke Identity Service, untuk memastikan pemilik access_token
        //2a.Jika access token kadaluarsa, respons expired token
        //2b.Jika access token tidak valid, respons error
        //2c.Jika access token valid, ambil user ID
        //Update ke DB : UPDATE question SET topic = title, content = new content, datetime = new datetime WHERE qid = 'qid'
        try {
            stmt = conn.createStatement();
            String sql;
            if (voteUp) {
                sql = "UPDATE answer SET Votes=Votes+1 WHERE aid = ?";
            } else {
                sql = "UPDATE answer SET Votes=Votes-1 WHERE aid = ?";
            }
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, AID);
            int a = pstmt.executeUpdate();
            return "Respons oke!";
        } catch (SQLException se) {
            return "Gagal!";
        }
    }
}
