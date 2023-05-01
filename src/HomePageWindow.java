import com.toedter.calendar.JCalendar;
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

public class HomePageWindow extends JFrame implements ActionListener, MouseListener{
    public static void main(String[] args) {
        new HomePageWindow(new Database(),0); 
    }
    private JFrame frame = new JFrame();
    private JButton button = new JButton(); 
    private JLabel label = new JLabel();
    private JLabel label2 = new JLabel();
    private JLabel southLabel;
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel(); 
    private JPanel panel3 = new JPanel(); 
    private JPanel panel4 = new JPanel();

    private JFrame dateFrame = new JFrame("Choose your day");
    private JButton nextBtn = new JButton("Next");
    private JCalendar calendar = new JCalendar();

    private JButton button_plane; 
    private JButton button_train;
    private JButton top_up;

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Options");
    private JMenuItem viewBalanceMenuItem = new JMenuItem("View Balance");
    private JMenuItem logoutMenuItem = new JMenuItem("Log Out");
    private JMenuItem exitMenuItem = new JMenuItem("Exit");

    Color bgColor = new Color(105, 105, 105);

    JButton[] buttonmenu = new JButton[3];
    private Database datum;
    private int index; 

    // int idx = new Register().getUseridx();
    // Database temp = new Register().getData();

    private String[] image = new String[]{
        "trainlogo.jpeg", "topuplogo1.jpeg", "airplanelogo.jpeg"
    };

    private String[] hoverimg = new String[]{
        "train", "topup", "airplane"
    };

    private String name_label[] = {
        "Date", "Profile", "Balance","Log out"
    };

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

        // this is for the button 
        for(String i : name_label){
            JButton button_new = new JButton(); 
            button_new.setText(i);
            button_new.setBackground(Color.WHITE);
            button_new.setFocusable(false);
            button_new.addActionListener(this);
            panel.add(button_new);
        }

        for (int i = 0; i < 3; i++){
            buttonmenu[i] = new JButton(new ImageIcon("bin/" + image[i]));
            buttonmenu[i].setPreferredSize(new Dimension(400, 500));;
            buttonmenu[i].setFocusable(false);
            buttonmenu[i].addActionListener(this);
            buttonmenu[i].addMouseListener(this);
            buttonmenu[i].addMouseListener(this);
            panel2.add(buttonmenu[i]);
        }
        panel2.setBackground(bgColor);

        panel3.setLayout(new BorderLayout());
        panel3.setPreferredSize(new Dimension(100, 130));
        label2.setText("Welcome, " + datum.user.get(index).getUsername() + " ");
        label.setText("Enjoy your holiday!!!");
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        label2.setForeground(Color.WHITE);
        label.setForeground(Color.WHITE);
        panel3.add(label2, BorderLayout.NORTH);
        panel3.add(label, BorderLayout.CENTER);
        panel3.setBackground(headerColor);

        // panel3.setLayout(new GridLayout(2, 1));
        // panel3.setPreferredSize(new Dimension(100, 130));
        // label2.setText("Welcome, " + datum.user.get(index).getUsername() + " ");
        // label.setText("Enjoy your holiday!!!");
        // label2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        // label.setFont(new Font("Times New Roman", Font.PLAIN, 60));
        // label2.setForeground(Color.WHITE);
        // label.setForeground(Color.WHITE);
        // panel3.add(label2);
        // panel3.add(label);
        // panel3.setAlignmentX(CENTER_ALIGNMENT);
        // panel3.setBackground(headerColor);

        ImageIcon downbanner = new ImageIcon(getClass().getResource("southbanner.png"));
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
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==nextBtn){
            String date = String.format("%tF", calendar.getDate());
            System.out.println(date);
            new PlanePageWindow(new Database(), index); 
            dateFrame.dispose();   
        }

        if (e.getSource()==viewBalanceMenuItem){
            new TopUpWindow(datum, index);
        } else if (e.getSource()==logoutMenuItem){
            new LoginWindow();
        } else if (e.getSource()==exitMenuItem){
            dispose();
        }
    
        // TODO Auto-generated method stub
        if(e.getSource() instanceof JButton btn){
            if(btn.equals(buttonmenu[0])){ 
                new TrainPageWindow(index);
                dispose(); 
            }
            else if(btn.equals(buttonmenu[1])){
                new TopUpWindow(new Database(), index);
                dispose();
            }
            else if(btn.equals(buttonmenu[2])){ 
                dateFrame.setVisible(true);
            }
            else{ 
                String get_text = btn.getText(); 
                if(get_text.equals(name_label[0]));
                else if(get_text.equals(name_label[1]));
                else if(get_text.equals(name_label[2]))new TopUpWindow(datum, index);
                else if(get_text.equals(name_label[3]))new LoginWindow();
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
                buttonmenu[i].setIcon(new ImageIcon("bin/"+hoverimg[i]+"enter.png"));
            }
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < 3; i++){
            if (e.getSource() == buttonmenu[i]){
                buttonmenu[i].setIcon(new ImageIcon("bin/" + image[i]));
            }
        }
    }
}
