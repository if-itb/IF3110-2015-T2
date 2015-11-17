package com.yangnormal.sstackex.ws;

import java.sql.*;
import javax.jws.WebService;

@WebService(endpointInterface = "com.yangnormal.sstackex.ws.WebServiceInterface")
public class WebServiceImpl implements WebServiceInterface{


	final String DB_URL="jdbc:mysql://localhost/mystackexchange";
	final String USER="root";
	final String PASS="";
	Connection conn = null;
	Statement stmt = null;
    Statement stmt2 = null;

    @Override
    public String printMessage() {
        return "Hello World!";
    }

    @Override
    public void register() {

    }

    @Override
    public void postQuestion() {

    }

    @Override
    public void postAnswer() {

    }

    @Override
    public void deleteQuestion() {

    }

    @Override
    public String[][] getQuestion() {
        return new String[0][];
    }

    @Override
	public String[][] getQuestionList(){
        int i = 0;
        int j = 0;
        String question[] = {"Failed"};
        String[][] questionList = new String[1][1];
		try{
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Open a connection
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // Query
            String query = "SELECT topic,vote,content,date,fullname FROM question JOIN user WHERE user.id = question.uid";
            String counter = "SELECT COUNT(id) AS questions FROM question";
            stmt = conn.createStatement();
            stmt2 = conn.createStatement();
            // Result Set
            ResultSet rs = stmt.executeQuery(query);
            ResultSet cnt = stmt2.executeQuery(counter);
            cnt.next();
            // Put result into array
            System.out.println(cnt.getInt(1));
            questionList = new String[cnt.getInt(1)][rs.getMetaData().getColumnCount()];
            while (rs.next()) {
                question = new String[rs.getMetaData().getColumnCount()];
                for (i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    question[i] = rs.getString(i + 1);
                }
                questionList[j] = question;
                j++;

            }

		}
		catch (SQLException se){
			se.printStackTrace();
			System.out.println("SQL Error");
		}
		catch (Exception e){
			e.printStackTrace();
		}
        finally{
            return questionList;
        }

	}

    @Override
    public String[][] getAnswerList() {
        return new String[0][];
    }
}
