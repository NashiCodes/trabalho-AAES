package org.nashi.devices.factories;

import org.nashi.devices.entities.Device;
import org.nashi.devices.entities.ThermoStat;

public class ThermoStatFactory extends DeviceFactory {
    private static final ThermoStatFactory INSTANCE = new ThermoStatFactory();

    public static ThermoStatFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public Device concreteDevice(String deviceName) {
        return new ThermoStat(deviceName);
    }
}
