package org.nashi.devices.controllers;

import org.nashi.devices.entities.Device;
import org.nashi.macros.Command;

public class WifiController implements DeviceController {
    private static final WifiController INSTANCE = new WifiController();

    public static WifiController getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "WifiController";
    }

    @Override
    public String sendCommand(Command command, Device device) {
        if (!devices.contains(device)) {
            return "Device not accepted";
        }

        var response = device.executeCommand(command, this);
        return "Command sent via Wifi: " + command.getName() + " to " + device.getName() + " with response: " + response;
    }

    @Override
    public String addAcepetedDevice(Device device) {
        devices.add(device);
        return "Device " + device.getName() + " successfully connected to Wifi";
    }
}
