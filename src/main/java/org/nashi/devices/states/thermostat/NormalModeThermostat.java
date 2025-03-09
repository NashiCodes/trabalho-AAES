package org.nashi.devices.states.thermostat;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class NormalModeThermostat extends DeviceState {
    private static final NormalModeThermostat INSTANCE = new NormalModeThermostat();

    private NormalModeThermostat() {
        this.DefaultMessage = "is now in normal mode.";
    }

    public static NormalModeThermostat getInstance() {
        return INSTANCE;
    }

    @Override
    public void turnOff(Device device) {
        var instance = ThermostatOff.getInstance();
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
    public void HighModeThermostat(Device device) {
        var instance = HighModeThermostat.getInstance();
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
