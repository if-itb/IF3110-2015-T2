/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Class.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author tama
 */
@WebService(serviceName = "NewWebService")
public class StackWebSevice {
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost/stack";
    
        static final String USER = "root";
        static final String PASS = "" ;
        
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    @WebMethod(operationName = "countAnswer")
        public int countAnswer(@WebParam(name="qid") int qid) {
            Connection conn = null ; 
            Statement stmt = null ;
            ResultSet rs =null;
            int ret = 0 ;
            try {
                Class.forName("com.mysql.jdbc.Driver");                
                conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                String sql = "SELECT COUNT(id_a) as total FROM answer WHERE q_id="+qid;
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);                
                rs.next();
                ret = rs.getInt("total");
                stmt.close();
                conn.close();
            }
            catch (Exception e) {
                e.printStackTrace() ;
            }
            return ret ;
        }
    
        @WebMethod(operationName="getAllQuestions")
        public ArrayList<Question> getAllQuestions() {
            Connection conn = null ; 
            Statement stmt = null ;
            ResultSet rs =null;
            ArrayList<Question> ret = new ArrayList<Question>() ;
            
            try {
                Class.forName("com.mysql.jdbc.Driver");                
                conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                String sql = "SELECT * FROM question";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Question Q = new Question();
                    int aa =rs.getInt("id_q");
                    Q.id_q = aa;
                    Q.title = rs.getString("title");
                    Q.content = rs.getString("content");
                    Q.vote = rs.getInt("vote");
                    Q.date = rs.getString("date");
                    Q.username = rs.getString("username");
                    Q.email = rs.getString("email"); 
                    Q.tanswer = countAnswer(aa);
                    ret.add(Q);
                }
                stmt.close();
                conn.close();
            }
            catch (Exception e) {
                e.printStackTrace() ;
            }
            return ret ;
        }
               
        @WebMethod(operationName="getQuestions")
        public Question getQuestions(@WebParam(name="qid") int qid) {
            Question Q = new Question() ;
            Connection conn = null ; 
            Statement stmt = null ;
            ResultSet rs =null;
            
            try {
                Class.forName("com.mysql.jdbc.Driver");                
                conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                String sql = "SELECT * FROM question WHERE id_q="+qid;
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                ResultSetMetaData rmsd = rs.getMetaData();
                rs.next();    
                    int aa =rs.getInt("id_q");
                    Q.id_q = aa;
                    Q.title = rs.getString("title");
                    Q.content = rs.getString("content");
                    Q.vote = rs.getInt("vote");
                    Q.date = rs.getString("date");
                    Q.username = rs.getString("username");
                    Q.email = rs.getString("email"); 
                    Q.tanswer = countAnswer(aa);             
                stmt.close();
                conn.close();
            }
            catch (Exception e) {
                e.printStackTrace() ;
            }
            return Q ;
        }
        
        
        @WebMethod(operationName="getAllAnswers")
        public ArrayList<Answer> getAllAnswers(@WebParam(name="id_a") int id_a) {
            Connection conn = null ; 
            Statement stmt = null ;
            ResultSet rs =null;
            ArrayList<Answer> ret = new ArrayList<Answer>() ;
            
            try {
                Class.forName("com.mysql.jdbc.Driver");                
                conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                String sql = "SELECT * FROM answer WHERE q_id="+id_a;
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);                
                while (rs.next()) {
                    Answer A = new Answer();
                    int aa = rs.getInt("id_a");
                    int bb = rs.getInt("q_id");
                    A.id_a = aa;
                    A.q_id = bb;
                    A.content = rs.getString("content");
                    A.vote = rs.getInt("vote");
                    A.date = rs.getString("date");
                    A.username = rs.getString("username");
                    A.email = rs.getString("email"); 
                    ret.add(A);
                }
                stmt.close();
                conn.close();
            }
            catch (Exception e) {
                e.printStackTrace() ;
            }
            return ret ;
        }
        
        @WebMethod(operationName="register")
        public int register(String n,String e,String p) {
            int status = 0 ;
            Connection conn = null ; 
            Statement stmt = null ;
            ResultSet rs =null;
            String list_u[][] = null ;            
            try {
                Class.forName("com.mysql.jdbc.Driver");                
                conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                String sql = "SELECT * FROM registered WHERE username='"+n+"' or email='"+e+"'";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                rs.last();
                int size = rs.getRow();
                rs.beforeFirst();
                if (size == 0) {
                   String sql2 = "INSERT INTO registered (username,email,password) VALUES ('"+n+"','"+e+"','"+p+"')";
                   stmt = conn.createStatement();
                   stmt.executeUpdate(sql2);
                }
                else {
                    rs.next();
                    status = rs.getInt("user_id");
                }
                stmt.close();
                conn.close();
            }
            catch (Exception ee) {
                ee.printStackTrace() ;
            }
            return status ;
        }
        
        @WebMethod(operationName="addQuestion")
        public int addQuestion(String at,String t,String c) {
            int status = 0;
            Random ran = new Random();
            int r =ran.nextInt(2);
            if (r!=0) {
                
                Connection conn = null ; 
                Statement stmt = null ;
                ResultSet rs =null;          
                try {
                    Class.forName("com.mysql.jdbc.Driver");                
                    conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                    String sql1 = "SELECT MAX(id_q) as max FROM question" ;
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql1);
                    rs.next();
                    int new_id = rs.getInt("max");
                    System.out.println("new id before : "+new_id);
                    new_id++;
                    System.out.println("after : "+new_id);
                    status=new_id;
                    String sql2 = "INSERT INTO question (id_q,username,email,title,content,date,vote) VALUES ('"+new_id+"','test','test@yahoo.com','"+t+"','"+c+"', CURRENT_TIMESTAMP,0)";
                    stmt = conn.createStatement();
                    stmt.executeUpdate(sql2);
                    stmt.close();
                    conn.close();
                }
                catch (Exception ee) {
                    ee.printStackTrace() ;
                }
            }
            return status ;
        }
        
         @WebMethod(operationName="updateQuestion")
        public int updateQuestion(String at,int id,String t,String c) {
            int status = 0;
            Random ran = new Random();
            int r = ran.nextInt(2);
            if (r!=0) {
                status = 1 ;
                Connection conn = null ; 
                Statement stmt = null ;
                ResultSet rs =null;           
                try {
                    Class.forName("com.mysql.jdbc.Driver");                
                    conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                    String sql = "UPDATE question SET title='"+t+"',content='"+c+"' WHERE id_q="+id;
                    stmt = conn.createStatement();                                    
                    stmt.executeUpdate(sql);
                    stmt.close();
                    conn.close();
                }
                catch (Exception ee) {
                    ee.printStackTrace() ;
                }
            }
            return status ;
        }
        
         @WebMethod(operationName="deleteQuestion")
        public int deleteQuestion(String at,int id) {
         int status = 0;
            Random ran = new Random();
            int r = ran.nextInt(2);
            if (r!=0) {
                status = 1 ;
                Connection conn = null ; 
                Statement stmt = null ;
                ResultSet rs =null;           
                try {
                    Class.forName("com.mysql.jdbc.Driver");                
                    conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                    String sql = "DELETE FROM question WHERE id_q="+id;
                    stmt = conn.createStatement();                                    
                    stmt.executeUpdate(sql);
                    stmt.close();
                    conn.close();
                }
                catch (Exception ee) {
                    ee.printStackTrace() ;
                }
            }
            return status ;
        }    
        
         @WebMethod(operationName="addAnswer")
        public int addAnswer(String at,int idq,int ida,String c) {
            int status = 0;
            Random ran = new Random();
            int r = ran.nextInt(2);
            if (r!=0) {
                status = 1;
                Connection conn = null ; 
                Statement stmt = null ;
                ResultSet rs =null; 
                try {
                    Class.forName("com.mysql.jdbc.Driver");                
                    conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                    String sql = "INSERT INTO `answer` (`id_a`, `q_id`, `content`, `date`, `vote`, `username`, `email`) VALUES ('"+ida+"','"+idq+"','"+c+"',CURRENT_TIMESTAMP,0,'test','test')";
                    stmt = conn.createStatement();                                    
                    stmt.executeUpdate(sql);
                    stmt.close();
                    conn.close();
                }
                catch (Exception ee) {
                    ee.printStackTrace() ;
                }
            }            
            return status ;
        }
        
         @WebMethod(operationName="searchQuestion")
        public ArrayList<Question> searchQuestion(String s) {
            Connection conn = null ; 
            Statement stmt = null ;
            ResultSet rs =null;
            ArrayList<Question> ret= new ArrayList<Question>();
            
            try {
                Class.forName("com.mysql.jdbc.Driver");                
                conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                String sql = "SELECT * FROM question WHERE title LIKE '%"+s+"%'";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
               
                while (rs.next()) {
                   Question Q = new Question();
                    int aa =rs.getInt("id_q");
                    Q.id_q = aa;
                    Q.title = rs.getString("title");
                    Q.content = rs.getString("content");
                    Q.vote = rs.getInt("vote");
                    Q.date = rs.getString("date");
                    Q.username = rs.getString("username");
                    Q.email = rs.getString("email"); 
                    Q.tanswer = countAnswer(aa);
                    ret.add(Q);
                }
                stmt.close();
                conn.close();
            }
            catch (Exception e) {
                e.printStackTrace() ;
            }
            return ret ;
        }
        
        
        @WebMethod(operationName="getVote")
        public int getVote(String t,int id) {
           Connection conn = null ; 
            Statement stmt = null ;
            ResultSet rs =null;
            int ret = 0 ;
            String sql;
            try {
                Class.forName("com.mysql.jdbc.Driver");                
                conn = DriverManager.getConnection(DB_URL, USER,PASS);  
                if (t.equals("q")) sql = "SELECT vote FROM question WHERE id_q="+id;
                else sql = "SELECT vote FROM answer WHERE id_a="+id;
                stmt= conn.createStatement();
                rs = stmt.executeQuery(sql);                
                rs.next();
                ret = rs.getInt("vote");
                stmt.close();
                conn.close();
            }
            catch (Exception e) {
                e.printStackTrace() ;
            }
            return ret ;
        }
        
        @WebMethod(operationName="changeVote")
        public int changeVote(String at,String t,int id,int num) {
            Connection conn = null ; 
            Statement stmt = null ;
            ResultSet rs =null;
            int status = 0 ;
            Random ran = new Random();
            int r = ran.nextInt(2);
            String sql;
            if (r!=0) {
                status=1;
                try {
                    Class.forName("com.mysql.jdbc.Driver");                
                    conn = DriverManager.getConnection(DB_URL, USER,PASS);  
                    if (t.equals("q")) sql = "UPDATE question SET vote=(vote+"+num+") WHERE id_q="+id;
                    else sql = "UPDATE answer SET vote=(vote++"+num+") WHERE id_a="+id;
                    stmt= conn.createStatement();
                    stmt.executeUpdate(sql);
                    stmt.close();
                    conn.close();
                }
                catch (Exception e) {
                    e.printStackTrace() ;
                }
            }
            return status ;
        }
        
}
