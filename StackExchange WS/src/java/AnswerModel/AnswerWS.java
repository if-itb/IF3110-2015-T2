package AnswerModel;

import DB.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

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
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        String url = "jdbc:mysql://localhost:3306/stackexchange";
        String username = "root";
        String password = "";
        
        ArrayList<Answer> answers = new ArrayList<Answer>();
        
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM answer WHERE qid = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,qid);
            ResultSet rs = pstmt.executeQuery();
            
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
     * @param access_token
     * @param qid
     * @param content
     * @return 
     */
    @WebMethod(operationName = "answerQuestion")
    public String answerQuestion(@WebParam(name = "access_token") String access_token, @WebParam(name = "qid") int qid, @WebParam(name = "content") String content) {
        Connection conn = new Database().connect();
        //1.HTTP Request connection ke Identity Service, untuk memastikan pemilik access_token
        //2a.Jika access token kadaluarsa, respons expired token
        //2b.Jika access token tidak valid, respons error
        //2c.Jika access token valid, ambil user ID
        int userID = 0;
        try {
            Statement stmt = conn.createStatement();
            String sqlA = "INSERT INTO answer VALUES (0,?,?,0,?,?)";
            String sqlQ = "UPDATE question SET Answers=Answers+1 WHERE qid = ?";
            PreparedStatement pstmtA = conn.prepareStatement(sqlA);
            PreparedStatement pstmtQ = conn.prepareStatement(sqlQ);
            pstmtA.setInt(1, userID);
            pstmtA.setString(2, content);
            pstmtA.setInt(3, qid);
            SimpleDateFormat ft = new SimpleDateFormat("y-M-d H:m:s");
            pstmtA.setString(4, ft.format(new Date()));
            pstmtQ.setInt(1, qid);
            int a = pstmtA.executeUpdate();
            int b = pstmtQ.executeUpdate();
            stmt.close();
            return "Respons oke!";
        } catch (SQLException se) {
            return "Gagal!";
        }
    }
}
