
public class Light extends Device {

    public Light(int id) {
        super(id, "Light");
    }

    @Override
    public void turnOn() {
        status = true;
        Logger.log("Light " + id + " turned On.");
    }

    @Override
    public void turnOff() {
        status = false;
        Logger.log("Light " + id + " turned Off.");
    }
}
