package home_page;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JFrame frame = new JFrame(); 
    JButton button = new JButton(); 
    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();


    String name_label[] = {
        "jason", "input", "yang"
    };
   
    home_page(){ 

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(10,1));

        for(String i : name_label){
            JButton button_new = new JButton(); 
            button_new.setText(i);
            panel.add(button_new);
        }

        label.setText("this is going to frame2");
        button.add(label);
        button.addActionListener(this);
        this.add(button, BorderLayout.NORTH);
        this.add(panel, BorderLayout.WEST); 
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