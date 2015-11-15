package AnswerModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

@WebService(serviceName = "AnswerWS")
public class AnswerWS {

    @WebMethod(operationName = "getAnswerByQID")
    @WebResult(name = "Answer")
    public List<Answer> getAnswerByQID(@WebParam(name = "qid") int qid) {
        
        List<Answer> answers = new ArrayList<Answer>();
        
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stackexchange2?zeroDateTimeBehaviour=convertToNull","root","dininta");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM answer where id_question = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            ResultSet rs = dbStatement.executeQuery();
            
            /* Get every data returned by SQLquery */
            int i = 0;
            while(rs.next()) {
                answers.add( new Answer(
                    rs.getInt("id"),
                    rs.getInt("id_question"),
                    rs.getInt("vote"),
                    rs.getString("content"),
                    rs.getString("date"),
                    rs.getString("username")));
                ++i;
            }
            rs.close();
            stmt.close();
        }
        catch(SQLException ex) {}
        return answers;
    }
}
