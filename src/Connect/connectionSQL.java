package Connect;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connectionSQL {
    public static String dataName ="QUANLYTHUVIEN";
    public static Connection getConnection(){
        String url ="net.sourceforge.jtds.jdbc.Driver";
        try{
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://localhost:1433/"+ dataName;
            return DriverManager.getConnection(dbUrl,"sa","123");
        }catch (Exception e) {
            Logger.getLogger(connectionSQL.class.getName()).log(Level.SEVERE, null, e);
            return null;

        }
    }

    public static void main(String[] args) {
        connectionSQL.getConnection();
    }
                          // TEST SQL
//public static void main(String[] args) {
//    try {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QLDIEM;user=sa;password=123";
//        Connection conn = DriverManager.getConnection(dbURL);
//        if (conn != null) {
//            System.out.println("Connected");
//        }
//    } catch (SQLException | ClassNotFoundException ex) {
//        System.err.println("Cannot connect database, " + ex);
//    }
//}
}
