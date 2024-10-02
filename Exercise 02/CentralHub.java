
import java.util.*;

public class CentralHub {

    private Map<Integer, Device> devices = new HashMap<>();
    private List<Schedule> schedules = new ArrayList<>();
    private List<Trigger> triggers = new ArrayList<>();

    public void addDevice(Device device) {
        devices.put(device.getId(), device);
        Logger.log(device.getType() + " added with ID: " + device.getId());
    }

    public void turnDeviceOn(int deviceId) {
        Device device = devices.get(deviceId);
        if (device != null) {
            device.turnOn();
        }
    }

    public void turnDeviceOff(int deviceId) {
        Device device = devices.get(deviceId);
        if (device != null) {
            device.turnOff();
        }
    }

    public void scheduleDevice(int deviceId, String time, String action) {
        schedules.add(new Schedule(deviceId, time, action));
        Logger.log("Scheduled " + action + " for device " + deviceId + " at " + time);
    }

    public void addTrigger(String condition, String operator, int value, String action) {
        triggers.add(new Trigger(condition, operator, value, action));
        Logger.log("Added trigger: " + condition + " " + operator + " " + value + ", action: " + action);
    }

    public void viewDeviceStatus() {
        for (Device device : devices.values()) {
            Logger.log(device.getType() + " " + device.getId() + " is " + device.getStatus());
        }
    }
}
