package org.nashi.devices.states.thermostat;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class EcoModeThermostat extends DeviceState {
    private static final EcoModeThermostat INSTANCE = new EcoModeThermostat();

    private EcoModeThermostat() {
        this.DefaultMessage = "is now in eco mode.";
    }

    public static EcoModeThermostat getInstance() {
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
