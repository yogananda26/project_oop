import java.util.Properties;

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
    void insert_history(int index){ 
        Database.user.get(index).history.add(this);
    }

    // getter
    
}
