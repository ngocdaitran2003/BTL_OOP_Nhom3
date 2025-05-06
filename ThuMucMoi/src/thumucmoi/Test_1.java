package thumucmoi;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.util.Arrays;
import java.util.Vector;

public class Test_1 extends JFrame{
    private JTable table;
    public Test_1(String title) {
        super(title);
        Object[][] data = {
            {1, "Nguyen Van A", 20, 3.4},
            {2, "Nguyen Van B", 20, 3.5},
            {3, "Nguyen Van C", 20, 3.4},
            {4, "Nguyen Van D", 20, 3.4},
            {5, "Nguyen Van F", 20, 3.4}
        };
        String[] header = {"STT", "Name", "Tuoi", "GPA"};
        table = new JTable(new DefaultTableModel(data, header));
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
        this.setSize(600,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(new Vector<>(Arrays.asList(6, "Nguyen Van E", 20, 9)));
        System.out.println(table.getValueAt(0, 1));
    }
    
    public static void main(String[] args) {
        new Test_1("App");
    }
}

