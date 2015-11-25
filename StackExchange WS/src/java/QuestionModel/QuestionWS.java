package QuestionModel;

import DB.Database;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.*;

/**
 *
 * @author M. Fauzan Naufan
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {

    /**
     * Web service operation
     *
     * @param access_token
     * @param title
     * @param content
     * @return
     */
    @WebMethod(operationName = "createQuestion")
    public String createQuestion(@WebParam(name = "access_token") String access_token, @WebParam(name = "title") String title, @WebParam(name = "content") String content) {
        Connection conn = new Database().connect();
        Statement stmt;
        //1.HTTP Request connection ke Identity Service, untuk memastikan pemilik access_token
        //2a.Jika access token kadaluarsa, respons expired token
        //2b.Jika access token tidak valid, respons error
        //2c.Jika access token valid, ambil user ID
        int userID = 0;
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO question VALUES (0,?,?,?,0,?,0)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            SimpleDateFormat ft = new SimpleDateFormat("y-M-d H:m:s");
            pstmt.setString(4, ft.format(new Date()));
            int a = pstmt.executeUpdate();
            stmt.close();
            return "Respons oke!";
        } catch (SQLException se) {
            return "Gagal!";
        }
    }

    /**
     * Web service operation
     *
     * @param qid
     * @param access_token
     * @param title
     * @param content
     * @return
     */
    @WebMethod(operationName = "editQuestion")
    public String editQuestion(@WebParam(name = "qid") int qid, @WebParam(name = "access_token") String access_token, @WebParam(name = "title") String title, @WebParam(name = "content") String content) {
        Connection conn = new Database().connect();
        Statement stmt;
        //1.HTTP Request connection ke Identity Service, untuk memastikan pemilik access_token
        //2a.Jika access token kadaluarsa, respons expired token
        //2b.Jika access token tidak valid, respons error
        //2c.Jika access token valid, ambil user ID
        //Update ke DB : UPDATE question SET topic = title, content = new content, datetime = new datetime WHERE qid = 'qid'
        try {
            stmt = conn.createStatement();
            String sql = "UPDATE question SET topic=?, content=?, datetime=? WHERE qid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            SimpleDateFormat ft = new SimpleDateFormat("y-M-d H:m:s");
            pstmt.setString(3, ft.format(new Date()));
            pstmt.setInt(4, qid);
            int a = pstmt.executeUpdate();
            stmt.close();
            return "Respons oke!";
        } catch (SQLException se) {
            return "Gagal!";
        }
    }

    /**
     * Web service operation
     *
     * @param qid
     * @param access_token
     * @return
     */
    @WebMethod(operationName = "deleteQuestion")
    public String deleteQuestion(@WebParam(name = "qid") int qid, @WebParam(name = "access_token") String access_token) {
        Connection conn = new Database().connect();
        Statement stmt;
        //1.HTTP Request connection ke Identity Service, untuk memastikan pemilik access_token
        //2a.Jika access token kadaluarsa, respons expired token
        //2b.Jika access token tidak valid, respons error
        //2c.Jika access token valid, ambil user ID
        try {
            stmt = conn.createStatement();
            String sqlQ = "DELETE FROM question WHERE qid = ?";
            String sqlA = "DELETE FROM answer WHERE qid = ?";
            PreparedStatement pstmtQ = conn.prepareStatement(sqlQ);
            PreparedStatement pstmtA = conn.prepareStatement(sqlA);
            pstmtQ.setInt(1, qid);
            pstmtA.setInt(1, qid);
            int a = pstmtQ.executeUpdate();
            int b = pstmtA.executeUpdate();
            stmt.close();
            return "Respons oke!";
        } catch (SQLException se) {
            return "Gagal!";
        }
    }

    /**
     * Web service operation
     *
     * @param access_token
     * @param qid
     * @param voteUp
     * @return
     */
    @WebMethod(operationName = "voteQuestion")
    public String voteQuestion(@WebParam(name = "access_token") String access_token, @WebParam(name = "qid") int qid, @WebParam(name = "voteUp") boolean voteUp) {
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
                sql = "UPDATE question SET Votes=Votes+1 WHERE qid = ?";
            } else {
                sql = "UPDATE question SET Votes=Votes-1 WHERE qid = ?";
            }
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, qid);
            int a = pstmt.executeUpdate();
            return "Respons oke!";
        } catch (SQLException se) {
            return "Gagal!";
        }
    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "getAllQuestion")
    public ArrayList<Question> getAllQuestion() {
        Connection conn = new Database().connect();
        Statement stmt;
        ResultSet rs;

        ArrayList<Question> questions = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM question";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                questions.add(new Question(rs.getInt("QID"),
                        rs.getInt("UserID"),
                        rs.getString("Topic"),
                        rs.getString("Content"),
                        rs.getInt("Votes"),
                        rs.getString("DateTime"),
                        rs.getInt("Answers")
                ));
            }
        } catch (SQLException ex) {

        }
        return questions;
    }

    /**
     * Web service operation
     *
     * @param qid
     * @return
     */
    @WebMethod(operationName = "getQuestionByQID")
    public ArrayList<Question> getQuestionByQID(@WebParam(name = "qid") int qid) {
        Connection conn = new Database().connect();
        Statement stmt;
        ResultSet rs;

        ArrayList<Question> questions = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM question WHERE qid = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, qid);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                questions.add(new Question(rs.getInt("QID"),
                        rs.getInt("UserID"),
                        rs.getString("Topic"),
                        rs.getString("Content"),
                        rs.getInt("Votes"),
                        rs.getString("DateTime"),
                        rs.getInt("Answers")
                ));
            }
        } catch (SQLException ex) {

        }
        return questions;
    }
}
