package org.nashi.devices.states.thermostat;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class ThermostatOff extends DeviceState {
    private static final ThermostatOff INSTANCE = new ThermostatOff();

    private ThermostatOff() {
        this.DefaultMessage = "is now off.";
    }

    public static ThermostatOff getInstance() {
        return INSTANCE;
    }

    @Override
    public void turnOn(Device device) {
        var instance = ThermostatOn.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }
}
