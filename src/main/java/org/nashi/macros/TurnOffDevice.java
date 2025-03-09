package org.nashi.macros;

import org.nashi.devices.entities.Device;

public class TurnOffDevice implements Command {
    private static final TurnOffDevice INSTANCE = new TurnOffDevice();
    private final String Name;

    private TurnOffDevice() {
        this.Name = "TurnOffDevice";
    }

    public static TurnOffDevice getInstance() {
        return INSTANCE;
    }


    @Override
    public String getName() {
        return Name;
    }

    @Override
    public String execute(Device device) {
        device.turnOff();
        return "Device " + device.getName() + " turned off";
    }
}
