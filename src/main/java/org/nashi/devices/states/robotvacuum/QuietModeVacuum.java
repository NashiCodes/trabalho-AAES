package org.nashi.devices.states.robotvacuum;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class QuietModeVacuum extends DeviceState {
    private static final QuietModeVacuum INSTANCE = new QuietModeVacuum();

    private QuietModeVacuum() {
        this.DefaultMessage = "is now in quiet mode. (Cleaning all rooms quietly)";
    }

    public static QuietModeVacuum getInstance() {
        return INSTANCE;
    }

    @Override
    public void turnOff(Device device) {
        var instance = RobotVacuumOff.getInstance();
        device.setState(instance);
        device.notifyObservers(device.getState().getMessage(device));
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
    public void SelfCleaningModeVacuum(Device device) {
        var instance = SelfCleaningModeVacuum.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }
}
