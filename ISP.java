public interface ProximityDoorCallback {
    void proximityCallback();
}
public interface TimedDoorCallback {
    void timeOutCallback();
}
public interface LockableAndOpenableDoor {
    void lock();
    void unlock();
    void open();
    void close();
}
public class Sensor {
    public void register(ProximityDoorCallback door) {
        
    }

    public boolean isPersonClose() {
        
        return false;
    }
}
public class Timer {
    public void register(long timeOut, TimedDoorCallback door) {
        
    }
}
public class SensingDoor implements LockableAndOpenableDoor, ProximityDoorCallback {
    private boolean _locked;
    private boolean _opened;
    private Sensor sensor;

    public SensingDoor(Sensor sensor) {
        this.sensor = sensor;
        this.sensor.register(this);
        _locked = true;
        _opened = false;
    }

    @Override
    public void lock() {
        _locked = true;
        System.out.println("SensingDoor is locked.");
    }

    @Override
    public void unlock() {
        _locked = false;
        System.out.println("SensingDoor is unlocked.");
    }

    @Override
    public void open() {
        if (!_locked) {
            _opened = true;
            System.out.println("SensingDoor is opened.");
        } else {
            System.out.println("Cannot open, SensingDoor is locked.");
        }
    }

    @Override
    public void close() {
        _opened = false;
        System.out.println("SensingDoor is closed.");
    }

    @Override
    public void proximityCallback() {
        if (sensor.isPersonClose()) {
            unlock();
            open();
        } else {
            close();
            lock();
        }
    }
}
public class TimedDoor implements LockableAndOpenableDoor, TimedDoorCallback {
    public static final int TIME_OUT = 5000; 
    private boolean _locked;
    private boolean _opened;
    private Timer timer;

    public TimedDoor(Timer timer) {
        this.timer = timer;
        this.timer.register(TIME_OUT, this);
        _locked = true;
        _opened = false;
    }

    @Override
    public void lock() {
        _locked = true;
        System.out.println("TimedDoor is locked.");
    }

    @Override
    public void unlock() {
        _locked = false;
        System.out.println("TimedDoor is unlocked.");
    }

    @Override
    public void open() {
        if (!_locked) {
            _opened = true;
            System.out.println("TimedDoor is opened.");
        } else {
            System.out.println("Cannot open, TimedDoor is locked.");
        }
    }

    @Override
    public void close() {
        _opened = false;
        System.out.println("TimedDoor is closed.");
    }

    @Override
    public void timeOutCallback() {
        if (_opened) {
            close();
            lock();
        }
    }
}
