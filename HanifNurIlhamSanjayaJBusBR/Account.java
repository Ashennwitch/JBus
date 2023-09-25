package HanifNurIlhamSanjayaJBusBR;


/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Serializable
{
    // instance variables - replace the example below with your own
    public String email;
    public String name;
    public String password;

    /**
     * Constructor for objects of class Account
     */
    public Account(int id, String name, String email, String password) {
        super(id); // Memanggil konstruktor Serializable dengan parameter id
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString() {
        return "Account ID: " + super.id + "%nAccount name: " + name + "%nEmail: " + email + "%nPassword: " + password;
    }
}
