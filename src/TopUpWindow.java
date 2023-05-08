import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopUpWindow extends JFrame implements ActionListener{
    
    private Font contentFont = new Font("Comic Sans MS", Font.PLAIN, 30);
    private JFrame frame;
    private JFrame profileFrame = new JFrame("Profile Details");
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JPanel headerPanel;
    private JLabel headerLabel;

    private JButton navButton;

    private JLabel southLabel;
    private JPanel panelTextArea = new JPanel(new BorderLayout());
    private JButton backButton = new JButton("Back"); 
    private JButton changePINButton = new JButton("Change PIN");

    private JPanel titPanel;
    private JPanel contentPanel;
    private JPanel panel1 = new JPanel(new GridLayout(6, 1));
    private JPanel panel2 = new JPanel(new GridLayout(4,1)); 

    private JPanel balancePanel;
    private JTextField balanceField;
    private JLabel balanceLabel;
    private JLabel textLabel;
    private JButton balanceBtn;
    private JPanel buttonPanel;
    private Database datum; 
    int index;

    private String buttonLabel[] = {
        "Home", "Profile", "History", "Log Out"
    };
    
    private String navigation[] = {
        "homeicon.png", "profileicon.png", "historyicon.png","logouticon.png"
    }; 

    public static void main(String[] args) {
        new TopUpWindow(new Database(), 0);
    }

    public TopUpWindow(Database data, int idx) {
        datum = data;
        index = idx;

        Color bgColor = new Color(223, 246, 255);
        Color headerColor = new Color(6, 40, 61);

        frame = new JFrame("Travelly");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(bgColor);

        for (int i = 0; i < 4; i++){
            ImageIcon navIcon = new ImageIcon("src/assets/" + navigation[i]);
            navButton = new JButton(navIcon);
            navButton.setText(buttonLabel[i]);
            navButton.setFont(new Font("Times New Roman", Font.PLAIN, 1));
            navButton.setFocusable(false);
            navButton.addActionListener(this);
            navButton.setPreferredSize(new Dimension(100, 75));
            panel2.add(navButton);
        }

        // for (int i = 2; i < 4; i++){
        //     ImageIcon navIcon = new ImageIcon("src/assets/" + navigation[i]);
        //     JButton navButton = new JButton(navIcon);
        //     navButton.setText(buttonLabel[i]);
        //     navButton.setFont(new Font("Times New Roman", Font.PLAIN, 1));
        //     navButton.setFocusable(false);
        //     navButton.addActionListener(this);
        //     navButton.setPreferredSize(new Dimension(100, 1));
        //     panel1.add(navButton);
        // }

        ImageIcon southBanner = new ImageIcon("src/assets/addbalancebanner.png");
        titlePanel = new JPanel(new FlowLayout());
        titleLabel = new JLabel(southBanner);
        titlePanel.setBackground(headerColor);
        titlePanel.add(titleLabel);

        contentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        balanceLabel = new JLabel();
        balanceLabel = new JLabel("Here's your current balance : Rp." + Database.user.get(index).getBalance());
        // balanceLabel.setText("Here's your balance : 0,-");
        balanceLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        textLabel = new JLabel("Amount : ");
        textLabel.setFont(contentFont);
        balanceField = new JTextField(15);
        balanceField.setFont(contentFont);
        balanceBtn = new JButton("Add");
        balanceBtn.setFont(contentFont);
        balanceBtn.setFocusable(false);
        balanceBtn.addActionListener(this);
        contentPanel.add(balanceLabel);
        contentPanel.setForeground(bgColor);

        JPanel balanceJPanel = new JPanel(new FlowLayout()); 
        balanceJPanel.add(balanceLabel); 
        contentPanel.add(balanceJPanel,BorderLayout.NORTH);
        balanceJPanel.setBackground(bgColor);

        balancePanel = new JPanel(new FlowLayout());
        balancePanel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        balancePanel.setBackground(bgColor);
        textLabel = new JLabel("Amount : ");
        textLabel.setFont(contentFont);
        balanceField = new JTextField(30);
        balanceField.setFont(contentFont);
        balanceBtn = new JButton("Add");
        balanceBtn.setFont(contentFont);
        balanceBtn.setFocusable(false);
        balanceBtn.addActionListener(this);
        balancePanel.add(textLabel);
        balancePanel.add(balanceField);
        balancePanel.add(balanceBtn);
        contentPanel.add(balancePanel, BorderLayout.CENTER);
        contentPanel.setBackground(bgColor);

        ImageIcon downbanner = new ImageIcon("src/assets/southbanner.png");
        southLabel = new JLabel(downbanner);
       
        // ImageIcon bgImage = new ImageIcon(getClass().getResource("topupbalancebg.png"));
        // JLabel bgLabel = new JLabel(bgImage);
        // contentPanel.add(bgLabel, BorderLayout.NORTH);
        // headerPanel.add(contentPanel, BorderLayout.CENTER);

        // frame.add(headerPanel, BorderLayout.CENTER);
        // frame.add(panel1, BorderLayout.EAST);
        frame.add(panel2, BorderLayout.WEST); 
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.CENTER);
        frame.add(southLabel, BorderLayout.SOUTH);
        frame.setVisible(true);

        profileFrame.setSize(500, 500);
        profileFrame.setLayout(new BorderLayout());
        panel1.setLayout(new GridLayout(1, 2));
        JTextArea profileArea = new JTextArea(
            "Here's your Profile Details\n" + 
            "Your Name              : " + datum.user.get(index).getFullName() + "\n" +
            "Your Email             : " + datum.user.get(index).getEmail() + "\n" +
            "Your Phone Number      : " + datum.user.get(index).getPhone() + "\n" +
            "Your Gender            : " + datum.user.get(index).getGender() + "\n" +
            "Your Current Balance   : " + datum.user.get(index).getBalance() + "\n"
        );
        panelTextArea.add(profileArea, BorderLayout.CENTER);
        panelTextArea.setForeground(Color.BLUE);
        profileArea.setEditable(false);
        profileArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        backButton.addActionListener(this);
        changePINButton.addActionListener(this);
        panel1.add(backButton);
        panel1.add(changePINButton);
        profileFrame.add(panelTextArea, BorderLayout.CENTER);
        profileFrame.add(panel1, BorderLayout.SOUTH);
        profileFrame.setLocationRelativeTo(null);
        profileFrame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        profileFrame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String amount = balanceField.getText();
        if(e.getSource() instanceof JButton btn){
            if (btn==balanceBtn){
                if (new Register().checkValidAmount(amount)){
                    String PIN = JOptionPane.showInputDialog(null, "Input Your PIN : ");
                    if (new Register().checkAddBalancePIN(PIN, amount, index)){
                        JOptionPane.showMessageDialog(null, "Added to your balance!");
                        balanceLabel.setText("Here's your current balance : Rp." + Database.user.get(index).getBalance().toString());
                        balanceField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong PIN!", "Invalid PIN", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please input correct amount", "Error Input", JOptionPane.ERROR_MESSAGE);
                }
            }else{ 
                if(btn.getText() == buttonLabel[0]){
                    new HomePageWindow(datum, index);
                    frame.dispose();
                    dispose();
                } else if (btn.getText() == buttonLabel[1]){
                    profileFrame.setVisible(true);
                } else if (btn.getText() == buttonLabel[2]){
                    frame.dispose();
                    new HistoryWindow(index);
                    dispose();
                } else if(btn.getText() == buttonLabel[3]){
                    new LoginWindow();
                    frame.dispose();
                    dispose();
                }
            } 
        }
    }
}