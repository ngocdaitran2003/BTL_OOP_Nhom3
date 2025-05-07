package DAO;

/**
 *
 * @author Dai
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Connector.KetNoiSQL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SinhVienDAO {
    public SinhVienDAO(){
        
    }
    
    // Kiểm tra các thông tin về Sinh viên đã tồn tại hay chưa khi lấy thông tin
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
    
    public boolean KiemTraMaSV(String MaSV){
        String sql_query = "select * from sinhvien where MaSV = '" + MaSV + "'";
        return KiemTra(sql_query);
    }
    
    public boolean KiemTraCCCDSV(String cccd) {
        String sql_query = "select * from sinhvien where CCCD = '" + cccd + "'";
        return KiemTra(sql_query);
    }
    
    public boolean KiemTraEmailSV(String email) {
        if(email.contains("@stu.ptit.edu.vn")){
            String sql_query = "select * from sinhvien where CCCD = '" + email + "'";
            return KiemTra(sql_query);
        }
        else {
            System.out.println("Không phải là tài khoản do trường cấp");
        }
        return false;
    }
    
    public boolean KiemTraSDTSV(String sodienthoai){
        String sql_query = "select * from SinhVien where soDienThoai ='" + sodienthoai + "'";
        return KiemTra(sql_query);
    }
    
    public boolean KiemTraTenDangNhap(String tendangnhap){
        String sql_query = "select * from TaiKhoan where tenDangNhap ='" + tendangnhap + "'";
        return KiemTra(sql_query);
    }
    
    public boolean KiemTraDangKy(String maSV){
        String sql_query = "select * from SinhVien where maSV='" + maSV + "' and trangThai=0";
        return KiemTra(sql_query);
    }
    
    public int SoLuongSVTheoGioiTinh(String gioitinh){
        int soluongsv = 0;
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select count(*) as soluongSV from SinhVien where gioiTinh='" + gioitinh + "'";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                soluongsv = result.getInt("soluongSV");
            }
            ps.close();
            connect.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return soluongsv;
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
    
    public boolean UpdateKiemTraMaSoSV(String masv, String test) {
        String sql = "select * from SinhVien where maSV ='" + masv + "'";
        return  KiemTraCapNhat(sql, masv, test);    
    }
    
    public boolean UpdateKiemTraCCCDSV(String cccd, String test){
        String sql = "select * from SinhVien where CCCD = '" + cccd + "'";
        return KiemTraCapNhat(sql, cccd, test);
    }
    
    public boolean UpdateKiemTraEmailSV(String email, String test){
        String sql = "select * from SinhVien where email ='" + email +"'";
        return KiemTraCapNhat(sql, email, test);
    }
    
    public boolean UpdateKiemTraSDTSV(String sodienthoai, String test){
        String sql = "select * from SinhVien where soDienThoai = '" + sodienthoai + "'";
        return KiemTraCapNhat(sql, sodienthoai, test);
    }
    
    // Lấy thông tin của sinh viên
    public String LayThongTinSinhVien(String sql, String ThongTin){
        String k = "";
        Connection connect = KetNoiSQL.getConnection();
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                k = result.getString(ThongTin);
            }
            ps.close();
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }
    
    public String LayMaSinhVienTuEmail(String email){
        String sql = "select maSV from SinhVien where email = '" + email + "'";
        return LayThongTinSinhVien(sql, "maSV");
    }
    
    public String LayGioiTinhSinhVienTuEmail(String email){
        String sql = "select gioiTinh from SinhVien where email= '" + email + "'";
        return LayThongTinSinhVien(sql, "gioiTinh");
    }
    
    public int LayTrangThaiSinhVien(String masv){
        int k = 0;
        String sql = "select trangThai from SinhVien where masv= '" + masv + "'";
        Connection con = KetNoiSQL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                k = rs.getInt("trangThai");
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }
     public int LayTrangThaiTheoEmail(String email) {
        int trangthai = 0;
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from SinhVien where email ='" + email + "'";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                trangthai = rs.getInt("trangThai");

            }
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trangthai;
    }
    
    public String LayLoaiPhong(String masv){
        String sql = "select loaiPhong from SinhVien sv join DangKyPhong dkp on sv.maSV=dkp.maSV where sv.maSV='" + masv + "'";
        return LayThongTinSinhVien(sql, "loaiPhong");
    }
    
    public void updateTrangThaiTheoTDN(String masv){
        Connection con = KetNoiSQL.getConnection();
        String sql = "update SinhVien set trangThai=? where maSV='" + masv + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,1);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateDKthanhcong(String masv) {
        Connection con = KetNoiSQL.getConnection();
        String sql = "update SinhVien set trangThai=? where maSV='" + masv + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,2);
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
// Trong prj mẫu có một giao diện QuanLySV dang ky
//    public void updateMaPhong(String masv, String maPhong) {
//        Connection con = KetNoiSQL.getConnection();
//        String sql = "update DangKyPhong set maPhong where maSV='" + masv + "'";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, maPhong);
//            ps.executeUpdate();
//            ps.close();
//            con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public String LayTenSVTuMaSV(String masv) {
        String sql = "select * from SinhVien where maSV='" + masv + "'";
        return LayThongTinSinhVien(sql, "tenSV");
    }
    
    public String LayGioiTinhSVtuMaSV(String masv) {
        String sql = "select * from SinhVien where maSV='" + masv + "'";
        return LayThongTinSinhVien(sql, "gioiTinh");
    }
}
