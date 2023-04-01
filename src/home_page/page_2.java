package home_page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

interface thing{

}

public class page_2 extends JFrame implements ActionListener {
    public static void main(String[] args) {
        
    }
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JButton button = new JButton();

    // this for note
    /*
     type of layout
     flowlayout
     gridlayout
     borderlayout
     */
    // this is for the action thing hell yeah
    
    page_2(){ 
        this.setSize(400, 400);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        label.setText("this is frame 2");
        label.setSize(100, 100);
        button.setText("this is for going back to frame 1 ");
        button.addActionListener(this);
        this.add(button);
        this.setVisible(true);

    }
    // this is for record the thing
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==button){
            new home_page();
            dispose(); 
        }
       
    }
}
