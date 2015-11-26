package com.yangnormal.sstackex.ws;

import java.sql.*;
import java.util.ArrayList;
import javax.jws.WebService;
import com.yangnormal.sstackex.ws.classes.*;
import org.json.*;


@WebService(endpointInterface = "com.yangnormal.sstackex.ws.WebServiceInterface")
public class WebServiceImpl implements WebServiceInterface{


    final String DB_URL="jdbc:mysql://localhost/mystackexchange";
    final String USER="root";
    final String PASS="";

    public int checkToken(int uid, String token) throws Exception{
        int status = 0;
        HttpConnection http = new HttpConnection();
        JSONObject obj = new JSONObject(http.sendGet("http://localhost:8083/v1/check?token="+token+"&uid="+uid));
        System.out.println(obj.get("status").toString());
        return (int)obj.get("status");
    }

    @Override
    public int register(String name, String email, String password) {
        int status = 0;
        Connection conn = null;
        Statement stmt = null;
        Statement stmt2 = null;
        try{
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // Query
            String check= "SELECT COUNT(id) as cnt FROM user WHERE email = '"+email+"'";
            String query = "INSERT INTO user (fullname, email, password) " + "VALUES ('"+name+"','"+email+"',"+"MD5('"+password+"'))";
            System.out.println(query);
            System.out.println(check);
            stmt = conn.createStatement();
            stmt2 = conn.createStatement();
            ResultSet c = stmt2.executeQuery(check);
            c.next();
            if (c.getInt(1) == 0){
                stmt.executeUpdate(query);
            }
            else {
                status = -1; // email has been used
            }
        }
        catch (SQLException se){
            se.printStackTrace();
            System.out.println("SQL register Error");
            status = -1;
        }
        catch (Exception e){
            e.printStackTrace();
            status = -1;
        }
        finally{
            return status;
        }


    }

