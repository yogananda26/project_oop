import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.junit.runner.Result;



public class HistoryWindow extends JFrame implements ActionListener {

    JFrame main_frame = new JFrame("History Frame");
    JPanel panel_head = new JPanel(new BorderLayout()); 
    // JPanel panel_passenger = new JPanel();
    ArrayList <JButton> passButtons = new ArrayList<>();
    ;
    JTable table_history;

    private String navigation[] = {
        "Home", "Date", "Profile", "Balance"
    };
    int index; 
    JPanel panel_navigation = new JPanel(new GridLayout(5, 1));

    // testing this
    //second_testing

    public HistoryWindow(int idx){
        //this is for frontend thing
        index = idx; 
        try {
            JLabel label_head = new JLabel("THIS IS YOUR HISTORY " + Database.user.get(index).getFullName()); 
            panel_head.add(label_head, BorderLayout.NORTH);


            //column names
            String[] column_name={"AIRLINE", "PRICE", "DEPARTURE ⇾ ARRIVAL", "DATE", "PASSENGER"};
            
            //adding data
            ArrayList <History> temp = Database.user.get(index).history;
            String[][] data = new String[temp.size()][5];
            for (int i = 0; i < temp.size(); i++) {
                data[i][0] = temp.get(i).get_transportation_name();
                data[i][1] = "Rp" + temp.get(i).get_price().toString();
                data[i][2] = temp.get(i).get_departure() + " ⇾ " + temp.get(i).get_arrival();
                data[i][3] = temp.get(i).get_date();
                data[i][4] = "Click To See Passengers Detail";

                
            }
            
            //initializing table
            table_history = new JTable(data, column_name);
            table_history.setRowHeight(15);
            table_history.setBounds(40, 50, 300, 400);

            //scroll pane
            JScrollPane panel_table = new JScrollPane(table_history);
            this.add(panel_table);
            
            ListSelectionModel model = table_history.getSelectionModel();
            model.addListSelectionListener(new ListSelectionListener() {
                
                public void valueChanged(ListSelectionEvent e){
                    if(! model.isSelectionEmpty()){
                        //get selected row
                        int selectedRow = model.getMaxSelectionIndex();
                        ArrayList <Passanger> temp1 = Database.user.get(index).history.get(selectedRow).get_array_passanger();
                        String lineSep = System.lineSeparator();
                        StringBuilder results = new StringBuilder();
                        for (int i = 0; i < temp1.size(); i++) {
                            String name = temp1.get(i).name;
                            String gender = temp1.get(i).gender;
                            String passport = temp1.get(i).passportNum;

                            results.append("Passenger "+ (i+1) + " :").append(lineSep);
                            results.append("  Name: ").append(name).append(lineSep);
                            results.append("  Gender: ").append(gender).append(lineSep);
                            if(i < temp1.size()){
                                results.append("  Passport: ").append(passport).append(lineSep).append(lineSep);
                            }
                            else{
                                results.append("  Passport: ").append(passport);
                            }
                        }
                        JOptionPane.showMessageDialog(null, results.toString());

                    }
                }
            });

            // Border blackline = BorderFactory.createLineBorder(Color.black);
            // Border empBorder = BorderFactory.createEmptyBorder(25, 25, 25, 25);

            // JLabel label_head = new JLabel("THIS IS YOUR HISTORY " + Database.user.get(index).getFullName()); 
            // panel_head.add(label_head, BorderLayout.NORTH);

            // ArrayList <History> temp = Database.user.get(index).history;
            // JPanel panel_history = new JPanel(new GridLayout(temp.size()+1, 1));
            // panel_history.setBorder(empBorder);
            // JLabel title_history = new JLabel("AIRLINE"); 
            // title_history.setBorder(blackline);
            // JLabel title_history1 = new JLabel("PRICE"); 
            // title_history1.setBorder(blackline);
            // JLabel title_history2 = new JLabel("ARRIVAL"); 
            // title_history2.setBorder(blackline);
            // JLabel title_history3 = new JLabel("DERPATURE"); 
            // title_history3.setBorder(blackline);
            // JLabel title_history4 = new JLabel("DATE"); 
            // title_history4.setBorder(blackline);
            // JLabel title_history5 = new JLabel("PASSENGER"); 
            // title_history5.setBorder(blackline);

            // panel_history.add(title_history);
            // panel_history.add(title_history1);
            // panel_history.add(title_history2);
            // panel_history.add(title_history3);
            // panel_history.add(title_history4);
            // panel_history.add(title_history5);

            // for(int i = 0; i<temp.size(); i++){
                
            //     JLabel label_history = new JLabel(temp.get(i).get_transportation_name());
            //     label_history.setBorder(blackline);
            //     JLabel label_history1 = new JLabel(temp.get(i).get_price().toString());
            //     label_history1.setBorder(blackline);
            //     JLabel label_history2 = new JLabel(temp.get(i).get_arrival());
            //     label_history2.setBorder(blackline);
            //     JLabel label_history3 = new JLabel(temp.get(i).get_departure());
            //     label_history3.setBorder(blackline);
            //     JLabel label_history4 = new JLabel(temp.get(i).get_date());
            //     label_history4.setBorder(blackline);

            //     panel_history.add(label_history);
            //     panel_history.add(label_history1);
            //     panel_history.add(label_history2);
            //     panel_history.add(label_history3);
            //     panel_history.add(label_history4);


            //     ArrayList <Passanger> temp1 = Database.user.get(index).history.get(i).get_array_passanger();
            //     // JPanel panel_for_passanger = new JPanel(new GridLayout(temp1.size(), 1)); 
            //     // JPanel panel_for_passanger = new JPanel(new GridLayout(temp1.size(), 1)); 
            //     JPanel panel_for_passanger = new JPanel(new GridLayout(temp1.size()*3, 1)); 
            //     // panel_for_passanger.setBorder(blackline);
            //     // JPanel panel_for_passanger = new JPanel(); 
            //     // panel_for_passanger.setLayout(new BoxLayout(panel_for_passanger, BoxLayout.Y_AXIS));

            //     for(int j = 0; j<temp1.size(); j++){  
            //         JLabel label = new JLabel("Name: " + temp1.get(j).name);
            //         // JLabel label1 = new JLabel(temp1.get(j).age.toString());
            //         JLabel label1 = new JLabel("Passport: " + temp1.get(j).passportNum);
            //         // JLabel label3 = new JLabel(temp1.get(j).NIN);
            //         JLabel label2 = new JLabel("Gender: " + temp1.get(j).gender);

            //         panel_for_passanger.add(label);
            //         panel_for_passanger.add(label1);
            //         panel_for_passanger.add(label2);
            //         // panel_for_passanger.add(label3);
            //         // panel_for_passanger.add(label4);

            //         panel_history.add(panel_for_passanger);
            //     }
            //     this.add(panel_head);
            //     this.add(panel_history); 
            // }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null,"You Dont Have Any Record Before");
        }
        // this is for navigation 
        for(String i : navigation){
            JButton button_new = new JButton(); 
            button_new.setText(i);
            button_new.setBackground(Color.WHITE);
            button_new.setFocusable(false);
            button_new.addActionListener(this);
            panel_navigation.add(button_new);
        }
        this.add(panel_navigation, BorderLayout.WEST);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() instanceof JButton btn){
            dispose();
            if(btn.getText() == navigation[0]){
                new HomePageWindow(new Database(), index); 
            }
            else if(btn.getText() == navigation[1]){
            }
            else if(btn.getText() == navigation[2]){
            }
            else if(btn.getText() == navigation[3]){
                new TopUpWindow(new Database(), index);
            }
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    } 
    
}
