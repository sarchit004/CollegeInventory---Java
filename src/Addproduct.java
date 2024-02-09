import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Addproduct extends Component {
    private JPanel mainpanel;
    private JPanel middlepanel;
    private JPanel bottompanel;
    private JLabel productentry;
    private JLabel addproducticon;
    private JLabel backbtnicon;
    private JPanel toppanel;
    private JTextField productname;
    private JTextField productid;
    private JTextField boughtfrom;
    private JTextField quantitypurchased;
    private JTextField mrp;
    private JTextField remarks;
    private JComboBox categorycombo;
    private JButton addbtn;
    private JButton resetbtn;

    public Addproduct(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("IIMS Inventory-New Product Entry");
        frame.setBounds(450,100,500,530);
        frame.setContentPane(mainpanel);

        createCombo();
        backbtnicon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Productdetail.main(new String[]{});
                frame.dispose();
            }
        });
        resetbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productid.setText(null);
                productname.setText(null);
                remarks.setText(null);
                mrp.setText(null);
                boughtfrom.setText(null);
                quantitypurchased.setText(null);

            }
        });
        resetbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productid.setText(null);
                productname.setText(null);
                boughtfrom.setText(null);
                quantitypurchased.setText(null);
                mrp.setText(null);
                remarks.setText(null);
            }
        });
        productid.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if(!Character.isDigit(c)) {
                    e.consume();
                }
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
        quantitypurchased.addKeyListener(listener);
        mrp.addKeyListener(listener);
        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (productid.getText().equals("") ||
                    productname.getText().equals("") ||
                    boughtfrom.getText().equals("") ||
                    quantitypurchased.getText().equals("") ||
                    remarks.getText().equals("") ||
                    mrp.getText().equals("")) {
                    JOptionPane.showMessageDialog(Addproduct.this, "Please fill up all the required information!", "ERROR!", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Addproduct.this, "Added Succesfully!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void createCombo() {
        categorycombo.setModel(new DefaultComboBoxModel(new String[] {"Home Assistant","Tuya","Zigbee","Sensors","Survillience"}));
    }

    public static void main(String[] args) {
        Addproduct ap = new Addproduct();
    }
}
