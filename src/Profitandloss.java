import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Profitandloss {
    private JPanel mainpanel;
    private JComboBox categorycombo;
    private JTextField a20ItemsPageTextField;
    private JTable profitlosstable;
    private JButton cancelbtn;
    private JPanel toppanel;
    private JPanel upperpanel;
    private JPanel lowerpanel;
    private JPanel bottompanel;
    private JLabel backbtnicon;
    private JLabel category;


    public Profitandloss(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainpanel);
        frame.setTitle("IIMS Inventory-Profit and Loss");
        frame.setBounds(450,100,500,500);
        frame.setVisible(true);

        createTable();
        createCombo();
        backbtnicon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Dashboard.main(new String[]{});
                frame.dispose();
            }
        });
        cancelbtn.addMouseListener(new MouseAdapter() {
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
                {"0001","Hikvision 4port NVR System",20000,23000,23000-20000,"-","positive selling reviews"},
                {},
        };
        profitlosstable.setModel(new DefaultTableModel(
                data,
                new String[]{"Product ID","Product Name","MRP","Selling Price","Net Profit","Net Loss","Remarks"}
        ));
        TableColumnModel columns = profitlosstable.getColumnModel();
        columns.getColumn(1).setMinWidth(100);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(0).setCellRenderer(centerRenderer);
        columns.getColumn(2).setCellRenderer(centerRenderer);
        columns.getColumn(3).setCellRenderer(centerRenderer);
        columns.getColumn(4).setCellRenderer(centerRenderer);
        columns.getColumn(5).setCellRenderer(centerRenderer);
    }

    private void createCombo() {
        categorycombo.setModel(new DefaultComboBoxModel(new String[] {"Home Assistant","Tuya","Zigbee","Sensors","Survillience"}));

    }

    public static void main(String[] args) {
        Profitandloss pl = new Profitandloss();
    }
}
