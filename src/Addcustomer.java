import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Addcustomer extends Component {
    private JPanel mainpanel;
    private JPanel toppanel;
    private JPanel middlepanel;
    private JPanel bottompanel;
    private JLabel backbtnicon;
    private JLabel addcustomericon;
    private JTextField customerid;
    private JTextField firstname;
    private JTextField contactno;
    private JTextField remarks;
    private JTextField address;
    private JTextField lastname;
    private JComboBox contactcombo;
    private JButton addbtn;
    private JButton resetbtn;
public Addcustomer() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(mainpanel);
    frame.setTitle("IIMS Inventory-Customer Entry");
    frame.setBounds(450,100,500,550);
    frame.setVisible(true);

    createCombo();



    backbtnicon.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            Customerdetails.main(new String[]{});
            frame.dispose();
        }
    });
    resetbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            customerid.setText(null);
            firstname.setText(null);
            lastname.setText(null);
            address.setText(null);
            remarks.setText(null);
            contactno.setText(null);
        }
    });
    customerid.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            char c = e.getKeyChar();
            if(!Character.isDigit(c)) {
                e.consume();
            }
        }
    });
    contactno.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            char c = e.getKeyChar();
            if(!Character.isDigit(c)) {
                e.consume();
            }
        }
    });
    addbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (customerid.getText().equals("") ||
                firstname.getText().equals("") ||
                lastname.getText().equals("") ||
                address.getText().equals("") ||
                remarks.getText().equals("") ||
                contactno.getText().equals("")) {
                JOptionPane.showMessageDialog(Addcustomer.this, "Please fill up all the required information!", "ERROR!", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(Addcustomer.this, "Added Succesfully!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    });
}

    private void createCombo() {
        contactcombo.setModel(new DefaultComboBoxModel(new String[] {"Nepal(+977)","USA(+1)","India(+91)","UK(+77)","Other...."}));

}

    public static void main(String[] args) {
        Addcustomer ac = new Addcustomer();
    }
}
