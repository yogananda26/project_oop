package Regis;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegisterWindow extends JFrame implements ActionListener{
    public static void main(String[] args) {
        new RegisterWindow();
    }

    JFrame register;
    JPanel titlePanel;
    JLabel titleLabel;
    JLayeredPane compLayer;
    JLabel fullNameLabel;
    JTextField nameField;
    JLabel emailLabel;
    JTextField emailField;
    JLabel passwordLabel;
    JLabel confirmLabel;
    JPasswordField passwordField;
    JPasswordField confirmField;
    JLabel phoneLabel;
    JTextField phoneField;
    JLabel usernameLabel;
    JTextField usernameField;
    JRadioButton maleBtn;
    JRadioButton femaleBtn;
    JLabel genderLabel;
    JLabel haveAcc;
    JLabel PINLabel;
    JPasswordField PINField;
    JButton loginBtn;
    JButton submitBtn;

    public RegisterWindow() {
        // container
        register = new JFrame("Travelly!!");
        register.setSize(600, 580);
        register.getContentPane().setBackground(Color.WHITE);
        register.setDefaultCloseOperation(EXIT_ON_CLOSE);
        register.setLayout(null);
        register.setResizable(false);
        register.setLocationRelativeTo(null);

        ImageIcon registerIcon = new ImageIcon("registerbutton.png");

        // component
        titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, 600, 75);
        titlePanel.setBackground(Color.decode("#c9ffeb"));
        titlePanel.setLayout(null);

        titleLabel = new JLabel();
        titleLabel.setText("REGISTER BABY!");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        titleLabel.setBounds(165, 10, 1000, 50);

        compLayer = new JLayeredPane();
        compLayer.setBounds(18, 95, 550, 430);
        compLayer.setOpaque(true);
        compLayer.setBackground(Color.white);

        fullNameLabel = new JLabel("Full Name : ");
        fullNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        fullNameLabel.setBounds(18, 15, 1000, 50);
        emailLabel = new JLabel("Email         : ");
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        emailLabel.setBounds(18, 60, 1000, 50);
        passwordLabel = new JLabel("Password   : ");
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        passwordLabel.setBounds(18, 105, 1000, 50);
        confirmLabel = new JLabel("Confirm     : ");
        confirmLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        confirmLabel.setBounds(18, 150, 1000, 50);
        usernameLabel = new JLabel("Username  : ");
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        usernameLabel.setBounds(18, 195, 1000, 50);
        PINLabel = new JLabel("PIN      : ");
        PINLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        PINLabel.setBounds(18, 105, 1000, 50);
        nameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmField = new JPasswordField();
        usernameField = new JTextField();
        PINField = new JPasswordField();
        nameField.setBounds(140, 30, 400, 25);
        nameField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        emailField.setBounds(140, 75, 400, 25);
        emailField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        passwordField.setBounds(140, 119, 400, 25);
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        confirmField.setBounds(140, 164, 400, 25);
        confirmField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        usernameField.setBounds(140, 205, 400, 25);
        usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        PINField.setBounds(140, 250, 400, 25);
        PINField.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        maleBtn = new JRadioButton();
        femaleBtn = new JRadioButton();
        maleBtn.setText("Male");
        femaleBtn.setText("Female");
        maleBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        femaleBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        maleBtn.setBounds(140, 250, 100, 30);
        femaleBtn.setBounds(240, 250, 100, 30);
        maleBtn.setFocusable(false);
        femaleBtn.setFocusable(false);
        maleBtn.setContentAreaFilled(false);
        femaleBtn.setContentAreaFilled(false);
        ButtonGroup group = new ButtonGroup();
        group.add(femaleBtn);
        group.add(maleBtn);
        genderLabel = new JLabel("Gender      : ");
        genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        genderLabel.setBounds(18, 238, 1000, 50);

        submitBtn = new JButton();
        submitBtn.setText("REGISTER");
        submitBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
        submitBtn.setBounds(210, 295, 150, 40);
        submitBtn.setFocusable(false);
        submitBtn.addActionListener(this);

        haveAcc = new JLabel("Have an account?");
        haveAcc.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        haveAcc.setBounds(240, 322, 250, 40);
        loginBtn = new JButton();
        loginBtn.setText("Login");
        loginBtn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        loginBtn.setBounds(250, 346, 60, 23);
        loginBtn.setContentAreaFilled(false);
        loginBtn.setFocusable(false);
        loginBtn.setBorderPainted(false);
        loginBtn.addActionListener(this);

        titlePanel.add(titleLabel);
        compLayer.add(fullNameLabel);
        compLayer.add(emailLabel);
        compLayer.add(passwordLabel);
        compLayer.add(confirmLabel);
        compLayer.add(usernameLabel);
        compLayer.add(nameField);
        compLayer.add(emailField);
        compLayer.add(passwordField);
        compLayer.add(confirmField);
        compLayer.add(usernameField);
        compLayer.add(maleBtn);
        compLayer.add(femaleBtn);
        compLayer.add(genderLabel);
        compLayer.add(submitBtn);
        compLayer.add(haveAcc);
        compLayer.add(loginBtn);
        register.add(titlePanel);
        register.add(compLayer);
        register.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==loginBtn){
            register.dispose();
            new Loginn.LoginWindow();
        }

        if (e.getSource()==submitBtn){
            String fullName = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirm = new String(confirmField.getPassword());
            String username = usernameField.getText();
            String gender = null;

            boolean name = false;
            boolean ema = false;
            boolean pass = false;
            boolean conf = false;
            boolean user = false;
            boolean gen = false;

            if (maleBtn.isSelected()){
                gender = "Male";
            } else if (femaleBtn.isSelected()){
                gender = "Female";
            }

            if (fullName != null && email != null && password != null && username != null && gender != null){
                if (!new Register().checkValidFullName(fullName)){
                    JOptionPane errorFullName = new JOptionPane();
                    errorFullName.showMessageDialog(null, "Please input correct Full Name!", "Full Name", JOptionPane.ERROR_MESSAGE);
                    fullName = null;
                    name = false;
                } else {
                    name = true;
                }
                if (!new Register().checkValidEmail(email)){
                    JOptionPane errorEmail = new JOptionPane();
                    errorEmail.showMessageDialog(null, "Please input correct email!", "Email", JOptionPane.ERROR_MESSAGE);
                    email = null;
                    ema = false;
                } else {
                    ema = true;
                }
                if (!new Register().checkValidPassword(password)){
                    JOptionPane errorPassword = new JOptionPane();
                    errorPassword.showMessageDialog(null, "Please input correct Password!", "Password", JOptionPane.ERROR_MESSAGE);
                    password = null;
                    pass = false;
                } else {
                    pass = true;
                }
                if (!new Register().checkValidConfirm(password, confirm)){
                    JOptionPane errorConfirm = new JOptionPane();
                    errorConfirm.showMessageDialog(null, "Make sure your Confirm Password is same", "Confirm", JOptionPane.ERROR_MESSAGE);
                    confirm = null;
                    conf = false;
                } else {
                    conf = true;
                }
                // if (!new Register().checkValidUsername(username)){
                //     JOptionPane errorUsername = new JOptionPane();
                //     errorUsername.showMessageDialog(null, "Username is already taken!", "Username", JOptionPane.ERROR_MESSAGE);
                //     username = null;
                //     user = false;
                // } else {
                //     user = true;
                }
                if (gender == null){
                    JOptionPane errorGender = new JOptionPane();
                    errorGender.showMessageDialog(null, "Please choose your gender!", "Gender", JOptionPane.ERROR_MESSAGE);
                    gender = null;
                    gen = false;
                } else {
                    gen = true;
                }

                if (name && user && gen && pass && conf && ema){
                         
                }

            } else {
                JOptionPane errorMsg = new JOptionPane();
                errorMsg.showMessageDialog(null, "Please fill the blank field!", "Register Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

