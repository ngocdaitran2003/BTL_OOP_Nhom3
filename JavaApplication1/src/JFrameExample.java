import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


//JTable()
//JTable(Object[][] rows, Object[] cols);
//ScrollPane

//public class JFrameExample extends javax.swing.JFrame {
//    private javax.swing.JLabel lblName, lblResult;
//    private javax.swing.JButton button;
//    private javax.swing.JTextField txt1, txt2;
//    
//    public JFrameExample(String title) {
//        this.setTitle(title);
//        lblName = new javax.swing.JLabel("Full Name");
//        lblResult = new javax.swing.JLabel("Result");
//        
//        button = new javax.swing.JButton("Convert");
//        
//        txt1 = new javax.swing.JTextField("");
//        txt2 = new javax.swing.JTextField("");
//        
//        add(lblName);
//        add(lblResult);
//        add(button);
//        add(txt1);
//        add(txt2);
//        
//        setSize(500,500);
//       
//    }
//}

public class JFrameExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess");
        JButton[] button = new JButton[64];
        for(int i = 0; i <= 63; i++) {
            button[i] = new JButton("");
            frame.add(button[i]);
        }
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
               if(i % 2 == 0) {
                   if(j % 2 == 1) button[i*8 + j].setBackground(Color.black);
                   else button[i*8 + j].setBackground(Color.white);
               }else{
                   if(j % 2 == 0) button[i*8 + j].setBackground(Color.black);
                   else button[i*8 + j].setBackground(Color.white);
               }
            }
        }
        frame.setSize(500,500);
        frame.setLayout(new GridLayout(8,8));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        int x = 1, y = 10;
        System.out.print("("+x+", "+y+")");
    }
}





























































































































































































































































































































