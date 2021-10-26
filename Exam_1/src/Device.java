import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Device
{
    String name;

    public Device(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                '}';
    }
}
 class DeviceList {
     List<Object> devices;

     void addDevice(Device device) {
         devices.add(device);
     }

     DeviceList() {
         devices = new ArrayList<>();
     }

     public void printAllDevices() {
         for (Object o : devices) {
             System.out.println(o);
         }
     }
 }
class Printer extends  Device
{
    @Override
    public String toString() {
        return "Printer{" +
                "name='" + name + '\'' +
                '}';
    }

    public Printer(String name) {
        super(name);
    }
}
class Scanner extends  Device
{
    @Override
    public String toString() {
        return "Scanner{" +
                "name='" + name + '\'' +
                '}';
    }

    public Scanner(String name) {
        super(name);
    }
}
class TestClass
{
    public static void main(String[] args) {
        DeviceList list = new DeviceList();
        list.addDevice( new Printer("Laser "));
        list.addDevice( new Scanner("Color "));
        list.printAllDevices();
    }
}

