package javax;



//
//public class CoreJavac extends javax.swing.JFrame{
//    private javax.swing.JTable tbn;
//    private java.awt.ScrollPane scroll;
//    public CoreJavac(String title) {
//        super(title);
//        this.setSize(500,300);
//        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
//        this.setLayout(new java.awt.BorderLayout());
//        this.setLocationRelativeTo(null);
//        
//        Object[][] data = {
//            {1, "Nguyen Van A", "12A1", 3.5},
//            {2, "Nguyen Van B", "12A1", 3.5},
//            {3, "Nguyen Van C", "12A1", 3.5},
//            {4, "Nguyen Van D", "12A1", 3.5},
//            {5, "Nguyen Van E", "12A1", 3.5},
//            {6, "Nguyen Van F", "12A1", 3.5},
//                        {1, "Nguyen Van A", "12A1", 3.5},
//            {2, "Nguyen Van B", "12A1", 3.5},
//            {3, "Nguyen Van C", "12A1", 3.5},
//            {4, "Nguyen Van D", "12A1", 3.5},
//            {5, "Nguyen Van E", "12A1", 3.5},
//            {6, "Nguyen Van F", "12A1", 3.5},
//                        {1, "Nguyen Van A", "12A1", 3.5},
//            {2, "Nguyen Van B", "12A1", 3.5},
//            {3, "Nguyen Van C", "12A1", 3.5},
//            {4, "Nguyen Van D", "12A1", 3.5},
//            {5, "Nguyen Van E", "12A1", 3.5},
//            {6, "Nguyen Van F", "12A1", 3.5},
//                        {1, "Nguyen Van A", "12A1", 3.5},
//            {2, "Nguyen Van B", "12A1", 3.5},
//            {3, "Nguyen Van C", "12A1", 3.5},
//            {4, "Nguyen Van D", "12A1", 3.5},
//            {5, "Nguyen Van E", "12A1", 3.5},
//            {6, "Nguyen Van F", "12A1", 3.5},
//                        {1, "Nguyen Van A", "12A1", 3.5},
//            {2, "Nguyen Van B", "12A1", 3.5},
//            {3, "Nguyen Van C", "12A1", 3.5},
//            {4, "Nguyen Van D", "12A1", 3.5},
//            {5, "Nguyen Van E", "12A1", 3.5},
//            {6, "Nguyen Van F", "12A1", 3.5},
//        };
//     
//        String[] header = {"STT", "Name", "Class", "GPA"};
//        
//        tbn = new javax.swing.JTable(data, header);
//        tbn.setBounds(100,0, 500, 500);
//        tbn.setFillsViewportHeight(true);
//       
//          
//        this.add(tbn.getTableHeader(), java.awt.BorderLayout.NORTH);
//        add(tbn, java.awt.BorderLayout.CENTER);
//        
//        setVisible(true);
//    }
//    public static void main(String[] args) {
//        new CoreJavac("Application");
//    }
//}


import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class CoreJavac extends JFrame {
    private JTable tbn;
    private JScrollPane scroll;

    public CoreJavac(String title) {
        super(title);
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        // Dữ liệu mẫu
        Object[][] data = new Object[40][4]; // 40 dòng dữ liệu
        for (int i = 0; i < 40; i++) {
            data[i][0] = i + 1;
            data[i][1] = "Nguyen Van " + (char) ('A' + (i % 26));
            data[i][2] = "12A" + (i % 3 + 1);
            data[i][3] = (Math.random() * 4.0); // GPA ngẫu nhiên
        }

        // Tiêu đề cột
        String[] header = {"STT", "Name", "Class", "GPA"};

        // Tạo JTable
        tbn = new JTable(data, header);
        tbn.setFillsViewportHeight(true); // Đảm bảo bảng lấp đầy phần hiển thị
        // Thêm vào JScrollPane để có thanh cuộn
        scroll = new JScrollPane(tbn);

        // Thêm JScrollPane vào JFrame (BorderLayout.CENTER tự động quản lý kích thước)
        this.add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }
//    String sd = "12/04/1009";
//    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
//    java.util.Date d = f.parse(sd);
    public static void change(Integer n) {
        n += 39;
    }
    public static void change1(int a[]) {
        
    }

//    public static void main(String[] args) throws Exception {
//       SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
//       String sd = "0h/10/2022";
//       String snum = "b123";
//       try{
//           Date d = f.parse(sd);
//           System.out.println(d);
//           int num = Integer.parseInt(snum);
//           System.out.println(num);
//       } catch(NumberFormatException e) {
//           System.out.println(e);
//       } catch(ParseException e) {
//           System.out.println(e);
//       } finally {
//           System.out.println("Luon luon execute");
//       }}
        public static void checkAge(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new IllegalArgumentException("Age must be 18 or above");
        }
        System.out.println(a/b);
    }

    public static void main(String[] args) throws Exception {
       
       
    }
    
}