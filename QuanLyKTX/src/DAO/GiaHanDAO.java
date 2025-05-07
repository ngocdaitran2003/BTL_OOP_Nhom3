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

import model.ThongTinGiaHan;

public class GiaHanDAO {
    public ThongTinGiaHan getAllThongTinGiaHanTheoMaSV(String msv){
        ThongTinGiaHan gh = new ThongTinGiaHan();
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select * from GiaHan where maSV='" + msv +"' ";
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                gh.setMaSV(rs.getString("maSV"));
                gh.setNgayHDKT(rs.getDate("ngayKTHD"));
                gh.setThoiGianGiaHan( rs.getInt("thoiGianGH"));
                gh.setTrangThai(rs.getInt("trangThai"));
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gh;  
    }
        
    public boolean KiemTraMaSV(String masv) {
        
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select * from GiaHan where maSV ='" + masv + "'";
        try {

            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return true;
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }   
}
