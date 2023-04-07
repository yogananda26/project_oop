import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Flow;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class HomePageWindow extends JFrame implements ActionListener{
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


    private JButton button_plane; 
    private JButton button_train;
    private JButton top_up;

    private ArrayList <ImageIcon> list_of_image = new ArrayList<>(); 


    private String name_label[] = {
        "Date", "Profile", "Balance"
    };
    HomePageWindow(Database data, int idx){ 

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3,1));
        panel2.setLayout(new FlowLayout(1,10, 10));
        panel3.setLayout(new GridLayout(1,3));

        // this is for the image 
        ImageIcon image_plane = new ImageIcon(getClass().getResource("images.png"));
        ImageIcon image_top_up = new ImageIcon(getClass().getResource("2464502-200.png"));
        ImageIcon image_train = new ImageIcon(getClass().getResource("png-clipart-black-train-illustration-rail-transport-train-station-maglev-computer-icons-train-angle-public-transport.png"));
        list_of_image.add(image_train);
        list_of_image.add(image_top_up);
        list_of_image.add(image_plane);

        // this is for the button 
        for(String i : name_label){
            JButton button_new = new JButton(); 
            button_new.setText(i);
            button_new.setBackground(Color.WHITE);
            button_new.setFocusable(false);
            panel.add(button_new);
        }

        for(ImageIcon j : list_of_image){
            JButton button_new_feature = new JButton(j);
            button_new_feature.setBackground(Color.WHITE);
            button_new_feature.setFocusable(false);
            button_new_feature.addActionListener(this);
            panel2.add(button_new_feature);
            // panel3.add(button_new_feature);
        }

        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel3.setPreferredSize(new Dimension(100, 70));
        label.setText("Travelly App");
        label.setFont(new Font("Helvetica", Font.PLAIN, 50));
        panel3.add(label);
        panel3.setBackground(new Color(79, 188, 224));


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
            if(btn.getIcon() == list_of_image.get(0)){ 
                new TrainPageWindow(); 
            }

            else if(btn.getIcon() == list_of_image.get(1)){
                new TopUpWindow();
            }
            else if(btn.getIcon() == list_of_image.get(2)){ 
                new PlanePageWindow();
                //the coding
            }
            dispose(); 
            
            // ArrayList<ImageIcon> list
        }
    }
};

/**
 * Innerhome_page
 */