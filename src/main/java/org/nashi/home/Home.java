package org.nashi.home;

public class Home {
    private NetworkSettings networkSettings;

    public Home(NetworkSettings networkSettings) {
        this.networkSettings = networkSettings;
    }

    public NetworkSettings getNetworkSettings() {
        return networkSettings;
    }

    public void setNetworkSettings(NetworkSettings networkSettings) {
        this.networkSettings = networkSettings;
    }
}
