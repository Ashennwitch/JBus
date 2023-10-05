package HanifNurIlhamSanjayaJBusBR;

import java.util.HashMap;

/**
 * Write a description of class Serializable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Serializable implements Comparable<Serializable>
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();

    protected Serializable(int id)
    {
        this.id = id;
        Class<?> clazz = this.getClass();
        if (!mapCounter.containsKey(clazz) || id >= mapCounter.get(clazz)) {
            mapCounter.put(clazz, id + 1);
        }
    }

    public static <T> void setLastAssignedId(Class<T> clazz, int lastId) {
        mapCounter.put(clazz, lastId);
    }

    public static <T> Integer getLastAssignedId(Class<T> clazz) {
        return mapCounter.get(clazz);
    }

    @Override
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
