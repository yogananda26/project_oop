import java.util.ArrayList;

public class User {
    private String fullName;
    private String username;
    private String email;
    private String password;
    private String PIN;
    private String gender;
    private long balance;

    ArrayList <History> history = new ArrayList<>();
    

    public User(String fullName, String username, String email, String password, String PIN, String gender, long balance) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.PIN = PIN;
        this.gender = gender;
        this.balance = balance;
    }
    
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPIN() {
        return PIN;
    }
    public void setPIN(String pIN) {
        PIN = pIN;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public long getBalance() {
        return balance;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }
}
