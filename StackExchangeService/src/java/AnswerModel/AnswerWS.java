package AnswerModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import Config.DB;

@WebService(serviceName = "AnswerWS")
public class AnswerWS {
    
    private final DB db = new DB();
    private Connection conn;

    /**
     *
     * @param qid
     * @return
     */
    @WebMethod(operationName = "getAnswerByQID")
    @WebResult(name = "Answer")
    public List<Answer> getAnswerByQID(@WebParam(name = "qid") int qid) {
        
        List<Answer> answers = new ArrayList<Answer>();
        
        conn = db.connect();
        
        try {
            Statement stmt;
            stmt = conn.createStatement();
            
            String sql;
            sql = "SELECT * FROM answer where id_question = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            
            ResultSet rs;
            rs = dbStatement.executeQuery();
            
            /* Get every data returned by SQLquery */
            while(rs.next()) {
                answers.add( new Answer(
                    rs.getInt("id_answer"),
                    rs.getInt("id_question"),
                    rs.getInt("vote"),
                    rs.getString("content"),
                    rs.getString("date"),
                    rs.getString("username")));
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException ex) {
           Logger.getLogger(AnswerWS.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
        return answers;
    }
    
}
