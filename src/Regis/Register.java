package Regis;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.toedter.calendar.JDayChooser;

public class Register extends JFrame {
    public static void main(String[] args) {
        new Register();
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

    JButton submitBtn;

    public Register() {
        // container
        register = new JFrame("Travelly!!");
        register.setSize(600, 700);
        register.getContentPane().setBackground(Color.WHITE);
        register.setDefaultCloseOperation(EXIT_ON_CLOSE);
        register.setLayout(null);
        register.setResizable(false);
        register.setLocationRelativeTo(null);

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
        compLayer.setBounds(18, 95, 550, 550);
        compLayer.setBackground(Color.ORANGE);
        compLayer.setOpaque(true);

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
        nameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmField = new JPasswordField();
        usernameField = new JTextField();
        nameField.setBounds(140, 30, 400, 25);
        nameField.setText("Enter Your Full Name!");
        nameField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        emailField.setBounds(140, 75, 400, 25);
        emailField.setText("Enter Your Email!");
        emailField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        passwordField.setBounds(140, 119, 400, 25);
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        confirmField.setBounds(140, 164, 400, 25);
        confirmField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        usernameField.setBounds(140, 205, 400, 25);
        usernameField.setText("Enter Your Username!");
        usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 18));

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
        submitBtn.setText("Register");

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
        register.add(titlePanel);
        register.add(compLayer);
        register.setVisible(true);
    }
}
