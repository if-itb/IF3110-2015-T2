package UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

@WebService(serviceName = "UserWS")
public class UserWS {
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    private static final String CONN_STRING="jdbc:mysql://localhost/dadakanDB";
    @WebMethod(operationName = "getUserbyID")
    @WebResult(name="User")
    public String getUserbyID(@WebParam(name = "id") int id) {
        String user="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dadakandb?zeroDateTimeBehavior=convertToNull","root","");
        
            Statement stmt = conn.createStatement();
            String sql = "SELECT name FROM users WHERE id = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1,id);
            ResultSet result = dbStatement.executeQuery();
            int i = 0;
            while(result.next()) {
                user+=result.getString("name");
                ++i;
            }
            result.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
