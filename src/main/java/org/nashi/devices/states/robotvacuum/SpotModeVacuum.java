package org.nashi.devices.states.robotvacuum;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class SpotModeVacuum extends DeviceState {
    private static final SpotModeVacuum INSTANCE = new SpotModeVacuum();

    private SpotModeVacuum() {
        this.DefaultMessage = "is now in spot mode.";
    }

    public static SpotModeVacuum getInstance() {
        return INSTANCE;
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
