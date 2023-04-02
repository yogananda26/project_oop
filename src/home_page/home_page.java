package home_page;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;



public class home_page extends JFrame implements ActionListener{
    // this is for Fram
    public static void main(String[] args) {
        new home_page();
    }
    private JFrame frame = new JFrame(); 
    private JButton button = new JButton(); 
    private JLabel label = new JLabel();
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel(); 


    private JButton button_plane; 
    private JButton button_train;
    private JButton top_up;

    ArrayList <ImageIcon> list_of_image = new ArrayList<>(); 


    private String name_label[] = {
        "jason", "input", "yang"
    };
    home_page(){ 
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(10,1));
        panel2.setLayout(new FlowLayout(1,10, 10));

        // this is for the image 
        ImageIcon image_plane = new ImageIcon("2668926-200.png");
        ImageIcon image_top_up = new ImageIcon("images.jpg");
        ImageIcon image_train = new ImageIcon("png-clipart-black-train-illustration-rail-transport-train-station-maglev-computer-icons-train-angle-public-transport.png");
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
        }
    
        label.setText("this is going to frame2");
        button.setSize(1920, 1080);
        button.add(label);
        button.addActionListener(this);
        this.add(panel2, BorderLayout.CENTER);
        this.add(button, BorderLayout.NORTH);
        this.add(panel, BorderLayout.WEST); 
        this.setVisible(true);
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() instanceof JButton btn){
            if(btn.getIcon() == list_of_image.get(0)){ 
                new plane_page();
                dispose();
            }
            else if(btn.getIcon() == list_of_image.get(1)){
                //the coding
            }
            else if(btn.getIcon() == list_of_image.get(2)){ 
                //the coding
            }
            // ArrayList<ImageIcon> list
        }
    }
};

/**
 * Innerhome_page
 */