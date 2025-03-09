package org.nashi.devices.states.thermostat;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class HighModeThermostat extends DeviceState {
    private static final HighModeThermostat INSTANCE = new HighModeThermostat();

    public static HighModeThermostat getInstance() {
        return INSTANCE;
    }

    @Override
    public String getState(Device device) {
        return device.getName() + " is running High Mode (temperature set to 25° C)";
    }

    @Override
    public String turnOff(Device device) {
        device.setState(ThermostatOff.getInstance());
        return device.getName() + " is off";
    }

    @Override
    public String TurboModeThermostat(Device device) {
        device.setState(TurboModeThermostat.getInstance());
        return device.getName() + " is running Turbo Mode (temperature set to 30° C)";
    }

    @Override
    public String LowModeThermostat(Device device) {
        device.setState(LowModeThermostat.getInstance());
        return device.getName() + " is running Low Mode (temperature set to 10° C)";
    }

    @Override
    public String EcoModeThermostat(Device device) {
        device.setState(EcoModeThermostat.getInstance());
        return device.getName() + " is running Eco Mode (adjusting the HVAC system to use less power)";
    }

    @Override
    public String NormalModeThermostat(Device device) {
        device.setState(NormalModeThermostat.getInstance());
        return device.getName() + " is running Normal Mode (temperature set to 20° C)";
    }
}
