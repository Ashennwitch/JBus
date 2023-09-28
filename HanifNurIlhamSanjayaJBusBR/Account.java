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
    public Account(int id, String name, String email, String password) {
        super(id); // Memanggil konstruktor Serializable dengan parameter id
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public void write() {

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
