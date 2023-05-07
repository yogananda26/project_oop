import com.toedter.calendar.JCalendar;
import java.lang.Package;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HomePageWindow extends JFrame implements ActionListener, MouseListener{
    
    private JFrame profileFrame = new JFrame("Profile Detail");
    private JButton button = new JButton(); 
    private JLabel label = new JLabel();
    private JLabel label2 = new JLabel();
    private JLabel southLabel;
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel(); 
    private JPanel panel3 = new JPanel(); 
    private JPanel panel4 = new JPanel();
    private JPanel panelTextArea = new JPanel();

    private JFrame dateFrame = new JFrame("Choose your day");
    private JButton nextBtn = new JButton("Next");
    private JCalendar calendar = new JCalendar();

    private JButton backButton = new JButton("Back"); 
    private JButton changePINButton = new JButton("Change PIN");

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Options");
    private JMenuItem viewBalanceMenuItem = new JMenuItem("View Balance");
    private JMenuItem logoutMenuItem = new JMenuItem("Log Out");
    private JMenuItem exitMenuItem = new JMenuItem("Exit");

    JButton[] buttonmenu = new JButton[3];
    private Database datum;
    private int index; 
    private int mark = -1;

    // int idx = new Register().getUseridx();
    // Database temp = new Register().getData();

    private String[] image = new String[]{
        "trainlogo.jpeg", "topuplogo1.jpeg", "airplanelogo.jpeg"
    };

    private String[] hoverimg = new String[]{
        "train", "topup", "airplane"
    };

    private String buttonlabel[] = {
        "profileiconhome.png", "balanceiconhome.png", "historyiconhome.png","logouticonhome.png"
    };
    private String buttonText[] = {
        "Profile", "Balance", "History", "Log Out"
    };

    public static void main(String[] args) {
        new HomePageWindow(new Database(),0); 
    }

    HomePageWindow(Database data, int idx){ 

        Color backgroundColor = new Color(223, 246, 255);
        Color headerColor = new Color(6, 40, 61);

        datum = data;
        index = idx;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(4,1));
        panel2.setLayout(new FlowLayout(1, 10, 10));
        panel3.setLayout(new GridLayout(1,3));

        menuBar.add(menu);
        menu.add(viewBalanceMenuItem);
        menu.addSeparator();
        menu.add(logoutMenuItem);
        menu.addSeparator();
        menu.add(exitMenuItem);
        viewBalanceMenuItem.addActionListener(this);
        logoutMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
        setJMenuBar(menuBar);

        for (int i = 0; i < 4; i++){
            JButton button_new = new JButton(new ImageIcon("src/assets/" + buttonlabel[i])); 
            button_new.setPreferredSize(new Dimension(80, 130));
            button_new.setText(buttonText[i]);
            button_new.setFont(new Font("Times New Roman", Font.PLAIN, 1));
            button_new.setFocusable(false);
            button_new.addActionListener(this);
            panel.add(button_new);
        }

        for (int i = 0; i < 3; i++){
            buttonmenu[i] = new JButton(new ImageIcon("src/assets/" + image[i]));
            buttonmenu[i].setPreferredSize(new Dimension(400, 500));;
            buttonmenu[i].setFocusable(false);
            buttonmenu[i].addActionListener(this);
            buttonmenu[i].addMouseListener(this);
            buttonmenu[i].addMouseListener(this);
            panel2.add(buttonmenu[i]);
        }

        ImageIcon northBanner = new ImageIcon("src/assets/northhomebanner.png");

        panel3.setLayout(new BorderLayout());
        panel3.setPreferredSize(new Dimension(100, 130));
        // label2.setText("Welcome, " + datum.user.get(index).getUsername() + " ");
        // label.setText("Enjoy your holiday!!!");
        label = new JLabel(northBanner);
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label2.setForeground(Color.WHITE);
        label.setForeground(Color.WHITE);
        panel3.add(label2, BorderLayout.NORTH);
        panel3.add(label, BorderLayout.CENTER);
        panel3.setBackground(headerColor);

        ImageIcon downbanner = new ImageIcon("src/assets/southbanner.png");
        southLabel = new JLabel(downbanner);
        panel4.setPreferredSize(new Dimension(100, 145));
        panel4.add(southLabel);
        panel4.setBackground(backgroundColor);

        button.setSize(1920, 1080);
        panel2.setBackground(backgroundColor);
        this.add(panel2, BorderLayout.CENTER);
        // this.add(panel3,BorderLayout.EAST);
        this.add(panel3, BorderLayout.NORTH);
        this.add(panel, BorderLayout.WEST); 
        this.add(panel4, BorderLayout.SOUTH);
        this.setVisible(true);

        nextBtn.setFocusable(false);
        nextBtn.addActionListener(this);
        dateFrame.setSize(400, 400);
        dateFrame.setLayout(new BorderLayout());
        dateFrame.add(calendar, BorderLayout.CENTER);
        dateFrame.add(nextBtn, BorderLayout.SOUTH);
        dateFrame.setLocationRelativeTo(null);
        dateFrame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        dateFrame.setResizable(false);    

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
        
        if(e.getSource() == nextBtn){
            String date = String.format("%tF", calendar.getDate());
            System.out.println(date);
            switch (mark) {
                case 0:
                    new TrainPageWindow(index, date);
                    break;
                case 1 : 
                    new PlanePageWindow(datum, index, date);
                default:
                    break;
            }
            dateFrame.dispose();   
        }
        
        if (e.getSource()==viewBalanceMenuItem){
            new TopUpWindow(datum, index);
        } else if (e.getSource()==logoutMenuItem){
            new LoginWindow();
        } else if (e.getSource()==exitMenuItem){
            dispose();
        }
        
        if(e.getSource() instanceof JButton btn){
            if(btn.equals(buttonmenu[0])){ 
                dateFrame.setVisible(true);
                mark = 0;
            }
            else if(btn.equals(buttonmenu[1])){
                new TopUpWindow(new Database(), index); 
            }
            else if(btn.equals(buttonmenu[2])){ 
                dateFrame.setVisible(true);
                mark = 1;
            }
            else{ 
                String get_text = btn.getText(); 
                if(get_text.equals("Profile")){
                    profileFrame.setVisible(true);
                } else if(get_text.equals("Balance")){
                    new TopUpWindow(datum, index);
                } else if(get_text.equals("History")){
                    new HistoryWindow(index);
                } else if(get_text.equals("Log Out")){
                    dispose();
                    new LoginWindow();
                }
            } 
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==buttonmenu[2]){
            
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
       
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        for (int i = 0; i < 3; i++){
            if (e.getSource()==buttonmenu[i]){
                buttonmenu[i].setIcon(new ImageIcon("src/assets/"+hoverimg[i]+"enter.png"));
            }
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < 3; i++){
            if (e.getSource() == buttonmenu[i]){
                buttonmenu[i].setIcon(new ImageIcon("src/assets/" + image[i]));
            }
        }
    }
}