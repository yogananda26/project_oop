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
        "Home", "Date", "Profile", "Balance"
    };
    private String more_button[] ={
        "More for Lion Air", "More For Sriwijaya Air","More for Garuda",
        "More for Batik Air","More for Super Air Jet","More for Air Asia",
        "More for SG Airline","More for for Qantas Airlane","More for Citilink"
    }; 
    private Double price[] = { 
        2000000.0, 3000000.0 , 1000000.0, 1500000.0, 4000000.0, 123000.0,
        212000.0, 100000.0, 112100.0
    };
    private ImageIcon image[] = {
        new ImageIcon(getClass().getResource("logo_lion_air.jpg")),
        new ImageIcon(getClass().getResource("Sriwijaya_air.jpg")), new ImageIcon(getClass().getResource("garuda_indonesia.png")),
        new ImageIcon(getClass().getResource("batik_air.jpg")), new ImageIcon(getClass().getResource("super_air_jet.png")),
        new ImageIcon(getClass().getResource("air_asia_air.png")), new ImageIcon(getClass().getResource("singapore_airlane.png")),
        new ImageIcon(getClass().getResource("qantas_air.png")), new ImageIcon(getClass().getResource("citilink_air.png"))
    };

    PlanePageWindow(){ 
    // this for note
    /*
     type of layout
     flowlayout
     gridlayout
     borderlayout
     */
        panel_container.setLayout(new GridLayout(9,5));
        for(int i = 0; i<plane_name.length; i++){

            // JButton button2 = new JButton();
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel panel_destination = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel panel_logo_airplane = new JLabel(image[i]);
            JPanel panel_button_more = new JPanel(new FlowLayout(FlowLayout.RIGHT,50,1));
            JPanel panel_plane = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel label_destination = new JLabel();
            JLabel label = new JLabel();
            JLabel label_price = new JLabel(); 

            String text = plane_name[i];
            label.setText(text);
            label.setFont(new Font(getName(), ABORT, 20));
            label.setPreferredSize(new Dimension(250, 25));
            panel_plane.setPreferredSize(new Dimension(250, 200));
            panel_plane.add(label);
            panel_plane.add(panel_logo_airplane);

            String dest = destination[i] + "  ---->  " + destination[(destination.length-1 - i)/(i+1)];
            label_destination.setText(dest);
            label_destination.setFont(new Font(getName(), ABORT, 20));
            panel_destination.setPreferredSize(new Dimension(500, 200));
            
            panel_destination.add(label_destination); 
            panel.add(panel_plane);
            panel.add(panel_destination);

            panel_container.add(panel); 
            JButton button_more = new JButton(more_button[i]);
            button_more.setPreferredSize(new Dimension(100,60));
            button_more.addActionListener(this);
            button_more.setFocusable(false);
            button_more.setBackground(Color.white);

            label_price.setText("Rp"+price[i].toString());
            label_price.setFont(new Font(getName(), ABORT, 20));

            panel_button_more.add(label_price);
            panel_button_more.add(button_more); 
            panel_container.add(panel_button_more);

        }
        panel2.setLayout(new GridLayout(4, 1));

        for(String i : navigation){
            JButton button1 = new JButton(); 
            button1.setText(i);
            button1.setBackground(Color.WHITE);
            button1.setFocusable(false);
            button1.addActionListener(this);
            panel2.add(button1); 
        }

        label_head.setText("Travelly App");
        label_head.setFont(new Font("Helvetica", Font.PLAIN, 50));
        panel_head.add(label_head);
        panel_head.setBackground(new Color(79, 188, 224));

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
            if(btn.getText() == "Home"){
                // new home_page(data);
                dispose(); 
            }
            else{
                for(int i = 0; i<more_button.length; i++){
                    if(btn.getText().equals(more_button[i])){
                        JFrame frame = new JFrame();
                        JPanel panel = new JPanel();
                        JPanel panel_field = new JPanel(); 
                        panel.setLayout(new FlowLayout());
                        frame.setLayout(new BorderLayout());
                        JButton button_yes = new JButton("Buy");
                        JButton button_no = new JButton("Cancel");
                        JPanel new_info = new JPanel(new FlowLayout(FlowLayout.CENTER));
                        JLabel label_head = new JLabel("This Is Your Choose"); 
                        new_info.add(label_head); 
                    
                        button_yes.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // this is for exit the program
                                String PIN = JOptionPane.showInputDialog(null,"Input Your pin");
                                System.out.println(PIN);
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
                            "============================\n\n" + 
                            "Plane      : " + plane_name[i] + "\n" + 
                            "Price      : Rp" + price[i] + ";\n" +
                            "Departure : " + destination[i] + "\n" +
                            "Arrival    : " + destination[(destination.length - 1-i)/(i+1)] + "\n\n" +
                            "============================"
                        );
                        text_ticket.setOpaque(false);
                        text_ticket.setEditable(false);
                        text_ticket.setFont(new Font("Sherif", Font.BOLD, 20));
                        
                        panel_field.add(text_ticket);
                        panel.add(button_yes);
                        panel.add(button_no); 
                        frame.setSize(400, 400);
                        frame.setLocationRelativeTo(null);
                        frame.add(new_info, BorderLayout.NORTH); 
                        frame.add(panel, BorderLayout.SOUTH); 
                        frame.add(panel_field, BorderLayout.CENTER); 
                        frame.setResizable(false);
                        frame.setVisible(true);
                        // this is for accessing the button
                        return; 
                    }   
                }
            }
        }  
    }
}
