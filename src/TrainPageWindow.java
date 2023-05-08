
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TrainPageWindow extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JPanel panelHead = new JPanel();
    JPanel panelContainer = new JPanel(new GridLayout(9, 5));
    JLabel labelHead = new JLabel("Book your train ticket!");
    int index;
    
    private String trainName[] = {
        "Argo Bromo", "Gajayana", "Argo Parahyangan", "Argo Wilis", "Bangunkarta", "Singasari", "Gaya Baru Malam Selatan", "Kertanegara", "Jayakarta"
    };

    private String destination[] = {
        "Gambir", "Surabaya", "Yogyakarta", "Semarang", "Malang", "Madiun", "Solo", "Bandung", "Blitar", "Banyuwangi", "Ponorogo", "Gresik"
    };

    private String textButton[] = {
        "forArgo", "forGaja", "forParah", "forWilis", "forBangun", "forSinga", "forGaya", "forKerta", "forJaya"
    };

    private Double price[] = { 
        250000.0, 300000.0 , 450000.0, 500000.0, 550000.0, 200000.0,
        600000.0, 400000.0, 350000.0
    }; 
  
    private String name_feature[] = {
        "Home", "Date", "Profile", "Balance"
    };

    private String navigation[] = {
        "homeicon.png", "dateicon.png", "profileicon.png", "balanceicon.png", "historyicon.png"
    };

    private String navigate[] = {
        "Home", "Date", "Profile", "Balance", "History"
    };

    Color headerColor = new Color(6, 40, 61);
    Color bgColor = new Color(223, 246, 255);

    ImageIcon logo = new ImageIcon("src/assets/logokai.png");
    ImageIcon moreButton = new ImageIcon("src/assets/moreinfobutton.png");

    public static void main(String[] args) {
        new TrainPageWindow(1, "test");
    }

    TrainPageWindow(int idx, String date){

        index = idx;

        panel.setLayout(new GridLayout(5 ,1));
        labelHead.setFont(new Font("Times New Roman", Font.BOLD, 50));
        labelHead.setForeground(Color.WHITE);
        panelHead.setBackground(headerColor);
        panelHead.add(labelHead);

        this.setLayout(new GridLayout());

        for (int i = 0; i < trainName.length; i++){
            JPanel bgPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel destinationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel logoPanel = new JLabel(logo);
            JPanel moreButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,50, 20));
            JPanel trainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel destinationLabel = new JLabel();
            JLabel label = new JLabel();
            JLabel priceLabel = new JLabel();

            JPanel panel_date = new JPanel(); 
            JLabel label_date = new JLabel(); 
            
            bgPanel.setBackground(bgColor);
            destinationPanel.setBackground(bgColor);
            logoPanel.setBackground(bgColor);
            moreButtonPanel.setBackground(bgColor);
            trainPanel.setBackground(bgColor);

            String tempText = trainName[i];
            label.setText(tempText);
            label.setFont(new Font("Times New Roman", Font.BOLD, 20));
            label.setPreferredSize(new Dimension(300, 25));
            trainPanel.setPreferredSize(new Dimension(300, 200));
            trainPanel.add(label);
            trainPanel.add(logoPanel);

            String dest = destination[i] + "  →  " + destination[(destination.length-1 - i)/(i+1)];
            destinationLabel.setText(dest);
            destinationLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            destinationLabel.setVerticalAlignment(JLabel.NORTH);
            destinationLabel.setHorizontalAlignment(JLabel.CENTER);
            destinationLabel.setPreferredSize(new Dimension(400, 150));

            destinationPanel.add(destinationLabel);
            // destinationPanel.setBackground(Color.red);
            bgPanel.add(trainPanel);
            bgPanel.add(destinationPanel);
            // bgPanel.setBackground(Color.BLUE);

            label_date.setText(date);
            label_date.setVerticalAlignment(JLabel.CENTER);
            label_date.setFont(new Font("Times New Roman", Font.BOLD, 20));
            panel_date.add(label_date);
            panel_date.setBackground(bgColor);
            panel_date.setPreferredSize(new Dimension(400, 50));
            
            panelContainer.add(bgPanel);
            
            // panelContainer.setBackground(Color.RED);
            JButton moreBtn = new JButton(moreButton);
            moreBtn.setPreferredSize(new Dimension(100, 40));
            moreBtn.setText(textButton[i]);
            moreBtn.setFont(new Font("Times New Roman", Font.PLAIN, 1));
            moreBtn.addActionListener(this);
            moreBtn.setFocusable(false);
            
            priceLabel.setText("Rp" + price[i].toString());
            priceLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

            moreButtonPanel.add(panel_date);
            moreButtonPanel.add(priceLabel);
            moreButtonPanel.add(moreBtn);
            // moreButtonPanel.setBackground(Color.red);
            panelContainer.add(moreButtonPanel);
        }
    
        for (int i = 0; i < 5; i++){
            ImageIcon navIcon = new ImageIcon("src/assets/" + navigation[i]);
            JButton navButton = new JButton(); 
            navButton.setIcon(navIcon);
            navButton.setText(navigate[i]);
            navButton.setPreferredSize(new Dimension(100, 100));
            navButton.setFont(new Font("Times New Roman", Font.PLAIN, 1));
            navButton.setBackground(Color.WHITE);
            navButton.setFocusable(false);
            navButton.addActionListener(this);
            panel.add(navButton);
        }

        this.setLayout(new BorderLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.add(panel,BorderLayout.WEST);
        this.add(panelHead, BorderLayout.NORTH);
        this.add(panelContainer, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton btn){
            if(btn.getText() == "Home"){
                dispose();
                new HomePageWindow(new Database(), index); 
            }
            else if(btn.getText() == "Balance"){
                dispose(); 
                new TopUpWindow(new Database(), index);
            }
            else if(btn.getText() == "History"){
                new HistoryWindow(index); 
            }
            else{ 
                for(int i = 0; i<textButton.length; i++){
                    if(btn.getText().equals(textButton[i])){
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
                                    new TopUpWindow(new Database(), index);
                                }
                                else{
                                    for(int i = 3; i>=0; i--){
                                        String PIN = JOptionPane.showInputDialog(null,"Input Your pin");
                                        if(PIN == null){
                                            return; 
                                        }
                                        if(new Register().checkValidPinEnter(PIN, index)){
                                            JOptionPane.showMessageDialog(null, "successfull buy your ticket");
                                            new History(trainName[inner], price[inner],destination[(destination.length - 1-inner)/(inner+1)], destination[inner], "1").insert_history(index);
                                            Double remaining_balance = Database.user.get(index).getBalance();  
                                            Database.user.get(index).setBalance(remaining_balance - price[inner]);

                                            for(int j = 0; j<Database.user.get(index).history.size(); j++){
                                                if(Database.user.get(index).history.get(j).get_transportation_name().equals(trainName[inner])){
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
                            "Plane        : " + trainName[i] + "\n" + 
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
