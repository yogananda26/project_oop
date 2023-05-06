import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopUpWindow extends JFrame implements ActionListener{
    
    Font contentFont = new Font("Comic Sans MS", Font.PLAIN, 30);
    JFrame frame;
    JPanel titlePanel;
    JLabel titleLabel;
    JPanel headerPanel;
    JLabel headerLabel;
    JPanel titPanel;
    JPanel contentPanel;
    JPanel panel1 = new JPanel(new GridLayout(6, 1));
    JPanel panel2 = new JPanel(new GridLayout(6,1)); 

    JPanel balancePanel;
    JTextField balanceField;
    JLabel balanceLabel;
    JLabel textLabel;
    JButton balanceBtn;
    JPanel buttonPanel;
    Database datum; 
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
        frame = new JFrame("Travelly");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(bgColor);

        JLabel emptyLabel = new JLabel(" ");
        // panel1.add(emptyLabel);
        // panel1.add(emptyLabel);
        // panel1.add(emptyLabel);
        // panel2.add(emptyLabel);
        // panel2.add(emptyLabel);
        // panel2.add(emptyLabel);

        for (int i = 0; i < 2; i++){
            ImageIcon navIcon = new ImageIcon("src/assets/" + navigation[i]);
            JButton navButton = new JButton(navIcon);
            navButton.setText(buttonLabel[i]);
            navButton.setFont(new Font("Times New Roman", Font.PLAIN, 1));
            navButton.setFocusable(false);
            navButton.addActionListener(this);
            navButton.setPreferredSize(new Dimension(100, 1));
            panel2.add(navButton);
        }

        for (int i = 2; i < 4; i++){
            ImageIcon navIcon = new ImageIcon("src/assets/" + navigation[i]);
            JButton navButton = new JButton(navIcon);
            navButton.setText(buttonLabel[i]);
            navButton.setFont(new Font("Times New Roman", Font.PLAIN, 1));
            navButton.setFocusable(false);
            navButton.addActionListener(this);
            navButton.setPreferredSize(new Dimension(100, 1));
            panel1.add(navButton);
        }

        ImageIcon titleImg = new ImageIcon();
        titlePanel = new JPanel(new FlowLayout());
        titleLabel = new JLabel("ADD BALANCE");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
        titlePanel.add(titleLabel);

        contentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        balanceLabel = new JLabel();
        // balanceLabel = new JLabel("Here's your current balance : Rp." + Database.user.get(index).getBalance());
        balanceLabel.setText("DISINI BALANCENYA");
        balanceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        textLabel = new JLabel("Amount : ");
        textLabel.setFont(contentFont);
        balanceField = new JTextField(15);
        balanceField.setFont(contentFont);
        balanceBtn = new JButton("Add");
        balanceBtn.setFont(contentFont);
        balanceBtn.setFocusable(false);
        balanceBtn.addActionListener(this);
        contentPanel.add(balanceLabel);

        // this is panel for label 
        JPanel balanceJPanel = new JPanel(new FlowLayout()); 
        balanceJPanel.add(balanceLabel); 
        contentPanel.add(balanceJPanel,BorderLayout.NORTH);

        balancePanel = new JPanel(new FlowLayout());
        balancePanel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        textLabel = new JLabel("Amount : ");
        textLabel.setFont(contentFont);
        balanceField = new JTextField(15);
        balanceField.setFont(contentFont);
        balanceBtn = new JButton("Add");
        balanceBtn.setFont(contentFont);
        balanceBtn.setFocusable(false);
        balanceBtn.addActionListener(this);
        balancePanel.add(textLabel);
        balancePanel.add(balanceField);
        balancePanel.add(balanceBtn);
        contentPanel.add(balancePanel, BorderLayout.CENTER);

       
        // ImageIcon bgImage = new ImageIcon(getClass().getResource("topupbalancebg.png"));
        // JLabel bgLabel = new JLabel(bgImage);
        // contentPanel.add(bgLabel, BorderLayout.NORTH);
        // headerPanel.add(contentPanel, BorderLayout.CENTER);

        // frame.add(headerPanel, BorderLayout.CENTER);
        frame.add(panel1, BorderLayout.EAST);
        frame.add(panel2, BorderLayout.WEST); 
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.CENTER);
        frame.setVisible(true);

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
                if(btn.getText() == navigation[0]){
                    new HomePageWindow(datum, index);
                }
                else if(btn.getText() == navigation[3]){
                    new TopUpWindow(datum, index); 
                }
            }
            dispose(); 
        }
    }
}