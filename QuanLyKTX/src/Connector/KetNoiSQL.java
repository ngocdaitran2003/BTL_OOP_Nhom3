package Connector;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;


/**
 *
 * @author Dai
 */
public class KetNoiSQL {
    // Các thông tin kết nối đến database
    private static Connection connection = null;
    private static String URL = "jdbc:mysql://localhost:3306/quanlyktxsinhvien";
    private static String USERNAME = "root";
    private static String PASSWORD = "";
    
    public static void closeConnection(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public static Connection ConnectSQL() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
    public KetNoiSQL() {
        String url = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(url);
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException ex) {
                Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection(){
        Connection connect = null;
        String url = "com.mysql.cj.jdbc.Driver";
        try {
            // Đăng ký mysql driver với Driver manager
            Class.forName(url);
            try{
                // Tạo kết nối đến database
                connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch(SQLException ex){
                Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connect;
    }
    
    
    public void Close() throws Exception {
        connection.close();
    }
    
    public static void main(String args[]) {
        try{
            // kết nối đến database
            Connection connect = getConnection();
             // Ngắt connection
            connect.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
