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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ThongTinSinhVien;

public class SinhVienDAO {
    public SinhVienDAO(){
        
    }
    public List<ThongTinSinhVien> getAllThongTinSVdaduyet() {
        List<ThongTinSinhVien> listSinhVien = new ArrayList<ThongTinSinhVien>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select sv.*,hd.maPhong,hd.ngayHDBD from SinhVien sv join HopDongKTX hd on sv.maSV=hd.maSV where sv.trangThai=1";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinSinhVien sv = new ThongTinSinhVien();
                sv.setMaSV(rs.getString("maSV"));
                sv.setTenSV(rs.getString("tenSV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setNgayBDHD(rs.getDate("ngayHDBD"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setMaLop(rs.getString("maLop"));
                listSinhVien.add(sv);
            }
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSinhVien;
    }

    public List<ThongTinSinhVien> getAllThongTinSV() {
        List<ThongTinSinhVien> listSinhVien = new ArrayList<ThongTinSinhVien>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from (select *,Null as maPhong from (select * from SinhVien except SELECT sv.* FROM SinhVien sv JOIN HopDongKTX hd ON sv.maSV = hd.maSV) as k union all SELECT sv.*, hd.maPhong FROM SinhVien sv JOIN HopDongKTX hd ON sv.maSV = hd.maSV) as k2";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinSinhVien sv = new ThongTinSinhVien();
                sv.setMaSV(rs.getString("maSV"));
                sv.setTenSV(rs.getString("tenSV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setMaLop(rs.getString("maLop"));
                sv.setTrangThai(rs.getInt("trangThai"));
                listSinhVien.add(sv);
            }
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSinhVien;
    }

    public List<ThongTinSinhVien> getAllThongTinSVTrangThai(int trangthai) {
        List<ThongTinSinhVien> listSinhVien = new ArrayList<ThongTinSinhVien>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from (select *,Null as maPhong from (select * from SinhVien except SELECT sv.* FROM SinhVien sv JOIN HopDongKTX hd ON sv.maSV = hd.maSV) as k union all SELECT sv.*, hd.maPhong FROM SinhVien sv JOIN HopDongKTX hd ON sv.maSV = hd.maSV) as k2 where trangThai='" + trangthai + "' ";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinSinhVien sv = new ThongTinSinhVien();
                sv.setMaSV(rs.getString("maSV"));
                sv.setTenSV(rs.getString("tenSV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setMaLop(rs.getString("maLop"));
                sv.setTrangThai(rs.getInt("trangThai"));
                listSinhVien.add(sv);
            }
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSinhVien;
    }

    public List<ThongTinSinhVien> getAllThongTinSVTheoPhong(String maPhong) {
        LocalDate datelocal = LocalDate.now();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        String strdatenow = String.valueOf(datelocal);
        Date datenow = null;
        try {
            datenow = formatter1.parse(strdatenow);
        } catch (Exception e) {
        }
        String ngayht = formatter1.format(datenow);
        List<ThongTinSinhVien> listSinhVien = new ArrayList<ThongTinSinhVien>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from SinhVien join HopDongKTX on SinhVien.maSV=HopDongKTX.maSV where maPhong='" + maPhong + "' and ngayHDBD<='"+ngayht+"' and ngayHDKT>'"+ngayht+"'";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinSinhVien sv = new ThongTinSinhVien();
                sv.setMaSV(rs.getString("maSV"));
                sv.setTenSV(rs.getString("tenSV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setMaLop(rs.getString("maLop"));
                listSinhVien.add(sv);
            }
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSinhVien;
    }

    public List<ThongTinSinhVien> getAllThongTinSVSearch(String where, String text) {
        List<ThongTinSinhVien> listSinhVien = new ArrayList<ThongTinSinhVien>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from SinhVien where " + where + " like N'%" + text + "%' ";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinSinhVien sv = new ThongTinSinhVien();
                sv.setMaSV(rs.getString("maSV"));
                sv.setTenSV(rs.getString("tenSV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setMaLop(rs.getString("maLop"));
                sv.setTrangThai(rs.getInt("trangThai"));
                listSinhVien.add(sv);
            }
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSinhVien;
    }
    
    public List<ThongTinSinhVien> getAllThongTinSVSearchTT(String where, String text, int trangthai) {
        List<ThongTinSinhVien> listSinhVien = new ArrayList<ThongTinSinhVien>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from SinhVien where " + where + " like N'%" + text + "%' and trangThai='" + trangthai + "'";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinSinhVien sv = new ThongTinSinhVien();
                sv.setMaSV(rs.getString("maSV"));
                sv.setTenSV(rs.getString("tenSV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setMaLop(rs.getString("maLop"));
                sv.setTrangThai(rs.getInt("trangThai"));
                listSinhVien.add(sv);
            }
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSinhVien;
    }

    public ThongTinSinhVien getAllThongTinSVTheoemail(String email) {
        ThongTinSinhVien sv = new ThongTinSinhVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from SinhVien where email ='" + email + "'";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sv.setMaSV(rs.getString("maSV"));
                sv.setTenSV(rs.getString("tenSV"));
                sv.setCCCD(rs.getString("CCCD"));
                sv.setGioiTinh(rs.getString("gioiTinh"));
                sv.setNgaySinh(rs.getDate("ngaySinh"));
                sv.setEmail(rs.getString("email"));
                sv.setSoDienThoai(rs.getString("soDienThoai"));
                sv.setQueQuan(rs.getString("queQuan"));
                sv.setMaLop(rs.getString("maLop"));
            }
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sv;
    }
    
    public String LayThongTinGioiTinh(String tendangnhap) {
        String gioitinh = null;
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from SinhVien where tenDangNhap ='" + tendangnhap + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                gioitinh = rs.getString("gioiTinh");
            }

            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gioitinh;
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
    
    public String layGioiTinhSVtuMaSV(String masv) {
        String k = "";
        Connection con = KetNoiSQL.getConnection();
        String sql = "select * from SinhVien where maSV='" + masv + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                k = rs.getString("gioiTinh");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }
    
    public String laytenSVtuMaSV(String masv) {
        String k = "";
        String sql = "select * from SinhVien where maSV='" + masv + "'";
        Connection con = KetNoiSQL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                k = rs.getString("tenSV");
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
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
    
     public String layMaSinhVienTuEmail(String email) {
        String k = "";
        String sql = "select maSV from SinhVien where email= '" + email + "'";
        Connection con = KetNoiSQL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                k = rs.getString("maSV");
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
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
     
     public String layGTSinhVienTuEmail(String email) {
        String k = "";
        String sql = "select gioiTinh from SinhVien where email= '" + email + "'";
        Connection con = KetNoiSQL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                k = rs.getString("gioiTinh");
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
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
    
    public boolean KiemTraMaSoSV(String masv) {
        ThongTinSinhVien sv = new ThongTinSinhVien();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from SinhVien where maSV ='" + masv + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return true;
            }
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }
    
    public boolean KiemTraTenDN(String tendangnhap) {
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from TaiKhoan where tenDangNhap ='" + tendangnhap + "'";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return true;
            }
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
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

    public String LayTenSVTuMaSV(String masv) {
        String sql = "select * from SinhVien where maSV='" + masv + "'";
        return LayThongTinSinhVien(sql, "tenSV");
    }
    
    public String LayGioiTinhSVtuMaSV(String masv) {
        String sql = "select * from SinhVien where maSV='" + masv + "'";
        return LayThongTinSinhVien(sql, "gioiTinh");
    }
    
    public String LayThongTinGioiTinhTuMaSV(String msv) {
        String gioitinh = null;
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from SinhVien where maSV ='" + msv + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                gioitinh = rs.getString("gioiTinh");
            }

            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gioitinh;
    }
}
