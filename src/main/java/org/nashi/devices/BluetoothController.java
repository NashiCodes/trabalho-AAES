package org.nashi.devices;

public class BluetoothController implements DeviceController {
    @Override
    public String sendCommand(String command) {
        return "Bluetooth command sent: " + command;
    }
}
