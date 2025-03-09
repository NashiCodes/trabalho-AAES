package org.nashi.devices.states.smartlight;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class SmartLightOn extends DeviceState {
    public static final SmartLightOn INSTANCE = new SmartLightOn();

    public static SmartLightOn getInstance() {
        return INSTANCE;
    }

    @Override
    public String getState(Device device) {
        return device.getName() + " is on please select a mode";
    }

    @Override
    public String turnOff(Device device) {
        device.setState(SmartLightOff.getInstance());
        return device.getName() + " turned off";
    }

    @Override
    public String RainbowModeLight(Device device) {
        device.setState(RainbowModeLight.getInstance());
        return device.getName() + " is running Rainbow Mode (color gradient)";
    }

    @Override
    public String EcoModeLight(Device device) {
        device.setState(EcoModeLight.getInstance());
        return device.getName() + " is running Eco Mode (color white, low brightness)";
    }

    @Override
    public String NormalModeLight(Device device) {
        device.setState(NormalModeLight.getInstance());
        return device.getName() + " is running Normal Mode (color on, medium brightness)";
    }
}
