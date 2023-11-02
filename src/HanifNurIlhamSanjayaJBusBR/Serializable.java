package HanifNurIlhamSanjayaJBusBR;

import java.util.HashMap;

/**
 * Write a description of class Serializable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Serializable {
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();
    public final int id;

    protected Serializable() {
        // Retrieve the class of the current instance
        Class<?> clazz = this.getClass();
        // Get the current serial number or initialize to 0 if not found
        int serial = mapCounter.getOrDefault(clazz, 0);
        // Increment the serial number and update the map
        mapCounter.put(clazz, serial + 1);
        // Assign the serial number as the ID for this instance
        this.id = serial;
    }
    public static <T> Integer setLastAssignedId(Class<T> clazz, int id) {
        return mapCounter.put(clazz, id);
    }

    public static <T> Integer getLastAssignedId(Class<T> clazz) {
        return mapCounter.get(clazz);
    }


    public int compareTo(Serializable other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Serializable) {
            return this.id == ((Serializable)obj).id;
        }
        return false;
    }

    public boolean equals(Serializable other) {
        return this.id == other.id;
    }
}
