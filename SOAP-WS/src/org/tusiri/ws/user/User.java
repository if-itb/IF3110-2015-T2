package org.tusiri.ws.user;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.tusiri.ws.db.DBConnection;


@WebService(endpointInterface = "org.tusiri.ws.user.User")
public class User {
	@WebMethod
	public int createUser(String username, String password, String email, String fullname) throws ClientProtocolException, IOException, ParseException{
		int u_id = 0;
		boolean exist = true;
		
		DBConnection dbc = new DBConnection();
		Statement stmt = dbc.getDBStmt();
		try{
			String sql = "SELECT email FROM user"
					+ "WHERE email='"+email+"'";
			ResultSet rs = stmt.executeQuery(sql);
            if (!rs.next()){
            	exist = false;
            }
		} catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		} catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		
		if (exist){
			u_id = -1;
		} 
		else{
			try{
				String sql = "INSERT INTO user(username,password,email,fullname)"
						+ "VALUES('"+username+"','"+password+"','"+email+"','"+fullname+"')";
				u_id = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
				ResultSet rd = stmt.getGeneratedKeys();
			} catch(SQLException se){
				//Handle errors for JDBC
				se.printStackTrace();
			} catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
			}
		}
		
		return u_id;
	}
}
