import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Billingdetails {
    private JPanel mainpanel;
    private JPanel toppanel;
    private JPanel middlepanel;
    private JPanel bottompanel;
    private JLabel backbtnicon;
    private JLabel billicon;
    private JLabel billdetails;
    private JTable billdetailstable;
    private JButton cancelbtn;


    public Billingdetails(){


        createTable();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainpanel);
        frame.setTitle("IIMS Inventory-Bill Details");
        frame.setBounds(450,100,500,530);
        frame.setVisible(true);
        backbtnicon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Purchasedetails.main(new String[]{});
                frame.dispose();
            }
        });
        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Purchasedetails.main(new String[]{});
                frame.dispose();
            }
        });
    }

    private void createTable() {
        Object [][] data = {
                {"001","Hikvision 4port NVR system","2023/2/3","Hikvision Infotech",256,"Sarash Chitrakar"},
                {"002","Rasberry Pie","2023/2/8","METS",260,"Sarash Chitrakar"},
                {"003","Tuya Door/Window contact sensor","2023/3/3","Technozone sys",262,"Sarash Chitrakar"},
                {"004","Zigbee PIR sensor","2023/3/5","Technozone sys",270,"Sarash Chitrakar"},

        };
        billdetailstable.setModel(new DefaultTableModel(
                data,
                new String[]{"Product ID","Product Name","Purchased Date","Vendor Name","Bill Number","Billed by"}
        ));
        TableColumnModel columns = billdetailstable.getColumnModel();
        columns.getColumn(0).setMinWidth(50);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(0).setCellRenderer(centerRenderer);
        columns.getColumn(2).setCellRenderer(centerRenderer);
        columns.getColumn(4).setCellRenderer(centerRenderer);
    }

    public static void main(String[] args) {
        Billingdetails bd = new Billingdetails();
    }
}
