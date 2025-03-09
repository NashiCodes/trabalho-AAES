package org.nashi.devices.states.smartlight;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class NormalModeLight extends DeviceState {
    private static final NormalModeLight INSTANCE = new NormalModeLight();

    private NormalModeLight() {
        this.DefaultMessage = "is now in normal mode. (color on, medium brightness)";
    }

    public static NormalModeLight getInstance() {
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
}