    @Override
    public int postQuestion(int uid, String token, String title, String content) throws Exception{
        if (checkToken(uid, token) == 1){
            Connection conn = null;
            Statement stmt = null;
            try{
                // Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
                // Open a connection
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                // Query
                String query = "INSERT INTO question (vote, topic, content, date, uid) VALUES (0,'"+title+"','"+content+"',CURRENT_TIMESTAMP,"+uid+")";
                stmt = conn.createStatement();
                // Result Set
                stmt.executeUpdate(query);
            }
            catch (SQLException se){
                se.printStackTrace();
                System.out.println("SQL post question Error");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(checkToken(uid, token));
        return (checkToken(uid, token));
    }

    @Override
    public int postAnswer(int qid, int uid, String token, String content) throws Exception{
        if (checkToken(uid, token) == 1){
            Connection conn = null;
            Statement stmt = null;
            try{
                // Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
                // Open a connection
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                // Query
                String query = "INSERT INTO answer (vote, content, date, uid, qid) VALUES (0,'"+content+"',CURRENT_TIMESTAMP,"+uid+","+qid+")";
                stmt = conn.createStatement();
                // Result Set
                stmt.executeUpdate(query);
            }
            catch (SQLException se){
                se.printStackTrace();
                System.out.println("SQL post answer Error");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return (checkToken(uid, token));
    }

    @Override
    public int deleteQuestion(int qid, int uid, String token) throws Exception{
        if (checkToken(uid, token) == 1){
            Connection conn = null;
            Statement stmt = null;
            try{
                // Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
                // Open a connection
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                // Query
                String query = "DELETE from question WHERE id="+qid;
                stmt = conn.createStatement();
                // Result Set
                stmt.executeUpdate(query);
            }
            catch (SQLException se){
                se.printStackTrace();
                System.out.println("SQL delete question Error");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return (checkToken(uid, token));
    }

    @SuppressWarnings("ValidExternallyBoundObject")
    @Override
    public Question getQuestion(int qid) {
        Connection conn = null;
        Statement stmt = null;
        int i = 0;
        String question[] = {"Failed"};
        Question q = new Question();
        String[][] questionList = new String[1][1];
        try{
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // Query
            String query = "SELECT question.topic,question.vote,question.content,question.date,question.uid,fullname,count(answer.qid) as answerSum " +
                    "FROM question LEFT JOIN user ON (question.id = user.id) LEFT JOIN answer ON (question.id = answer.id) " +
                    "WHERE question.id = "+qid+" " +
                    "GROUP BY question.id, question.topic, question.content, question.vote, question.date";
            stmt = conn.createStatement();
            // Result Set
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                q.setContent(rs.getString("content"));
                q.setTopic(rs.getString("topic"));
                q.getUser().setName(rs.getString("fullname"));
                q.setVote(rs.getInt("vote"));
                q.setDate(rs.getString("date"));
                q.setAnswerSum(rs.getInt("answerSum"));
            }

        }
        catch (SQLException se){
            se.printStackTrace();
            System.out.println("SQL get question Error");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            return q;
        }
    }

    @Override
    public String[] getQuestionArray(int qid) {
        Connection conn = null;
        Statement stmt = null;
        int i = 0;
        String question[] = {"Failed"};
        try{
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // Query
            String query = "SELECT topic,vote,content,date,fullname FROM question JOIN user WHERE question.id ="+qid;
            stmt = conn.createStatement();
            // Result Set
            ResultSet rs = stmt.executeQuery(query);
            // Put result into array
            rs.next();
            question = new String[rs.getMetaData().getColumnCount()];

            for (i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                question[i] = rs.getString(i + 1);
            }

        }
        catch (SQLException se){
            se.printStackTrace();
            System.out.println("SQL get question Error");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            return question;
        }
    }

    @Override
    public Question[] getQuestionList(){
        ArrayList<Question> questionList = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;

        try{
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // Query
            String query = "SELECT question.topic,question.vote,question.content,question.date,question.uid,fullname,count(answer.qid) as answerSum " +
                    "FROM question LEFT JOIN user ON (question.uid = user.id) LEFT JOIN answer ON (question.id = answer.id) " +
                    "GROUP BY question.id, question.topic, question.content, question.vote, question.date";
            stmt = conn.createStatement();
            // Result Set
            ResultSet rs = stmt.executeQuery(query);
            // Put result into array
            while (rs.next()) {
                Question q = new Question();
                q.setContent(rs.getString("content"));
                q.setTopic(rs.getString("topic"));
                q.getUser().setName(rs.getString("fullname"));
                q.setVote(rs.getInt("vote"));
                q.setDate(rs.getString("date"));
                q.setAnswerSum(rs.getInt("answerSum"));
                questionList.add(q);
            }

        }
        catch (SQLException se){
            se.printStackTrace();
            System.out.println("SQL get question list Error");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            Question[] qList = questionList.toArray(new Question[questionList.size()]);
            return qList;
        }

    }

    @Override
    public Answer[] getAnswerList(int qid){
        Connection conn = null;
        Statement stmt = null;
        ArrayList<Answer> answerList = new ArrayList<>();
        try{
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // Query
            String query = "SELECT answer.id,answer.content,answer.vote,answer.date,fullname FROM answer JOIN user ON (answer.uid=user.id) JOIN question ON (answer.qid=user.id) WHERE question.id = "+qid;
            stmt = conn.createStatement();
            // Result Set
            ResultSet rs = stmt.executeQuery(query);
            // Put result into array
            while (rs.next()) {
                Answer answer = new Answer();
                answer.setId(rs.getInt("id"));
                answer.setVote(rs.getInt("vote"));
                answer.setContent(rs.getString("content"));
                answer.setDate(rs.getString("date"));
                answer.getUser().setName(rs.getString("fullname"));
                answer.setQid(qid);
                answerList.add(answer);
            }

        }
        catch (SQLException se){
            se.printStackTrace();
            System.out.println("SQL get answer list Error");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            Answer[] alist = answerList.toArray(new Answer[answerList.size()]);
            return alist;
        }
    }

    @Override
	public String[][] getQuestionListArray(){
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
			System.out.println("SQL get question list Error");
		}
		catch (Exception e){
			e.printStackTrace();
		}
        finally{
            return questionList;
        }

	}

    @Override
    public String[][] getAnswerListArray(int qid) {
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
            System.out.println("SQL get answer list Error");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            return answerList;
        }
    }

    @Override
    public int vote(int type, int id, int direction, int uid, String token) throws Exception{
        if (checkToken(uid, token) == 1){
            Connection conn = null;
            Statement stmt = null;
            Statement stmt2 = null;
            String query = "";
            String query2 = "";
            try{
                // Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
                // Open a connection
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                // Query
                if (type == 0) { // vote question
                    if (direction == 1) { // up
                        query = "UPDATE question SET vote = vote + 1 WHERE id=" + id;
                    } else if (direction == -1){ // down
                        query = "UPDATE question SET vote = vote - 1 WHERE id=" + id;
                    }
                    query2 = "INSERT INTO vote_question (qid, uid, vote) VALUES ("+id+","+uid+","+direction+")";
                }
                else if (type == 1) { // vote answer
                    if (direction == 1) { // up
                        query = "UPDATE answer SET vote = vote + 1 WHERE id=" + id;
                    } else if (direction == -1){ // down
                        query = "UPDATE answer SET vote = vote - 1 WHERE id=" + id;
                    }
                    query2 = "INSERT INTO vote_answer (aid, uid, vote) VALUES ("+id+","+uid+","+direction+")";
                }

                stmt = conn.createStatement();
                stmt2 = conn.createStatement();
                // Result Set
                stmt.executeUpdate(query);
                stmt2.executeUpdate(query2);
            }
            catch (SQLException se){
                se.printStackTrace();
                System.out.println("SQL vote Error");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return (checkToken(uid, token));
    }

    @Override
    public int updateQuestion(int qid, int uid, String token, String title, String content) throws Exception{
        if (checkToken(uid, token) == 1){
            Connection conn = null;
            Statement stmt = null;
            try{
                // Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
                // Open a connection
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                // Query
                String query = "UPDATE question (vote, topic, content, date, uid) VALUES (0,'"+title+"','"+content+"',CURRENT_TIMESTAMP,"+uid+")";
                stmt = conn.createStatement();
                // Result Set
                stmt.executeUpdate(query);
            }
            catch (SQLException se){
                se.printStackTrace();
                System.out.println("SQL post question Error");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return (checkToken(uid, token));
    }
    @Override
    public int updateAnswer(int aid, int qid, int uid, String token, String content) throws Exception{
        if (checkToken(uid, token) == 1){
            Connection conn = null;
            Statement stmt = null;
            try{
                // Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
                // Open a connection
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                // Query
                String query = "INSERT INTO answer (vote, content, date, uid, qid) VALUES (0,'"+content+"',CURRENT_TIMESTAMP,"+uid+","+qid+")";
                stmt = conn.createStatement();
                // Result Set
                stmt.executeUpdate(query);
            }
            catch (SQLException se){
                se.printStackTrace();
                System.out.println("SQL post answer Error");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return (checkToken(uid, token));
    }
}
