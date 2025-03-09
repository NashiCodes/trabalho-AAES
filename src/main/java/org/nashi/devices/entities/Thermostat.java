package org.nashi.devices.entities;

import org.nashi.devices.states.thermostat.ThermostatOff;

public class Thermostat extends Device {
    private int temperature;
    private int humidity;
    private double comsumption;

    public Thermostat(String name) {
        super(name);
    }

    @Override
    protected void setDefaultSettings() {
        this.temperature = 20;
        this.humidity = 50;
        this.comsumption = 2.0;

        this.setState(ThermostatOff.getInstance());
    }

    @Override
    public String toString() {
        return "Thermostat: " + this.getName() + "\n" +
                "Temperature: " + this.temperature + "\n" +
                "Humidity: " + this.humidity + "\n" +
                "Consumption: " + this.comsumption + "\n";
    }
}
