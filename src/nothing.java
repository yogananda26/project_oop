import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class nothing extends JFrame implements ActionListener{
   

    JButton btn;
    static int input;
    static void change_input(int second){
        input = second;
    }
    public nothing(){
        ImageIcon image = new ImageIcon(getClass().getResource("regisbutton.jpg"));
        btn = new JButton(image);
        btn.setContentAreaFilled(false);
        btn.setFocusable(false);
        btn.setBorderPainted(false);
        btn.addActionListener(this);
        setLayout(new FlowLayout());
        add(btn);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn){
            System.out.println("asik");
        }
    }
    public static void main(String[] args) {
     
    }
}
