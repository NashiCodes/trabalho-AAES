package org.nashi.devices.states.robotvacuum;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class RobotVacuumOff extends DeviceState {
    private static final RobotVacuumOff INSTANCE = new RobotVacuumOff();

    public static RobotVacuumOff getInstance() {
        return INSTANCE;
    }

    @Override
    public String getState(Device device) {
        return device.getName() + " is now off.";
    }

    @Override
    public String turnOn(Device device) {
        device.setState(RobotVacuumOn.getInstance());
        return device.getName() + " is on, please select a mode.";
    }

}
