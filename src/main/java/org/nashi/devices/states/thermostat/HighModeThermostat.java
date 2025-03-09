package org.nashi.devices.states.thermostat;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class HighModeThermostat extends DeviceState {
    private static final HighModeThermostat INSTANCE = new HighModeThermostat();

    private HighModeThermostat() {
        this.DefaultMessage = "is now in high mode.";
    }

    public static HighModeThermostat getInstance() {
        return INSTANCE;
    }

    @Override
    public void turnOff(Device device) {
        var instance = ThermostatOff.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }

    @Override
    public void NormalModeThermostat(Device device) {
        var instance = NormalModeThermostat.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }

    @Override
    public void EcoModeThermostat(Device device) {
        var instance = EcoModeThermostat.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }

    @Override
    public void LowModeThermostat(Device device) {
        var instance = LowModeThermostat.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }

    @Override
    public void TurboModeThermostat(Device device) {
        var instance = TurboModeThermostat.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }
}
