package org.nashi.devices.states.smartlight;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class NormalModeLight extends DeviceState {
    private static final NormalModeLight INSTANCE = new NormalModeLight();

    public static NormalModeLight getInstance() {
        return INSTANCE;
    }

    @Override
    public String getState(Device device) {
        return device.getName() + " is running Normal Mode (color on, medium brightness)";
    }

    @Override
    public String turnOff(Device device) {
        device.setState(SmartLightOff.getInstance());
        return device.getName() + " turned off";
    }

    @Override
    public String EcoModeLight(Device device) {
        device.setState(EcoModeLight.getInstance());
        return device.getName() + " is running Eco Mode (color white, low brightness)";
    }

    @Override
    public String RainbowModeLight(Device device) {
        device.setState(RainbowModeLight.getInstance());
        return device.getName() + " is running Rainbow Mode (color gradient)";
    }
}
