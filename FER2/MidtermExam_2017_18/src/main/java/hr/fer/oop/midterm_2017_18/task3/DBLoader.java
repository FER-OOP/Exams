package hr.fer.oop.midterm_2017_18.task3;
import java.util.HashSet;
import java.util.Set;

public class DBLoader {
    public static Set<Device> loadDevices(){
        Set<Device> devices = new HashSet<>();
        devices.add(new Fridge("1", false, 10, false));
        devices.add(new Bulb("2", false, Color.BLUE, false));
        devices.add(new TV("3", false, 32));
        devices.add(new Fridge("4", false, 10, false));

        return devices;
    }
}
