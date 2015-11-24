//tokenGenerate.java


package com.wbd.service;

import com.wbd.rest.Token;
import com.wbd.db.DBConnection;
import MD5Hashing.MD5Hashing;

import com.wbd.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/tokenValidate")
public class tokenValidate{
	
        ///lifeTim of tokenin minutes
        public static int lifetimeToken = 2;
        
	public static class Identity{
                //Checkig the user is valid or not
		public int valid = -999;
		public int userID = 0;
	}

	public static Identity getIdentity(String access_token){
		//Create Object Identity
		Identity identity = new Identity();

		//Establish Databse Connection
		DBConnection dbc = new DBConnection();
		PreparedStatement stmt = dbc.getStatement();
		Connection conn = dbc.getConnection();
		try{
			String sql = "SELECT * FROM token WHERE access_token = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,access_token);

			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()){
				identity.userID = rs.getInt("userID");
				//Check whether the access_token is expired or not
				Date tokenDate = rs.getTimestamp("timestamp");
                                
				Date expired = new Date(tokenDate.getTime() + TimeUnit.MINUTES.toMillis( lifetimeToken ));
				Date current = new Date();

				//Get the time of data in milliseconds
				long expiredTime = expired.getTime();
				long currentTime = current.getTime();

				if (currentTime >= expiredTime){
					identity.valid = 0;
				}
				else{
					identity.valid = 1;
				}
			}			
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return identity;
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Identity post(@FormParam("access_token") String access_token) {
		Identity identity = getIdentity(access_token);
		return identity;
	}
        
        @OPTIONS
        public Response options() {
             return Response.ok()
                   .header("Access-Control-Allow-Origin", "*")
                   .header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept")
                   .header("Access-Control-Allow-Methods", "*")
                        .build();
         }



}