///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package DAO;
//
///**
// *
// * @author Đại
// */
//
//import Connector.KetNoiSQL;
//import model.HopDongKTX;
//import Connector.KetNoiSQL;
////import JFrame.DangKyPhong;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class HopDongDAO {
//    public HopDongKTX getAllThongTinHDTheoMaSV(String maSV) {
//        HopDongKTX hd = new HopDongKTX();
//        Connection connect = KetNoiSQL.getConnection();
//        String sql = "select * from HopDongKTX where maSV ='" + maSV + "'";
//        try {
//            PreparedStatement ps = connect.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                hd.setMaSV(rs.getString("maSV"));
//                hd.setMaPhong(rs.getString("maPhong"));
//                hd.setNgayHDBD(rs.getDate("ngayHDBD"));
//                hd.setNgayHDKT(rs.getDate("ngayHDKT"));
//            }
//            connect.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return hd;
//    }
//    
//    public String LayMPTuHD(String msv) {
//        String mp="";
//        Connection connect = KetNoiSQL.getConnection();
//        String sql = "select * from HopDongKTX where maSV ='" + msv + "'";
//        try {
//            PreparedStatement ps = connect.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                 mp = rs.getString("MaPhong");
//            }
//            connect.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return mp;
//    }        
//}
