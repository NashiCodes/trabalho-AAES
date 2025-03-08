package org.nashi.home;

public class NetworkSettings {
    private String wifiSSID;
    private String bluetoothMAC;

    public NetworkSettings(String wifiSSID, String bluetoothMAC) {
        this.wifiSSID = wifiSSID;
        this.bluetoothMAC = bluetoothMAC;
    }

    public String getWifiSSID() {
        return wifiSSID;
    }

    public void setWifiSSID(String wifiSSID) {
        this.wifiSSID = wifiSSID;
    }

    public String getBluetoothMAC() {
        return bluetoothMAC;
    }

    public void setBluetoothMAC(String bluetoothMAC) {
        this.bluetoothMAC = bluetoothMAC;
    }
}
