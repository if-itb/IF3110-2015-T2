import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserService {
    
    public boolean emailExist(String email) throws SQLException{
        String query = "SELECT * FROM user WHERE email='"+ email +"'";
        Statement statement; 
        DatabaseConnect dbc = new DatabaseConnect();
        boolean exist = false;
        try{
            statement =  dbc.getConn().createStatement();
            ResultSet rs = statement.executeQuery(query);
            if(rs.next())
                exist = true;
            rs.close();
            statement.close();
            
        } catch (SQLException se){
            se.printStackTrace();
	}
        return exist;
    }
    
    public boolean passwordValid(String email, String password) throws SQLException{
        String query = "SELECT * FROM user WHERE email='"+ email +"' AND password='"+ password +"'";
        boolean valid = false;
        Statement statement; 
        DatabaseConnect dbc = new DatabaseConnect();
        try{
            statement =  dbc.getConn().createStatement();
            ResultSet rs = statement.executeQuery(query);
            if(rs.next())
                valid = true;
            rs.close();
            statement.close();
            
        } catch (SQLException se){
            se.printStackTrace();
	}
        return valid;
        
    }
    
    public int getUserIDFromToken(String tokenValue){
        String query = "SELECT * FROM token WHERE value='"+ tokenValue +"'";
        Statement statement;
        int user_id = -1;
        DatabaseConnect dbc = new DatabaseConnect();
        try{
            statement =  dbc.getConn().createStatement();
            ResultSet rs = statement.executeQuery(query);
           
            if(rs.next()){
                user_id = rs.getInt("user_id"); 
            }
            rs.close();
            statement.close();
        } catch (SQLException se){
            se.printStackTrace();
	}
        return user_id;
    }
    
    public int getUserIDFromEmail(String email){
        String query = "SELECT * FROM user WHERE email='"+ email +"'";
        Statement statement;
        int user_id = -1;
        DatabaseConnect dbc = new DatabaseConnect();
        try{
            statement =  dbc.getConn().createStatement();
            ResultSet rs = statement.executeQuery(query);
           
            if(rs.next()){
                user_id = rs.getInt("user_id"); 
            }
            rs.close();
            statement.close();
        } catch (SQLException se){
            se.printStackTrace();
	}
        return user_id;
    }
}
