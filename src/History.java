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
    private ArrayList<Passanger> user_booking = new ArrayList<>();

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
    ArrayList<Passanger> get_array_passanger(){
        return user_booking;
    }
    String get_plane_name(){
        return transportation_name;
    }
    
    int insert_history_booking(int index_user, int index_history, Passanger passager){
        if(Database.user.get(index_user).history.get(index_history).user_booking.add(passager)){
            return 1; 
        }
        return 0;
    }

    void insert_history(int index){ 
        Database.user.get(index).history.add(this);
    }


    String get_transportation_name(){
        return transportation_name;
    }
    String get_arrival(){
        return Arrival;
    }
    String get_departure(){
        return Departure;
    }
    Double get_price(){
        return ticket_price; 
    }
    String get_date(){
        return date; 
    }

   
    // getter
}
