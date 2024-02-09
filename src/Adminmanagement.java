import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Adminmanagement {
    private JPanel mainpanel;
    private JTable admintable;
    private JButton addAdminButton;
    private JLabel backbtnicon;
    private JPanel toppanel;
    private JPanel middlepanel;
    private JPanel bottompanel;

    public Adminmanagement(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainpanel);
        frame.setTitle("IIMS Inventory-Admin");
        frame.setBounds(450,100,500,400);
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
        addAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Addadmin.main(new String[]{});
                frame.dispose();
            }
        });
    }

    private void createTable() {
        Object [][] data = {
                {"0001","Admin","Admin","admin","admin123","Active"},
                {"0002","Sarash Chitrakar","Purnachandi","sarash","sarash123","Active"},
                {},
        };
        admintable.setModel(new DefaultTableModel(
                data,
                new String[]{"ID","Name","Address","Username","Password","Status"}
        ));
        TableColumnModel columns = admintable.getColumnModel();
        columns.getColumn(1).setMinWidth(100);
        columns.getColumn(2).setMinWidth(70);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(0).setCellRenderer(centerRenderer);

    }

    public static void main(String[] args) {
        Adminmanagement am = new Adminmanagement();
    }
}
