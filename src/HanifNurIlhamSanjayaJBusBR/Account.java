package HanifNurIlhamSanjayaJBusBR;


/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Serializable {
    // instance variables - replace the example below with your own
    public String email;
    public String name;
    public String password;
    private static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$";
    private static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,}$";

    /**
     * Constructor for objects of class Account
     */
    public Account(String name, String email, String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Object write() {
        return null;
    }

    public String toString() {
        return "Account ID: " + super.id + "\n"
                + "Account name: " + name + "\n"
                + "Email: " + email + "\n"
                + "Password: " + password;
    }

    public boolean validate() {
        return email.matches(REGEX_EMAIL) && password.matches(REGEX_PASSWORD);
    }
}