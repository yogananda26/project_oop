
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
import javax.swing.JPanel;

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
        new TrainPageWindow(1);
    }

    TrainPageWindow(int idx){

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
            JPanel moreButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 50, 5));
            JPanel trainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel destinationLabel = new JLabel();
            JLabel label = new JLabel();
            JLabel priceLabel = new JLabel();
            
            bgPanel.setBackground(bgColor);
            destinationPanel.setBackground(bgColor);
            logoPanel.setBackground(bgColor);
            moreButtonPanel.setBackground(bgColor);
            trainPanel.setBackground(bgColor);

            String tempText = trainName[i];
            label.setText(tempText);
            label.setFont(new Font("Times New Roman", Font.BOLD, 20));
            label.setPreferredSize(new Dimension(250, 25));
            trainPanel.setPreferredSize(new Dimension(250, 200));
            trainPanel.add(label);
            trainPanel.add(logoPanel);

            String dest = destination[i] + "  →  " + destination[(destination.length-1 - i)/(i+1)];
            destinationLabel.setText(dest);
            destinationLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            destinationLabel.setHorizontalAlignment(JLabel.CENTER);
            destinationLabel.setPreferredSize(new Dimension(500, 200));

            destinationPanel.add(destinationLabel);
            bgPanel.add(trainPanel);
            bgPanel.add(destinationPanel);
            bgPanel.setBackground(Color.BLUE);

            panelContainer.add(bgPanel);
            panelContainer.setBackground(Color.RED);
            JButton moreBtn = new JButton(moreButton);
            moreBtn.setPreferredSize(new Dimension(100, 40));
            moreBtn.setText(textButton[i]);
            moreBtn.setFont(new Font("Times New Roman", Font.PLAIN, 1));
            moreBtn.addActionListener(this);
            moreBtn.setFocusable(false);
            
            priceLabel.setText("Rp" + price[i].toString());
            priceLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            moreButtonPanel.add(priceLabel);
            moreButtonPanel.add(moreBtn);
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
            dispose();
            if(btn.getText() == "Home"){
                new HomePageWindow(new Database(), index); 
            }
            else if(btn.getText() == "Balance"){
                new TopUpWindow(new Database(), index);
            }
        }
    }

}
