import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Addpurchase extends Component {
    private JPanel mainpanel;
    private JPanel upperpanel;
    private JPanel middlepanel;
    private JPanel bottompanel;
    private JLabel backbtnicon;
    private JLabel addpurchaseicon;
    private JLabel purchaseentry;
    private JTextField remarks;
    private JTextField productname;
    private JTextField productid;
    private JTextField boughtfrom;
    private JTextField quantitypurchased;
    private JTextField purchaseddate;
    private JTextField mrp;
    private JComboBox categorycombo;
    private JButton addbtn;
    private JButton resetbtn;
    private JTextField billno;
    private JTextField billedby;

    public Addpurchase() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setTitle("IIMS Inventory-New Purchase Entry");
    frame.setBounds(450,100,500,530);
    frame.setContentPane(mainpanel);

    createCombo();


    backbtnicon.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            Purchasedetails.main(new String[]{});
            frame.dispose();
        }
    });
        resetbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productid.setText(null);
                productname.setText(null);
                boughtfrom.setText(null);
                quantitypurchased.setText(null);
                purchaseddate.setText(null);
                mrp.setText(null);
                billno.setText(null);
                billedby.setText(null);
                remarks.setText(null);
            }
        });
        KeyAdapter listener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if(!Character.isDigit(c)) {
                    e.consume();
                }
            }
        };
        productid.addKeyListener(listener);
        quantitypurchased.addKeyListener(listener);
        mrp.addKeyListener(listener);
        billno.addKeyListener(listener);
        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (productname.getText().equals("") ||
                    productid.getText().equals("") ||
                    boughtfrom.getText().equals("") ||
                    quantitypurchased.getText().equals("") ||
                    purchaseddate.getText().equals("") ||
                    mrp.getText().equals("") ||
                    billedby.getText().equals("") ||
                    billno.getText().equals("") ||
                    remarks.getText().equals("")) {
                    JOptionPane.showMessageDialog(Addpurchase.this, "Please fill up all the required information!", "ERROR!", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Addpurchase.this, "Added Succesfully!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void createCombo() {
        categorycombo.setModel(new DefaultComboBoxModel(new String[] {"Home Assistant","Tuya","Zigbee","Sensors","Survillience"}));

    }

    public static void main(String[] args) {
        Addpurchase ap = new Addpurchase();
    }
}
