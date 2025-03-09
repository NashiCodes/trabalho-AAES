package org.nashi.devices.states.robotvacuum;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class QuietModeVacuum extends DeviceState {
    private static final QuietModeVacuum INSTANCE = new QuietModeVacuum();

    public static QuietModeVacuum getInstance() {
        return INSTANCE;
    }

    @Override
    public String getState(Device device) {
        return device.getName() + " is now in quiet mode. (Cleaning all rooms quietly)";
    }

    @Override
    public String turnOff(Device device) {
        device.setState(RobotVacuumOff.getInstance());
        return device.getName() + " is now off.";
    }

    @Override
    public String NormalModeVacuum(Device device) {
        device.setState(NormalModeVacuum.getInstance());
        return device.getName() + " is now in normal mode. (Cleaning all rooms)";
    }

    @Override
    public String SpotModeVacuum(Device device) {
        device.setState(SpotModeVacuum.getInstance());
        return device.getName() + " is now in spot mode. (Cleaning a specific area)";
    }

    @Override
    public String SelfCleaningModeVacuum(Device device) {
        device.setState(SelfCleaningModeVacuum.getInstance());
        return device.getName() + " is now in self-cleaning mode. (Cleaning its own dustbin)";
    }
}
