package org.nashi.devices.states.robotvacuum;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class NormalModeVacuum extends DeviceState {
    private static final NormalModeVacuum INSTANCE = new NormalModeVacuum();

    private NormalModeVacuum() {
        this.DefaultMessage = "is now in normal mode. (Cleaning all rooms)";
    }

    public static NormalModeVacuum getInstance() {
        return INSTANCE;
    }

    @Override
    public void turnOff(Device device) {
        var instance = RobotVacuumOff.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }

    @Override
    public void SpotModeVacuum(Device device) {
        device.setState(SpotModeVacuum.getInstance());
        device.notifyObservers(device.getState().getMessage(device));
    }

    @Override
    public void QuietModeVacuum(Device device) {
        device.setState(QuietModeVacuum.getInstance());
        device.notifyObservers(device.getState().getMessage(device));
    }

    @Override
    public void SelfCleaningModeVacuum(Device device) {
        device.setState(SelfCleaningModeVacuum.getInstance());
        device.notifyObservers(device.getState().getMessage(device));
    }
}
