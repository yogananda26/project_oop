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
    JPanel panel2 = new JPanel(new GridLayout(4,1)); 

    JPanel balancePanel;
    JTextField balanceField;
    JLabel balanceLabel;
    JLabel textLabel;
    JButton balanceBtn;
    JPanel buttonPanel;
    Database datum; 
    int index;

    
  
    private String navigation[] = {
        "Home", "Date", "Profile", "Balance"
    };
    public TopUpWindow(Database data, int idx) {
        datum = data;
        index = idx;
        Color bgColor = new Color(70, 188, 224);
        frame = new JFrame("Travelly");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(bgColor);

        ImageIcon titleImg = new ImageIcon();
        titlePanel = new JPanel();
        titleLabel = new JLabel(titleImg);
        titlePanel.add(titleLabel, BorderLayout.NORTH);

        titPanel = new JPanel(new FlowLayout());

        headerPanel = new JPanel(new BorderLayout());
        headerLabel = new JLabel("Add Balance");
        headerLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        titPanel.add(headerLabel);
        titPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        headerPanel.add(titPanel, BorderLayout.NORTH);

        contentPanel = new JPanel(new BorderLayout());
        balanceLabel = new JLabel("Here's your current balance : Rp." + Database.user.get(index).getBalance());
        balanceLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
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

        // help ini taro dipaling bwh
        // ImageIcon bgImage = new ImageIcon(getClass().getResource("topupbalancebg.png"));
        // JLabel bgLabel = new JLabel(bgImage);
        // contentPanel.add(bgLabel, BorderLayout.NORTH);
        headerPanel.add(contentPanel, BorderLayout.CENTER);

        for(String i : navigation){
            JButton button1 = new JButton(); 
            button1.setText(i);
            button1.setBackground(Color.WHITE);
            button1.setFocusable(false);
            button1.addActionListener(this);
            panel2.add(button1); 
        }

        frame.add(headerPanel, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.WEST); 
        frame.add(titlePanel, BorderLayout.NORTH);
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
                        balanceLabel.setText("Here's your current balance : Rp." + Database.user.get(index).getBalance());
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