package org.nashi.devices.entities.invalid_devices;

public class TestDeviceNoConstructorArg {
    private String name;


    public TestDeviceNoConstructorArg() {
        this.name = "Random Name";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
