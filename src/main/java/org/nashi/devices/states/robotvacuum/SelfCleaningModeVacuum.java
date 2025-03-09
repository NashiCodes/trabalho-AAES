package org.nashi.devices.states.robotvacuum;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class SelfCleaningModeVacuum extends DeviceState {
    private static final SelfCleaningModeVacuum INSTANCE = new SelfCleaningModeVacuum();

    private SelfCleaningModeVacuum() {
        this.DefaultMessage = "is now in self-cleaning mode. (Cleaning its own dustbin)";
    }

    public static SelfCleaningModeVacuum getInstance() {
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

}
