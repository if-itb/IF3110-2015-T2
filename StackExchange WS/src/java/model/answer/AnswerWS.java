/*
 * To change this license header, choose License Headeresult in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.answer;

import com.sun.istack.logging.Logger;
import connection.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author Adz
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {
    
    /**
     * Connecting to Database
     * DB is another java file where DB settings is there
     */
    Connection conn = DB.connect();


    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswerByQID")
    @WebResult(name = "Answer")
    public List<Answer> getAnswerByQID(@WebParam(name = "qid") int qid) {
        List<Answer> answeresult = new ArrayList<>();
        
        try{
            String sql;
            sql = "SELECT * FROM answer WHERE id_question = ?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, qid);
            
            ResultSet result = statement.executeQuery();
            
            /* Get every data returned by SQL Query */
            int i = 0;
            while(result.next()){
                answeresult.add(new Answer(result.getInt("id"),
                                        result.getInt("id_question"),
                                        result.getInt("id_user"),
                                        result.getString("content"),
                                        result.getString("timestamp")
                ));
                i++;
            }
            
            result.close();
        }
        catch(SQLException ex){
            Logger.getLogger(AnswerWS.class).log(Level.SEVERE, null, ex);
        }
        
        //TODO write your implementation code here:
        return answeresult;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addAnswer")
    @WebResult(name = "Answer")
    public boolean addAnswer(@WebParam(name = "idQuestion") int idQuestion,
                            @WebParam(name = "idUser") int idUser, 
                            @WebParam(name = "content") String content) throws SQLException 
    {
        boolean success = false;
        PreparedStatement statement = null;
        
        try{
            String sql;
            sql = "INSERT INTO answer(id_question, id_user, content) VALUES (?,?,?)";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, idQuestion);
            statement.setInt(2, idUser);
            statement.setString(3, content);
            
            success = statement.executeUpdate() > 0;
        }
        catch(SQLException ex){
            Logger.getLogger(AnswerWS.class).log(Level.SEVERE, null, ex);
        }
        finally{
            if(statement != null)
                statement.close();
        }
        
        //TODO write your implementation code here:
        return success;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteAnswerUpByID")
    @WebResult(name = "Answer")
    public boolean voteAnswerUpByID(@WebParam(name = "idAnswer") int idAnswer, int idUser) throws SQLException {
        boolean success = false;
        boolean available = isVoteAnswerAvailable(idUser, idAnswer);
        PreparedStatement statement = null;
        
        if(available == true){
            try{
                /* update vote value in answer table */
                String sql;
                sql = "UPDATE answer SET votes = votes + 1 WHERE id_answer = ?";
                
                statement = conn.prepareStatement(sql);
                statement.setInt(1, idAnswer);
                
                sql = "INSERT INTO vote_answer VALUES (?, ?)";
                
                statement = conn.prepareStatement(sql);
                statement.setInt(1, idUser);
                statement.setInt(2, idAnswer);
                
                success = statement.executeUpdate() > 0;
            }
            catch(SQLException ex){
                Logger.getLogger(AnswerWS.class).log(Level.SEVERE, null, ex);
            }
            finally{
                if(statement != null)
                    statement.close();
            }
            
            return success;
        }
        
        //TODO write your implementation code here:
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isVoteAnswerAvailable")
    @WebResult(name = "Answer")
    public boolean isVoteAnswerAvailable(@WebParam(name = "idUser") int idUser, @WebParam(name = "idAnswer") int idAnswer) throws SQLException {
        boolean available = false;
        PreparedStatement statement = null;
                
        try{
            String sql;
            sql = "SELECT * FROM vote_answer WHERE id_user = ? AND id_answer = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, idUser);
            statement.setInt(2, idAnswer);
            
            available = statement.execute();
        }
        catch(SQLException ex){
            Logger.getLogger(AnswerWS.class).log(Level.SEVERE, null, ex);
        }
        finally{
            if(statement != null)
                statement.close();
        }
        
        //TODO write your implementation code here:
        return available;
    }
}
