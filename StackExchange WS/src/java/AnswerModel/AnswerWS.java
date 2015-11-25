package AnswerModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

@WebService(serviceName = "AnswerWS")
public class AnswerWS {
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    private static final String CONN_STRING="jdbc:mysql://localhost/dadakanDB";
    @WebMethod(operationName = "getAnswerByQID")
    @WebResult(name="Answer")
    public ArrayList<Answer> getAnswerByQID(@WebParam(name = "qid") int qid) {
        ArrayList<Answer> answers = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnswerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dadakandb?zeroDateTimeBehavior=convertToNull","root","");
        

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM answers WHERE id_question = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1,qid);
            ResultSet result = dbStatement.executeQuery();
            int i = 0;
            while(result.next()) {
                answers.add(new Answer(result.getInt("id"),
                    result.getInt("id_user"),
                    result.getInt("id_question"),
                    result.getString("content"),
                    result.getString("timestamp")
                ));
                ++i;
            }
            result.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answers;
    }
}
