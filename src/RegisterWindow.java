import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RegisterWindow extends JFrame implements ActionListener, MouseListener, Border{


    JFrame register;
    JPanel titlePanel;
    JLabel titleLabel, fullNameLabel, emailLabel, passwordLabel, confirmLabel, phoneLabel, usernameLabel, genderLabel,
            PINLabel, haveAcc, signFullName, signEmail, signPassword, signPhone, signPIN, signUsername;
    JLayeredPane compLayer;
    JTextField nameField, emailField, phoneField, usernameField;
    JPasswordField passwordField, confirmField, PINField;
    JRadioButton maleBtn, femaleBtn;
    JButton loginBtn, submitBtn;

    Font labelFont = new Font("Open Sans", Font.PLAIN, 20);
    Font fieldFont = new Font("Open Sans", Font.PLAIN, 18);

    public RegisterWindow() {
        // container
        Color bgColor = new Color(105, 105, 105);
        register = new JFrame("Travelly!!");
        register.setSize(600, 630);
        register.getContentPane().setBackground(bgColor);
        register.setDefaultCloseOperation(EXIT_ON_CLOSE);
        register.setLayout(null);
        register.setResizable(false);
        register.setLocationRelativeTo(null);

        // component
        titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, 600, 75);
        titlePanel.setBackground(bgColor);
        titlePanel.setLayout(null);

        titleLabel = new JLabel();
        titleLabel.setText("REGISTER YOURSELF!");
        titleLabel.setFont(new Font("Open Sans", Font.BOLD, 30));
        titleLabel.setBounds(140, 10, 1000, 50);

        compLayer = new JLayeredPane();
        compLayer.setBounds(18, 95, 550, 470);
        compLayer.setOpaque(true);
        compLayer.setBackground(Color.white);

        fullNameLabel = new JLabel("Full Name : ");
        fullNameLabel.setFont(labelFont);
        fullNameLabel.setBounds(18, 15, 1000, 50);
        emailLabel = new JLabel("Email         : ");
        emailLabel.setFont(labelFont);
        emailLabel.setBounds(18, 60, 1000, 50);
        passwordLabel = new JLabel("Password   : ");
        passwordLabel.setFont(labelFont);
        passwordLabel.setBounds(18, 105, 1000, 50);
        confirmLabel = new JLabel("Confirm     : ");
        confirmLabel.setFont(labelFont);
        confirmLabel.setBounds(18, 150, 1000, 50);
        phoneLabel = new JLabel("Phone        : ");
        phoneLabel.setFont(labelFont);
        phoneLabel.setBounds(18, 195, 1000, 50);
        usernameLabel = new JLabel("Username  : ");
        usernameLabel.setFont(labelFont);
        usernameLabel.setBounds(18, 240, 1000, 50);
        PINLabel = new JLabel("PIN            : ");
        PINLabel.setFont(labelFont);
        PINLabel.setBounds(18, 320, 1000, 50);

        nameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmField = new JPasswordField();
        usernameField = new JTextField();
        PINField = new JPasswordField();
        phoneField = new JTextField();
        nameField.setBounds(140, 30, 400, 25);
        nameField.setFont(fieldFont);
        nameField.addMouseListener(this);
        emailField.setBounds(140, 75, 400, 25);
        emailField.setFont(fieldFont);
        emailField.addMouseListener(this);
        passwordField.setBounds(140, 119, 400, 25);
        passwordField.setFont(fieldFont);
        passwordField.addMouseListener(this);
        confirmField.setBounds(140, 164, 400, 25);
        confirmField.setFont(fieldFont);
        phoneField.setBounds(140, 210, 400, 25);
        phoneField.setFont(fieldFont);
        phoneField.addMouseListener(this);
        usernameField.setBounds(140, 255, 400, 25);
        usernameField.setFont(fieldFont);
        usernameField.addMouseListener(this);
        PINField.setBounds(140, 335, 180, 25);
        PINField.setFont(fieldFont);
        PINField.addMouseListener(this);

        maleBtn = new JRadioButton();
        femaleBtn = new JRadioButton();
        maleBtn.setText("Male");
        femaleBtn.setText("Female");
        maleBtn.setFont(fieldFont);
        femaleBtn.setFont(fieldFont);
        maleBtn.setBounds(140, 290, 100, 30);
        femaleBtn.setBounds(240, 290, 100, 30);
        maleBtn.setFocusable(false);
        femaleBtn.setFocusable(false);
        maleBtn.setContentAreaFilled(false);
        femaleBtn.setContentAreaFilled(false);
        ButtonGroup group = new ButtonGroup();
        group.add(femaleBtn);
        group.add(maleBtn);
        genderLabel = new JLabel("Gender      : ");
        genderLabel.setFont(labelFont);
        genderLabel.setBounds(18, 278, 1000, 50);

        ImageIcon submitIcon = new ImageIcon(getClass().getResource("registerbutton.png"));
        submitBtn = new JButton(submitIcon);
        submitBtn.setBounds(200, 380, 180, 49);
        submitBtn.setContentAreaFilled(false);
        submitBtn.setFocusable(false);
        submitBtn.setBorderPainted(false);
        submitBtn.addActionListener(this);

        haveAcc = new JLabel("Have an account?");
        haveAcc.setFont(new Font("Open Sans", Font.PLAIN, 12));
        haveAcc.setBounds(243, 420, 250, 40);
        loginBtn = new JButton();
        loginBtn.setText("Login");
        loginBtn.setFont(new Font("Open Sans", Font.PLAIN, 12));
        loginBtn.setBounds(255, 440, 70, 23);
        loginBtn.setContentAreaFilled(false);
        loginBtn.setFocusable(false);
        loginBtn.setBorderPainted(false);
        loginBtn.addActionListener(this);

        Font signFont = new Font("Open Sans", Font.PLAIN, 10);
        signFullName = new JLabel("Alphabetic only!");
        signFullName.setFont(signFont);
        signFullName.setForeground(Color.RED);
        signFullName.setBounds(140, 10, 150, 25);
        signFullName.setVisible(false);
        compLayer.add(signFullName);
        signEmail = new JLabel("youremail@gmail.com");
        signEmail.setFont(signFont);
        signEmail.setForeground(Color.RED);
        signEmail.setBounds(140, 55, 150, 25);
        signEmail.setVisible(false);
        compLayer.add(signEmail);
        signPassword = new JLabel("Min 8 characters");
        signPassword.setFont(signFont);
        signPassword.setForeground(Color.RED);
        signPassword.setBounds(140, 100, 150, 25);
        signPassword.setVisible(false);
        compLayer.add(signPassword);
        signPhone = new JLabel("Must between 11 - 13 digits (digit only)");
        signPhone.setFont(signFont);
        signPhone.setForeground(Color.RED);
        signPhone.setBounds(140, 190, 150, 25);
        signPhone.setVisible(false);
        compLayer.add(signPhone);
        signPIN = new JLabel("Must 6 digits (digit only)");
        signPIN.setFont(signFont);
        signPIN.setForeground(Color.RED);
        signPIN.setBounds(140, 315, 150, 25);
        signPIN.setVisible(false);
        compLayer.add(signPIN);
        signUsername = new JLabel("Must be unique!");
        signUsername.setFont(signFont);
        signUsername.setForeground(Color.RED);
        signUsername.setBounds(140, 235, 150, 25);
        signUsername.setVisible(false);
        compLayer.add(signUsername);

        titlePanel.add(titleLabel);
        compLayer.add(fullNameLabel);
        compLayer.add(phoneField);
        compLayer.add(phoneLabel);
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
        compLayer.add(PINLabel);
        compLayer.add(PINField);
        register.add(titlePanel);
        register.add(compLayer);
        register.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            register.dispose();
            new LoginWindow();
        } else if (e.getSource() == submitBtn) {
            String fullName = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirm = new String(confirmField.getPassword());
            String username = usernameField.getText();
            String gender = null;
            String PIN = new String(PINField.getPassword());
            String phone = phoneField.getText();

            boolean name, ema, pass, conf, user, gen, pin, pho = false;

            if (maleBtn.isSelected()) {
                gender = "Male";
            } else if (femaleBtn.isSelected()) {
                gender = "Female";
            }

            if (fullName != null && email != null && password != null && username != null && gender != null
                    && PIN != null) {
                if (!new Register().checkValidFullName(fullName)) {
                    JOptionPane.showMessageDialog(null, "Please input correct Full Name!", "Full Name",
                            JOptionPane.ERROR_MESSAGE);
                    fullName = null;
                    name = false;
                } else {
                    name = true;
                }
                if (!new Register().checkValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "Please input correct email!", "Email",
                            JOptionPane.ERROR_MESSAGE);
                    email = null;
                    ema = false;
                } else {
                    ema = true;
                }
                if (!new Register().checkValidPassword(password)) {
                    JOptionPane.showMessageDialog(null, "Please input correct Password!", "Password",
                            JOptionPane.ERROR_MESSAGE);
                    password = null;
                    pass = false;
                } else {
                    pass = true;
                }
                if (!new Register().checkValidConfirm(password, confirm)) {
                    JOptionPane.showMessageDialog(null, "Make sure your Confirm Password is same", "Confirm",
                            JOptionPane.ERROR_MESSAGE);
                    confirm = null;
                    conf = false;
                } else {
                    conf = true;
                }
                if (!new Register().checkValidPhone(phone)){
                    JOptionPane.showMessageDialog(null, "Phone Number is must 11-13 digits and digit only!", "Phone",
                            JOptionPane.ERROR_MESSAGE);
                    phone = null;
                    pho = false;
                } else {
                    pho = true;
                }
                if (!new Register().checkValidUsername(username)) {
                    JOptionPane.showMessageDialog(null, "Username is already taken!", "Username",
                            JOptionPane.ERROR_MESSAGE);
                    username = null;
                    user = false;
                } else {
                    user = true;
                }
                if (gender == null) {
                    JOptionPane.showMessageDialog(null, "Please choose your gender!", "Gender",
                            JOptionPane.ERROR_MESSAGE);
                    gender = null;
                    gen = false;
                } else {
                    gen = true;
                }
                if (!new Register().checkValidPIN(PIN)) {
                    JOptionPane.showMessageDialog(null, "PIN must 6 digits [digits only]", "PIN",
                            JOptionPane.ERROR_MESSAGE);
                    PIN = null;
                    pin = false;
                } else {
                    pin = true;
                }

                if (name && user && gen && pass && conf && ema && pin && pho) {
                    new Register().addUser(fullName, email, password, username, gender, PIN, phone);
                    nameField.setText(null);
                    passwordField.setText(null);
                    confirmField.setText(null);
                    PINField.setText(null);
                    emailField.setText(null);
                    usernameField.setText(null);
                    SwingUtilities.updateComponentTreeUI(register);
                    int choose = JOptionPane.showConfirmDialog(null, "Successfully Registered!\nGo to login page!");
                    if (choose == 0) {
                        register.dispose();
                        new LoginWindow();
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please fill the blank field!", "Register Warning",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==nameField){
            signFullName.setVisible(true);
        } else if (e.getSource()==emailField){
            signEmail.setVisible(true);
        } else if (e.getSource()==passwordField){
            signPassword.setVisible(true);
        } else if (e.getSource()==phoneField){
            signPhone.setVisible(true);
        } else if (e.getSource()==PINField){
            signPIN.setVisible(true);
        } else if (e.getSource()==usernameField){
            signUsername.setVisible(true);
        }
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==nameField){
            signFullName.setVisible(false);
        } else if (e.getSource()==emailField){
            signEmail.setVisible(false);
        } else if (e.getSource()==passwordField){
            signPassword.setVisible(false);
        } else if (e.getSource()==phoneField){
            signPhone.setVisible(false);
        } else if (e.getSource()==PINField){
            signPIN.setVisible(false);
        } else if (e.getSource()==usernameField){
            signUsername.setVisible(false);
        }
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'paintBorder'");
    }

    @Override
    public Insets getBorderInsets(Component c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBorderInsets'");
    }

    @Override
    public boolean isBorderOpaque() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isBorderOpaque'");
    }
}
