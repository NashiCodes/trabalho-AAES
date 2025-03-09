package org.nashi.devices.states;

import org.nashi.devices.entities.Device;

public abstract class DeviceState {
    public abstract String getState(Device device);


    public String turnOff(Device device) {
        throw new RuntimeException("Cannot change state to off");
    }

    public String turnOn(Device device) {
        throw new RuntimeException("Cannot change state to on");
    }

    public String NormalModeLight(Device device) {
        throw new RuntimeException("Cannot change state to Normal Mode Light");
    }

    public String EcoModeLight(Device device) {
        throw new RuntimeException("Cannot change state to Eco Mode Light");
    }

    public String RainbowModeLight(Device device) {
        throw new RuntimeException("Cannot change state to Rainbow Mode Light");
    }

    public String NormalModeThermostat(Device device) {
        throw new RuntimeException("Cannot change state to Normal Mode Thermostat");
    }

    public String EcoModeThermostat(Device device) {
        throw new RuntimeException("Cannot change state to Eco Mode Thermostat");
    }

    public String HighModeThermostat(Device device) {
        throw new RuntimeException("Cannot change state to High Mode Thermostat");
    }

    public String LowModeThermostat(Device device) {
        throw new RuntimeException("Cannot change state to Low Mode Thermostat");
    }

    public String TurboModeThermostat(Device device) {
        throw new RuntimeException("Cannot change state to Turbo Mode Thermostat");
    }

    public String SelfCleaningModeVacuum(Device device) {
        throw new RuntimeException("Cannot change state to Auto Cleaning Mode Vacuum");
    }

    public String QuietModeVacuum(Device device) {
        throw new RuntimeException("Cannot change state to Quiet Cleaning Mode Vacuum");
    }

    public String SpotModeVacuum(Device device) {
        throw new RuntimeException("Cannot change state to Turbo Cleaning Mode Vacuum");
    }

    public String NormalModeVacuum(Device device) {
        throw new RuntimeException("Cannot change state to Normal Mode Vacuum");
    }
}
