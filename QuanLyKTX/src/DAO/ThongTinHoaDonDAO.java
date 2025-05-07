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
import model.ThongTinHoaDon;
import model.ThongTinHoaDonSV;

public class ThongTinHoaDonDAO {
    public List<ThongTinHoaDonSV> getAllThongTinHoaDonSV() {
        List<ThongTinHoaDonSV> list = new ArrayList<ThongTinHoaDonSV>();
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select * from hoadonsv order by ngayThang desc";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                ThongTinHoaDonSV hdsv = new ThongTinHoaDonSV();
                hdsv.setNgayThang(result.getDate("ngayThang"));
                hdsv.setMaSV(result.getString("maSV"));
                hdsv.setTienThanhToan(result.getDouble("tienThanhToan"));
                hdsv.setTrangThai(result.getByte("trangThai"));
                list.add(hdsv);
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<ThongTinHoaDonSV> getAllThongTinHoaDonSVChuaTT() {
        List<ThongTinHoaDonSV> list = new ArrayList<ThongTinHoaDonSV>();
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select * from HoaDonSV where thanhToan='0'";
        try {

            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                ThongTinHoaDonSV hdsv = new ThongTinHoaDonSV();
                hdsv.setNgayThang(result.getDate("ngayThang"));
                hdsv.setMaSV(result.getString("maSV"));
                hdsv.setTienThanhToan(result.getDouble("tienThanhToan"));
                hdsv.setTrangThai(result.getByte("trangThai"));
                list.add(hdsv);
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ThongTinHoaDonSV> getAllThongTinHoaDonSVTheoMaSV(String masv) {
        List<ThongTinHoaDonSV> list = new ArrayList<ThongTinHoaDonSV>();
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select * from hoadonsv where maSV='" + masv + "'";
        try {

            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                ThongTinHoaDonSV hdsv = new ThongTinHoaDonSV();
                hdsv.setNgayThang(result.getDate("ngayThang"));
                hdsv.setMaSV(result.getString("maSV"));
                hdsv.setTienThanhToan(result.getDouble("tienThanhToan"));
                hdsv.setTrangThai(result.getByte("trangThai"));
                list.add(hdsv);
            }
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public double TongTienHoaDon(int thanhtoan) {
        double soluong = 0;
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select sum(tienPhi) as soluong from HoaDonSV where thanhToan='" + thanhtoan + "'";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                soluong = result.getDouble("soluong");
            }
            connect.close();
        } catch (Exception e) {
        }
        return soluong;
    }
    
    public double TongSoDichVu(String dichvu) {

        double soluong = 0;
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select sum(" + dichvu + ") as soluong from HoaDonSV";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                soluong = result.getDouble("soluong");
            }
            connect.close();
        } catch (Exception e) {
        }
        return soluong;
    }
    
    public double SoNuocTheoPhong(String maphong) {
        double soluong = 0;
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select * from HoaDonSV where maPhong='" + maphong + "'";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                soluong = result.getFloat("soNuocMoi") - result.getFloat("soNuocCu");
            }
            connect.close();
        } catch (Exception e) {
        }
        return soluong;
    }
    
    public double SoDienTheoPhong(String maphong) {
        double soluong = 0;
        Connection connect = KetNoiSQL.getConnection();
        String sql = "select * from HoaDonSV where maPhong='" + maphong + "'";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                soluong = result.getFloat("soDienMoi") - result.getFloat("soDienCu");
            }
            connect.close();
        } catch (Exception e) {
        }
        return soluong;
    }
    
    public List<ThongTinHoaDonSV> searchHoaDonSVAll(String tungay, String denngay, byte trangthai) {
        List<ThongTinHoaDonSV> list = new ArrayList<>();
        Connection connectn = KetNoiSQL.getConnection();
        String sql = "select * from hoadonsv where ngayThang >= ? and ngayThang <= ? and trangThai = ? order by ngayThang desc";
        try {
            PreparedStatement ps = connectn.prepareStatement(sql);
            ps.setString(1, tungay);
            ps.setString(2, denngay);
            ps.setByte(3, trangthai);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                ThongTinHoaDonSV hdsv = new ThongTinHoaDonSV();
                hdsv.setNgayThang(result.getDate("ngayThang"));
                hdsv.setMaSV(result.getString("maSV"));
                hdsv.setTienThanhToan(result.getDouble("tienThanhToan"));
                hdsv.setTrangThai(result.getByte("trangThai"));
                list.add(hdsv);
            }
            ps.close();
            connectn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public List<ThongTinHoaDonSV> searchHoaDonSV(String tungay, String denngay, byte trangthai, String masv) {
        List<ThongTinHoaDonSV> list = new ArrayList<>();
        Connection connectn = KetNoiSQL.getConnection();
        String sql = "select * from hoadonsv where ngayThang >= ? and ngayThang <= ? and trangThai = ? and maSV = ? order by ngayThang desc";
        try {
            PreparedStatement ps = connectn.prepareStatement(sql);
            ps.setString(1, tungay);
            ps.setString(2, denngay);
            ps.setByte(3, trangthai);
            ps.setString(4, masv);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                ThongTinHoaDonSV hdsv = new ThongTinHoaDonSV();
                hdsv.setNgayThang(result.getDate("ngayThang"));
                hdsv.setMaSV(result.getString("maSV"));
                hdsv.setTienThanhToan(result.getDouble("tienThanhToan"));
                hdsv.setTrangThai(result.getByte("trangThai"));
                list.add(hdsv);
            }

            connectn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public boolean KiemTraHoaDonSV(String masv, String ngayThang) {
        boolean kiemtra = false;
        Connection connectn = KetNoiSQL.getConnection();
        String sql = "select * from hoadonsv where ngayThang = ? and maSV =?";
        try {
            PreparedStatement ps = connectn.prepareStatement(sql);
            ps.setString(1, ngayThang);
            ps.setString(2, masv);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                kiemtra = true;
            }

            connectn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kiemtra;
    }
}
