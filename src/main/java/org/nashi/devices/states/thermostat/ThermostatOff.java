package org.nashi.devices.states.thermostat;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class ThermostatOff extends DeviceState {
    private static final ThermostatOff INSTANCE = new ThermostatOff();

    public static ThermostatOff getInstance() {
        return INSTANCE;
    }

    @Override
    public String getState(Device device) {
        return device.getName() + " is off";
    }

    @Override
    public String turnOn(Device device) {
        device.setState(ThermostatOn.getInstance());
        return device.getName() + " is on and running at 20 degrees Celsius";
    }
}
