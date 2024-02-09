import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {


    private JPanel mainpanel;
    private JPanel toppanel;
    private JPanel bottompanel;
    private JLabel dashboardicon;
    private JButton productDetaisButton;
    private JButton customerDetailsButton;
    private JButton purchaseButton;
    private JButton salesButton;
    private JButton profitAndLossButton;
    private JButton logoutButton;
    private JButton adminManagementButton;

    public Dashboard(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainpanel);
        frame.setTitle("IIMS Inventory-Dashboard");
        frame.setVisible(true);
        frame.setBounds(450,100,550,450);

        productDetaisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Productdetail.main(new String[]{});
                frame.dispose();
            }
        });
//        customerDetailsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Customerdetails.main(new )
//            }
//        });
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Purchasedetails.main(new String[]{});
                frame.dispose();
            }
        });
        salesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Salesdetail.main(new String[]{});
                frame.dispose();
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.main(new String[]{});
                frame.dispose();
            }
        });
        customerDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customerdetails.main(new String[]{});
                frame.dispose();
            }
        });
        profitAndLossButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profitandloss.main(new String[]{});
                frame.dispose();
            }
        });
        adminManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Adminmanagement.main(new String[]{});
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        Dashboard db = new Dashboard();
    }
}
