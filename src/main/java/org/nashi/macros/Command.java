package org.nashi.macros;

import org.nashi.devices.entities.Device;

public interface Command {
    String getName();

    String execute(Device device);
}
