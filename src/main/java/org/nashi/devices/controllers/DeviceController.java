package org.nashi.devices.controllers;

import org.nashi.devices.entities.Device;
import org.nashi.macros.Command;

import java.util.ArrayList;
import java.util.List;

public interface DeviceController {
    List<Device> devices = new ArrayList<>();

    String getName();

    String sendCommand(Command command, Device device);

    String addAcepetedDevice(Device device);
}
