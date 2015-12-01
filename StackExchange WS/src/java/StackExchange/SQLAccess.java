/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackExchange;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author adar
 */
@WebService(serviceName = "SQLAccess")
@Stateless()
public class SQLAccess {
    private Connection connect;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public SQLAccess() {}
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "open")
    public void open() {
        try {
            // load MySQL driver
            Class.forName("com.mysql.jdbc.Driver"); //....

            // setup the connection with the DB.
            connect = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/stackexchange?zeroDateTimeBehavior=convertToNull", "root",""); //....

            statement = connect.createStatement();
        } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
    
    @WebMethod(operationName = "close")
    public void close() {
        try {
            if (resultSet != null) {
                    resultSet.close();
            }
            if (statement != null) {
                    statement.close();
            }
            if (preparedStatement != null) {
                    preparedStatement.close();
            }
            if (connect != null) {
                    connect.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @WebMethod(operationName = "getQuestion")
    public List getQuestion() {
        List<Question> listquestion=new ArrayList();
        open();
        try {
                preparedStatement = connect.prepareStatement("SELECT * FROM question ORDER BY 'id' DESC;");
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next())
                {
                    listquestion.add(new Question(resultSet.getInt("id"),resultSet.getInt("id_user"),resultSet.getString("topic"),resultSet.getString("content"),resultSet.getTimestamp("timepost")));
                }
                close();
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            return listquestion;
    }
    
    @WebMethod(operationName = "getQuestionID")
    public Questions getQuestionID(@WebParam(name = "id") int id) {
        Questions questionId=new Questions();
        open();
        try {
                preparedStatement = connect.prepareStatement("SELECT * FROM question WHERE 'id'="+ id + ";");
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next())
                {
                    questionId.setQuestions(resultSet.getInt("id"),resultSet.getInt("id_user"), 
                            resultSet.getString("topic"),resultSet.getString("content"),resultSet.getTimestamp("timepost"));
                }
                close();
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
        return questionId;
    }
    
    @WebMethod(operationName = "getAnswer")
    public List getAnswer(@WebParam(name = "id") int id) {
        List<Answer> listanswer=new ArrayList();
        open();
        try {
                preparedStatement = connect.prepareStatement("SELECT * FROM answer WHERE 'id'="+ id +";");
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next())
                {
                    listanswer.add(new Answer(resultSet.getInt("id"),resultSet.getInt("id_question"),resultSet.getInt("id_user"),
                            resultSet.getString("content"),resultSet.getTimestamp("timepost")));
                }
                close();
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            return listanswer;
    }
    
    @WebMethod(operationName = "addQuestion")
    public void addQuestion(@WebParam(name = "id") int id, @WebParam(name = "id_user") int id_user, @WebParam(name = "topic") String topic, @WebParam(name = "content") String content, @WebParam(name = "timepost") String timepost) {
        open();
        try {
            int i;
            String S = "INSERT INTO 'stackexchange'.'question' ('id', 'id_user', 'topic', 'content', 'timepost') VALUES (NULL, '"+id_user+"', '"+topic+"', '"+content+"', '"+timepost+"');";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
    
    @WebMethod(operationName = "updateQuestion")
    public void updateQuestion(@WebParam(name = "id") int id, @WebParam(name="topic") String topic, @WebParam(name="content") String content, @WebParam(name="timepost") String timepost)
    {
        open();
        try {
            String S = "UPDATE 'stackexchange'.'question' SET 'topic' = '"+topic+"', 'content' = '"+content+"', 'timepost' = '"+timepost+"' WHERE 'question'.'id' ="+id+";";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
    
    @WebMethod(operationName = "deleteQuestion")
    public void deleteQuestion(@WebParam(name = "id")int id)
    {
        open();
        try {
            String S = "DELETE FROM 'question'.'question' WHERE 'question'.'id' ="+id+";";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
    
    @WebMethod(operationName = "getMaxId")
    public int getMaxId()
    {
        int id = 0;
        open();
        try {
            preparedStatement = connect.prepareStatement("SELECT 'id' FROM 'stackexchange'.'question ORDER BY 'id' DESC LIMIT 1;");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                id = resultSet.getInt("id");
            }
            close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return id;
    }
    
    @WebMethod(operationName = "getUserID")
    public int getUserID(@WebParam(name="username")String username)
    {
        int id = 0;
        open();
        try {
            preparedStatement = connect.prepareStatement("SELECT 'id' FROM 'stackexchange'.'user' WHERE username=\""+username+"\";");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                id = resultSet.getInt("id");
            }
            close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return id;
    }
    
    @WebMethod(operationName="addAnswer")
    public void addAnswer(@WebParam(name="id") int id, @WebParam(name="id_question") int id_question, @WebParam(name="id_user") int id_user, @WebParam(name="content") String content, @WebParam(name="timepost") String timepost)
    {
        open();
        try {
            String S="INSERT INTO 'stackexchange'.'answer' ('id', 'id_question', 'id_user', 'content', 'timepost') VALUES ('"+ id + "', '"+ id_question +"','"+ id_user +"', '"+ content +"', '"+timepost+"');";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);

            close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
    
    @WebMethod(operationName = "addUser")
    public void addUser(@WebParam(name="username") String username, @WebParam(name="email") String email, @WebParam(name="password") String password)
    {
        open();
        try {
            
            String S = "INSERT INTO 'stackexchange'.'user' ('username','email','password') VALUES ('" + username + "', '"+ email +"', '"+password+"');";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
    
    @WebMethod(operationName = "voteQuestion")
    void voteQuestion(@WebParam(name = "id") int id, @WebParam(name = "vote") int vote) {
        open();
            try {
                int count=0;
                preparedStatement = connect.prepareStatement("SELECT * FROM vote_question WHERE id_user = 'id_user' AND id_question = 'id_question';");
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next())
                {
                    count++;
                    //listquestion.add(new Question(resultSet.getInt("id"),resultSet.getInt("id_user"),resultSet.getString("topic"),resultSet.getString("content"),resultSet.getTimestamp("timepost")));
                }
                if(count==0){
            String S="INSERT INTO 'stackexchange'.'question' ('id', 'vote') VALUES ('"+ id + "', '"+ vote +"');";
        }
        else{
            String S = "UPDATE 'stackexchange'.'question' SET 'vote' = '"+vote+"'  WHERE 'question'.'id' ="+id+";";
        }
             close();  
            }
        catch (SQLException e) {    
            e.printStackTrace();
        }
    }
    
    @WebMethod(operationName = "voteAnswer")
    public void voteAnswer(@WebParam(name = "id") int id,@WebParam(name = "vote") int vote) {
        open();
            try {
                int count=0;
                preparedStatement = connect.prepareStatement("SELECT * FROM vote_answer WHERE id_user = 'id_user' AND id_question = 'id_question' AND id = 'id';");
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next())
                {
                    count++;
                    //listquestion.add(new Question(resultSet.getInt("id"),resultSet.getInt("id_user"),resultSet.getString("topic"),resultSet.getString("content"),resultSet.getTimestamp("timepost")));
                }
                if(count==0){
            String S="INSERT INTO 'stackexchange'.'answer' ('id', 'vote') VALUES ('"+ id + "', '"+ vote +"');";
        }
        else{
            String S = "UPDATE 'stackexchange'.'answer' SET 'vote' = '"+vote+"'  WHERE 'question'.'id' ="+id+" AND 'answer'.'id'="+id+";";
        }
             close();  
            }
        catch (SQLException e) {    
            e.printStackTrace();
        }
    }
}
