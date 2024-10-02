
public class DeviceFactory {

    public Device createDevice(String type, int id) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id);
            case "door lock":
                return new DoorLock(id);
            default:
                throw new IllegalArgumentException("Unknown device type.");
        }
    }
}
