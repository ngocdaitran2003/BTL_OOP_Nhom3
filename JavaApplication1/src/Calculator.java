import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JLabel lblFirst, lblSecond, lblResult;
    private JTextField txtFirst, txtSecond, txtResult;
    private JButton btnClear, btnAdd, btnSub, btnMul, btnDiv;

    public Calculator(String title) {
        // Cấu hình JFrame
        this.setTitle(title);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null); // Null layout (cần setBounds cho từng thành phần)

        // Khởi tạo các JLabel
        lblFirst = new JLabel("First Number:");
        lblSecond = new JLabel("Second Number:");
        lblResult = new JLabel("Result:");

        // Khởi tạo JTextField
        txtFirst = new JTextField();
        txtSecond = new JTextField();
        txtResult = new JTextField();
        txtResult.setEditable(false); // Không cho nhập vào ô kết quả

        // Khởi tạo JButton
        btnAdd = new JButton("+");
        btnSub = new JButton("-");
        btnMul = new JButton("*");
        btnDiv = new JButton("/");
        btnClear = new JButton("Clear");

        // Đặt vị trí bằng setBounds(x, y, width, height)
        lblFirst.setBounds(30, 30, 100, 30);
        txtFirst.setBounds(150, 30, 150, 30);

        lblSecond.setBounds(30, 70, 100, 30);
        txtSecond.setBounds(150, 70, 150, 30);

        lblResult.setBounds(30, 110, 100, 30);
        txtResult.setBounds(150, 110, 150, 30);

        btnAdd.setBounds(30, 160, 50, 30);
        btnSub.setBounds(90, 160, 50, 30);
        btnMul.setBounds(150, 160, 50, 30);
        btnDiv.setBounds(210, 160, 50, 30);
        btnClear.setBounds(270, 160, 80, 30);

        // Thêm các thành phần vào JFrame
        this.add(lblFirst);
        this.add(txtFirst);
        this.add(lblSecond);
        this.add(txtSecond);
        this.add(lblResult);
        this.add(txtResult);
        this.add(btnAdd);
        this.add(btnSub);
        this.add(btnMul);
        this.add(btnDiv);
        this.add(btnClear);

        // Sự kiện nút bấm
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate("+");
            }
        });

        btnSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate("-");
            }
        });

        btnMul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate("*");
            }
        });

        btnDiv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate("/");
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtFirst.setText("");
                txtSecond.setText("");
                txtResult.setText("");
            }
        });

        this.setVisible(true);
    }

    // Phương thức tính toán
    private void calculate(String operator) {
        try {
            double num1 = Double.parseDouble(txtFirst.getText());
            double num2 = Double.parseDouble(txtSecond.getText());
            double result = 0;

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": 
                    if (num2 == 0) {
                        txtResult.setText("Error");
                        return;
                    }
                    result = num1 / num2; 
                    break;
            }
            txtResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            txtResult.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        //new Calculator("Calculator");
        JFrame frame = new JFrame("Hello");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(null);
        
        JButton button = new JButton("click");
        frame.add(button);
        button.setBounds(50,10,50,50);
    }
}