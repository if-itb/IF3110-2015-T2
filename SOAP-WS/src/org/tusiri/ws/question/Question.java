package org.tusiri.ws.question;
import javax.jws.WebMethod;
import javax.jws.WebService;

import java.util.*;
import java.sql.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.tusiri.ws.db.DBConnection;


//This statement means that class "Bookstore.java" is the root-element of our example
@XmlRootElement(namespace = "de.vogella.xml.jaxb.model")
@WebService(endpointInterface = "org.tusiri.ws.question.Question")
public class Question {
	
	// XmLElementWrapper generates a wrapper element around XML representation
	@XmlElementWrapper(name = "bookList")
	// XmlElement sets the name of the entities
	@XmlElement(name = "book")
	private ArrayList<QuestionItem> bookList;
	private String name;
	private String location;
	
	@WebMethod
	public ArrayList<QuestionItem> getQuestionList() {
		ArrayList<QuestionItem> questionItemList = new ArrayList();
		DBConnection dbc = new DBConnection();
		Statement stmt = dbc.getDBStmt();
		try{
			String sql = "SELECT * FROM question";
			ResultSet rs = stmt.executeQuery(sql);
			
			// Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				int id_question  = rs.getInt("id_question");
				int id_user  = rs.getInt("id_user");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String content = rs.getString("content");
				String question_date = rs.getDate("question_date").toString();
				String topic = rs.getString("topic");
				int num_vote = rs.getInt("num_vote");
				
				QuestionItem q = new QuestionItem();
				q.setIDQuestion(id_question);
				q.setIDUser(id_user);
				q.setUsername(username);
				q.setEmail(email);
				q.setContent(content);
				q.setQuestionDate(question_date);
				q.setTopic(topic);
				q.setNumVote(num_vote);
				
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