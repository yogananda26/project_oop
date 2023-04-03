package home_page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;



public class plane_page extends JFrame implements ActionListener {

    
    JFrame frame = new JFrame("this is frame 2");
    JLabel label = new JLabel();
    JButton button = new JButton();
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel(); 
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel(); 
    JPanel panel6 = new JPanel();
    JPanel panel7 = new JPanel();

    private String plane_name[] = {
        "Lion Air", "Sriwijaya Air", "Garuda", "Batik Air",
        "Super Air Jet", "Air Asia", "Singapore Airlane", "Qantas Airlane",
        "Citilink"
    };
    private String navigation[] = {
        "Home", "Date", "Profile", "Balance"
    };
    private Double price[] = { 
        2000000.0, 3000000.0 , 1000000.0, 1500000.0, 4000000.0, 123000.0,
        212000.0, 100000.0, 112100.0
    };
    plane_page(){ 
    // this for note
    /*
     type of layout
     flowlayout
     gridlayout
     borderlayout
     */
    // this is for the action thing hell yeah
    // panel.setBackground(Color.blue);
    // panel.setLayout(null);
    // panel.setBounds(10,10,300, 300);
    // panel3.setBackground(Color.red);
    // panel3.setLayout(null);
    // panel4.setBackground(Color.yellow);
    // panel4.setLayout(null);
    // panel5.setBackground(Color.green);
    // panel5.setLayout(null);


    // panel2.setLayout(new GridLayout(2,2));
    // panel2.add(panel);
    // panel2.add(panel3);
    // panel2.add(panel4);
    // panel2.add(panel5);
    
    panel.setLayout(new GridLayout(10,5));
        for(int i = 0; i<plane_name.length; i++){
            JLabel label = new JLabel();
            String text = "Now promo " + plane_name[i] + " --> " + price[i];
            label.setText(text);
            label.setFont(new Font(getName(), ABORT, 30));

            panel.add(label); 
        }
        panel.setPreferredSize(new Dimension(200,200));
    panel2.setLayout(new GridLayout(4, 1));
        for(String i : navigation){
            JButton button1 = new JButton(); 
            button1.setText(i);
            button1.addActionListener(this);
            panel2.add(button1); 
        }
        // for(Double j : price){ 
        //     JLabel label1 = new JLabel();
        //     label1.setText(j.toString()); 
        //     label1.setFont(new Font(getName(), ABORT, 30));
        //     panel2.add(label1);
        // }
        // panel2.setPreferredSize(new Dimension(200,200));

        // this.setLayout(new BorderLayout());
        // this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(panel2, BorderLayout.WEST);
        this.add(panel, BorderLayout.CENTER);
        // button.setText("this is for going back to frame 1 ");
        // button.addActionListener(this);
        this.setVisible(true);

    }
    // this is for record the thing
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() instanceof JButton btn){ 
            if(btn.getText() == "Home"){
                new home_page();
                dispose(); 
            }
        }
       
    }
}
