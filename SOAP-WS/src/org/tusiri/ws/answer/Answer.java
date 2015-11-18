package org.tusiri.ws.answer;
import javax.jws.WebMethod;
import javax.jws.WebService;

import java.util.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.tusiri.ws.db.DBConnection;
import org.tusiri.ws.question.QuestionItem;
import org.tusiri.ws.token_validity.CheckTokenValidity;
import org.tusiri.ws.token_validity.TokenValidity;

@WebService(endpointInterface = "org.tusiri.ws.answer.Answer")
public class Answer {
	@WebMethod
	public ArrayList<AnswerItem> getAnswerList(int id_question) {
		ArrayList<AnswerItem> questionItemList = new ArrayList<AnswerItem>();
		DBConnection dbc = new DBConnection();
		PreparedStatement stmt = dbc.getDBStmt();
		Connection conn = dbc.getConn();
		try{
			String sql = "SELECT *,user.username as username FROM answer "
					+ "INNER JOIN user ON answer.id_user = user.id_user "
					+ "WHERE id_question = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id_question);
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			
			// Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				
				int num_answer = rs.getInt("num_answer");
				int id_user = rs.getInt("id_user");
				String content = rs.getString("content");
				String answer_date = rs.getString("answer_date");
				int num_votes = rs.getInt("num_votes");
				String username = rs.getString("username");
				
				AnswerItem a = new AnswerItem(num_answer,id_question,id_user,content,answer_date,num_votes,username);
				questionItemList.add(a);
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
	
	@WebMethod
	public int createAnswer(String access_token,int id_question,String content) throws ClientProtocolException, IOException, ParseException{
		int status = 0;
		
		System.out.println(access_token);
		System.out.println(id_question);
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
					
					String sql = "INSERT INTO answer(id_question,id_user,content,answer_date,num_vote)"
							+ "VALUES(?,?,?,NOW(),0);"
							+ "UPDATE question SET num_answer = num_answer+1 WHERE id_question = ?";
					stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					stmt.setInt(1, id_question);
					stmt.setInt(2, validity.getIdUser());
					stmt.setString(3,content);
					stmt.setInt(4, id_question);
					stmt.executeUpdate();
					ResultSet rs = stmt.getGeneratedKeys();
		            while (rs.next()) {
		            	status = 1;
		            }
				} catch(SQLException se){
					//Handle errors for JDBC
					se.printStackTrace();
				} catch(Exception e){
					//Handle errors for Class.forName
					e.printStackTrace();
				}
			} else {
				status = -1;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}
}

