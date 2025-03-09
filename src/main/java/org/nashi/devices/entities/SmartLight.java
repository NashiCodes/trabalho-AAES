package org.nashi.devices.entities;

import org.nashi.devices.states.smartlight.SmartLightOff;

import java.util.ArrayList;
import java.util.List;

public class SmartLight extends Device {
    private String Color;
    private int Brightness;
    private List<String> ColorOptions;

    public SmartLight(String name) {
        super(name);
    }

    @Override
    protected void setDefaultSettings() {
        this.setState(SmartLightOff.getInstance());
        this.ColorOptions = new ArrayList<>() {
            {
                add("Red");
                add("Green");
                add("Blue");
                add("White");
                add("Yellow");
                add("Purple");
                add("Orange");
                add("Pink");
            }
        };

        this.Color = "White";
        this.Brightness = 50;


    }

    @Override
    public String toString() {
        return "Smart Light: " + this.getName() + "\n" +
                "Color: " + this.Color + "\n" +
                "Brightness: " + this.Brightness + "\n";
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public List<String> getColorOptions() {
        return ColorOptions;
    }

    public void setColorOptions(List<String> colorOptions) {
        ColorOptions = colorOptions;
    }

    public int getBrightness() {
        return Brightness;
    }

    public void setBrightness(int brightness) {
        Brightness = brightness;
    }
}
