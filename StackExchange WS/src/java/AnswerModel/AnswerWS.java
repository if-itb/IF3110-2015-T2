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
        ArrayList<Answer> answers;
        answers = new ArrayList<>();
        int i = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/stackexchange";
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM answer WHERE qid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, qid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int aid = rs.getInt("AID");
                int uid = rs.getInt("UserID");
                String content = rs.getString("Content");
                int votes = rs.getInt("Votes");
                int qid1 = qid;
                String datetime = rs.getString("DateTime");
                answers.add(new Answer(aid, uid, content, votes, qid, datetime));
                i++;
            }
            stmt.close();
        } catch (SQLException ex) {
        }
        System.out.println(i);
        return answers;
    }
}
