package org.nashi.devices.states.thermostat;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class LowModeThermostat extends DeviceState {
    private static final LowModeThermostat INSTANCE = new LowModeThermostat();

    private LowModeThermostat() {
        this.DefaultMessage = "is now in low mode.";
    }

    public static LowModeThermostat getInstance() {
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
    public void HighModeThermostat(Device device) {
        var instance = HighModeThermostat.getInstance();
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
