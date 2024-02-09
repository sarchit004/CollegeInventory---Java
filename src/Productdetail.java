import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Productdetail {
    private JPanel mainpanel;
    private JPanel toppanel;
    private JPanel middlepanel;
    private JPanel bottompanel;
    private JLabel productdetail;
    private JLabel producticon;
    private JLabel backbtnicon;
    private JTable producttable;
    private JButton addproduct;

    public Productdetail(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("IIMS Inventory-Product Details");
        frame.setBounds(450,100,550,450);
        frame.setContentPane(mainpanel);

        createTable();
        addproduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Addproduct.main(new String[]{});
                frame.dispose();
            }
        });
        backbtnicon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Dashboard.main(new String[]{});
                frame.dispose();
            }
        });
    }

    private void createTable() {
        Object [][] data = {
                {"001","Door Window sensor","Tuya","Mets",5,1000,2*1000,"Battery operated"},
                {"002","PIR motion sensor","Zigbee","Zigbee station",20,1500,20*1500,"Only compatible with hub"},
                {},
        };
        producttable.setModel(new DefaultTableModel(
                data,
                new String[]{"ID","Name","Category","Vendor","Quantity Purchased","MRP","Total Price","Remarks"}
        ));
        TableColumnModel columns = producttable.getColumnModel();
        columns.getColumn(1).setMinWidth(60);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(0).setCellRenderer(centerRenderer);          //product id
        columns.getColumn(4).setCellRenderer(centerRenderer);
        columns.getColumn(5).setCellRenderer(centerRenderer);
        columns.getColumn(6).setCellRenderer(centerRenderer);

    }

    public static void main(String[] args) {
        Productdetail pd = new Productdetail();
    }
}
