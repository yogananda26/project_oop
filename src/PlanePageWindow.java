import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PlanePageWindow extends JFrame implements ActionListener {

    JFrame frame = new JFrame("this is frame 2");
    JLabel label_head = new JLabel();
    JButton button = new JButton();
    JPanel panel_container = new JPanel();
    JPanel panel2 = new JPanel(); 
    JPanel panel_head = new JPanel(new FlowLayout(FlowLayout.CENTER));
    static int index;

    private String plane_name[] = {
        "Lion Air", "Sriwijaya Air", "Garuda", "Batik Air",
        "Super Air Jet", "Air Asia", "Singapore Airlane", "Qantas Airlane",
        "Citilink"
    };
    private String destination[] = {
        "Bandung","Jakarta","Surabaya", "Makassar", "Semarang","Yogyakarta","Madura","Jambi", "Papua","Medan",
        "Manado", "Maluku"
    }; 
    private String navigation[] = {
        "homeicon.png", "dateicon.png", "profileicon.png", "balanceicon.png", "historyicon.png"
    };
    private String navigate[] = {
        "Home", "Date", "Profile", "Balance", "History"
    };
    private String more_button[] ={
        "More for Lion Air", "More For Sriwijaya Air","More for Garuda",
        "More for Batik Air","More for Super Air Jet","More for Air Asia",
        "More for SG Airline","More for for Qantas Airlane","More for Citilink"
    }; 
    private Double price[] = { 
        2000000.0, 3000000.0 , 1000000.0, 1500000.0, 4000000.0, 123000.0,
        212000.0, 100000.0, 750000.0
    }; 

    private String image[] = {
        "logo_lion_air (1).jpg", "Sriwijaya_air (1).png", "garuda_indonesia (1).png", "batik_air (1).png","super_air_jet (1).png", 
        "air_asia_air (1).png", "singapore_airline (1).png", "qantas_air (1).png", "citilink_air (1).png" 
    };
   
    public static void main(String[] args) {
        new PlanePageWindow(new Database(), 0, "test"); 
        // System.out.println("main");
    }

    public PlanePageWindow(Database data, int idx, String date){

        Color bgColor = new Color(223, 246, 255);
        Color headerColor = new Color(6, 40, 61);
        ImageIcon moreButton = new ImageIcon("src/assets/moreinfobutton.png");
 
        ImageIcon image_icon[] = new ImageIcon[image.length]; 
        for(int i = 0; i<image.length; i++){
            image_icon[i] = new ImageIcon("src/assets/"+image[i]);
        }

        index = idx;
        panel_container.setLayout(new GridLayout(9,5));
        for(int i = 0; i<plane_name.length; i++){

            // JButton button2 = new JButton();
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
            JPanel panel_destination = new JPanel(new FlowLayout(FlowLayout.CENTER, 50 , 5));
            JLabel panel_logo_airplane = new JLabel(image_icon[i]);
            JPanel panel_button_more = new JPanel(new FlowLayout(FlowLayout.RIGHT, 50, 5));
            JPanel panel_plane = new JPanel(new FlowLayout(FlowLayout.LEADING));
            JLabel label_destination = new JLabel();
            JLabel label = new JLabel();
            JLabel label_price = new JLabel();

            JPanel panel_date = new JPanel(); 
            JLabel label_date = new JLabel(); 

            panel.setBackground(bgColor); 
            panel_destination.setBackground(bgColor);
            panel_logo_airplane.setBackground(bgColor);
            panel_button_more.setBackground(bgColor);
            panel_plane.setBackground(bgColor);
            panel_date.setBackground(bgColor);

            String text = plane_name[i];
            label.setText(text);
            label.setFont(new Font("Times New Roman", Font.BOLD, 20));
            label.setPreferredSize(new Dimension(250, 25));
            panel_plane.setPreferredSize(new Dimension(300, 100));
            panel_plane.add(label);
            panel_plane.add(panel_logo_airplane);

            String dest = destination[i] + "  →  " + destination[(destination.length-1 - i)/(i+1)];
            label_destination.setText(dest);
            label_destination.setFont(new Font("Times New Roman", Font.BOLD, 20));
            label_destination.setHorizontalAlignment(JLabel.CENTER);
            // label_destination.setPreferredSize(new Dimension(200, 200));

            label_date.setText(date); 
            label_date.setFont(new Font(getName(), ABORT, 20));
            label_date.setHorizontalAlignment(JLabel.CENTER);
            panel_date.add(label_date); 
            
            

            
            panel_destination.add(label_destination);
            panel.add(panel_plane);
            panel.add(panel_date);

            
        
            panel_container.add(panel); 
            panel_container.add(panel_destination);
            JButton button_more = new JButton(moreButton);
            button_more.setText(more_button[i]);
            button_more.setFont(new Font("Times New Roman", Font.PLAIN, 1));
            button_more.setPreferredSize(new Dimension(100,40));
            button_more.addActionListener(this);
            button_more.setFocusable(false);
            button_more.setBackground(Color.white);

            label_price.setText("Rp"+price[i].toString());
            label_price.setFont(new Font("Times New Roman", Font.BOLD, 20));
            panel_button_more.add(label_price);
            panel_button_more.add(button_more); 

            panel_container.add(panel_button_more);

        }
        panel2.setLayout(new GridLayout(5, 1));
        panel2.setPreferredSize(new Dimension(100, 750));

        for (int i = 0; i < 5; i++){
            ImageIcon navIcon = new ImageIcon("src/assets/" + navigation[i]);
            JButton button1 = new JButton(); 
            button1.setIcon(navIcon);
            button1.setText(navigate[i]);
            button1.setFont(new Font("Times New Roman", Font.PLAIN, 1));
            button1.setBackground(Color.WHITE);
            button1.setFocusable(false);
            button1.addActionListener(this);
            panel2.add(button1);
        }

        label_head.setText("Book your airplane ticket!");
        label_head.setFont(new Font("Times New Roman", Font.BOLD, 50));
        label_head.setForeground(Color.WHITE);
        panel_head.add(label_head);
        panel_head.setBackground(new Color(79, 188, 224));
        panel_head.setBackground(headerColor);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(panel2, BorderLayout.WEST);
        this.add(panel_head, BorderLayout.NORTH); 
        this.add(panel_container, BorderLayout.CENTER);
        this.setVisible(true);
        
    }
    // this is for record the thing
    @Override
    public void actionPerformed(ActionEvent e) {
        Database data = new Database();
        if(e.getSource() instanceof JButton btn){ 
            dispose();
            if(btn.getText() == "Home"){  
                new HomePageWindow(new Database(), index);
            }
            else if(btn.getText() == "Balance"){
                new TopUpWindow(new Database(), index);
            }
            else if(btn.getText() == "History"){
                new HistoryWindow(index);
            }
            else{
                for(int i = 0; i<more_button.length; i++){
                    if(btn.getText().equals(more_button[i])){
                        final Integer inner = new Integer(i);
                        JFrame frame = new JFrame();
                        JPanel panel = new JPanel();
                        JPanel panel_field = new JPanel(); 
                        panel.setLayout(new FlowLayout());
                        frame.setLayout(new BorderLayout());
                        JButton button_yes = new JButton("Buy");
                        JButton button_no = new JButton("Cancel");
                        JPanel new_info = new JPanel(new FlowLayout(FlowLayout.CENTER));
                        JLabel label_head = new JLabel("This Is Your Choice"); 
                        label_head.setFont(new Font("Times New Roman", Font.BOLD, 30));
                        new_info.add(label_head); 
                    
                        button_yes.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // this is for cheking if our balance is enough or not
                                Integer input = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input how many Ticket that you want to add" )); 
                                if(Database.user.get(index).getBalance() < input*price[inner]){
                                    JOptionPane.showMessageDialog(null, "Your balance is not enough, Please top up first, Must have min : " +
                                    input*price[inner]);
                                    dispose();
                                    new TopUpWindow(data, index);
                                }
                                else{
                                    for(int i = 3; i>=0; i--){
                                        String PIN = JOptionPane.showInputDialog(null,"Input Your pin");
                                        if(PIN == null){
                                            return; 
                                        }
                                        if(new Register().checkValidPinEnter(PIN, index)){
                                            JOptionPane.showMessageDialog(null, "successfull buy your ticket");
                                            new History(plane_name[inner], price[inner],destination[(destination.length - 1-inner)/(inner+1)], destination[inner], "1").insert_history(index);
                                            Double remaining_balance = Database.user.get(index).getBalance();  
                                            Database.user.get(index).setBalance(remaining_balance - price[inner]);

                                            for(int j = 0; j<Database.user.get(index).history.size(); j++){
                                                if(Database.user.get(index).history.get(j).get_plane_name().equals(plane_name[inner])){
                                                   new PassengerSubmitWindow(0, input, index, j); 
                                                }
                                            }

                                            System.out.println(Database.user.get(index).history);
                                            break;
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null, "Please input your exact password " + i +" attemps more");
                                        }   
                                    }
                                }
                                // this is for exit the program
                                frame.setVisible(false);                               
                            } 
                        });
                        button_no.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // this is for exit the program
                                frame.setVisible(false);
                            }
                        });

                        // this is for the info
                        JTextArea text_ticket = new JTextArea(
                            "═════════════════════════\n\n" + 
                            "Plane        : " + plane_name[i] + "\n" + 
                            "Price         : Rp" + price[i] + ",-\n" +
                            "Departure : " + destination[i] + "\n" +
                            "Arrival      : " + destination[(destination.length - 1-i)/(i+1)] + "\n\n" +
                            "═════════════════════════"
                        );
                        text_ticket.setOpaque(false);
                        text_ticket.setEditable(false);
                        text_ticket.setFont(new Font("Times New Roman", Font.BOLD, 20));
                        
                        panel_field.add(text_ticket);
                        panel.add(button_yes);
                        panel.add(button_no); 
                        frame.setSize(400, 350);
                        frame.setLocationRelativeTo(null);
                        frame.add(new_info, BorderLayout.NORTH); 
                        frame.add(panel, BorderLayout.SOUTH); 
                        frame.add(panel_field, BorderLayout.CENTER); 
                        frame.setResizable(false);
                        frame.setVisible(true);
                        // this is for accessing the button
                    }   
                }
            }
        }  
    }
}
