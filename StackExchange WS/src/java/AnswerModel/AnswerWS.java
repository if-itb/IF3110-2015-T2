package AnswerModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
}
