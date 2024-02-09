import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Customerdetails {
    private JPanel mainpanel;
    private JTable customertable;
    private JPanel toppanel;
    private JPanel middlepanel;
    private JPanel bottompanel;
    private JLabel backbtnicon;
    private JLabel customericon;
    private JButton addNewCustomerButton;

    public Customerdetails() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainpanel);
        frame.setTitle("IIMS Inventory-Customer Details");
        frame.setBounds(350,100,650,500);
        frame.setVisible(true);

        createTable();

        backbtnicon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Dashboard.main(new String[]{});
                frame.dispose();
            }
        });
        addNewCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Addcustomer.main(new String[]{});
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        Customerdetails cd = new Customerdetails();
    }

    private void createTable() {
        Object [][] data = {
                {"0001","Ram","Shakya","Purnachandi","9813058011","nothing new"},
                {},
        };
        customertable.setModel(new DefaultTableModel(
                data,
                new String[]{"Customer ID","First Name","Last Name","Address","Contact number","Remarks"}
        ));
        TableColumnModel columns = customertable.getColumnModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(0).setCellRenderer(centerRenderer);
        columns.getColumn(4).setCellRenderer(centerRenderer);
    }

}
