import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

class PasswordGenerator implements ActionListener {

    private static final SecureRandom random = new SecureRandom();
    private static final String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String small_caps = "abcdefghijklmnopqrstuvwxyz";
    private static final String Numeric = "1234567890";
    private static final String special_char = "~!@#$%^&*()_+{}|:<>?";
    private static final String dic = caps + small_caps + Numeric + special_char;

    JFrame frame;
    JButton PassGeneBtn;
    Container conn1;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == PassGeneBtn) {
            String generatedPassword = generatePassword(12); 
            JOptionPane.showMessageDialog(frame, "Generated Password: " + generatedPassword);
        }
    }

    public static void FrameGUI(JFrame frame) {
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
    }

    public static void ContainerGUI(Container conn) {
        conn.setVisible(true);
        conn.setBackground(Color.black);
        conn.setLayout(null);
    }

    public void GUIButtonsSetting(JButton btn) {
        btn.setBackground(new Color(0XFB2576));
        btn.setForeground(Color.WHITE);
        btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        btn.setFocusable(false);
        Cursor crs = new Cursor(Cursor.HAND_CURSOR);
        btn.setCursor(crs);
        Font fn = new Font("Monospace", Font.BOLD, 15);
        btn.setFont(fn);
    }

    public String generatePassword(int len) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int index = random.nextInt(dic.length());
            password.append(dic.charAt(index));
        }
        return password.toString();
    }

    PasswordGenerator() {
        frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300); 
        frame.setResizable(false);

        FrameGUI(frame);

        conn1 = frame.getContentPane();
        ContainerGUI(conn1);

        PassGeneBtn = new JButton("GENERATE PASSWORD");
        PassGeneBtn.setBounds(125, 100, 220, 40);
        conn1.add(PassGeneBtn);
        GUIButtonsSetting(PassGeneBtn);
        PassGeneBtn.addActionListener(this);
    }

    public static void main(String[] args) {
       new PasswordGenerator();
    }
}
