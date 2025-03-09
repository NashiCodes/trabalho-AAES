package org.nashi.devices.entities;

import org.nashi.devices.controllers.WifiController;
import org.nashi.macros.TurnOffDevice;
import org.nashi.macros.TurnOnDevice;

public class SmartLight extends Device {

    public SmartLight(String name) {
        super(name);
        addCommand(TurnOnDevice.getInstance());
        addCommand(TurnOffDevice.getInstance());

        WifiController.getInstance().addAcepetedDevice(this);
    }
}
