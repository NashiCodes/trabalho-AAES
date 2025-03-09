package org.nashi.devices.controllers;

import org.nashi.devices.entities.Device;
import org.nashi.macros.Command;

public class BluetoothController implements DeviceController {
    private static final BluetoothController INSTANCE = new BluetoothController();

    public BluetoothController getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "BluetoothController";
    }

    @Override
    public String sendCommand(Command command, Device device) {
        var response = device.executeCommand(command, this);
        return "Command sent via Bluetooth: " + command.getName() + " to " + device.getName() + " with response: " + response;
    }

    @Override
    public String addAcepetedDevice(Device device) {
        return "Device " + device.getName() + " successfully connected to Bluetooth";
    }
}
