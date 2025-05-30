package model;

import java.util.Date;

/**
 *
 * @author Nam
 */
public class ThongTinGiaHan {
    private String maSV;
    private Date ngayHDKT;
    private int thoiGianGiaHan;
    private int trangThai;

    public ThongTinGiaHan() {
    }

    public ThongTinGiaHan(String maSV, Date ngayHDKT, int thoiGianGiaHan, int trangThai) {
        this.maSV = maSV;
        this.ngayHDKT = ngayHDKT;
        this.thoiGianGiaHan = thoiGianGiaHan;
        this.trangThai = trangThai;
    }



    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public Date getNgayHDKT() {
        return ngayHDKT;
    }

    public void setNgayHDKT(Date ngayHDKT) {
        this.ngayHDKT = ngayHDKT;
    }

    public int getThoiGianGiaHan() {
        return thoiGianGiaHan;
    }

    public void setThoiGianGiaHan(int thoiGianGiaHan) {
        this.thoiGianGiaHan = thoiGianGiaHan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
}
