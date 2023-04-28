import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.w3c.dom.UserDataHandler;

public class History {
    private String transportation_name;
    private Double ticket_price; 
    private String Arrival;
    private String Departure;
    private String date;
    private ArrayList<PassengerSubmitWindow> user_booking = new ArrayList<>();

    // setter 
    public History(String name, Double Price, String arrived, String departure, String date){ 
        this.transportation_name = name;
        this.ticket_price = Price;
        this.Arrival = arrived; 
        this.Departure = departure;
        this.date = date;
    }
    
    public History(){};//this is for empty contructor
    int get_passager_lenght(){
        return user_booking.size(); 
    }
    ArrayList<PassengerSubmitWindow> get_array_passanger(){
        return user_booking;
    }
    String get_plane_name(){
        return transportation_name;
    }
    
    void insert_history_booking(int index_user, int index_history, PassengerSubmitWindow passager){
        Database.user.get(index_user).history.get(index_history).user_booking.add(passager);
    }

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

                ArrayList <PassengerSubmitWindow> temp1 = Database.user.get(index).history.get(i).get_array_passanger();
                for(int j = 0; j<Database.user.get(index).history.get(i).get_passager_lenght(); j++){  
                    System.out.println(temp1.get(j).name);
                    System.out.println(temp1.get(j).age);
                    System.out.println(temp1.get(j).passportNum);
                    System.out.println(temp1.get(j).NIN);
                    System.out.println(temp1.get(j).gender);
                }
                System.out.println("next person");
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null,"You Dont Have Any Record Before");
        }
    }

    // getter
}
