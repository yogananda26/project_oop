import javax.xml.crypto.Data;

public class Register {

    int userSize = Database.user.size();
    private int idx = 0;

    public static void main(String[] args) {
        new RegisterWindow();
    }

    boolean checkValidEmail(String email) {
        if (email.contains("@gmail.com")) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkValidFullName(String fullName) {
        for (char c : fullName.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    boolean checkValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        return true;
    }

    boolean checkValidConfirm(String password, String confirm) {
        if (confirm.equals(password)) {
            return true;
        }
        return false;
    }

    boolean checkValidUsername(String username) {
        for (int i = 0; i < userSize; i++) {
            if (username.equals(Database.user.get(i).getUsername())) {
                return false;
            }
        }
        return true;
    }

    boolean checkValidPIN(String PIN) {
        if (PIN.length() < 6) {
            return false;
        }
        for (char c : PIN.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }

    boolean checkValidPinEnter(String PIN, int index) {
        if (Database.user.get(index).getPIN().equals(PIN)) {
            return true;
        }
        return false;
    }

    boolean checkValidPhone(String phone) {
        for (char c : phone.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                return false;
            }
        }
        if (phone.length() < 11 || phone.length() > 13) {
            return false;
        }
        return true;
    }

    public void addUser(String fullName, String email, String password, String username, String gender, String PIN,
            String phone) {
        User users = new User(fullName, username, email, password, PIN, gender, phone, 0.0);
        Database.user.add(users);
    }

    int login(String email, String password) {
        for (int i = 0; i < userSize; i++) {
            if (Database.user.get(i).getEmail().equals(email) && Database.user.get(i).getPassword().equals(password)) {
                return i;
            }
        }
        return -1;
    }

    boolean checkValidAmount(String amount) {
        for (char c : amount.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }

    boolean checkAddBalancePIN(String PIN, String amount, int idx) {
        if (Database.user.get(idx).getPIN().equals(PIN)) {
            Long addAmount = Long.parseLong(amount);
            addUserAmount(addAmount, idx);
            return true;
        }
        return false;
    }

    int getUseridx() {
        return idx;
    }

    void addUserAmount(Long addAmount, int idx) {
        Double temp = Database.user.get(idx).getBalance();
        Database.user.get(idx).setBalance(temp + addAmount);
    }

    // int getIdx(){
    // return idx;
    // }
}
