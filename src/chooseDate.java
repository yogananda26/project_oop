import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.toedter.calendar.*;

public class chooseDate extends JFrame implements ActionListener{
    private JFrame dateFrame = new JFrame("Choose your day");
    private JButton nextBtn = new JButton("Next");
    private JCalendar calendar = new JCalendar();

    chooseDate(){
        nextBtn.setFocusable(false);
        nextBtn.addActionListener(this);
        dateFrame.setSize(400, 400);
        dateFrame.setLayout(new BorderLayout());
        dateFrame.add(calendar, BorderLayout.CENTER);
        dateFrame.add(nextBtn, BorderLayout.SOUTH);
        dateFrame.setLocationRelativeTo(null);
        dateFrame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        dateFrame.setResizable(false);
        dateFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==nextBtn){
            String date = String.format("%tF", calendar.getDate());
            System.out.println(date);
            new RegisterWindow();
            dateFrame.dispose();
            
        }
    }

}
