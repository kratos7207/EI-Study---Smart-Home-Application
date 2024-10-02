
public class SmartHome {

    public static void main(String[] args) {
        CentralHub centralHub = new CentralHub();

        // Create devices using the Factory Method
        DeviceFactory deviceFactory = new DeviceFactory();
        Device light = deviceFactory.createDevice("light", 1);
        Device thermostat = deviceFactory.createDevice("thermostat", 2);
        Device doorLock = deviceFactory.createDevice("door lock", 3);

        // Add devices to the Central Hub
        centralHub.addDevice(light);
        centralHub.addDevice(thermostat);
        centralHub.addDevice(doorLock);

        // Turn devices on/off
        centralHub.turnDeviceOn(1);
        centralHub.turnDeviceOff(2);

        // Set a schedule for the thermostat
        centralHub.scheduleDevice(2, "06:00", "Turn On");

        // Add an automation trigger
        centralHub.addTrigger("temperature", ">", 75, "turnOff(1)");

        // View status of devices
        centralHub.viewDeviceStatus();
    }
}
