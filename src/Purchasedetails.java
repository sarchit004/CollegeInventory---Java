import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Purchasedetails {
    private JPanel mainpanel;
    private JPanel toppanel;
    private JPanel upperpanel;
    private JPanel lowerpanel;
    private JPanel bottompanel;
    private JLabel purchasedetails;
    private JLabel puchaseicon;
    private JLabel backbtn;
    private JComboBox categorycombo;
    private JTextField itemsperpage;
    private JLabel category;
    private JTable purchasetable;
    private JButton billingdetails;
    private JButton addpurchase;

    public Purchasedetails(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("IIMS Inventory-Purchase");
        frame.setBounds(300,100,800,550);
        frame.setContentPane(mainpanel);
        
        createTable();
        createCombo();

        addpurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Addpurchase.main(new String[]{});
                frame.dispose();
            }
        });
        backbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Dashboard.main(new String[]{});
                frame.dispose();
            }
        });
        billingdetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Billingdetails.main(new String[]{});
                frame.dispose();
            }
        });
    }

    private void createCombo() {
        categorycombo.setModel(new DefaultComboBoxModel(new String[] {"Home Assistant","Tuya","Zigbee","Sensors","Survillience"}));
    }

    private void createTable() {
        Object [][] data = {
                {"0001","Hikvision 4port NVR System","2023/2/3","Hikvision Infotech",5,20000,5*20000,"expensive"},
                {"0002","Rasberry Pie","2023/2/8","METS",4,25000,4*25000,"just bought 4 for now"},
                {"0003","Tuya Door/window contact sensor","2023/3/3","Technozone sys",50,500,50*500,"only wifi compatible"},
                {"0004","Zigbee PIR sensor","2023/3/5","Technozone sys",25,1000,25*1000,"can be used only with gateway"},
                {},
                {},
        };
        purchasetable.setModel(new DefaultTableModel(
                data,
                new String[]{"Product ID","Product Name","Purchased Date","Vendor Name","Quantity Purchased","MRP","Total Price","Remarks"}
        ));
        TableColumnModel columns = purchasetable.getColumnModel();
        columns.getColumn(0).setMinWidth(60);          //product id
        columns.getColumn(0).setMaxWidth(65);           //product id
        columns.getColumn(1).setMinWidth(170);          //product name
        columns.getColumn(2).setMinWidth(96);          //purchased date
        columns.getColumn(3).setMinWidth(150);          //vendor name
        columns.getColumn(4).setMinWidth(65);          //quantity purchased
        columns.getColumn(5).setMinWidth(50);          //mrp
        columns.getColumn(6).setMinWidth(75);          //total price
        columns.getColumn(7).setMinWidth(100);          //remarks


        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(0).setCellRenderer(centerRenderer);          //product id
        columns.getColumn(2).setCellRenderer(centerRenderer);          //date purchased
        columns.getColumn(4).setCellRenderer(centerRenderer);          //quantity purchased
        columns.getColumn(5).setCellRenderer(centerRenderer);          //mrp
        columns.getColumn(6).setCellRenderer(centerRenderer);          //total price


    }


    public static void main(String[] args) {
        Purchasedetails pd = new Purchasedetails();
    }
}
