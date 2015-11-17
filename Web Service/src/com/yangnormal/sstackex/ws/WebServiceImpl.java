package com.yangnormal.sstackex.ws;

import java.sql.*;
import javax.jws.WebService;

@WebService(endpointInterface = "com.yangnormal.sstackex.ws.WebServiceInterface")
public class WebServiceImpl implements WebServiceInterface{


	final String DB_URL="jdbc:mysql://localhost/mystackexchange";
	final String USER="root";
	final String PASS="";


    @Override
    public int register(String name, String email, String password) {
        int status = 0;
        return status;

    }

    @Override
    public void postQuestion(String token) {

    }

    @Override
    public void postAnswer(int qid, String token) {

    }

    @Override
    public void deleteQuestion(int qid, String token) {

    }

    @Override
    public String[] getQuestion(int qid) {
        Connection conn = null;
        Statement stmt = null;
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
            String query = "SELECT topic,vote,content,date,fullname FROM question JOIN user WHERE question.uid = qid";
            stmt = conn.createStatement();
            // Result Set
            ResultSet rs = stmt.executeQuery(query);
            // Put result into array
            question = new String[rs.getMetaData().getColumnCount()];
            for (i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                question[i] = rs.getString(i + 1);
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
            return question;
        }
    }

    @Override
	public String[][] getQuestionList(){
        Connection conn = null;
        Statement stmt = null;
        Statement stmt2 = null;
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
    public String[][] getAnswerList(int qid) {
        Connection conn = null;
        Statement stmt = null;
        Statement stmt2 = null;
        int i = 0;
        int j = 0;
        String answer[] = {"Failed"};
        String[][] answerList = new String[1][1];
        try{
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // Query
            String query = "SELECT answer.content,answer.vote,answer.date,fullname FROM answer JOIN user JOIN question WHERE user.id = answer.uid AND question.id = "+qid;
            String counter = "SELECT COUNT(answer.id) AS answers FROM answer JOIN user JOIN question WHERE user.id = answer.uid AND question.id = "+qid;
            stmt = conn.createStatement();
            stmt2 = conn.createStatement();
            // Result Set
            ResultSet rs = stmt.executeQuery(query);
            ResultSet cnt = stmt2.executeQuery(counter);
            cnt.next();
            // Put result into array
            System.out.println(cnt.getInt(1));
            answerList = new String[cnt.getInt(1)][rs.getMetaData().getColumnCount()];
            while (rs.next()) {
                answer = new String[rs.getMetaData().getColumnCount()];
                for (i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    answer[i] = rs.getString(i + 1);
                }
                answerList[j] = answer;
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
            return answerList;
        }
    }

    @Override
    public void vote(int qid, int direction) {
    }
}
