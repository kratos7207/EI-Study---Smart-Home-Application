
//Device Interface:
public interface Device {
    void turnOn();
    void turnOff();
    String getStatus();
    int getId();
}
________________________________________
//Light Class:
public class Light implements Device {
    private int id;
    private boolean isOn;

    public Light(int id) {
        this.id = id;
        this.isOn = false;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Light " + id + " is turned ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Light " + id + " is turned OFF.");
    }

    @Override
    public String getStatus() {
        return "Light " + id + " is " + (isOn ? "On" : "Off");
    }

    @Override
    public int getId() {
        return id;
    }
}
________________________________________
//Thermostat Class:
public class Thermostat implements Device {
    private int id;
    private int temperature;

    public Thermostat(int id, int initialTemp) {
        this.id = id;
        this.temperature = initialTemp;
    }

    @Override
    public void turnOn() {
        System.out.println("Thermostat " + id + " is ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("Thermostat " + id + " is OFF.");
    }

    @Override
    public String getStatus() {
        return "Thermostat " + id + " is set to " + temperature + " degrees.";
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat " + id + " temperature set to " + temperature);
    }

    @Override
    public int getId() {
        return id;
    }
}
________________________________________
//DoorLock Class:
public class DoorLock implements Device {
    private int id;
    private boolean isLocked;

    public DoorLock(int id) {
        this.id = id;
        this.isLocked = true;
    }

    @Override
    public void turnOn() {
        isLocked = false;
        System.out.println("Door " + id + " is UNLOCKED.");
    }

    @Override
    public void turnOff() {
        isLocked = true;
        System.out.println("Door " + id + " is LOCKED.");
    }

    @Override
    public String getStatus() {
        return "Door " + id + " is " + (isLocked ? "Locked" : "Unlocked");
    }

    @Override
    public int getId() {
        return id;
    }
}
________________________________________
//DeviceFactory Class (Factory Method):
public class DeviceFactory {
    public static Device createDevice(String type, int id) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id, 72); // Default temperature
            case "door":
                return new DoorLock(id);
            default:
                throw new IllegalArgumentException("Unknown device type.");
        }
    }
}
________________________________________
//DeviceProxy Class (Proxy Pattern):
public class DeviceProxy implements Device {
    private Device realDevice;
    private boolean isAuthorized;

    public DeviceProxy(Device realDevice, boolean isAuthorized) {
        this.realDevice = realDevice;
        this.isAuthorized = isAuthorized;
    }

    @Override
    public void turnOn() {
        if (isAuthorized) {
            realDevice.turnOn();
        } else {
            System.out.println("Unauthorized access to device " + realDevice.getId());
        }
    }

    @Override
    public void turnOff() {
        if (isAuthorized) {
            realDevice.turnOff();
        } else {
            System.out.println("Unauthorized access to device " + realDevice.getId());
        }
    }

    @Override
    public String getStatus() {
        return realDevice.getStatus();
    }

    @Override
    public int getId() {
        return realDevice.getId();
    }
}
________________________________________
//SmartHomeHub Class (Observer Pattern):
import java.util.ArrayList;
import java.util.List;

public class SmartHomeHub {
    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device device) {
        devices.add(device);
        System.out.println("Device added: " + device.getStatus());
    }

    public void removeDevice(int id) {
        devices.removeIf(device -> device.getId() == id);
        System.out.println("Device with ID " + id + " removed.");
    }

    public void turnOnDevice(int id) {
        Device device = getDeviceById(id);
        if (device != null) {
            device.turnOn();
            notifyDevices();
        }
    }

    public void turnOffDevice(int id) {
        Device device = getDeviceById(id);
        if (device != null) {
            device.turnOff();
            notifyDevices();
        }
    }

    public void showAllStatuses() {
        for (Device device : devices) {
            System.out.println(device.getStatus());
        }
    }

    private void notifyDevices() {
        System.out.println("Notifying all devices of changes...");
        // In a more complex system, this would propagate updates to dependent devices.
    }

    private Device getDeviceById(int id) {
        return devices.stream().filter(device -> device.getId() == id).findFirst().orElse(null);
    }
}
________________________________________
//Main Class (for testing):
public class Main {
    public static void main(String[] args) {
        // Initialize the smart home hub
        SmartHomeHub hub = new SmartHomeHub();

        // Create devices using the factory
        Device light1 = DeviceFactory.createDevice("light", 1);
        Device thermostat1 = DeviceFactory.createDevice("thermostat", 2);
        Device door1 = DeviceFactory.createDevice("door", 3);

        // Add devices to the hub
        hub.addDevice(light1);
        hub.addDevice(thermostat1);
        hub.addDevice(door1);

        // Turn on a light
        hub.turnOnDevice(1);

        // Show status of all devices
        hub.showAllStatuses();

        // Create a proxy to control access to the door
        Device doorProxy = new DeviceProxy(door1, true);
        doorProxy.turnOff();  // Lock the door via proxy

        // Show status of all devices
        hub.showAllStatuses();
    }
}

