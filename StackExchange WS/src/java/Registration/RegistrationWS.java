package Registration;
import java.sql.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

@WebService(serviceName = "RegistrationWS")
@Stateless()
public class RegistrationWS {    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    private static final String CONN_STRING = "jdbc:mysql://localhost/dadakanDB";
    @WebMethod(operationName = "register")
    public boolean register(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        Connection conn = null;
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String sql = "SELECT email FROM users WHERE email LIKE '" + email + "'";
            PreparedStatement dbs = conn.prepareStatement(sql);
            ResultSet rs = dbs.executeQuery();
            if(!rs.isBeforeFirst() && (email!=null || email!="")) {
                sql = "INSERT INTO users(name,password,email) VALUES ('"+name+"','"+password+"','"+email+"')";
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                return true;
            }
        }
        catch (ClassNotFoundException | SQLException e) {         
        }
        return false;
    }
}
