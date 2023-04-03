package Loginn;

import Regis.RegisterWindow;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow extends JFrame implements ActionListener{
    public static void main(String[] args) {
        new LoginWindow();
    }

    JFrame login;
    JPanel titlePanel;
    JLabel titleLabel;
    JLayeredPane compLayer;

    JTextField emailField;
    JPasswordField passwordField;
    JLabel emailLabel;
    JLabel passwordLabel;
    JButton loginBtn;
    JLabel haveAcc;
    JButton registerBtn;

    public LoginWindow() {
        // container
        login = new JFrame("Travelly!!");
        login.setSize(600, 370);
        login.getContentPane().setBackground(Color.WHITE);
        login.setDefaultCloseOperation(EXIT_ON_CLOSE);
        login.setLayout(null);
        login.setResizable(false);
        login.setLocationRelativeTo(null);

        // component
        titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, 600, 75);
        titlePanel.setBackground(Color.decode("#c9ffeb"));
        titlePanel.setLayout(null);

        titleLabel = new JLabel();
        titleLabel.setText("LOGIN BABY!");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        titleLabel.setBounds(190, 10, 1000, 50);

        compLayer = new JLayeredPane();
        compLayer.setBounds(18, 95, 550, 220);
        compLayer.setOpaque(true);
        compLayer.setBackground(Color.white);

        emailLabel = new JLabel("Email         :");
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        emailLabel.setBounds(18, 15, 1000, 50);
        passwordLabel = new JLabel("Password   :");
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        passwordLabel.setBounds(18, 60, 1000, 50);
        emailField = new JTextField();
        emailField.setBounds(130, 29, 400, 25);
        emailField.setText("Enter Your Email!");
        emailField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        passwordField = new JPasswordField();
        passwordField.setBounds(130, 74, 400, 25);
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        loginBtn = new JButton();
        loginBtn.setText("Login");
        loginBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
        loginBtn.setBounds(215, 130, 120, 40);
        loginBtn.setFocusable(false);

        haveAcc = new JLabel("Have an account?");
        haveAcc.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        haveAcc.setBounds(232, 160, 250, 40);
        registerBtn = new JButton();
        registerBtn.setText("Register");
        registerBtn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        registerBtn.setBounds(215, 180, 120, 23);
        registerBtn.setContentAreaFilled(false);
        registerBtn.setFocusable(false);
        registerBtn.setBorderPainted(false);
        registerBtn.addActionListener(this);

        titlePanel.add(titleLabel);
        compLayer.add(emailLabel);
        compLayer.add(passwordLabel);
        compLayer.add(emailField);
        compLayer.add(passwordField);
        compLayer.add(loginBtn);
        compLayer.add(haveAcc);
        compLayer.add(registerBtn);
        login.add(titlePanel);
        login.add(compLayer);
        login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerBtn){
            login.dispose();
            new Regis.RegisterWindow();
        }
    }
}
