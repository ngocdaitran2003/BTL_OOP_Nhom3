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
import java.text.ParesulteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.ThongTinDichVu;
import model.ThongTinHoaDonSV;

public class ThongTinDichVuDAO {
    public ThongTinDichVuDAO(){
    
    }
    
    public List<ThongTinDichVu> getAllThongTinDichVu() {
        List<ThongTinDichVu> list = new ArrayList<ThongTinDichVu>();
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select * from dichvuphong order by ngayThang desc";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                ThongTinDichVu dichvu = new ThongTinDichVu();
                dichvu.setNgayThang(result.getDate("ngayThang"));
                dichvu.setMaPhong(result.getString("maPhong"));
                dichvu.setSoDienCu(result.getFloat("soDienCu"));
                dichvu.setSoDienMoi(result.getFloat("soDienMoi"));
                dichvu.setSoNuocCu(result.getFloat("soNuocCu"));
                dichvu.setSoNuocMoi(result.getFloat("soNuocMoi"));
                list.add(dichvu);
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<ThongTinDichVu> getAllThongTinSearch(String where, String text) {
        List<ThongTinDichVu> list = new ArrayList<ThongTinDichVu>();
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select * from dichvuphong where " + where + " like N'%" + text + "%' order by ngayThang desc";
        try { 
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                ThongTinDichVu dichvu = new ThongTinDichVu();
                dichvu.setNgayThang(result.getDate("ngayThang"));
                dichvu.setMaPhong(result.getString("maPhong"));
                dichvu.setSoDienCu(result.getFloat("soDienCu"));
                dichvu.setSoDienMoi(result.getFloat("soDienMoi"));
                dichvu.setSoNuocCu(result.getFloat("soNuocCu"));
                dichvu.setSoNuocMoi(result.getFloat("soNuocMoi"));
                list.add(dichvu);
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public double SoNuocTheoPhong(String maphong,String ngayThang) {
        double soluong = 0;
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select * from hoadonphong where maPhong='" + maphong + "' and ngayThang='"+ngayThang+"'";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                soluong = result.getFloat("soNuocTieuThu");
            }
            connect.close();
        } catch (Exception e) {
        }
        return soluong;
    }
    
    public double SoDienTheoPhong(String maphong,String ngayThang) {
        double soluong = 0;
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select * from hoadonphong where maPhong='" + maphong + "' and ngayThang='"+ngayThang+"'";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                soluong = result.getFloat("soDienTieuThu");
            }
            connect.close();
        } catch (Exception e) {
        }
        return soluong;
    }
    
    public double SoTienDichVuTheoPhong(String maphong,String ngayThang) {
        double soluong = 0;
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select * from hoadonphong where maPhong='" + maphong + "' and ngayThang='"+ngayThang+"'";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                soluong = result.getFloat("tongTien");
            }
            connect.close();
        } catch (Exception e) {
        }
        return soluong;
    }
}
