import javax.swing.*;
import java.awt.event.*;

public class Addadmin extends JFrame{
    private JPanel mainpanel;
    private JTextField adminid;
    private JTextField username;
    private JTextField adminname;
    private JButton addButton;
    private JButton resetButton;
    private JPasswordField password;
    private JTextField confirmpassword;
    private JLabel backbtnicon;
    private JLabel addadmin;
    private JLabel addadminicon;
    private JPanel toppanel;
    private JPanel middlepanel;
    private JPanel bottompanel;

    public Addadmin(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainpanel);
        frame.setTitle("IIMS Inventory-Admin Management");
        frame.setBounds(450,100,500,450);
        frame.setVisible(true);
        backbtnicon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Adminmanagement.main(new String[]{});
                frame.dispose();
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminid.setText(null);
                adminname.setText(null);
                username.setText(null);
                password.setText(null);
                confirmpassword.setText(null);

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpw = String.valueOf(confirmpassword.getText());
                String pw = String.valueOf(password.getPassword());
                if (adminid.getText().equals("") ||
                    adminname.getText().equals("") ||
                    username.getText().equals("") ||
                    password.getText().equals("") ||
                    confirmpassword.getText().equals("")) {
                    JOptionPane.showMessageDialog(Addadmin.this, "Please fill up all the required information!", "FAILED!", JOptionPane.ERROR_MESSAGE);
                } else if (!(cpw.equals(pw))){
                    JOptionPane.showMessageDialog(Addadmin.this, "Passwords doesn't match!", "FAILED!", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Addadmin.this, "Added Succesfully", "Succesfull!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        adminid.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    public static void main(String[] args) {
        Addadmin aa = new Addadmin();
    }
}
