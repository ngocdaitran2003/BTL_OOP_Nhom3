package javax;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class DangKyTaiKhoan extends JFrame{
    public DangKyTaiKhoan(String title){
        super(title);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        button = new JButton("Click me!");
        button.setBounds(20,50,80,30);
        
        label = new JLabel("Password: ");
        label.setBounds(20, 80, 80,30);
        
        jtf = new JTextField();
        jtf.setBounds(150, 80, 80,30);
        this.add(label);
        this.add(jtf);
        this.add(button);
    }
    public static void main(String[] args){
        new DangKyTaiKhoan("Example").setVisible(true);
    }
    private JButton button;
    private JLabel label;
    private JTextField jtf;
}