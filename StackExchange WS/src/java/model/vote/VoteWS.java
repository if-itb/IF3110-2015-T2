/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vote;

import java.sql.PreparedStatement;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import connection.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS X202E
 */
@WebService(serviceName = "VoteWS")
public class VoteWS {
    Connection conn = DB.connect();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "hasVotedQuestion")
    public boolean hasVotedQuestion(@WebParam(name = "question_id") int question_id, @WebParam(name = "user_id") int user_id) {
        boolean voted = false;
        try {
            String sql = "SELECT count(*) AS vote FROM vote_question WHERE question_id = ? AND user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, question_id);
            stmt.setInt(2, user_id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            if (rs.getInt("vote")!=0) voted = true;
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VoteWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voted;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "hasVotedAnswer")
    public boolean hasVotedAnswer(@WebParam(name = "answer_id") int answer_id, @WebParam(name = "user_id") int user_id) {
        boolean voted = false;
        try {
            String sql = "SELECT count(*) AS vote FROM vote_answer WHERE answer_id = ? AND user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, answer_id);
            stmt.setInt(2, user_id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            if (rs.getInt("vote")!=0) voted = true;
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VoteWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voted;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getQuestionVotes")
    public int getQuestionVotes(@WebParam(name = "question_id") int question_id) {
        int votecount = 0;
        try {
            String sql = "SELECT vote FROM question WHERE question_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, question_id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            votecount = rs.getInt("vote");
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VoteWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return votecount;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswerVotes")
    public int getAnswerVotes(@WebParam(name = "answer_id") int answer_id) {
        int votecount = 0;
        try {
            String sql = "SELECT vote FROM answer WHERE answer_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, answer_id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            votecount = rs.getInt("vote");
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VoteWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return votecount;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteQuestion")
    @Oneway
    public void voteQuestion(@WebParam(name = "question_id") int question_id, @WebParam(name = "user_id") int user_id, @WebParam(name = "vote") int vote) {
        if (!hasVotedQuestion(question_id,user_id)) {
            try {
                String sql = "UPDATE question SET vote = vote+? WHERE question_id = ?";
                PreparedStatement stmt1 = conn.prepareStatement(sql);
                stmt1.setInt(1, vote);
                stmt1.setInt(2,question_id);
                int i = stmt1.executeUpdate();
                stmt1.close();
                if (i>0) {
                    sql = "INSERT INTO vote_question (question_id, user_id) VALUES (?,?)";
                    PreparedStatement stmt2 = conn.prepareStatement(sql);
                    stmt2.setInt(1,question_id);
                    stmt2.setInt(2,user_id);
                    stmt2.executeUpdate();
                    stmt2.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VoteWS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteAnswer")
    @Oneway
    public void voteAnswer(@WebParam(name = "answer_id") int answer_id, @WebParam(name = "user_id") int user_id, @WebParam(name = "vote") int vote) {
        if (!hasVotedAnswer(answer_id,user_id)) {
            try {
                String sql = "UPDATE answer SET vote = vote+? WHERE answer_id = ?";
                PreparedStatement stmt1 = conn.prepareStatement(sql);
                stmt1.setInt(1, vote);
                stmt1.setInt(2,answer_id);
                int i = stmt1.executeUpdate();
                stmt1.close();
                if (i>0) {
                    sql = "INSERT INTO vote_answer (answer_id, user_id) VALUES (?,?)";
                    PreparedStatement stmt2 = conn.prepareStatement(sql);
                    stmt2.setInt(1,answer_id);
                    stmt2.setInt(2,user_id);
                    stmt2.executeUpdate();
                    stmt2.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VoteWS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
