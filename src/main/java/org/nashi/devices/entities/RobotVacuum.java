package org.nashi.devices.entities;

import org.nashi.devices.states.DeviceState;
import org.nashi.devices.states.robotvacuum.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RobotVacuum extends Device {
    private String Area;
    private int DirtLevel;
    private Map<String, Integer> AreaDirtLevelRate;
    private List<String> Rooms;
    private int NoiseLevel;

    public RobotVacuum(String name) {
        super(name);
    }

    @Override
    protected void setDefaultSettings() {
        this.Area = "All";
        this.DirtLevel = 0;
        this.AreaDirtLevelRate = new HashMap<String, Integer>();
        this.Rooms = List.of("Living Room", "Kitchen", "Bedroom", "Bathroom");
        this.NoiseLevel = 0;

        this.AreaDirtLevelRate.put("Living Room", 5);
        this.AreaDirtLevelRate.put("Kitchen", 10);
        this.AreaDirtLevelRate.put("Bedroom", 15);
        this.AreaDirtLevelRate.put("Bathroom", 20);

        this.setState(RobotVacuumOff.getInstance());
    }

    public List<String> getRooms() {
        return Rooms;
    }

    public void addRoom(String room, int dirtLevel) {
        if (room.isEmpty()) {
            throw new IllegalArgumentException("Room cannot be empty.");
        }
        if (room.isBlank()) {
            throw new IllegalArgumentException("Room cannot be blank.");
        }

        if (dirtLevel < 0 || dirtLevel > 100) {
            throw new IllegalArgumentException("Dirt level must be between 0 and 100.");
        }

        this.Rooms.add(room);
        this.AreaDirtLevelRate.put(room, dirtLevel);

    }

    public void removeRoom(String room) {
        if (room.isEmpty()) {
            throw new IllegalArgumentException("Room cannot be empty.");
        }
        if (room.isBlank()) {
            throw new IllegalArgumentException("Room cannot be blank.");
        }

        this.Rooms.remove(room);
        this.AreaDirtLevelRate.remove(room);
    }

    public void updateRoomDirtLevel(String room, int dirtLevel) {
        if (room.isEmpty()) {
            throw new IllegalArgumentException("Room cannot be empty.");
        }
        if (room.isBlank()) {
            throw new IllegalArgumentException("Room cannot be blank.");
        }

        if (dirtLevel < 0 || dirtLevel > 100) {
            throw new IllegalArgumentException("Dirt level must be between 0 and 100.");
        }

        this.AreaDirtLevelRate.put(room, dirtLevel);
    }

    public int getRoomDirtLevel(String room) {
        if (room.isEmpty()) {
            throw new IllegalArgumentException("Room cannot be empty.");
        }
        if (room.isBlank()) {
            throw new IllegalArgumentException("Room cannot be blank.");
        }

        return this.AreaDirtLevelRate.get(room);
    }

    public void setState(DeviceState state) {
        if (state == NormalModeVacuum.getInstance()) {
            this.Area = "All";
            for (var room : this.AreaDirtLevelRate.keySet()) {
                this.DirtLevel += this.AreaDirtLevelRate.get(room);
            }
            this.NoiseLevel = 50;
        }

        if (state == RobotVacuumOn.getInstance() && this.DirtLevel >= 100) {
            throw new IllegalArgumentException("Cannot turn on the vacuum. Dirt level is too high.");
        }

        if (state == QuietModeVacuum.getInstance()) {
            this.NoiseLevel = 25;
        }

        if (state == SpotModeVacuum.getInstance()) {
            this.DirtLevel += this.AreaDirtLevelRate.get(this.Area);
        }

        if (state == SelfCleaningModeVacuum.getInstance()) {
            this.DirtLevel = 0;
        }

        super.setState(state);
    }

    @Override
    public String toString() {
        return "Dirty Level: " + this.DirtLevel + "\n" +
                "Area to clean: " + this.Area + "\n" +
                "Noise Level: " + this.NoiseLevel + "\n";
    }

    public int getDirtLevel() {
        return DirtLevel;
    }

    public void setDirtLevel(int dirtLevel) {
        DirtLevel = dirtLevel;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }
}
