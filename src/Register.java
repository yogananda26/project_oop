import javax.xml.crypto.Data;

public class Register {

    static Database data = new Database();

    public static void main(String[] args) {
        new RegisterWindow();
    }

    boolean checkValidEmail(String email){
        if (email.contains("@gmail.com")){
            return true;
        } else {
            return false;
        }
    }

    boolean checkValidFullName(String fullName){
        for (char c: fullName.toCharArray()){
            if (Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    boolean checkValidPassword(String password){
        if (password.length() < 8){
            return false;
        } 
        return true;
    }

    boolean checkValidConfirm(String password, String confirm){
        if (confirm.equals(password)){
            return true;
        }
        return false;
    }

    boolean checkValidUsername(String username){
        for (int i = 0; i < data.user.size(); i++){
            if (username.equals(data.user.get(i).getUsername())){
                return false;
            }
        }
        return true;
    }

    boolean checkValidPIN(String PIN){
        if (PIN.length() < 6){
            return false;
        }
        for (char c: PIN.toCharArray()){
            if (Character.isAlphabetic(c)){
                return false;
            }
        }
        return true;
    }

    boolean checkValidPhone(String phone){
        for (char c: phone.toCharArray()){
            if (Character.isAlphabetic(c)){
                return false;
            }
        }
        if (phone.length() < 11 || phone.length() > 13){
            return false;
        }
        return true;
    }

    public void addUser(String fullName, String email, String password, String username, String gender, String PIN, String phone){
        User users = new User(fullName, username, email, password, PIN, gender, phone, 0);
        data.user.add(users);
        System.out.println(data.user.get(0));
    }

    boolean login(String email, String password){
        for (int i = 0; i < data.user.size(); i++){
            if (data.user.get(i).getEmail().equals(email) && data.user.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
