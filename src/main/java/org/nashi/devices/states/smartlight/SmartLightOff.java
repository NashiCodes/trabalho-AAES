package org.nashi.devices.states.smartlight;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class SmartLightOff extends DeviceState {
    public static final SmartLightOff INSTANCE = new SmartLightOff();

    public static SmartLightOff getInstance() {
        return INSTANCE;
    }

    @Override
    public String getState(Device device) {
        return device.getName() + " is off";
    }

    public String turnOn(Device device) {
        device.setState(SmartLightOn.getInstance());
        return device.getName() + " is now on please select a mode";
    }
}
