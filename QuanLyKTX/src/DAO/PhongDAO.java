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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ThongTinPhong;

/**
 *
 * @author Đại
 */
public class PhongDAO {
    public PhongDAO(){
        
    }
    
    public List<ThongTinPhong> getAllThongTinPhong() {
        List<ThongTinPhong> listPhong = new ArrayList<ThongTinPhong>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from Phong";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinPhong phong = new ThongTinPhong();
                phong.setMaPhong(rs.getString("maPhong"));
                phong.setTenPhong(rs.getString("tenPhong"));
                phong.setSoLuongSVPhong(rs.getInt("soLuongSVPhong"));
                phong.setLoaiPhong(rs.getString("loaiPhong"));
                phong.setTienPhong(rs.getDouble("tienPhong"));
                phong.setGioiTinh(rs.getString("gioiTinh"));
                listPhong.add(phong);
            }
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPhong;
    }

    public List<ThongTinPhong> getAllThongTinPhongSearch(String where, String text) {
        List<ThongTinPhong> listPhong = new ArrayList<ThongTinPhong>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from Phong where " + where + " like N'%" + text + "%'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinPhong phong = new ThongTinPhong();
                phong.setMaPhong(rs.getString("maPhong"));
                phong.setTenPhong(rs.getString("tenPhong"));
                phong.setSoLuongSVPhong(rs.getInt("soLuongSVPhong"));
                phong.setLoaiPhong(rs.getString("loaiPhong"));
                phong.setTienPhong(rs.getDouble("tienPhong"));
                phong.setGioiTinh(rs.getString("gioiTinh"));
                listPhong.add(phong);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPhong;
    }
    
     public int SoLuongSV(String maPhong) {
        int soluongsv = 0;
        Connection connectectect = KetNoiSQL.getConnection();
        String sql = "select count(*) as soluongSV from Phong where maPhong='" + maPhong + "'";
        try {
            PreparedStatement ps = connectectect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                soluongsv = result.getInt("soluongSV");
            }
            connectectect.close();
        } catch (Exception e) {
        }
        return soluongsv;
    }
     


    public int SoLuongSVPhong(String maPhong) {
        int soluongsv = 0;
        Connection connectectect = KetNoiSQL.getConnection();
        String sql = "select * from Phong where maPhong ='" + maPhong + "'";

        try {
            PreparedStatement ps = connectectect.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                soluongsv = result.getInt("soLuongSVPhong");
            }
            connectectect.close();
        } catch (Exception e) {
        }
        return soluongsv;
    }
    
    public List<ThongTinPhong> getAllThongTinPhongTheoGT_SL(String gioitinh){
        List<ThongTinPhong> listmaphongtheoGT_SL= new PhongDAO().getAllThongTinPhongGioiTinh(gioitinh);
        for (ThongTinPhong phong : listmaphongtheoGT_SL){
            if (new PhongDAO().soluongSVtttheomaPhong(phong.getMaPhong())>=phong.getSoLuongSVPhong()) {
                listmaphongtheoGT_SL.remove(phong);
            } 
        }
        return listmaphongtheoGT_SL;   
   }
    
    public double TienPhong(String maph) {
        double tienphong = 0;
        Connection connectect = KetNoiSQL.getConnection();
        String sql = "select * from Phong where maPhong ='" + maph + "'";

        try {
            PreparedStatement ps = connectect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tienphong = rs.getDouble("tienPhong");
            }
            connectect.close();
        } catch (Exception e) {
        }
        return tienphong;
    }

    public boolean KiemTraMaSoPhong(String maphong) {
        Connection connectect = KetNoiSQL.getConnection();
        String sql = "select * from Phong where maPhong ='" + maphong + "'";
        try {

            PreparedStatement preparedStatement = connectect.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return true;
            }
            connectect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
     public List<ThongTinPhong> getAllThongTinPhongDK(String gioitinh, String loaiphong) {
        List<ThongTinPhong> listPhong = new ArrayList<ThongTinPhong>();
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from Phong where gioitinh='" + gioitinh + "' and loaiphong='" + loaiphong + "'";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ThongTinPhong phong = new ThongTinPhong();
                phong.setTenPhong(rs.getString("tenPhong"));
                phong.setMaPhong(rs.getString("maPhong"));
                phong.setSoLuongSVPhong(rs.getInt("soLuongSVPhong"));
                phong.setGioiTinh(rs.getString("gioiTinh"));
                phong.setTienPhong(rs.getDouble("tienPhong"));
                phong.setLoaiPhong(rs.getString("loaiPhong"));
                listPhong.add(phong);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPhong;
    }

   public List<ThongTinPhong> getAllThongTinPhongGioiTinh(String gioitinh) {
        List<ThongTinPhong> listPhong = new ArrayList<ThongTinPhong>();
        int slsvdango = slsvTrongPhong(gioitinh);
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from Phong where gioiTinh=? ";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, gioitinh);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (slsvdango >0) {
                    ThongTinPhong phong = new ThongTinPhong();
                    phong.setTenPhong(rs.getString("tenPhong"));
                    phong.setMaPhong(rs.getString("maPhong"));
                    phong.setSoLuongSVPhong(rs.getInt("soLuongSVPhong"));
                    phong.setGioiTinh(rs.getString("gioiTinh"));
                    phong.setTienPhong(rs.getDouble("tienPhong"));
                    phong.setLoaiPhong(rs.getString("loaiPhong"));
                    //    phong.setSoLuongSVTT(rs.getInt("sinhVienTonTai"));
                    listPhong.add(phong);
                }
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPhong;
    }

    public List<ThongTinPhong> getAllThongTinPhongGioiTinhLoaiPhong(String gioitinh, String loaiphong) {
        List<ThongTinPhong> listPhong = new ArrayList<ThongTinPhong>();
        Connection conn = KetNoiSQL.getConnection();
        int slsvdango = slsvTrongPhong(gioitinh);
        String sql = "select * from Phong where loaiPhong=? and gioiTinh=? ";
        try {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, loaiphong);
            preparedStatement.setString(2, gioitinh);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (slsvdango < rs.getInt("soLuongSVPhong")) {
                    ThongTinPhong phong = new ThongTinPhong();
                    phong.setTenPhong(rs.getString("tenPhong"));
                    phong.setMaPhong(rs.getString("maPhong"));
                    phong.setSoLuongSVPhong(rs.getInt("soLuongSVPhong"));
                    phong.setGioiTinh(rs.getString("gioiTinh"));
                    phong.setTienPhong(rs.getDouble("tienPhong"));
                    phong.setLoaiPhong(rs.getString("loaiPhong"));
                    listPhong.add(phong);
                }
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPhong;
    }

    public Date getngayHDBD(String masv) {
        Date date = null;
        //Date dt,dtcp=null;
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        Connection con = KetNoiSQL.getConnection();
        String sql = "Select * from HopDongKTX where maSV=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, masv);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                date = rs.getDate("ngayHDBD");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(PhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("date dao:" + date);
        return date;
    }
    
     public int demSVienDK(String loaiphong, String gioitinh) {
        int sl = 0;
        Connection connectect = KetNoiSQL.getConnection();
        String sql = "select count(*) as slsv from DangKyPhong dkp join SinhVien sv on dkp.maSV=sv.maSV where gioiTinh='" + gioitinh + "' and loaiPhong='" + loaiphong + "'";
        try {
            PreparedStatement ps = connectect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sl = rs.getInt("slsv");
            }
            ps.close();
            connectect.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sl;
    }
    
     
    public int slsvTrongPhong(String loaiphong, String gioitinh) {
        int slsv = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select count(*) as slsv from DangKyPhong dkp join SinhVien sv on dkp.maSV=sv.maSV where gioiTinh='" + gioitinh + "' and loaiPhong='" + loaiphong + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs2 = ps.executeQuery();
            while (rs2.next()) {
                slsv = rs2.getInt("tongSVtt");
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDangKyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slsv;
    }
     
    public int slsvTrongPhong(String gioitinh) {
        int slsv = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select count(*) as slsv from DangKyPhong dkp join SinhVien sv on dkp.maSV=sv.maSV where gioiTinh='" + gioitinh + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs2 = ps.executeQuery();
            while (rs2.next()) {
                slsv = rs2.getInt("tongSVtt");
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDangKyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slsv;
    }
    
    public int slsvtontaitrongPhong(String loaiphong, String gioitinh) {
        List<String> listmp = listmaphongTheoLoaiPhongAGT(loaiphong, gioitinh);
        int tongsv = 0;
        for (String i : listmp) {
            tongsv = tongsv + soluongSVtttheomaPhong(i);
        }
        return tongsv;
    }
    
    public int CheckPhong(String loaiphong, String gioitinh) {
        int t = 1;
        int slsvDK = demSVienDK(loaiphong, gioitinh);
        int slsv = slsvTrongPhong(loaiphong, gioitinh);
        int slsvtontai = slsvtontaitrongPhong(loaiphong, gioitinh);
        if (slsvtontai + slsvDK >= slsv) {
            t = 0;
        }
        return t;
    }
    
    public int CheckPhong(String gioitinh) {
        int t = 1;
        int slsvDK, slsv, slsvtontai;
        slsvDK = demSVinDK(gioitinh);
        slsv = slsvINPhong(gioitinh);
        slsvtontai = slsvtontaitrongPhong(gioitinh);
        if (slsvtontai + slsvDK >= slsv) {
            t = 0;
        }

        return t;
    }
    
    public int demSVinDK(String gioitinh) {
        int sl = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select count(*) as slsv from DangKyPhong dkp join SinhVien sv on dkp.maSV=sv.maSV where gioiTinh='" + gioitinh + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sl = rs.getInt("slsv");
            }

        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sl;
    }
    
    public int slsvINPhong(String gioitinh) {
        int slsv = 0;
        Connection con = KetNoiSQL.getConnection();

        String sql2 = "select loaiPhong ,sum(soLuongSVPhong) as tongSVtt from Phong where gioiTinh='" + gioitinh + "' group by loaiPhong";
        try {

            PreparedStatement ps2 = con.prepareStatement(sql2);

            ResultSet rs2 = ps2.executeQuery();

            while (rs2.next()) {
                slsv = slsv + rs2.getInt("tongSVtt");
            }

        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDangKyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return slsv;

    }
    
    public int slsvtontaitrongPhong(String gioitinh) {
        List<String> listmp = listmaphongTheoGioiTinh(gioitinh);
        int tongsv = 0;
        for (String i : listmp) {
            tongsv = tongsv + soluongSVtttheomaPhong(i);
        }
        return tongsv;
    }
    
    public List<String> listmaphongTheoGioiTinh(String gioitinh) {
        List<String> listmaphong = new ArrayList<>();
        Connection con = KetNoiSQL.getConnection();
        String sql2 = "select maPhong from Phong where gioiTinh='" + gioitinh + "'";
        try {
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                listmaphong.add(rs2.getString("maPhong"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDangKyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listmaphong;

    }
    
    public void AddHopDong(String masv, String maphong, Date ngay) {
        Connection connectect = KetNoiSQL.getConnection();
        int row = 0;
        String sql = "insert into HopDongKTX (maSV,maPhong,ngayHDBD) values(?,?,?)";
        try {
            PreparedStatement ps = connectect.prepareStatement(sql);
            //String date1,date2,date3;
            ps.setString(1, masv.trim());
            ps.setString(2, maphong);
            ps.setDate(3, new java.sql.Date(ngay.getTime()));
            //ps.setString(4, "");

            row = ps.executeUpdate();

            connectect.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        public void deleteDK(String maSV) {
        Connection connect = KetNoiSQL.getConnection();
        String sql = "delete from DangKyPhong where maSV = ?";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, maSV);
            ps.executeUpdate();

        } catch (SQLException ex) {

        }
    }
    public Date getNgayHDKT(String masv) {
        Date date = null;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select * from HopDongKTX where maSV='" + masv + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                date = rs.getDate("ngayHDKT");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    
    public void updateNgayHDKT(String masv) {
        Date date = new Date();
        Connection con = KetNoiSQL.getConnection();
        String sql = "update HopDongKTX set ngayHDKT=? where maSV=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ps.setString(2, masv);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<String> getlistmaphong() {

        List<String> listmp = new ArrayList<>();
        Connection con = KetNoiSQL.getConnection();
        String sql = "select * from Phong";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listmp.add(rs.getString("maPhong"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listmp;
    }
    
    public int soluongSVtttheomaPhong(String maphong) {
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String datestr = sp.format(date);
        Date datefm = null;
        try {
            datefm = sp.parse(datestr);
        } catch (ParseException ex) {
        }

        int slsvtt = 0;
        Connection con = KetNoiSQL.getConnection();
        String sql = "select count(hd.maPhong) as slsv from HopDongKTX hd join Phong p on p.maPhong=hd.maPhong where ngayHDKT>? group by hd.maPhong having hd.maPhong='" + maphong + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                slsvtt = rs.getInt("slsv");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slsvtt;
    }
    
    public List<String> listmaphongTheoLoaiPhongAGT(String loaiphong, String gioitinh) {
        List<String> listmaphong = new ArrayList<>();
        Connection con = KetNoiSQL.getConnection();
        String sql = "select maPhong from Phong where loaiPhong='" + loaiphong + "' and gioiTinh='" + gioitinh + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs2 = ps.executeQuery();
            while (rs2.next()) {
                listmaphong.add(rs2.getString("maPhong"));
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDangKyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listmaphong;
    }
}
