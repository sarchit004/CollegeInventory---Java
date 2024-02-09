import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Addsales extends Component {
    private JPanel mainpanel;
    private JPanel toppanel;
    private JPanel middlepanel;
    private JPanel bottompanel;
    private JLabel backbtnicon;
    private JLabel salesentry;
    private JTextField productname;
    private JTextField chalanby;
    private JTextField productid;
    private JTextField chalanno;
    private JTextField solddate;
    private JTextField soldto;
    private JTextField quantitysold;
    private JTextField sellingrate;
    private JTextField discount;
    private JButton addbtn;
    private JButton resetbtn;
    private JTextField remarks;
    private JComboBox categorycombo;

    public Addsales(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainpanel);
        frame.setTitle("IIMS Inventory-Sales Entry");
        frame.setVisible(true);
        frame.setBounds(450,100,500,530);

        createCombo();
        backbtnicon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Salesdetail.main(new String[]{});
                frame.dispose();
            }
        });
        resetbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productid.setText(null);
                productname.setText(null);
                soldto.setText(null);
                quantitysold.setText(null);
                solddate.setText(null);
                sellingrate.setText(null);
                discount.setText(null);
                chalanno.setText(null);
                chalanby.setText(null);
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
        chalanno.addKeyListener(listener);
        quantitysold.addKeyListener(listener);
        sellingrate.addKeyListener(listener);
        discount.addKeyListener(listener);
        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (productid.getText().equals("") ||
                    productname.getText().equals("") ||
                    soldto.getText().equals("") ||
                    solddate.getText().equals("") ||
                    quantitysold.getText().equals("") ||
                    sellingrate.getText().equals("") ||
                    chalanno.getText().equals("") ||
                    chalanby.getText().equals("") ||
                    remarks.getText().equals("")) {
                    JOptionPane.showMessageDialog(Addsales.this, "Please fill up all the required informations!", "ERROR!", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Addsales.this, "Added Succesfully!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void createCombo() {
        categorycombo.setModel(new DefaultComboBoxModel(new String[] {"Home Assistant","Tuya","Zigbee","Sensors","Survillience"}));
    }

    public static void main(String[] args) {
        Addsales as = new Addsales();
    }
}
