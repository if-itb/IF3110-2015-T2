package StackExchange;

//import StackExchange.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class MySQLAccess {
    private Connection connect;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public MySQLAccess() {}
        
    private void open() {
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

    private void close() {
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

    private void writeResultSet(ResultSet resultSet) throws SQLException{
        // resultSet is initialised before the first data set
       /* open();
        try{
            int count=0;
        while (resultSet.next()){
            count++;
            // it is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g., resultSet.getSTring(2);
            /*String barcode = resultSet.getString("barcode");
            String nama = resultSet.getString("nama_produk");
            String tag = resultSet.getString("tag");
            System.out.println("barcode: " + barcode);
            System.out.println("nama " + nama);
            System.out.println("tag " + tag);
        }
        if(count==0){
            String S="INSERT INTO 'stackexchange'.'question' ('id', 'vote') VALUES ('"+ id + "', '"+ vote +"');";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        }
        else{
            String S = "UPDATE 'stackexchange'.'question' SET 'vote' = '"+vote+"'  WHERE 'question'.'id' ="+id+";";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
        }
        }catch(SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }

	
	/*
    public List getUser(){
        List<User> listuser=new ArrayList();
        open();
        try {
            preparedStatement = connect.prepareStatement("SELECT * FROM user;");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                listuser.add(new User(resultSet.getString("username"),resultSet.getString("password"), 
                        resultSet.getString("email"), resultSet.getString("role")));
            }
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
        return listuser;
    }
    
    public User getSpesificUser(String username) {
        User user = new User();
        open();
        try {
            preparedStatement = connect.prepareStatement("SELECT * FROM user WHERE username='"+username+"';");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setUser(resultSet.getString("username"), resultSet.getString("password"),
                        resultSet.getString("email"), resultSet.getString("role"));
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    */
	
	
    public List getQuestion(){
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
    
    public Question getQuestionId(int id)
    {
        Question questionId=new Question();
        open();
        try {
                preparedStatement = connect.prepareStatement("SELECT * FROM question WHERE 'id'="+ id + ";");
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next())
                {
                    questionId.setQuestion(resultSet.getInt("id"),resultSet.getInt("id_user"), 
                            resultSet.getString("topic"),resultSet.getString("content"),resultSet.getTimestamp("timepost"));
                }
                close();
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
        return questionId;
    }
    
    public List getAnswer(int id)
    {
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
    
    public void addQuestion(int id, int id_user, String topic, String content, String timepost)
    {
        open();
        try {
            int i;
            //if(publish){i=1;}
            //else{i=0;}
            String S = "INSERT INTO 'stackexchange'.'question' ('id', 'id_user', 'topic', 'content', 'timepost') VALUES (NULL, '"+id_user+"', '"+topic+"', '"+content+"', '"+timepost+"');";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
    
    public void updateQuestion(int id, String topic, String content, String timepost)
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
    
    public void deleteQuestion(int id)
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
    
    public int getUserID(String username)
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
    /*
    public void publishPost(int idPost)
    {
        Post post = getPostId(idPost);
        int published = post.publish;
        open();
        try {
            String S = null;
            if(published==1)
            {
                S = "UPDATE `simpleblog`.`post` SET `publish`=0 WHERE `post`.`id post` ="+idPost+";";
            }
            else
            {
                S = "UPDATE `simpleblog`.`post` SET `publish`=1 WHERE `post`.`id post` ="+idPost+";";
            }
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
	*/
    
    public void addAnswer(int id, int id_question, int id_user, String content, String timepost)
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
    

    public void addUser(String username, String email, String password)
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
    /*
     public void updateUser(int id, String username, String password, String email, String role)
    {
        open();
        try {
            String S = "UPDATE `simpleblog`.`user` SET `username` = '"+username+"', `password` = '"+password+"', `email` = '"+email+"', `role` = '"+role+"' WHERE `id` ="+id+";";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
    
    public void deleteUser(int id)
    {
        open();
        try {
            String S = "DELETE FROM `simpleblog`.`user` WHERE `user`.`id` ="+id+";";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }
	*/

    /*com.mysql.jdbc.Statement createStatement() {
       throw new UnsupportedOperationException("Not yet implemented");
    }*/

    /*
    public String getRolebyUsername(String username) {
        open();
        String role = "";
        try{
            preparedStatement = connect.prepareStatement("SELECT `role` FROM `simpleblog`.`user` WHERE username=\""+username+"\";");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                role = resultSet.getString("role");
            }
            close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return role; 
    }*/

    void voteQuestion(int id, int vote) {
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
    
    void voteAnswer(int id, int vote) {
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
    
       /* try {
            String S="INSERT INTO 'stackexchange'.'question' ('id', 'vote') VALUES ('"+ id + "', '"+ vote +"');";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);

            close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }*/

    /*public void updateVote(int id, int vote)
    {
        open();
        try {
            String S = "UPDATE 'stackexchange'.'question' SET 'vote' = '"+vote+"'  WHERE 'question'.'id' ="+id+";";
            preparedStatement = connect.prepareStatement(S);
            statement.executeUpdate(S);
            close();
        } catch (SQLException e) {    
            e.printStackTrace();
        }
    }*/
    
}
