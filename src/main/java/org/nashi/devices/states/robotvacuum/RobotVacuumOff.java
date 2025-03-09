package org.nashi.devices.states.robotvacuum;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class RobotVacuumOff extends DeviceState {
    private static final RobotVacuumOff INSTANCE = new RobotVacuumOff();

    private RobotVacuumOff() {
        this.DefaultMessage = "is now off.";
    }

    public static RobotVacuumOff getInstance() {
        return INSTANCE;
    }

    @Override
    public void turnOn(Device device) {
        var instance = RobotVacuumOn.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }

}
