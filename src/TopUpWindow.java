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

    JPanel balancePanel;
    JTextField balanceField;
    JLabel balanceLabel;
    JLabel textLabel;
    JButton balanceBtn;
    JPanel buttonPanel;

    public static void main(String[] args) {
        new TopUpWindow();
    }

    public TopUpWindow() {
        Color bgColor = new Color(70, 188, 224);
        frame = new JFrame("Travelly");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(bgColor);

        ImageIcon titleImg = new ImageIcon(getClass().getResource("TopUpJumbo.png"));
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
        balanceLabel = new JLabel("Here's your current balance : Rp.150.000");
        balanceLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        contentPanel.add(balanceLabel, BorderLayout.NORTH);

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
        headerPanel.add(contentPanel, BorderLayout.CENTER);

        frame.add(headerPanel, BorderLayout.CENTER);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String amount = balanceField.getText();
        if (e.getSource()==balanceBtn){
            if (new Register().checkValidAmount(amount)){
                JOptionPane showValidAmount = new JOptionPane();
                String PIN = showValidAmount.showInputDialog(null, "Input Your PIN : ");
                if (new Register().checkAddBalancePIN(PIN, amount)){
                    JOptionPane showCorrectPin = new JOptionPane();
                    showCorrectPin.showMessageDialog(null, "Added to your balance!");
                } else {
                    JOptionPane errorPIN = new JOptionPane();
                    errorPIN.showMessageDialog(null, "Wrong PIN!", "Invalid PIN", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane showError = new JOptionPane();
                showError.showMessageDialog(null, "Please input correct amount", "Error Input", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}