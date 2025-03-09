package org.nashi.devices.entities;

import org.nashi.devices.observer.DeviceObserver;
import org.nashi.devices.states.DeviceState;

import java.util.List;

public abstract class Device {
    private String name;
    private DeviceState state;
    private List<DeviceObserver> observers;

    public Device(String name) {
        this.name = name;
    }

    public final void Initialize() {
        setDefaultSettings();
    }

    protected abstract void setDefaultSettings();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceState getState() {
        return state;
    }

    public void setState(DeviceState state) {
        this.state = state;
    }

    public void attach(DeviceObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        observers.forEach(observer -> observer.update(this, message));
    }

    public abstract String toString();
}

