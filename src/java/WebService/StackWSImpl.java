/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

 
import javax.jws.WebService;
import java.sql.*;
import java.util.Random;
import java.util.Vector;
import java.sql.Timestamp;
import java.util.Date;
//Service Implementation
@WebService(endpointInterface = "WebService.StackWS")
public class StackWSImpl implements StackWS{
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost/stack";
    
        static final String USER = "root";
        static final String PASS = "" ;
        
	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}
        
        @Override
        public int tesplus(int a,int b) {
            return a+b ;
        }
        
        @Override
        public int countAnswer(int id) {
            Connection conn = null ; 
            Statement stmt = null ;
            ResultSet rs =null;
            int ret = 0 ;
            try {
                Class.forName("com.mysql.jdbc.Driver");                
                conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                String sql = "SELECT COUNT(id_a) as total FROM answer WHERE q_id="+id;
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
        
        @Override 
        public String[][] getAllQuestions() {
            Connection conn = null ; 
            Statement stmt = null ;
            ResultSet rs =null;
            String ret[][] = null ;
            
            try {
                Class.forName("com.mysql.jdbc.Driver");                
                conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                String sql = "SELECT * FROM question";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                ResultSetMetaData rmsd = rs.getMetaData();
                int col = rmsd.getColumnCount();
                rs.last();
                int size = rs.getRow();
                rs.beforeFirst();
                ret = new String[size][col+1];               
                int count = 0;
                while (rs.next()) {
                    int aa = rs.getInt("id_q");
                    ret[count][0] = String.valueOf(aa);
                    ret[count][1] = rs.getString("title");
                    ret[count][2] = rs.getString("content");
                    ret[count][3] = String.valueOf(rs.getInt("vote"));
                    ret[count][4] = rs.getString("date");
                    ret[count][5] = rs.getString("username");
                    ret[count][6] = rs.getString("email"); 
                    ret[count][7] = String.valueOf(countAnswer(aa));
                    count++;
                }
                stmt.close();
                conn.close();
            }
            catch (Exception e) {
                e.printStackTrace() ;
            }
            return ret ;
        }
        
        @Override
        public String[] getQuestions(int id) {
            String ret[] = null ;
            Connection conn = null ; 
            Statement stmt = null ;
            ResultSet rs =null;
            
            try {
                Class.forName("com.mysql.jdbc.Driver");                
                conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                String sql = "SELECT * FROM question WHERE id_q="+id;
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                ResultSetMetaData rmsd = rs.getMetaData();
                rs.next();    
                ret = new String[8];
                int aa = rs.getInt("id_q");
                ret[0] = String.valueOf(aa);
                ret[1] = rs.getString("title");
                ret[2] = rs.getString("content");
                ret[3] = String.valueOf(rs.getInt("vote"));
                ret[4] = rs.getString("date");
                ret[5] = rs.getString("username");
                ret[6] = rs.getString("email"); 
                ret[7] = String.valueOf(countAnswer(aa));              
                stmt.close();
                conn.close();
            }
            catch (Exception e) {
                e.printStackTrace() ;
            }
            return ret ;
        }
        
        
        @Override
        public String[][] getAllAnswers(int id) {
            Connection conn = null ; 
            Statement stmt = null ;
            ResultSet rs =null;
            String ret[][] = null ;
            
            try {
                Class.forName("com.mysql.jdbc.Driver");                
                conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                String sql = "SELECT * FROM answer WHERE q_id="+id;
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                ResultSetMetaData rmsd = rs.getMetaData();
                int col = rmsd.getColumnCount();
                rs.last();
                int size = rs.getRow();
                rs.beforeFirst();
                ret = new String[size][col];               
                int count = 0;
                while (rs.next()) {
                    int aa = rs.getInt("id_a");
                    int bb = rs.getInt("q_id");
                    ret[count][0] = String.valueOf(aa);
                    ret[count][1] = String.valueOf(bb);
                    ret[count][2] = rs.getString("content");
                    ret[count][3] = String.valueOf(rs.getInt("vote"));
                    ret[count][4] = rs.getString("date");
                    ret[count][5] = rs.getString("username");
                    ret[count][6] = rs.getString("email"); 
                    count++;
                }
                stmt.close();
                conn.close();
            }
            catch (Exception e) {
                e.printStackTrace() ;
            }
            return ret ;
        }
        
        @Override
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
        
        @Override
        public String[] getUser(int id) {
            Connection conn = null ; 
            Statement stmt = null ;
            ResultSet rs =null;
            String ret[] = null ;            
            try {
                Class.forName("com.mysql.jdbc.Driver");                
                conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                String sql = "SELECT * FROM registered WHERE user_id="+id;
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                rs.next();
                ret = new String[4];
                ret[0] = String.valueOf(id);
                ret[1] = rs.getString("username");
                ret[2] = rs.getString("email");
                ret[3] = rs.getString("password");
                stmt.close();
                conn.close();
            }
            catch (Exception ee) {
                ee.printStackTrace() ;
            }
            return ret ;
        }
        
        public int addQuestion(String at,String t,String c) {
            int status = 0;
            Random ran = new Random();
            //Bilangan random dibuat karena belum ada identity service
            //Untuk mensimulasikan andaikan jika sudah ada identitity service, token tidak valid
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
        public int updateQuestion(String at,int id,String t,String c) {
            int status = 0;
            Random ran = new Random();
            //Bilangan random dibuat karena belum ada identity service
            //Untuk mensimulasikan andaikan jika sudah ada identitity service, token tidak valid
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
        
        public int deleteQuestion(String at,int id) {
         int status = 0;
            Random ran = new Random();
            //Bilangan random dibuat karena belum ada identity service
            //Untuk mensimulasikan andaikan jika sudah ada identitity service, token tidak valid
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
        
        public int addAnswer(String at,int idq,int ida,String c) {
            int status = 0;
            Random ran = new Random();
            int r = ran.nextInt(2);
            //Bilangan random dibuat karena belum ada identity service
            //Untuk mensimulasikan andaikan jika sudah ada identitity service, token tidak valid
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
        
        public String[][] searchQuestion(String s) {
            Connection conn = null ; 
            Statement stmt = null ;
            ResultSet rs =null;
            String ret[][] = null ;
            
            try {
                Class.forName("com.mysql.jdbc.Driver");                
                conn = DriverManager.getConnection(DB_URL, USER,PASS);               
                String sql = "SELECT * FROM question WHERE title LIKE '%"+s+"%'";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                ResultSetMetaData rmsd = rs.getMetaData();
                int col = rmsd.getColumnCount();
                rs.last();
                int size = rs.getRow();
                rs.beforeFirst();
                ret = new String[size][col+1];               
                int count = 0;
                while (rs.next()) {
                    int aa = rs.getInt("id_q");
                    ret[count][0] = String.valueOf(aa);
                    ret[count][1] = rs.getString("title");
                    ret[count][2] = rs.getString("content");
                    ret[count][3] = String.valueOf(rs.getInt("vote"));
                    ret[count][4] = rs.getString("date");
                    ret[count][5] = rs.getString("username");
                    ret[count][6] = rs.getString("email"); 
                    ret[count][7] = String.valueOf(countAnswer(aa));
                    count++;
                }
                stmt.close();
                conn.close();
            }
            catch (Exception e) {
                e.printStackTrace() ;
            }
            return ret ;
        }
        
        
        @Override
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
        
        @Override
        public int changeVote(String at,String t,int id,int num) {
            Connection conn = null ; 
            Statement stmt = null ;
            ResultSet rs =null;
            int status = 0 ;
            Random ran = new Random();
            //Bilangan random dibuat karena belum ada identity service
            //Untuk mensimulasikan andaikan jika sudah ada identitity service, token tidak valid
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