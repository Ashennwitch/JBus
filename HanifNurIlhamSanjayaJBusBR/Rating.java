package HanifNurIlhamSanjayaJBusBR;


/**
 * Write a description of class Rating here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Rating {
    long count;
    long total;

    public Rating() {
        this.count = 0;
        this.total = 0;
    }
    
    public void insert(int rating) {
        this.total += rating;
        this.count++;
    }
    
    public double getAverage() {
        if (count == 0) {
            return 0.0; // Mengembalikan 0 jika tidak ada rating yang dimasukkan
        }

        return (double) (total / count); 
    }
    
    public long getCount() {
        return count;
    }
    
    public long getTotal() {
        return total;
    }
}
