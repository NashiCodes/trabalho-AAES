package org.nashi.devices.states.smartlight;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class RainbowModeLight extends DeviceState {
    private static final RainbowModeLight INSTANCE = new RainbowModeLight();

    private RainbowModeLight() {
        this.DefaultMessage = "is now in rainbow mode. (color gradient)";
    }

    public static RainbowModeLight getInstance() {
        return INSTANCE;
    }

    @Override
    public void turnOff(Device device) {
        var instance = SmartLightOff.getInstance();
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
