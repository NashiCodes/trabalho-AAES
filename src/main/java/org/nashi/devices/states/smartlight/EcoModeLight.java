package org.nashi.devices.states.smartlight;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class EcoModeLight extends DeviceState {
    private static final EcoModeLight INSTANCE = new EcoModeLight();

    private EcoModeLight() {
        this.DefaultMessage = "is now in Eco mode. (color white, low brightness)";
    }

    public static EcoModeLight getInstance() {
        return INSTANCE;
    }

    @Override
    public String getState(Device device) {
        return device.getName() + " is running Eco Mode (color white, low brightness)";
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
    public void NormalModeLight(Device device) {
        var instance = NormalModeLight.getInstance();
        device.setState(instance);
        device.notifyObservers(instance.getMessage(device));
    }
}
