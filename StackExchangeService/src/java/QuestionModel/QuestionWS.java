/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionModel;


import Authentication.Auth;
import Config.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private final DB db = new DB();
    private final Auth auth= new Auth();
    private Connection conn;
    private static String getCurrentTimeStamp() {
        Calendar cal = Calendar.getInstance();  
	Timestamp now = new Timestamp(cal.getTimeInMillis());
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now); 
    }

    /**
     *
     * @param qid
     * @return
     */
    @WebMethod(operationName = "getQuestionByQID")
    @WebResult(name = "Question")
    public List<Question> getQuestionByQID(@WebParam(name = "qid") int qid) {
        
        List<Question> question = new ArrayList<Question>();
        
        conn = db.connect();
        
        try {
            Statement stmt;
            stmt = conn.createStatement();
            
            String sql;
            sql = "SELECT * FROM question where id_question = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);

            ResultSet rs;
            rs = dbStatement.executeQuery();            
            /* Get every data returned by SQLquery */
            while(rs.next()) {
                question.add( new Question(
                    rs.getInt("id_question"),
                    rs.getInt("vote"),
                    rs.getString("topic"),    
                    rs.getString("content"),
                    rs.getString("date"),
                    rs.getString("username")));
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException ex) {
           Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
        return question;
    }
    
    @WebMethod(operationName = "createQuestion")
    public  Boolean createQuestion(@WebParam(name = "username") String uname , 
            @WebParam(name = "topic") String topic,
            @WebParam(name = "token") String token,
            @WebParam(name = "content") String content){
        conn = db.connect();
        Boolean status = true;
        if(auth.checkToken(token)){
            try {
                Statement stmt;
                stmt = conn.createStatement();
                String sql;
                sql = "INSERT INTO question (topic, username,content,vote,date)VALUES (?, ?, ?, 0, ?)";

                PreparedStatement dbStatement = conn.prepareStatement(sql);
                dbStatement.setString(1, topic);
                dbStatement.setString(2, uname);
                dbStatement.setString(3, content);
                dbStatement.setString(4, getCurrentTimeStamp());

                status= dbStatement.execute();

                stmt.close();
                conn.close();
            }
            catch(SQLException ex) {
               Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
        return status;
    }
    
    @WebMethod(operationName = "getQuestions")
    @WebResult(name = "Questions")
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<Question>();
        conn = db.connect();
        try {
            Statement stmt;
            stmt = conn.createStatement();
            
            String sql;
            sql = "SELECT * FROM question ORDER BY date DESC";
            PreparedStatement dbStatement = conn.prepareStatement(sql);

            ResultSet rs;
            rs = dbStatement.executeQuery();            
            /* Get every data returned by SQLquery */
            while(rs.next()) {
             int temp = getAnswerById(rs.getInt("id_question"));
                questions.add( new Question(
                    temp,
                    rs.getInt("id_question"),
                    rs.getInt("vote"),
                    rs.getString("topic"),    
                    rs.getString("content"),
                    rs.getString("date"),
                    rs.getString("username")));
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException ex) {
           Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
        return questions;
    }
    
    @WebMethod(operationName = "getVoteById")
    @WebResult(name = "vote")
    public int getVoteById(@WebParam(name = "qid") int qid) {
        int count= 0;
        conn = db.connect();
        try {
            Statement stmt;
            stmt = conn.createStatement();
            
            String sql;
            sql = "SELECT vote FROM question where id_question = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            
            ResultSet rs;
            rs = dbStatement.executeQuery();
            
            /* Get every data returned by SQLquery */
            while(rs.next()) {
                count = rs.getInt("vote");
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException ex) {
           Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
        return count;
    }
    @WebMethod(operationName = "getAnswerById")
    public int getAnswerById(@WebParam(name = "qid") int qid) {
        int count= 0;
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
                count++;
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException ex) {
           Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
        return count;
    }
    @WebMethod(operationName = "voteUp")
    public int voteUp(@WebParam(name = "qid") int qid,@WebParam(name = "username") String username,@WebParam(name = "token") String token ){
        int count=0;
        conn = db.connect();
        if(auth.checkToken(token)){
            try {
                Statement stmt;
                stmt = conn.createStatement();

                String sql, sql_select;
                sql="UPDATE question SET vote = vote+ 1 WHERE id_question = ? ";
                sql_select = "SELECT vote FROM question where id_question = ?";

                PreparedStatement dbStatement = conn.prepareStatement(sql);
                dbStatement.setInt(1, qid);
                dbStatement.execute();

                sql="INSERT INTO vote_question (id_question, username) VALUES (?,?)";
                PreparedStatement dbStatement2 = conn.prepareStatement(sql);
                dbStatement2.setInt(1, qid);
                dbStatement2.setString(2, username);
                dbStatement2.execute();

                PreparedStatement dbStatementSelect = conn.prepareStatement(sql_select);
                dbStatementSelect.setInt(1, qid);

                ResultSet rs;
                rs = dbStatementSelect.executeQuery();

                /* Get every data returned by SQLquery */
                while(rs.next()) {
                    count = rs.getInt("vote");
                }
                rs.close();
                stmt.close();
                conn.close();
            }
            catch(SQLException ex) {
               Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
        return count;
    }
    @WebMethod(operationName = "voteDown")
    public int voteDown(@WebParam(name = "qid") int qid,@WebParam(name = "username") String username,@WebParam(name = "token") String token ){
        int count=0;
        conn = db.connect();
        if(auth.checkToken(token)){
            try {
                Statement stmt;
                stmt = conn.createStatement();

                String sql, sql_select;
                sql="UPDATE question SET vote = vote- 1 WHERE id_question = ? ";
                sql_select = "SELECT vote FROM question where id_question = ?";

                PreparedStatement dbStatement = conn.prepareStatement(sql);
                dbStatement.setInt(1, qid);
                dbStatement.execute();

                sql="INSERT INTO vote_question (id_question, username) VALUES (?,?)";
                PreparedStatement dbStatement2 = conn.prepareStatement(sql);
                dbStatement2.setInt(1, qid);
                dbStatement2.setString(2, username);
                dbStatement2.execute();

                PreparedStatement dbStatementSelect = conn.prepareStatement(sql_select);
                dbStatementSelect.setInt(1, qid);

                ResultSet rs;
                rs = dbStatementSelect.executeQuery();

                /* Get every data returned by SQLquery */
                while(rs.next()) {
                    count = rs.getInt("vote");
                }
                rs.close();
                stmt.close();
                conn.close();
            }
            catch(SQLException ex) {
               Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
        return count;
    }
    
    @WebMethod(operationName = "deleteQuestionById")
    public Boolean deleteQuestionById(@WebParam(name = "qid") int qid,@WebParam(name = "token") String token){
        int count=0;
        conn = db.connect();
        Boolean status= true;
        if(auth.checkToken(token)){ 
            try {
               Statement stmt;
               stmt = conn.createStatement();

               String sql;

               sql = "DELETE FROM question where id_question = ?";

               PreparedStatement dbStatement = conn.prepareStatement(sql);
               dbStatement.setInt(1, qid);
               status=dbStatement.execute();

               stmt.close();
               conn.close();
            }
            catch(SQLException ex) {
               Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
         return status;
    }
    @WebMethod(operationName = "isVoted")
    public Boolean isVoted(@WebParam(name = "qid") int qid,@WebParam(name = "username") String username){
        Boolean status = false;
        conn = db.connect();
        
         try {
            Statement stmt;
            stmt = conn.createStatement();
            
            String sql;
            sql="Select * from vote_question where id_question = ? and username = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            dbStatement.setString(2, username);

            ResultSet rs;
            rs = dbStatement.executeQuery();
            
            /* Get every data returned by SQLquery */
            while(rs.next()) {
                status= true;
            }
            
            stmt.close();
            conn.close();
        }
        catch(SQLException ex) {
           Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return status;
    }
     @WebMethod(operationName = "searchQuestion")
    public List<Question> searchQuestion(@WebParam(name = "keyword") String keyword){
        List<Question> questions = new ArrayList<Question>();
        conn = db.connect();
        
         try {
            Statement stmt;
            stmt = conn.createStatement();
            
            String sql;
            sql="SELECT * FROM question WHERE topic LIKE '%?%' OR content LIKE '%?%' ORDER BY Date DESC";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setString(1, keyword);
            dbStatement.setString(2, keyword);

            ResultSet rs;
            rs = dbStatement.executeQuery();
            
             while(rs.next()) {
             int temp = getAnswerById(rs.getInt("id_question"));
                questions.add( new Question(
                    temp,
                    rs.getInt("id_question"),
                    rs.getInt("vote"),
                    rs.getString("topic"),    
                    rs.getString("content"),
                    rs.getString("date"),
                    rs.getString("username")));
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException ex) {
           Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return questions;
    }
    
}

