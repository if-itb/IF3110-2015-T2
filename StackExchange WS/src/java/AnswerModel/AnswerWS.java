package AnswerModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "AnswerWS")
public class AnswerWS {
    Connection conn = DB.connect();
    @WebMethod(operationName = "getAnswerByQID")
    @WebResult(name="Answer")
    public ArrayList<Answer> getAnswerByQID(@WebParam(name = "qid") int qid) {
        ArrayList<Answer> answers = new ArrayList<Answer>();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM answers WHERE id_question = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1,qid);
            ResultSet rs = dbStatement.executeQuery();
            int i = 0;
            while(rs.next()) {
                answers.add(new Answer(
                                    rs.getInt("id"),
                                    rs.getInt("id_question"),
                                    rs.getInt("id_user"),
                                    rs.getString("content"),
                                    rs.getString("timestamp")
                                )       
                );
                ++i;
            }
            rs.close();
            stmt.close();
        }
        catch (SQLException ex){
            Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answers;
    }
}
