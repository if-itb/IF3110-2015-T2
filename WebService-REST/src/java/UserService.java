import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserService {
    
    public boolean emailExist(String email) throws SQLException{
        String query = "SELECT * FROM user WHERE email='"+ email +"'";
        PreparedStatement statement; 
        DatabaseConnect dbc = new DatabaseConnect();
        boolean exist = false;
        try{
            statement =  dbc.getConn().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
                exist = true;
            //rs.close();
            //statement.close();
            
        } catch (SQLException se){
            se.printStackTrace();
	}
        return exist;
    }
    
    public boolean passwordValid(String email, String password) throws SQLException{
        String query = "SELECT * FROM user WHERE email='"+ email +"' AND password='"+ password +"'";
        boolean valid = false;
        PreparedStatement statement; 
        DatabaseConnect dbc = new DatabaseConnect();
        try{
            statement =  dbc.getConn().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
                valid = true;
            //rs.close();
            //statement.close();
            
        } catch (SQLException se){
            se.printStackTrace();
	}
        return valid;
        
    }
    
    public int getUserIDFromToken(String tokenValue){
        String query = "SELECT * FROM token WHERE value='"+ tokenValue +"'";
        PreparedStatement statement;
        int user_id = -1;
        DatabaseConnect dbc = new DatabaseConnect();
        try{
            statement =  dbc.getConn().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
           
            if(rs.next()){
                user_id = rs.getInt("user_id"); 
            }
            //rs.close();
            //statement.close();
        } catch (SQLException se){
            se.printStackTrace();
	}
        finally{
            return user_id;
        }
    }
    
    public int getUserIDFromEmail(String email){
        String query = "SELECT * FROM user WHERE email='"+ email +"'";
        PreparedStatement statement;
        int user_id = -1;
        DatabaseConnect dbc = new DatabaseConnect();
        try{
            statement =  dbc.getConn().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
           
            if(rs.next()){
                user_id = rs.getInt("id"); 
            }
            //rs.close();
            //statement.close();
        } catch (SQLException se){
            se.printStackTrace();
	}
        finally{
            return user_id;
        }
    }
    
    public void executeQuery(String query){
        PreparedStatement statement;
        DatabaseConnect dbc = new DatabaseConnect();
        try{
            statement =  dbc.getConn().prepareStatement(query);
            statement.executeUpdate();
           
            //rs.close();
            //statement.close();
        } catch (SQLException se){
            se.printStackTrace();
	}
    }
}
