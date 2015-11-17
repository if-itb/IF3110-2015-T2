/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionModel;


import Config.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author FiqieUlya
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {
    /**
     * Web service operation
     */
    private final DB db = new DB();
    private Connection conn;
    
    @WebMethod(operationName = "getQuestionByQid")
    @WebResult(name = "Question")
    public List<Question> getQuestionById(@WebParam(name = "qid") int qid) {
        List<Question> question = new ArrayList<Question>();
        conn = db.connect();
        
        try {
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM question where id_question = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            ResultSet rs = dbStatement.executeQuery();
            
            /* Get every data returned by SQLquery */
            int i = 0;
            while(rs.next()) {
                question.add( new Question(
                    rs.getInt("id_question"),
                    rs.getInt("vote"),
                    rs.getString("topic"),    
                    rs.getString("content"),
                    rs.getString("date"),
                    rs.getString("username")));
                ++i;
            }
            rs.close();
            stmt.close();
        }
        catch(SQLException ex) {}
        return question;
    }
}
