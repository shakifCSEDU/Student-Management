import java.sql.*;
public class DBConnection {

    static Connection con = null;
    private static final String url = "jdbc:mysql://localhost:3307/student?autoReconnect = true & useSSL = false";
    private static final String user = "root";
    private static final String password = "shakif";


    public static Connection createConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
