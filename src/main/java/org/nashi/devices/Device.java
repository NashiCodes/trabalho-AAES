package org.nashi.devices;

public abstract class Device {
    protected DeviceController controller;

    public Device(DeviceController controller) {
        this.controller = controller;
    }

    public abstract void turnOn();

    public abstract void turnOff();
}

