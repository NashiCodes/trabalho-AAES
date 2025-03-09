package org.nashi.devices.factories;

import org.nashi.devices.entities.Device;
import org.nashi.devices.entities.SmartLight;

public class SmartLightFactory extends DeviceFactory {
    private static final SmartLightFactory INSTANCE = new SmartLightFactory();

    public static SmartLightFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public Device concreteDevice(String deviceName) {
        var smartLight = new SmartLight(deviceName);
        smartLight.Initialize();
        return smartLight;
    }
}
