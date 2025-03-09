package org.nashi.devices.factories;

import org.nashi.devices.entities.Device;

public abstract class DeviceFactory {

    public Device createDevice(String deviceName) {
        if (deviceName.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        if (deviceName.isBlank())
            throw new IllegalArgumentException("Name cannot be blank");

        return concreteDevice(deviceName);
    }

    public abstract Device concreteDevice(String deviceName);
}
