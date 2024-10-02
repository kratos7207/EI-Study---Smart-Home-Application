
public class DoorLock extends Device {

    public DoorLock(int id) {
        super(id, "Door Lock");
    }

    @Override
    public void turnOn() {
        status = true;
        Logger.log("Door " + id + " locked.");
    }

    @Override
    public void turnOff() {
        status = false;
        Logger.log("Door " + id + " unlocked.");
    }
}
