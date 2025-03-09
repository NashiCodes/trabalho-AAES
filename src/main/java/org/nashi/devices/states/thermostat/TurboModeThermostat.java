package org.nashi.devices.states.thermostat;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class TurboModeThermostat extends DeviceState {
    private static final TurboModeThermostat INSTANCE = new TurboModeThermostat();

    private TurboModeThermostat() {
        this.DefaultMessage = "is now in turbo mode.";
    }

    public static TurboModeThermostat getInstance() {
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
    public void LowModeThermostat(Device device) {
        var instance = LowModeThermostat.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }
}
