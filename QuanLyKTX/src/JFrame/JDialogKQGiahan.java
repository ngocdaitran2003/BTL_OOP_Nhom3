/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package JFrame;

import Connector.KetNoiSQL;
import DAO.GiaHanDAO;
import DAO.HopDongKTXDAO;
import java.sql.Connection;
import model.ThongTinHopDong;
import java.util.Date;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ThongTinGiaHan;



/**
 *
 * @author Nguyễn Văn Vũ
 */
public class JDialogKQGiahan extends javax.swing.JDialog {
    String msv;

    Date nkt;
    /**
     * Creates new form JDialogGiahan
     */
    public JDialogKQGiahan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    void setMSV(String MaSV){
    msv=MaSV;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtNgayBD = new javax.swing.JLabel();
        txtNgayKT = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtTGGH = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtKetQua = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(237, 50, 55));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Thông tin hợp đồng");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(19, 90, 118));
        jLabel26.setText("Mã sinh viên :");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(19, 90, 118));
        jLabel27.setText("Mã phòng :");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(19, 90, 118));
        jLabel28.setText("Thời gian hợp đồng :");

        txtNgayBD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNgayBD.setForeground(new java.awt.Color(19, 90, 118));

        txtNgayKT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNgayKT.setForeground(new java.awt.Color(19, 90, 118));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(19, 90, 118));
        jLabel3.setText(" -");

        txtMaSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaSV.setForeground(new java.awt.Color(19, 90, 118));

        txtMaPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaPhong.setForeground(new java.awt.Color(19, 90, 118));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(19, 90, 118));
        jLabel29.setText("Thời gian gia hạn:");

        txtTGGH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTGGH.setForeground(new java.awt.Color(19, 90, 118));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(19, 90, 118));
        jLabel30.setText("Kết quả:");

        txtKetQua.setBackground(new java.awt.Color(255, 255, 255));
        txtKetQua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtKetQua.setForeground(new java.awt.Color(19, 90, 118));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMaSV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                .addComponent(txtMaPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTGGH, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayKT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(txtTGGH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30)
                    .addComponent(txtKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialogKQGiahan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogKQGiahan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogKQGiahan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogKQGiahan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogKQGiahan dialog = new JDialogKQGiahan(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel txtKetQua;
    private javax.swing.JLabel txtMaPhong;
    private javax.swing.JLabel txtMaSV;
    private javax.swing.JLabel txtNgayBD;
    private javax.swing.JLabel txtNgayKT;
    private javax.swing.JLabel txtTGGH;
    // End of variables declaration//GEN-END:variables

     void LayThongTinHDUp(String MaSV) {
        ThongTinGiaHan gh = new GiaHanDAO().getAllThongTinGiaHanTheoMaSV(MaSV);
        ThongTinHopDong hd =new HopDongKTXDAO().getAllThongTinHDTheoMaSV(MaSV);
        SimpleDateFormat sp =new SimpleDateFormat("dd-MM-yyyy");
        String tg="";
        if (gh.getThoiGianGiaHan()==3 ) {
            tg="3 tháng";
        }else if (gh.getThoiGianGiaHan()==6 ) {            
            tg="6 tháng";
        }else if (gh.getThoiGianGiaHan()==9 ) {            
            tg="9 tháng";
        }else    tg="12 tháng";            
        String tt ="";
        if (gh.getTrangThai()==0 ) {
            tt="Gia hạn bị từ chối";
        }else if (gh.getTrangThai()==1) {            
            tt="Đang chờ kết quả";
        }else tt="Gia hạn thành công";
        txtMaSV.setText(gh.getMaSV());
        txtMaPhong.setText(new HopDongKTXDAO().laymaPhongtumaSV(msv));
        txtNgayBD.setText(sp.format(hd.getNgayHDBD()));
        txtNgayKT.setText(sp.format(gh.getNgayHDKT()));
        txtTGGH.setText(tg);
        txtKetQua.setText(tt);

     }
     void deleteChuyenPhong(String MaSV) {
        Connection conn = KetNoiSQL.getConnection();
        ThongTinGiaHan gh = new GiaHanDAO().getAllThongTinGiaHanTheoMaSV(MaSV);
        int tt=0;
        if (gh.getTrangThai()==0 || gh.getTrangThai()==2){
                    String sql = "delete from GiaHan where maSV = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, MaSV);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Đã có lỗi xảy ra");
        }
        }

    }
       
 
    
}
