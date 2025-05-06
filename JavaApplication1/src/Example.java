import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
public class Example {
    private static String url = "jdbc:mysql://localhost:3306/northwind?autoReconnect=true&useSSL=false";
    private static String username = "root";
    private static String password = "Dayeon123451.";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //Nap Driver//Dăng kí Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
    //Truy vấn bằng executeQuery
    //Sửa thêm, xóa bằng executeUpdate
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = getConnection();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        if(con != null) {
           try {
                PreparedStatement stmt = con.prepareStatement("INSERT INTO Customers VALUES(?, ?, ?, ?, ?, ?, ?)");
                int n = Integer.parseInt(sc.nextLine());
                for(int i = 0; i < n; i++) {
                    int id = Integer.parseInt(sc.nextLine());
                    String name = sc.nextLine();
                    String contactName = sc.nextLine();
                    String address = sc.nextLine();
                    String city = sc.nextLine();
                    String code = sc.nextLine();
                    String country = sc.nextLine();
                    stmt.setInt(1, id);
                    stmt.setString(2, name);
                    stmt.setString(3, contactName);
                    stmt.setString(4, address);
                    stmt.setString(5, city);
                    stmt.setString(6, code);
                    stmt.setString(7, country);
                    int row = stmt.executeUpdate();
                    System.out.println(row);
                }
                con.commit();
           }catch(Exception e) {
               System.out.println(e);
               con.rollback();
           }
        }else{
            System.out.println("Failed");
        }
    }
}
