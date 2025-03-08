package org.nashi.devices;

public class WifiController implements DeviceController {
    @Override
    public String sendCommand(String command) {
        return "Wifi command sent: " + command;
    }
}
