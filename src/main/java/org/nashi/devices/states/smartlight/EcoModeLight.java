package org.nashi.devices.states.smartlight;

import org.nashi.devices.entities.Device;
import org.nashi.devices.states.DeviceState;

public class EcoModeLight extends DeviceState {
    private static final EcoModeLight INSTANCE = new EcoModeLight();

    public static EcoModeLight getInstance() {
        return INSTANCE;
    }

    @Override
    public String getState(Device device) {
        return device.getName() + " is running Eco Mode (color white, low brightness)";
    }

    @Override
    public String turnOff(Device device) {
        device.setState(SmartLightOff.getInstance());
        return device.getName() + " turned off";
    }

    @Override
    public String turnOn(Device device) {
        device.setState(SmartLightOn.getInstance());
        return device.getName() + " is on but in standby mode (no color)";
    }

    @Override
    public String RainbowModeLight(Device device) {
        device.setState(RainbowModeLight.getInstance());
        return device.getName() + " is running Rainbow Mode (color gradient)";
    }

    @Override
    public String NormalModeLight(Device device) {
        device.setState(NormalModeLight.getInstance());
        return device.getName() + " is running Normal Mode (color on, medium brightness)";
    }
}
