package org.tusiri.ws.answer;
import javax.jws.WebMethod;
import javax.jws.WebService;

import java.util.*;
import java.sql.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.tusiri.ws.db.DBConnection;
import org.tusiri.ws.question.QuestionItem;

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
	
	
}

