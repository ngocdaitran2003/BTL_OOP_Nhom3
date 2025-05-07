/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Đại
 */
import Connector.KetNoiSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ThongTinNhanVien;
import model.ThongTinPhong;

public class NhanVienDAO {
     public List<ThongTinNhanVien> getAllThongTinNV() {
        List<ThongTinNhanVien> listNhanVien = new ArrayList<ThongTinNhanVien>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from NhanVien";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinNhanVien nv = new ThongTinNhanVien();
                nv.setTenNV(rs.getString("tenNV"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setGioiTinh(rs.getString("gioiTinh"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setEmail(rs.getString("email"));
                nv.setSoDienThoai(rs.getString("soDienThoai"));
                nv.setQueQuan(rs.getString("queQuan"));
                nv.setChucVu(rs.getString("chucVu"));
                nv.setTrangThai(rs.getString("trangThai"));
                listNhanVien.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNhanVien;
    }

    public List<ThongTinNhanVien> getAllThongTinNVSearch(String where, String text) {
        List<ThongTinNhanVien> listNhanVien = new ArrayList<ThongTinNhanVien>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from NhanVien where " + where + " like N'%" + text + "%'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinNhanVien nv = new ThongTinNhanVien();
                nv.setTenNV(rs.getString("tenNV"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setGioiTinh(rs.getString("gioiTinh"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setSoDienThoai(rs.getString("soDienThoai"));
                nv.setChucVu(rs.getString("chucVu"));
                nv.setTrangThai(rs.getString("trangThai"));
                //nv.setEmail(rs.getString("email"));
                //nv.setTenDangNhap(rs.getString("tenDangNhap"));
                
                //nv.setQueQuan(rs.getString("queQuan"));
                listNhanVien.add(nv);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNhanVien;
    }
    
    public ThongTinNhanVien getAllThongTinNVTheoTenDN(String tendn) {
        ThongTinNhanVien nv = new ThongTinNhanVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from NhanVien where tenDangNhap='" + tendn + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                nv.setTenNV(rs.getString("tenNV"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setGioiTinh(rs.getString("gioiTinh"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setEmail(rs.getString("email"));
                nv.setTenDangNhap(rs.getString("tenDangNhap"));
                nv.setSoDienThoai(rs.getString("soDienThoai"));
                nv.setQueQuan(rs.getString("queQuan"));
                nv.setChucVu(rs.getString("chucVu"));
                nv.setTrangThai(rs.getString("trangThai"));
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nv;
    }
    
    public ThongTinNhanVien getAllThongTinNVTheoEmail(String email) {
        ThongTinNhanVien nv = new ThongTinNhanVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from NhanVien where email='" + email + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                nv.setTenNV(rs.getString("tenNV"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setGioiTinh(rs.getString("gioiTinh"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setEmail(rs.getString("email"));
                nv.setSoDienThoai(rs.getString("soDienThoai"));
                nv.setQueQuan(rs.getString("queQuan"));
                nv.setChucVu(rs.getString("chucVu"));
                nv.setTrangThai(rs.getString("trangThai"));
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nv;
    }
    
     // Kiểm tra các thông tin về Nhân viên đã tồn tại hay chưa khi lấy thông tin
    public boolean KiemTra(String sql){
        Connection connect = KetNoiSQL.getConnection();
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
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
    
     public boolean KiemTraCCCDNV(String cccd) {  
        String sql = "select * from NhanVien where CCCD ='" + cccd + "'";
        return KiemTra(sql);
    }
     public boolean KiemTraEmailNV(String email) {
      String sql = "select * from NhanVien where email ='" + email + "'";
        return KiemTra(sql);

    }
     public boolean KiemTraSDTNV(String sodienthoai) {
        String sql = "select * from NhanVien where soDienThoai ='" + sodienthoai + "'";
        return KiemTra(sql);
    }
     
    public ThongTinNhanVien getAllThongTinNVTheoemail(String email) {
        ThongTinNhanVien sv = new ThongTinNhanVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from NhanVien where email ='" + email + "'";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sv.setTenNV(rs.getString("tenNV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setChucVu(rs.getString("chucVu"));
                sv.setTrangThai(rs.getString("trangThai"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sv;
    }
    
     // Kiểm tra các thông tin về sinh viên đã tồn tại chưa khi cập nhật thông tin
    public boolean KiemTraCapNhat(String sql, String input, String test){
        Connection connect = KetNoiSQL.getConnection();
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                if(test.equals(input)){
                    return true;
                }  
            }
            ps.close();
            connect.close();
        } catch(Exception e){
            e.printStackTrace();
        }   
        return false;
    }
    
    public boolean UpKiemTraEmailNV(String email,String test) {
        String sql = "select * from NhanVien where email ='" + email + "'";
        return  KiemTraCapNhat(sql, email, test);
    }
    public boolean UpKiemTraCCCDNV(String cccd,String test) {
        String sql = "select * from NhanVien where CCCD ='" + cccd + "'";
        return KiemTraCapNhat(sql, cccd, test);
    }
    
    public boolean UpKiemTraSDTNV(String sodienthoai,String test) {
        String sql = "select * from NhanVien where soDienThoai ='" + sodienthoai + "'";
        return KiemTraCapNhat(sql,sodienthoai, test);

    }
}
