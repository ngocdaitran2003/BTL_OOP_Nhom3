package DAO;

/**
 *
 * @author Dai
 */
import Connector.KetNoiSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ThongTinTaiKhoan;

public class TaiKhoanDAO {
    public int SoLuongQuanLy(){
        int soluong = 0;
        Connection connect = KetNoiSQL.getConnection();
        String sql_query = "select count ";
        return soluong;
    }
    
    public String LayEmail(String tenDangNhap) throws SQLException{
        String email = null;
        Connection connect = KetNoiSQL.getConnection();
        String sql_query = "select * from taikhoan where tenDangNhap ='"+ tenDangNhap + "'";
        try{
            PreparedStatement ps = connect.prepareStatement(sql_query);
            ResultSet result = ps.executeQuery();
            // Lấy thông tin email
            while(result.next()){
                email = result.getString("email");
            }
            ps.close();
            connect.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return email;
    }
    
    public boolean KiemTraEmail(String email){
        Connection connect = KetNoiSQL.getConnection();
        String sql_query = "select * from taikhoan where email ='"+ email + "'";
        
        // Kiểm tra Email
        try{
            PreparedStatement ps = connect.prepareStatement(sql_query);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                return true;
            }
            ps.close();
            connect.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public void CapNhatEmail(String email, String text){
        Connection connect = KetNoiSQL.getConnection();
        String sql_update = "update taikhoan set email= ? admin where email='"+ email + "'";
        
        // Cập nhật email
        try{
            PreparedStatement ps = connect.prepareStatement(sql_update);
            ps.setString(1, text);
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void XoaTaiKhoan(String email){
        Connection connect = KetNoiSQL.getConnection();
        String sql_delete = "delete from taikhoan where email=?";
        
        // Xoá tài khoản
        try{
            PreparedStatement ps = connect.prepareStatement(sql_delete);
            ps.setString(1, email);
            ps.executeUpdate();
            ps.close();
            connect.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean KiemTraTenDNTK(String tendangnhap) {
        ThongTinTaiKhoan tk = new ThongTinTaiKhoan();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from taikhoan where tenDangNhap ='" + tendangnhap + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

}
