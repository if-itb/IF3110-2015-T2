package ReST;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Database.Database;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author erick_000
 */
public class Validation extends HttpServlet{
    Database db = new Database();
    Connection conn = Database.connect();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("application/json");
        JSONObject obj = new JSONObject();
        
        try (PrintWriter out = response.getWriter()) {
            String token = request.getParameter("token");
            
            try {
                Statement stmt = conn.createStatement();
                String sql;
                
                sql = "SELECT * FROM tokenlist WHERE token = ?";
                PreparedStatement dbStatement = conn.prepareStatement(sql);
                dbStatement.setString(1, token);
                
                ResultSet rs = dbStatement.executeQuery();
                
                if (rs.next()) {
                    Date expDate = null;
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    try {
                        expDate = df.parse(rs.getString("expdate"));
                    }
                    catch (SQLException | ParseException e) {
                        
                    }
                    
                    Date currentDate = new Date();
                    
                    if (currentDate.after(expDate)) {
                        obj.put("result", "expired");
                    }
                    else {
                        obj.put("result", "valid");
                    }
                    
                    out.print(obj);
                }
                else {
                    obj.put("message", "invalid");
                    out.print(obj);
                }
            }
            catch (SQLException e) {
                obj.put("error", e);
                out.print(obj);
            }
        }
    }
}
