package org.nashi.macros;

import org.nashi.devices.entities.Device;

public class TurnOnDevice implements Command {
    private static final TurnOnDevice INSTANCE = new TurnOnDevice();
    private final String Name;

    private TurnOnDevice() {
        this.Name = "TurnOnDevice";
    }

    public static TurnOnDevice getInstance() {
        return INSTANCE;
    }


    @Override
    public String getName() {
        return Name;
    }

    @Override
    public String execute(Device device) {
        device.turnOn();
        return "Device " + device.getName() + " turned on";
    }
}
