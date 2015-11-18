
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
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
            
        } catch (SQLException se){
            se.printStackTrace();
	}
        return valid;
        
    }
}
