package Regis;

public class Register {
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

    // boolean checkValidUsername(String username){

    // }

    public void addUser(String fullName, String email, String password, String username, String gender){
        // User user = new User(fullName, email, password, username, gender);
        // User user = new User
    }
}
