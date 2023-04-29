import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;



public class HistoryWindow extends JFrame implements ActionListener {

    JFrame main_frame = new JFrame("History Frame");
    JPanel panel_head = new JPanel(new BorderLayout()); 

    // testing this
    //second_testing

    public HistoryWindow(int index){
        //this is for frontend thing
        JLabel label_head = new JLabel("This is your History " + Database.user.get(index).getFullName()); 
        panel_head.add(label_head, BorderLayout.NORTH);

        try {
            ArrayList <History> temp = Database.user.get(index).history;
            JPanel panel_history = new JPanel(new GridLayout(temp.size(), 1)); 
            for(int i = 0; i<temp.size(); i++){
                
                JLabel label_history = new JLabel(temp.get(i).get_transportation_name());
                JLabel label_history1 = new JLabel(temp.get(i).get_price().toString());
                JLabel label_history2 = new JLabel(temp.get(i).get_arrival());
                JLabel label_history3 = new JLabel(temp.get(i).get_departure());
                JLabel label_history4 = new JLabel(temp.get(i).get_date());

                panel_history.add(label_history);
                panel_history.add(label_history1);
                panel_history.add(label_history2);
                panel_history.add(label_history3);
                panel_history.add(label_history4);


                ArrayList <Passanger> temp1 = Database.user.get(index).history.get(i).get_array_passanger();
                JPanel panel_for_passanger = new JPanel(new GridLayout(temp1.size(), 1)); 

                for(int j = 0; j<temp1.size(); j++){  
                    JLabel label = new JLabel(temp1.get(j).name);
                    JLabel label1 = new JLabel(temp1.get(j).age.toString());
                    JLabel label2 = new JLabel(temp1.get(j).passportNum);
                    JLabel label3 = new JLabel(temp1.get(j).NIN);
                    JLabel label4 = new JLabel(temp1.get(j).gender);

                    panel_for_passanger.add(label);
                    panel_for_passanger.add(label1);
                    panel_for_passanger.add(label2);
                    panel_for_passanger.add(label3);
                    panel_for_passanger.add(label4);

                    panel_history.add(panel_for_passanger);
                }
                this.add(panel_history, BorderLayout.CENTER); 
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null,"You Dont Have Any Record Before");
        }
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    } 
    
}
