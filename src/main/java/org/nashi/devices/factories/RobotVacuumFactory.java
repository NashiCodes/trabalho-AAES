package org.nashi.devices.factories;

import org.nashi.devices.entities.Device;
import org.nashi.devices.entities.RobotVacuum;

public class RobotVacuumFactory extends DeviceFactory {
    private static final RobotVacuumFactory INSTANCE = new RobotVacuumFactory();

    public static RobotVacuumFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public Device concreteDevice(String deviceName) {
        var device = new RobotVacuum(deviceName);
        device.Initialize();
        return device;
    }
}
