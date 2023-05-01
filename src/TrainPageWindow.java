

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class TrainPageWindow extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    int index; 
  
    private String name_feature[] = {
        "Home", "Date", "Profile", "Balance"
    };
    TrainPageWindow(int idx){
        index = idx;   
        panel.setLayout(new GridLayout(4 ,1));
        this.setLayout(new GridLayout());
        for(String i : name_feature){
            JButton button = new JButton();
            button.setText(i);
            button.addActionListener(this);
            button.setBackground(Color.white);
            button.setFocusable(false);
            panel.add(button); 
        }
        this.setLayout(new BorderLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.add(panel,BorderLayout.WEST);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton btn){
            dispose();
            if(btn.getText() == "Home"){
                new HomePageWindow(new Database(), index); 
            }
            else if(){
                
            }
        }
    }

}
