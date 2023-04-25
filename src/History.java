import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

public class History {
    private String transportation_name;
    private Double ticket_price; 
    private String Arrival;
    private String Departure;
    private String date;

    // setter 
    public History(String name, Double Price, String arrived, String departure, String date){ 
        this.transportation_name = name;
        this.ticket_price = Price;
        this.Arrival = arrived; 
        this.Departure = departure;
        this.date = date;
    }
    public History(){};//this is for empty contructor

    void insert_history(int index){ 
        Database.user.get(index).history.add(this);
    }

    void print_all_history(int index){
        System.out.println("This is your History");
        try {
            ArrayList <History> temp = Database.user.get(index).history;
            for(int i = 0; i<temp.size(); i++){
                System.out.println(temp.get(i).transportation_name);
                System.out.println(temp.get(i).ticket_price);
                System.out.println(temp.get(i).Arrival);
                System.out.println(temp.get(i).Departure);
                System.out.println(temp.get(i).date);
                System.out.println("\n");
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null,"You Dont Have Any Record Before");
        }
    }

    // getter
    
}
