package org.nashi.devices.observer;

import org.nashi.devices.entities.Device;

public interface DeviceObserver {
    void update(Device device, String message);
}