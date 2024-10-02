
public class Thermostat extends Device {

    private int temperature;

    public Thermostat(int id) {
        super(id, "Thermostat");
        this.temperature = 70; // Default temperature
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        Logger.log("Thermostat " + id + " set to " + temperature + " degrees.");
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void turnOn() {
        status = true;
        Logger.log("Thermostat " + id + " turned On.");
    }

    @Override
    public void turnOff() {
        status = false;
        Logger.log("Thermostat " + id + " turned Off.");
    }
}
