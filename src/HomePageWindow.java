import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePageWindow extends JFrame implements ActionListener, MouseListener{
    public static void main(String[] args) {
        new HomePageWindow(new Database(),0); 
    }
    private JFrame frame = new JFrame();
    private JButton button = new JButton(); 
    private JLabel label = new JLabel();
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel(); 
    private JPanel panel3 = new JPanel(); 

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
        datum = data;
        index = idx;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(4,1));
        panel2.setLayout(new FlowLayout(1, 10, 10));
        panel3.setLayout(new GridLayout(1,3));

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
            panel2.add(buttonmenu[i]);
        }

        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel3.setPreferredSize(new Dimension(100, 70));
        label.setText("Book for your holiday!!!");
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        panel3.add(label);
        panel3.setBackground(new Color(105, 105, 105));


        button.setSize(1920, 1080);
        this.add(panel2, BorderLayout.CENTER);
        // this.add(panel3,BorderLayout.EAST);
        this.add(panel3, BorderLayout.NORTH);
        this.add(panel, BorderLayout.WEST); 
        this.setVisible(true);
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    
        // TODO Auto-generated method stub
        if(e.getSource() instanceof JButton btn){
            if(btn.equals(buttonmenu[0])){ 
                new TrainPageWindow(index); 
            }
            else if(btn.equals(buttonmenu[1])){
                new TopUpWindow(new Database(), index);
            }
            else if(btn.equals(buttonmenu[2])){ 
                new PlanePageWindow(new Database(), index);
                //the coding
            }
            else{ 
                String get_text = btn.getText(); 
                if(get_text.equals(name_label[0]));
                else if(get_text.equals(name_label[1]));
                else if(get_text.equals(name_label[2]))new TopUpWindow(datum, index);
                else if(get_text.equals(name_label[3]))new LoginWindow();
            } 
            dispose();
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
