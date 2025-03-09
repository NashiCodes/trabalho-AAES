package org.nashi.devices.states;

import org.nashi.devices.entities.Device;

public abstract class DeviceState {
    protected String DefaultMessage = "This device is in an unknown state.";

    public String getState(Device device) {
        return this.getMessage(device);
    }

    public String getMessage(Device device) {
        return device.getName() + this.DefaultMessage + "\n" +
                device + "\n";
    }

    public void turnOff(Device device) {
        throw new RuntimeException("Cannot change state to off");
    }

    public void turnOn(Device device) {
        throw new RuntimeException("Cannot change state to on");
    }

    public void NormalModeLight(Device device) {
        throw new RuntimeException("Cannot change state to Normal Mode Light");
    }

    public void EcoModeLight(Device device) {
        throw new RuntimeException("Cannot change state to Eco Mode Light");
    }

    public void RainbowModeLight(Device device) {
        throw new RuntimeException("Cannot change state to Rainbow Mode Light");
    }

    public void NormalModeThermostat(Device device) {
        throw new RuntimeException("Cannot change state to Normal Mode Thermostat");
    }

    public void EcoModeThermostat(Device device) {
        throw new RuntimeException("Cannot change state to Eco Mode Thermostat");
    }

    public void HighModeThermostat(Device device) {
        throw new RuntimeException("Cannot change state to High Mode Thermostat");
    }

    public void LowModeThermostat(Device device) {
        throw new RuntimeException("Cannot change state to Low Mode Thermostat");
    }

    public void TurboModeThermostat(Device device) {
        throw new RuntimeException("Cannot change state to Turbo Mode Thermostat");
    }

    public void SelfCleaningModeVacuum(Device device) {
        throw new RuntimeException("Cannot change state to Auto Cleaning Mode Vacuum");
    }

    public void QuietModeVacuum(Device device) {
        throw new RuntimeException("Cannot change state to Quiet Cleaning Mode Vacuum");
    }

    public void SpotModeVacuum(Device device) {
        throw new RuntimeException("Cannot change state to Turbo Cleaning Mode Vacuum");
    }

    public void NormalModeVacuum(Device device) {
        throw new RuntimeException("Cannot change state to Normal Mode Vacuum");
    }
}
