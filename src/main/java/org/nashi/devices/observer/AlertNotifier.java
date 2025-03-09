package org.nashi.devices.observer;

import org.nashi.devices.entities.Device;

public class AlertNotifier implements DeviceObserver {
    private String LastMessage = "";

    @Override
    public void update(Device device, String message) {
        if (!message.equals(LastMessage)) {
            this.LastMessage = "[ALERTA] " + device.getName() + ": " + message;
        }
    }

    public String getLastMessage() {
        return LastMessage;
    }
}
