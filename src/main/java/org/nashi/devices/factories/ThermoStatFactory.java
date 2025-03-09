package org.nashi.devices.factories;

import org.nashi.devices.entities.Device;
import org.nashi.devices.entities.Thermostat;

public class ThermoStatFactory extends DeviceFactory {
    private static final ThermoStatFactory INSTANCE = new ThermoStatFactory();

    public static ThermoStatFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public Device concreteDevice(String deviceName) {
        var device = new Thermostat(deviceName);
        device.Initialize();
        return device;
    }
}
