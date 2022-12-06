import java.sql.Connection;
import java.sql.DriverManager;

//import static java.lang.Class.forName;

public class Main {
    public static void main(String[] args) {
        getConnection();
    }

    public static Connection getConnection(){
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseUrl = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password  = "";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(databaseUrl,username,password);
//            System.out.println("Database connected successfully!");
            return conn;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
