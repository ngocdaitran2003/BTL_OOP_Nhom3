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
import model.ThongTinThongBao;


public class QuanLiThongBaoDAO {
    public List<ThongTinThongBao> getAllThongTinTB() {
        List<ThongTinThongBao> listThongBao = new ArrayList<>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from ThongBao";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinThongBao tb = new ThongTinThongBao();
                tb.setTieuDe(rs.getString("tieuDe"));
                tb.setNoiDung(rs.getString("noiDung"));
                tb.setSoPhong(rs.getString("soPhong"));
                tb.setNgayThongBao(rs.getTimestamp("ngayThongBao").toLocalDateTime());
                listThongBao.add(tb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listThongBao;
    }
    
    
    public List<ThongTinThongBao> getAllThongTinTBTheoPhong(String maPhong) {
        List<ThongTinThongBao> listThongBao = new ArrayList<>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from ThongBao where maPhong='"+maPhong+"'";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinThongBao tb = new ThongTinThongBao();
                tb.setTieuDe(rs.getString("tieuDe"));
                tb.setNoiDung(rs.getString("noiDung"));
                tb.setSoPhong(rs.getString("soPhong"));
                tb.setNgayThongBao(rs.getTimestamp("ngayThongBao").toLocalDateTime());
                listThongBao.add(tb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listThongBao;
    }
    
    public List<ThongTinThongBao> getAllThongBaoSearch(String where, String text) {
        List<ThongTinThongBao> listThongBao = new ArrayList<>();
        Connection conn = KetNoiSQL.getConnection();

        try {
            if ("ngayThongBao".equals(where)) {
                String sql = "SELECT * FROM ThongBao WHERE CONVERT(NVARCHAR, " + where + ", 120) LIKE N'%" + text + "%'";

                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    ThongTinThongBao tb = new ThongTinThongBao();
                    tb.setTieuDe(rs.getString("tieuDe"));
                    tb.setNoiDung(rs.getString("noiDung"));
                    tb.setSoPhong(rs.getString("soPhong"));
                    tb.setNgayThongBao(rs.getTimestamp("ngayThongBao").toLocalDateTime());
                    listThongBao.add(tb);
                }
            } else {
                String sql = "SELECT * FROM ThongBao WHERE " + where + " LIKE N'%" + text + "%'";

                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                
                while (rs.next()) {
                    ThongTinThongBao tb = new ThongTinThongBao();
                    tb.setTieuDe(rs.getString("tieuDe"));
                    tb.setNoiDung(rs.getString("noiDung"));
                    tb.setSoPhong(rs.getString("soPhong"));
                    tb.setNgayThongBao(rs.getTimestamp("ngayThongBao").toLocalDateTime());
                    listThongBao.add(tb);
                }
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listThongBao;
    }
}
