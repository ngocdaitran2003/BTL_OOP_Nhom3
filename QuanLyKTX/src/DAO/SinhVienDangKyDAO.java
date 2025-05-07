/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connector.KetNoiSQL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Đại
 */
class SinhVienDangKyDAO {
    public SinhVienDangKyDAO() {

    }
    
    public boolean KiemTraMaSoSV(String masv) {
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select * from SinhVien where maSV ='" + masv + "' and trangThai=0";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                return true;
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String LayThongTinLoaiPhong(String masv) {
        String loaiphong = null;
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select * from SinhVien sv join DangKyPhong dkp on sv.maSV=dkp.maSV where trangThai=0 and sv.maSV ='" + masv + "'";
        try {

            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                loaiphong = result.getString("loaiPhong");
            }

            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loaiphong;
    }

    public String LayThongTinGioiTinh(String tendangnhap) {
        String gioitinh = null;
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select * from SinhVien where tenDangNhap ='" + tendangnhap + "'";
        try {

            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                gioitinh = result.getString("gioiTinh");
            }

            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gioitinh;
    }
    //checkPhong
    public int CheckPhong(String loaiphong) {
        int t = 0;
        int slsv = 0, slsvtontai = 0;
        Connection connect = KetNoiSQL.getConnection();
        String sql1 = "select loaiPhong ,sum(sinhVienTonTai) as tongSV from Phong where loaiPhong='" + loaiphong + "' group by loaiPhong";
        String sql2 = "select loaiPhong ,sum(soLuongSVPhong) as tongSV from Phong where loaiPhong='" + loaiphong + "' group by loaiPhong";
        try {
            PreparedStatement ps1 = connect.prepareStatement(sql1);
            PreparedStatement ps2 = connect.prepareStatement(sql2);
            ResultSet result1 = ps1.executeQuery();
            ResultSet result2 = ps2.executeQuery();
            while (result1.next()) {
                slsvtontai = result1.getInt("tongSV");
            }
            while (result2.next()) {
                slsv = result2.getInt("tongSV");
            }
            if (slsvtontai < slsv) {
                t = 1;
            } else {
                t = 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDangKyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
}
