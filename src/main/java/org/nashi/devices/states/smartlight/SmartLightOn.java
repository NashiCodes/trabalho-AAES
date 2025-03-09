package org.nashi.devices.states.smartlight;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class SmartLightOn extends DeviceState {
    public static final SmartLightOn INSTANCE = new SmartLightOn();

    private SmartLightOn() {
        this.DefaultMessage = "is on please select a mode.";
    }

    public static SmartLightOn getInstance() {
        return INSTANCE;
    }

    @Override
    public void turnOff(Device device) {
        var instance = SmartLightOff.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }

    @Override
    public void RainbowModeLight(Device device) {
        var instance = RainbowModeLight.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }

    @Override
    public void EcoModeLight(Device device) {
        var instance = EcoModeLight.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }

    @Override
    public void NormalModeLight(Device device) {
        var instance = NormalModeLight.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }
}
