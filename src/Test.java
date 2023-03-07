import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Test;user=sa;password=123";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }
}
