package org.nashi.devices.factories;

import org.nashi.devices.entities.Device;

public class DeviceFactory {

    public static Device createDevice(String deviceType, String deviceName) {
        if (deviceType.isEmpty())
            throw new IllegalArgumentException("Type cannot be empty");
        if (deviceName.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        if (deviceType.isBlank())
            throw new IllegalArgumentException("Type cannot be blank");
        if (deviceName.isBlank())
            throw new IllegalArgumentException("Name cannot be blank");

        Object device = null;
        try {
            var deviceClass = Class.forName("org.nashi.devices.entities." + deviceType);
            device = deviceClass.getDeclaredConstructor(String.class).newInstance(deviceName);

        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("The device do not have a constructor with no parameters");
        } catch (Exception e) {
            throw new IllegalArgumentException("Device type not found");
        }

        if (!(device instanceof Device))
            throw new IllegalArgumentException("The type is not a valid device");

        return (Device) device;

    }
}
