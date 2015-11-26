package stackExchangeWS.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author davidkwan
 */
public class DbQuestionManager {
    private static Connection conn = null;
        public static void askQuestion(Question question) throws SQLException{
            conn = ConnectionManager.getInstance().getConnection();
            String sql = "INSERT INTO question (askerId, topic, content) VALUES(?,?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, question.getAskerId());
            pstmt.setString(2, question.getTopic());
            pstmt.setString(3, question.getContent());
            
            pstmt.executeUpdate();
            ConnectionManager.getInstance().close();
	}
        
        public static Question selectQuestion(int questionId) throws SQLException{
            conn = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM question WHERE questionId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, questionId);
            ResultSet rs = pstmt.executeQuery();
            
            Question question = new Question();
            while(rs.next()){
                question.setQuestionId(rs.getInt("questionId"));
                question.setAskerId(rs.getInt("askerId"));
                question.setAskerId(rs.getInt("askerId"));
                question.setTopic(rs.getString("topic"));
                question.setContent(rs.getString("content"));
                question.setTime(rs.getString("time"));
            }
            
            ConnectionManager.getInstance().close();
            
            return question;
        }
        
        public static ArrayList<Question> getAllQuestions() throws SQLException{
            conn = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM question";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            ArrayList<Question> questions = new ArrayList<Question>();
            while(rs.next()){
                Question question = new Question();
                question.setQuestionId(rs.getInt("questionId"));
                question.setAskerId(rs.getInt("askerId"));
                question.setAskerId(rs.getInt("askerId"));
                question.setTopic(rs.getString("topic"));
                question.setContent(rs.getString("content"));
                question.setTime(rs.getString("time"));
                
                questions.add(question);
            }
            
            ConnectionManager.getInstance().close();
            
            return questions;
        }
        
        public static void voteQuestion(int questionId, int userId, int value) throws SQLException{
            conn = ConnectionManager.getInstance().getConnection();
            
            // Check whether user has ever vote or not
            String SelectSql = "SELECT * FROM votes_question WHERE questionId = ? AND voter=?";
            PreparedStatement pstmt = conn.prepareStatement(SelectSql);
            
            pstmt.setInt(1, questionId);
            pstmt.setInt(2, userId);
            ResultSet rs = pstmt.executeQuery();
            
            // No row available
            if(rs.next() == false){
                String updateSql = "INSERT INTO votes_question VALUES (?, ?, ?)";
                pstmt = conn.prepareStatement(updateSql);
                
                pstmt.setInt(1, questionId);
                pstmt.setInt(2, userId);
                pstmt.setInt(3, value);
                pstmt.executeUpdate();
            }
            else{
                int vote = rs.getInt("value");
                vote = (vote == -value)?value:vote^value; // If negative of value, change it to the opposite, else vote/unvote.
                
                String updateSql = "UPDATE votes_question SET value=? WHERE questionId = ? AND voter = ?";
                pstmt = conn.prepareStatement(updateSql);
                
                pstmt.setInt(1, vote);
                pstmt.setInt(2, questionId);
                pstmt.setInt(3, userId);
                pstmt.executeUpdate();
            }
            
            ConnectionManager.getInstance().close();
            
        }
        
        public static int countVoteQuestion(int questionId) throws SQLException{
            conn = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT SUM(value) FROM votes_question WHERE questionId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, questionId);
            ResultSet rs = pstmt.executeQuery();
            
            int countVote = 0;
            while(rs.next()){
                countVote = rs.getInt("SUM(value)");
            }
            
            ConnectionManager.getInstance().close();
            
            return countVote;
        }
        
        public static void editQuestion(int questionId, String topic, String content) throws SQLException{
            conn = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE question SET topic = ?, content = ? WHERE questionId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, topic);
            pstmt.setString(2, content);
            pstmt.setInt(3, questionId);
            
            pstmt.executeUpdate();
            ConnectionManager.getInstance().close();
        }
        
        public static void deleteQuestion(int questionId) throws SQLException{
            conn = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM question WHERE questionId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, questionId);
            
            pstmt.executeUpdate();
            ConnectionManager.getInstance().close();
        }
}
