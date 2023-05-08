import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.junit.runner.Result;



public class HistoryWindow extends JFrame implements ActionListener {

    JFrame main_frame = new JFrame("History Frame");
    JPanel panel_head = new JPanel(new BorderLayout()); 
    JLabel bannerLabel;
    ArrayList <JButton> passButtons = new ArrayList<>();
    JTable table_history;

    private String navigation[] = {
        "homeicon.png",  "profileicon.png", "balanceicon.png"
    };
    private String navigate[] = {
        "Home", "Profile", "Balance"
    };

    JFrame profileFrame = new JFrame();

    int index; 
    JPanel panel_navigation = new JPanel(new GridLayout(5, 1));

    public HistoryWindow(int idx){

        index = idx; 

        Color bgColor = new Color(223, 246, 255);
        ImageIcon southbanner = new ImageIcon("src/assets/southbanner.png");

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

        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null,"You Dont Have Any Record Before");
        }

        for (int i = 0; i < 3; i++){
            ImageIcon navIcon = new ImageIcon("src/assets/" + navigation[i]);
            JButton button_new = new JButton(); 
            button_new.setIcon(navIcon);
            button_new.setText(navigate[i]);
            button_new.setFont(new Font("Times New Roman", Font.PLAIN, 1));
            button_new.setBackground(Color.WHITE);
            button_new.setPreferredSize(new Dimension(100, 150));
            button_new.setFocusable(false);
            button_new.addActionListener(this);
            panel_navigation.add(button_new);
        }

        bannerLabel = new JLabel(southbanner);

        this.getContentPane().setBackground(bgColor);
        this.add(panel_navigation, BorderLayout.WEST);
        this.add(bannerLabel, BorderLayout.SOUTH);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);

        JPanel panel1 = new JPanel(new GridLayout(1, 2));
        JPanel panelTextArea = new JPanel(new BorderLayout());

        profileFrame.setSize(500, 500);
        profileFrame.setLayout(new BorderLayout());
        JTextArea profileArea = new JTextArea(
            "Here's your Profile Details\n" + 
            "Your Name              : " + new Database().user.get(index).getFullName() + "\n" +
            "Your Email             : " + new Database().user.get(index).getEmail() + "\n" +
            "Your Phone Number      : " + new Database().user.get(index).getPhone() + "\n" +
            "Your Gender            : " + new Database().user.get(index).getGender() + "\n" +
            "Your Current Balance   : " + new Database().user.get(index).getBalance() + "\n"
        );
        panelTextArea.add(profileArea, BorderLayout.CENTER);
        panelTextArea.setForeground(Color.BLUE);
        profileArea.setEditable(false);
        profileArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
        profileFrame.add(panelTextArea, BorderLayout.CENTER);
        profileFrame.setLocationRelativeTo(null);
        profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profileFrame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() instanceof JButton btn){
            dispose();
            if(btn.getText() == navigate[0]){
                new HomePageWindow(new Database(), index); 
            }
            else if(btn.getText() == navigate[1]){
                profileFrame.setVisible(true);
            }
            else if(btn.getText() == navigate[2]){
                new TopUpWindow(new Database(), index);
            }
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    } 
    
}
