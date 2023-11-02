package HanifNurIlhamSanjayaJBusBR;


/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Serializable implements FileParser
{
    // instance variables - replace the example below with your own
    public String email;
    public String name;
    public String password;

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

    @Override
    public boolean read(String filename) {
        return false; // Mengembalikan true jika berhasil membaca, false jika gagal
    }
    
    public String toString() {
        return "Account ID: " + super.id + "\n"
            + "Account name: " + name + "\n"
            + "Email: " + email + "\n"
            + "Password: " + password;
    }
}
