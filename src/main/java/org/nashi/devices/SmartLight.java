package org.nashi.devices;

public class SmartLight extends Device {
    public SmartLight(DeviceController controller) {
        super(controller);
    }

    @Override
    public void turnOn() {
        controller.sendCommand("Turn on");
    }

    @Override
    public void turnOff() {
        controller.sendCommand("Turn off");
    }

    public void changeColor(String color) {
        controller.sendCommand("Change color to " + color);
    }
}
