package Token;


import Database.DatabaseConnect;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static java.lang.invoke.MethodHandles.identity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import Database.DatabaseConnect; 
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Token {
    private String access_token;
    private String lifetime;
    
    public Token(String ac_token){
        access_token = ac_token;
        String query = "SELECT * FROM token WHERE value="+ ac_token;
        PreparedStatement statement;
        DatabaseConnect dbc = new DatabaseConnect();
        try{
            statement =  dbc.getConn().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
           
            if(rs.next()){
                lifetime = rs.getString("lifetime"); 
            }
            rs.close();
            statement.close();
        } catch (SQLException se){
            se.printStackTrace();
	}
    }
    
    public boolean isTokenValid(){
        boolean valid = false;
	long expire_ms = Long.parseLong(lifetime);
	Date cur_date = new Date();
        long cur_date_ms = cur_date.getTime();
	if(expire_ms>cur_date_ms){
            valid = true;
	}
        return valid;
    }

    private String getLifetime() {
        return lifetime;
    }
}
