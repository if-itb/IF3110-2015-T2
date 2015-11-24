//tokenGenerate.java


package com.wbd.service;

import com.wbd.rest.Token;
import MD5Hashing.MD5Hashing;

import com.wbd.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;


@Path("/token")
public class tokenGenerate implements ContainerResponseFilter {
        
    
        @Override
        public ContainerResponse filter(ContainerRequest creq, ContainerResponse cresp) {

            cresp.getHttpHeaders().putSingle("Access-Control-Allow-Origin", "*");
            cresp.getHttpHeaders().putSingle("Access-Control-Allow-Credentials", "true");
            cresp.getHttpHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
            cresp.getHttpHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Accept");

            return cresp;
        }
    
	public static boolean isTokenFound(Token token){
		boolean found = false;

		DBConnection dbc = new DBConnection();
		PreparedStatement stmt = dbc.getStatement();
		Connection conn = dbc.getConnection();
		try{
			String sql = "SELECT access_token FROM user WHERE access_token = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, token.access_token);
    
                        ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()){
				found = true;
			}             
		} catch(SQLException se){
			se.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}

		return found;
	}

	public static Token generateToken(String email, String password){
		Token token = new Token();

		DBConnection dbc = new DBConnection();
		PreparedStatement stmt = dbc.getStatement();
		Connection conn = dbc.getConnection();
		try{
			String sql = "SELECT * FROM user WHERE Email = ? AND Password = ?";
			
			//System.out.println(email);
			//System.out.println(password);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, password);
			
			//System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			//System.out.println(sql);
			System.out.println("Luminto homo");
			if(rs.next()){
                                //User is not unique
                                MD5Hashing md5 = new MD5Hashing();

                                token.access_token = md5.Hash(password);
                                token.lifetime = 5;

                                sql = "INSERT INTO token(access_token,IDUser) VALUES (?,?)";
                                PreparedStatement dbStatement = conn.prepareStatement(sql);
                                dbStatement.setString(1, token.access_token);
                                dbStatement.setInt(2, rs.getInt("IDUser"));
                                dbStatement.executeUpdate();
			}

		} catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		} catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}		
		return token;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Token post(@FormParam("email") String email,
	@FormParam("password") String password) {
		Token token = generateToken(email,password);
		return token;
	}
            
	@POST
	@Path("/signout")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void signOut(@FormParam("access_token") String access_token) {
		DBConnection dbc = new DBConnection();
		PreparedStatement stmt = dbc.getStatement();
		Connection conn = dbc.getConnection();
		
		try{
			String sql = "DELETE FROM token WHERE access_token = ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, access_token);
			stmt.executeUpdate();
		} catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		} catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}					
	}


}

