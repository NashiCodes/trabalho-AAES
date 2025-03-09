package org.nashi.devices.states.robotvacuum;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class RobotVacuumOn extends DeviceState {
    private static final RobotVacuumOn INSTANCE = new RobotVacuumOn();

    private RobotVacuumOn() {
        this.DefaultMessage = "is on, please select a mode.";
    }

    public static RobotVacuumOn getInstance() {
        return INSTANCE;
    }

    @Override
    public String getState(Device device) {
        return device.getName() + " is on, please select a mode.";
    }

    @Override
    public void turnOff(Device device) {
        var instance = RobotVacuumOff.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }

    @Override
    public void NormalModeVacuum(Device device) {
        var instance = NormalModeVacuum.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }

    @Override
    public void SpotModeVacuum(Device device) {
        var instance = SpotModeVacuum.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }

    @Override
    public void QuietModeVacuum(Device device) {
        var instance = QuietModeVacuum.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }

    @Override
    public void SelfCleaningModeVacuum(Device device) {
        var instance = SelfCleaningModeVacuum.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }
}
