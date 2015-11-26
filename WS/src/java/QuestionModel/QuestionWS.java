/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionModel;

import AnswerModel.Answer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import ws.register.RegisterWS;

/**
 *
 * @author yoga
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {

    Connection conn = null;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getQuestionbyID")
    @WebResult(name = "Question")
    public ArrayList<Question> getQuestionbyID(@WebParam(name = "id") int id) {
        ArrayList<Question> questions = new ArrayList<Question>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stackexchange?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM questions WHERE QuestionID = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, id);
            ResultSet rs = dbStatement.executeQuery();
            /* Get every data returned by SQL query */
            int i = 0;
            while (rs.next()) {
                questions.add(new Question(rs.getInt("QuestionID"),
                        rs.getInt("Votes"),
                        rs.getInt("Answers"),
                        rs.getString("Topic"),
                        rs.getString("Question"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("Datetime")
                ));
                ++i;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getallQuestions")
    @WebResult(name = "Question")
    public ArrayList<Question> getallQuestions() {
        ArrayList<Question> questions = new ArrayList<Question>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stackexchange?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM questions";

            PreparedStatement dbStatement = conn.prepareStatement(sql);

            ResultSet rs = dbStatement.executeQuery();
            /* Get every data returned by SQL query */
            int i = 0;
            while (rs.next()) {
                questions.add(new Question(rs.getInt("QuestionID"),
                        rs.getInt("Votes"),
                        rs.getInt("Answers"),
                        rs.getString("Topic"),
                        rs.getString("Question"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("Datetime")
                ));
                ++i;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteQuestion")
    @WebResult(name = "Question")
    public int deleteQuestion(@WebParam(name = "id") int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stackexchange?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "DELETE FROM questions WHERE QuestionID = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, id);
            dbStatement.executeUpdate();
            /* Get every data returned by SQL query */

            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            return 2;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "InsertQuestion")
    @WebResult(name = "Question")
    public int InsertQuestion(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "topic") String topic, @WebParam(name = "content") String content) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stackexchange?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO questions (Votes,Answers,Topic,Question,Name,Email,Datetime) VALUES(0,0,?,?,?,?,NOW())";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setString(1, topic);
            dbStatement.setString(2, content);
            dbStatement.setString(3, name);
            dbStatement.setString(4, email);
            dbStatement.executeUpdate();
            /* Get every data returned by SQL query */

            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            return 2;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateQuestion")
    public int updateQuestion(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "topic") String topic, @WebParam(name = "content") String content, @WebParam(name = "id") int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stackexchange?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "UPDATE questions SET Topic=?,Question=?,Name=?,Email=? WHERE QuestionID=?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setString(1, topic);
            dbStatement.setString(2, content);
            dbStatement.setString(3, name);
            dbStatement.setString(4, email);
            dbStatement.setInt(5, id);
            dbStatement.executeUpdate();
            /* Get every data returned by SQL query */

            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            return 2;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

    /**
     * Web service operation up vote an answer
     */
    @WebMethod(operationName = "upQuestion")
    public String upQuestion(@WebParam(name = "qid") int qid) {
        int returnExecution = 0;
        
        String currentEmail = new String("");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stackexchange?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt = conn.createStatement();
            String currentAccessToken = "dfcc5e81-8c60-4d90-9b6e-7c6fba3eee55";
            String sql;
            returnExecution = returnExecution + 1;
            PreparedStatement dbStatement;
            //take the email from session asumsi bahwa token selalu bersama email
            sql = "SELECT email FROM sessions WHERE AccessToken = ?";
            sql = "SELECT Email FROM sessions WHERE AccessToken = ?";
            dbStatement = conn.prepareStatement(sql);
            dbStatement.setString(1, currentAccessToken);
            ResultSet rsEmail = dbStatement.executeQuery();
            //agar index berada di elemen pertama dan get email
            if(rsEmail.next()) {
                returnExecution = returnExecution + 1;
                //returnExecution = returnExecution + 1;
                currentEmail = rsEmail.getString("Email");
                return currentAccessToken;
            }
            
            //Melakukan pengecekan apakah sudah pernah di upvote atau tidak
            sql = "SELECT * FROM upquestion WHERE IDQuestion = ? AND email = ?";
            dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            dbStatement.setString(2, currentEmail);
            ResultSet rs = dbStatement.executeQuery();
            if(rs.next()){
            //agar index berada di elemen pertama
            //search apakah sudah pernah dilakukan vote up atau down sebelumnya 
                returnExecution = returnExecution + 2;
                //jika sudah totalVote == 1 maka dilarang vote up lagi
                if(rs.getInt("totalVote") == 1){
                    //do nothing
                    returnExecution = returnExecution + 3;
                } else { //total vote 0 atau -1
                    //Up the the question table
                    returnExecution = returnExecution + 5;
                    sql = "UPDATE questions SET Votes = Votes + 1 WHERE QuestionID = ?";
                    dbStatement = conn.prepareStatement(sql);
                    dbStatement.setInt(1, qid);
                    dbStatement.executeUpdate();
                    //Up the the relation of email and question in table upquestion
                    sql = "UPDATE upquestions SET totalVotes = totalVotes+1 WHERE IDQuestion = ? AND email = ?";
                    dbStatement = conn.prepareStatement(sql);
                    dbStatement.setInt(1, qid);
                    dbStatement.setString(2, currentEmail);
                    dbStatement.executeUpdate();
                }
            }
            

            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return currentEmail;
    }

    /**
     * Web service operation down vote an answer
     */
    @WebMethod(operationName = "downQuestion")
    public int downQuestion(@WebParam(name = "qid") int qid) {

        ArrayList<Answer> answers = new ArrayList<Answer>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stackexchange?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt = conn.createStatement();
            String sql;
            //Take the question
            sql = "UPDATE questions SET Votes=Votes-1 WHERE QuestionID = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            dbStatement.executeUpdate();

            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getQuestionSearch")
    public ArrayList<Question> getQuestionSearch(@WebParam(name = "search") String search) {
        ArrayList<Question> questions = new ArrayList<Question>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stackexchange?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM questions WHERE  Topic LIKE '%"+search+"%' or Question LIKE '%"+search+"%'";

            PreparedStatement dbStatement = conn.prepareStatement(sql);

            ResultSet rs = dbStatement.executeQuery();
            /* Get every data returned by SQL query */
            int i = 0;
            while (rs.next()) {
                questions.add(new Question(rs.getInt("QuestionID"),
                        rs.getInt("Votes"),
                        rs.getInt("Answers"),
                        rs.getString("Topic"),
                        rs.getString("Question"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("Datetime")
                ));
                ++i;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }

}
