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
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.ThongTinHopDong;
import model.ThongTinSinhVien;

public class HopDongKTXDAO {
    public String laymaPhongtumaSV(String masv) {
        String k = "";
        String sql = "select * from HopDongKTX where maSV='" + masv + "'";
        Connection con = KetNoiSQL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                k = rs.getString("maPhong");
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }
    
    public String LayNgayBDTuMaSV(String masv) {
        SimpleDateFormat formatter1 = new SimpleDateFormat("MM/yyyy");
        Date ngay = null;
        String sql = "select * from HopDongKTX where maSV='" + masv + "'";
        Connection con = KetNoiSQL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ngay = rs.getDate("ngayHDBD");
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formatter1.format(ngay);
    }
    
    public String LayNgayKTTuMaSV(String masv) {
        SimpleDateFormat formatter1 = new SimpleDateFormat("MM/yyyy");
        Date ngay = null;
        String sql = "select * from HopDongKTX where maSV='" + masv + "'";
        Connection con = KetNoiSQL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ngay = rs.getDate("ngayHDKT");
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formatter1.format(ngay);
    }
    
    public void updateHopDongKTX(String masv, String maPhong, Date ngayHDKT,Date ngayHDBD) {
        Connection con = KetNoiSQL.getConnection();
        String sql = "update HopDongKTX set maPhong=?,ngayHDKT=?,ngayHDBD=? where maSV='" + masv + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maPhong);
            ps.setDate(2, new java.sql.Date(ngayHDKT.getTime()));
            ps.setDate(3, new java.sql.Date(ngayHDBD.getTime()));
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteDangkyPhong(String masv) {
        Connection conn = KetNoiSQL.getConnection();
        String sql = "delete from DangKyPhong where maSV=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, masv);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
        }
    }
    
        public Date layNgayHDBDtuDangKYPhong(String masv) {

        Date date = null;
        String sql = "select * from DangKyPhong where maSV='" + masv + "'";
        Connection con = KetNoiSQL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                date = rs.getDate("ngayHDBD");
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
        
    public Date layNgayHDKTtuDangKYPhong(String masv) {

        Date date = null;
        String sql = "select * from DangKyPhong where maSV='" + masv + "'";
        Connection con = KetNoiSQL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                date = rs.getDate("ngayHDKT");
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
         
    public Date layNgayHDKTTuHDKTX(String masv) {

        Date date = null;
        String sql = "select * from hopdongktx where maSV='" + masv + "'";
        Connection con = KetNoiSQL.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                date = rs.getDate("ngayHDKT");
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    
    public List<String> LayMaSinhVienChuaCoHopDong() {
        List<String> listmasv = new ArrayList<>();
        Connection con = KetNoiSQL.getConnection();
        String sql = "Select * from SinhVien where trangThai=1 or trangThai=0";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listmasv.add(rs.getString("maSV"));
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(HopDongKTXDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listmasv;
    }
    
    public double getTienPhongTheoMaSV(String masv) {
        double tienphong = 0;
        Connection conn = KetNoiSQL.getConnection();
        String sql = "SELECT ph.tienPhong AS tienphong FROM phong AS ph , hopdongktx AS hd , sinhvien AS sv WHERE ph.maPhong = hd.maPhong AND hd.maSV=sv.maSV AND sv.maSV='" + masv + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                tienphong = rs.getDouble("tienphong");
            }
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tienphong;
    }
    
    public String LayMPTuHD(String msv) {
        String mp = "";
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from HopDongKTX where maSV ='" + msv + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                mp = rs.getString("MaPhong");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mp;
    }
}
