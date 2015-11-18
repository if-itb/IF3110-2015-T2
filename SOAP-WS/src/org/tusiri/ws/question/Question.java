package org.tusiri.ws.question;
import javax.jws.WebMethod;
import javax.jws.WebService;

import java.util.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.tusiri.ws.db.DBConnection;

import org.tusiri.ws.token_validity.CheckTokenValidity;
import org.tusiri.ws.token_validity.TokenValidity;

//This statement means that class "Bookstore.java" is the root-element of our example

@WebService(endpointInterface = "org.tusiri.ws.question.Question")
public class Question {
	
	@WebMethod
	public int createQuestion(String access_token,String title,String content) throws ClientProtocolException, IOException, ParseException{
		int q_id = 0;
		
		System.out.println(access_token);
		System.out.println(title);
		System.out.println(content);
		
		try {
			CheckTokenValidity checker = new CheckTokenValidity(access_token);
			TokenValidity validity = checker.check();
			
			if(validity.getIsValid()){
				//Masukkan ke database
				DBConnection dbc = new DBConnection();
				PreparedStatement stmt = dbc.getDBStmt();
				Connection conn = dbc.getConn();
				try{
					/*String sql = "INSERT INTO question(id_user,content,question_date,topic,num_vote)"
							+ "VALUES("+id_user+",'"+content+"',NOW(),'"+title+"',0)";*/
					String sql = "INSERT INTO question(id_user,content,question_date,topic,num_vote)"
							+ "VALUES(?,?,NOW(),?,0)";
					stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					stmt.setInt(1, validity.getIdUser());
					stmt.setString(2,content);
					stmt.setString(3,title);
					stmt.executeUpdate();
					ResultSet rs = stmt.getGeneratedKeys();
		            while (rs.next()) {
		               q_id = rs.getInt(1);
		            } 	
					System.out.println("q_id = " + q_id);
					//res = 1;
				} catch(SQLException se){
					//Handle errors for JDBC
					se.printStackTrace();
				} catch(Exception e){
					//Handle errors for Class.forName
					e.printStackTrace();
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return q_id;
	}
	
	@WebMethod
	public int editQuestion(String access_token,String title,String content, int id_question) throws ClientProtocolException, IOException, ParseException{
		int q_id = 0;
		
		System.out.println(access_token);
		System.out.println(title);
		System.out.println(content);
		System.out.println(id_question);
		
		try {
			CheckTokenValidity checker = new CheckTokenValidity(access_token);
			TokenValidity validity = checker.check();
			
			if(validity.getIsValid()){
				//Masukkan ke database
				DBConnection dbc = new DBConnection();
				PreparedStatement stmt = dbc.getDBStmt();
				Connection conn = dbc.getConn();
				try{
					String sql = "UPDATE question SET content = ?, topic = ?, question_date() = NOW() WHERE id_question = ?";
					stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					stmt.setString(1,content);
					stmt.setString(2,title);
					stmt.setInt(3, id_question);
					stmt.executeUpdate();
					ResultSet rs = stmt.getGeneratedKeys();
		            while (rs.next()) {
		               q_id = rs.getInt(1);
		            } 	
					System.out.println("q_id = " + q_id);
					//res = 1;
				} catch(SQLException se){
					//Handle errors for JDBC
					se.printStackTrace();
				} catch(Exception e){
					//Handle errors for Class.forName
					e.printStackTrace();
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return q_id;
	}
	
	@WebMethod
	public int deleteQuestion(String access_token,int id_question) throws ClientProtocolException, IOException, ParseException{
		int q_id = 0;
		
		System.out.println(access_token);
		System.out.println(id_question);
		
		try {
			CheckTokenValidity checker = new CheckTokenValidity(access_token);
			TokenValidity validity = checker.check();
			
			if(validity.getIsValid()){
				//Masukkan ke database
				DBConnection dbc = new DBConnection();
				PreparedStatement stmt = dbc.getDBStmt();
				Connection conn = dbc.getConn();
				try{
					String sql = "DELETE FROM question WHERE id_question = ?; "
							+ "DELETE FROM answer WHERE id_question = ?";
					stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					stmt.setInt(1, id_question);
					stmt.setInt(2, id_question);
					stmt.executeUpdate();
					ResultSet rs = stmt.getGeneratedKeys();
		            while (rs.next()) {
		               q_id = rs.getInt(1);
		            } 	
					System.out.println("q_id = " + q_id);
					//res = 1;
				} catch(SQLException se){
					//Handle errors for JDBC
					se.printStackTrace();
				} catch(Exception e){
					//Handle errors for Class.forName
					e.printStackTrace();
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return q_id;
	}
	
	@WebMethod
	public ArrayList<QuestionItem> getQuestionList() {
		ArrayList<QuestionItem> questionItemList = new ArrayList();
		DBConnection dbc = new DBConnection();
		PreparedStatement stmt = dbc.getDBStmt();
		Connection conn = dbc.getConn();
		try{
			String sql = "SELECT * FROM question NATURAL JOIN user";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			// Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				int id_question  = rs.getInt("id_question");
				int id_user  = rs.getInt("id_user");
				String content = rs.getString("content");
				String question_date = rs.getDate("question_date").toString();
				String topic = rs.getString("topic");
				int num_vote = rs.getInt("num_vote");
				String username = rs.getString("username");
				
				QuestionItem q = new QuestionItem();
				q.setIDQuestion(id_question);
				q.setIDUser(id_user);
				q.setContent(content);
				q.setQuestionDate(question_date);
				q.setTopic(topic);
				q.setNumVote(num_vote);
				q.setUsername(username);
				
				questionItemList.add(q);
			}
		} catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		} catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		return questionItemList;
	}
} 