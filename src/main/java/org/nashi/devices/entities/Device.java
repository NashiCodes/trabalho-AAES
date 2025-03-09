package org.nashi.devices.entities;

import org.nashi.devices.controllers.DeviceController;
import org.nashi.devices.states.DeviceState;
import org.nashi.macros.Command;

import java.util.ArrayList;
import java.util.List;

public abstract class Device {
    private final List<Command> commands = new ArrayList<>();
    private String name;
    private DeviceState state;

    public Device(String name) {
        this.name = name;
    }

    public String addCommand(Command command) {
        commands.add(command);
        return "Command added: " + command.getName();
    }

    public String executeCommand(Command command, DeviceController controller) {
        return command.execute(this);
    }

    public List<Command> getCommands() {
        return commands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String turnOff() {
        return "Command Not Found";
    }

    public String turnOn() {
        return "Command Not Found";
    }

    public DeviceState getState() {
        return state;
    }

    public void setState(DeviceState state) {
        this.state = state;
    }
}

