package org.nashi.devices.states.smartlight;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class RainbowModeLight extends DeviceState {
    private static final RainbowModeLight INSTANCE = new RainbowModeLight();

    public static RainbowModeLight getInstance() {
        return INSTANCE;
    }

    @Override
    public String getState(Device device) {
        return device.getName() + " is running Rainbow Mode (color gradient)";
    }

    @Override
    public String EcoModeLight(Device device) {
        device.setState(EcoModeLight.getInstance());
        return device.getName() + " is running Eco Mode (low brightness)";
    }

    @Override
    public String NormalModeLight(Device device) {
        device.setState(NormalModeLight.getInstance());
        return device.getName() + " is running Normal Mode (medium brightness)";
    }
}
