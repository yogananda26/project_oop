package home_page;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class home_page extends JFrame implements ActionListener{
    // this is for Fram
    public static void main(String[] args) {
        new home_page();
    }
    JFrame frame = new JFrame(); 
    JButton button = new JButton(); 
    JLabel label = new JLabel();
    home_page(){ 
        this.setSize(200, 200);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        label.setText("this is going to frame2");
        button.add(label);
        button.addActionListener(this);
        this.add(button);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == button){ 
            new page_2();
            dispose();
        }

    }
};