package hr.fer.oop.midterm_2017_18.task3;
import java.util.Set;


public class Main {
    public static void main(String[] args){
        Set<Device> devices = DBLoader.loadDevices();

        for(Device device : devices){
            if (!device.isPoweredOn()){
                device.switchPower();
            }
            if(device instanceof RemoteAbs){
                RemoteAbs remoteDevice = (RemoteAbs) device;
                remoteDevice.startRemoteSession();
                if(remoteDevice instanceof Fridge){
                    Fridge fridge = (Fridge) remoteDevice;
                    fridge.setTemperature(10);
                }
                if(remoteDevice instanceof Bulb){
                    Bulb bulb = (Bulb) remoteDevice;
                    bulb.setColor(Color.RED);
                }
            }
        }
    }
}
