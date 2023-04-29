import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PassengerSubmitWindow extends JFrame implements ActionListener{
    JPanel headerPanel, fieldPanel, genderPanel, mainPanel, footerPanel;
    JLabel nameLabel, ageLabel, passportNumLabel,
            NINLabel, passengerNumLabel, genderLabel;
    JTextField nameField, ageField, passportNumField,
            NINField;
    ButtonGroup genderBtn;
    JRadioButton maleBtn, femaleBtn;
    JButton submitBtn;
    Font labelFont = new Font("Times New Roman", Font.PLAIN, 20);
    Font fieldFont = new Font("Times New Roman", Font.PLAIN, 18);
    int currNumOfPass, numOfPass;
    String plane;
    int index;
    String name; 
    Integer age;
    String passportNum;
    String NIN;
    String gender; 
    int index_input;
   
    

    public PassengerSubmitWindow(int curr, int num, int idx, int idx_input){
       
        //passingan dari class lain
        currNumOfPass = curr;
        numOfPass = num;
        index = idx;
        index_input = idx_input; 
        
        Color bgColor = new Color(70, 188, 224);
        setTitle("TRAVELLY");
        setBackground(bgColor);

        //header
        headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        passengerNumLabel = new JLabel("PASSENGER "+(currNumOfPass+1));
        passengerNumLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        headerPanel.add(passengerNumLabel);

        //fieldPanel and its component
        fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(5, 2, 3, 3));
        fieldPanel.setBackground(new Color(200,200,200));
        fieldPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));


        //textfield
        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(30);
        ageLabel = new JLabel("Age: ");
        ageField = new JTextField(3);
        passportNumLabel = new JLabel("Passport Number: ");
        passportNumField = new JTextField(20);
        NINLabel = new JLabel("National Identity Number: ");
        NINField = new JTextField(16);
        genderPanel = new JPanel();
        genderPanel.setLayout(new GridLayout(1, 2));
        genderLabel = new JLabel("Gender: ");
        genderBtn = new ButtonGroup();
        maleBtn = new JRadioButton("Male");
        femaleBtn = new JRadioButton("Female");
        genderBtn.add(maleBtn);
        genderBtn.add(femaleBtn);
        genderPanel.add(maleBtn);
        genderPanel.add(femaleBtn);

        //add to fieldpanel
        fieldPanel.add(nameLabel);
        fieldPanel.add(nameField);
        fieldPanel.add(ageLabel);
        fieldPanel.add(ageField);
        fieldPanel.add(passportNumLabel);
        fieldPanel.add(passportNumField);
        fieldPanel.add(NINLabel);
        fieldPanel.add(NINField);
        fieldPanel.add(genderLabel);
        fieldPanel.add(genderPanel);

        //footerPanel
        footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout());
        submitBtn = new JButton("SUBMIT");
        footerPanel.add(submitBtn);
        submitBtn.addActionListener(this);

        //mainPanel
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(headerPanel);
        mainPanel.add(fieldPanel);
        mainPanel.add(footerPanel);
        

        setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        pack();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(submitBtn)) {
            Integer check = 1;
            try {
                name = nameField.getText();
                if (name.length() == 0) throw new IllegalArgumentException();
                check *= 1;
            }catch (Exception exc){
                JOptionPane.showMessageDialog(null, "Name can't be empty!", "Name", JOptionPane.ERROR_MESSAGE);
                check *= 0;
            }
            try {
                age = Integer.parseInt(ageField.getText());
                if (age <= 0) throw new IllegalArgumentException();
                check *= 1;
            }catch (Exception exc){
                JOptionPane.showMessageDialog(null, "Age must be greater than 0", "Age", JOptionPane.ERROR_MESSAGE);
                check *= 0;
            }
            try {
                passportNum = passportNumField.getText();
                if (passportNum.length() == 0 || Long.parseLong(passportNum) < 0) throw new IllegalArgumentException();
                check *= 1;
            }catch (Exception exc){
                JOptionPane.showMessageDialog(null, "Passport Number must be filled!", "Passport Number", JOptionPane.ERROR_MESSAGE);
                check *= 0;
            }
            try {
                NIN = NINField.getText();
                if (NIN.length() != 16 || Long.parseLong(NIN) < 0) throw new IllegalArgumentException();
                check *= 1;
            }catch (Exception exc){
                JOptionPane.showMessageDialog(null, "NIN must be a number and 16 characters length!", "NIN", JOptionPane.ERROR_MESSAGE);
                check *= 0;
            }
            if (maleBtn.isSelected()) {
                gender = "Male";
            } else if (femaleBtn.isSelected()) {
                gender = "Female";
            }else {
                gender = "";
                JOptionPane.showMessageDialog(null, "Please select yout gender!", "Gender", JOptionPane.ERROR_MESSAGE);
            }

            if (check == 1){
                //masukkin data bookingan ke data dummy
                new History().insert_history_booking(index, index_input, new Passanger(plane, name, check, passportNum, NIN, gender)); 
                currNumOfPass+=1;
                passengerNumLabel.setText("PASSENGER "+(currNumOfPass+1));
                System.out.println(gender);  

                nameField.setText("");
                ageField.setText("");
                passportNumField.setText("");
                NINField.setText("");
                genderBtn.clearSelection();

                if (currNumOfPass == numOfPass){
                    dispose();
                }
            }else{
                System.out.println("Data Salah!");
            }
        }
    }
}
