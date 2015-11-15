package org.tusiri.ws.resource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.tusiri.ws.db.DBConnection;
import org.tusiri.ws.model.Token;

@Path("/token-validity")
public class TokenValidity {
	
	public static class Validity{
		public boolean valid=false;
	}
	
	public static Validity getValidity(String access_token){
		Validity validity = new Validity();
		
		//Check database
		DBConnection dbc = new DBConnection();
		Statement stmt = dbc.getDBStmt();
		try{
			String sql = "SELECT * FROM token "
					+ "WHERE access_token='"+access_token+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				//cek tanngal expire
				java.util.Date date = rs.getTimestamp("timestamp");
				Date expire = new Date(date.getTime() + TimeUnit.DAYS.toMillis( 2 ));//2 days validity
				long expire_ms = expire.getTime();
				Date cur_date = new Date();
				long cur_date_ms = cur_date.getTime();
				if(expire_ms>cur_date_ms){
					validity.valid = true;
				}
			}
		} catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		} catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		return validity;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Validity post(@FormParam("access_token") String access_token) {
		System.out.println("kepanggil");
		System.out.println(access_token);
		Validity validity = getValidity(access_token);
		System.out.println(validity.valid);
		return validity;
	}
}
