package org.nashi.devices.states.smartlight;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class SmartLightOff extends DeviceState {
    public static final SmartLightOff INSTANCE = new SmartLightOff();

    private SmartLightOff() {
        this.DefaultMessage = "is off";
    }

    public static SmartLightOff getInstance() {
        return INSTANCE;
    }

    @Override
    public void turnOn(Device device) {
        var instance = SmartLightOn.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }
}
