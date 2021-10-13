package support;
import java.sql.*;
public class DBConn {
    public static Connection getConn(){
        Connection conn = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:odbc:music");
        } catch (Exception ex) {

        }
        return conn;
    }
    public static void close(Connection conn,Statement stmt,ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            if(conn!=null && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException ex) {
        }
    }

}
