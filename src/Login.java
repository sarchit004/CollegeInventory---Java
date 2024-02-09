import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends Component {
    private JPanel mainpanel;
    private JTextField tfusername;
    private JButton loginbtn;
    private JPasswordField pfpassword;
    private JLabel loginpageicon;
    private JPanel leftpanel;
    private JPanel rightpanel;


    public Login(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainpanel);
        frame.setBounds(450,100,550,450);
        frame.setTitle("IIMS Inventory-Login");
        frame.setVisible(true);

        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfusername.getText();
                String password = String.valueOf(pfpassword.getPassword());
                if(username.equals("sarash")&&password.equals("sarash123")) {
                    Dashboard.main(new String[]{});
                    frame.dispose();
                } else if (username.equals("admin")&&password.equals("admin123")) {
                    Dashboard.main(new String[]{});
                    frame.dispose();
                } else {
                        JOptionPane.showMessageDialog(Login.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
                        tfusername.setText("");
                        pfpassword.setText("");
                    }
                }
        });
    }

    public static void main(String[] args) {
        Login l = new Login();
    }
}
