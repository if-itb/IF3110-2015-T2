/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSModel;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class Question {
     public static ArrayList<WSModule.QuestionClass> getAllQuestion(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<WSModule.QuestionClass> questionList = new ArrayList<WSModule.QuestionClass>();
        WSModule.QuestionClass [] questionArray = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            final String localhost = "jdbc:mysql://localhost:3306/wbd2";
            final String USER = "root";
            final String PASS = "";

            //STEP 3: Open a connection
            conn = (Connection) DriverManager.getConnection(localhost,USER,PASS);



            //STEP 4: Execute a query
             String sql = "SELECT questionId, title, content, vote, `date`, userID FROM questions";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            
            ResultSet rs = stmt.executeQuery();
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int questionId  = rs.getInt("questionId");
                String title = rs.getString("title");
                String content = rs.getString("title");
                int vote  = rs.getInt("vote");
                String date = rs.getDate("date").toString();
                int userID  = rs.getInt("questionId");
                System.out.println(questionId);

                //construct Question
                WSModule.QuestionClass questionRecord = new WSModule.QuestionClass(questionId,title,content,vote,date,userID);

                //Adding Question to QuestionQueue
                questionList.add(questionRecord);

            }
            rs.close();
            stmt.close();
            conn.close();
      
            
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
       
        return questionList;
    }//end main
}//end JDBCExample
