package org.nashi.devices.entities;

import org.nashi.devices.states.DeviceState;

public abstract class Device {
    private String name;
    private DeviceState state;

    public Device(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String turnOff() {
        throw new RuntimeException("Device Cannot change its state");
    }

    public String turnOn() {
        throw new RuntimeException("Device Cannot change its state");
    }

    public DeviceState getState() {
        return state;
    }

    public void setState(DeviceState state) {
        this.state = state;
    }
}

