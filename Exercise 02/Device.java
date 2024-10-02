
public abstract class Device {

    protected int id;
    protected String type;
    protected boolean status;

    public Device(int id, String type) {
        this.id = id;
        this.type = type;
        this.status = false;
    }

    public abstract void turnOn();

    public abstract void turnOff();

    public String getStatus() {
        return (status ? "On" : "Off");
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
