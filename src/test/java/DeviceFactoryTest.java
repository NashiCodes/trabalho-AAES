import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nashi.devices.factories.RobotVacuumFactory;
import org.nashi.devices.factories.SmartLightFactory;
import org.nashi.devices.factories.ThermoStatFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DeviceFactoryTest {
    SmartLightFactory smartLightFactory;
    ThermoStatFactory thermoStatFactory;
    RobotVacuumFactory robotVacuumFactory;

    @BeforeEach
    public void setUp() {
        smartLightFactory = SmartLightFactory.getInstance();
        thermoStatFactory = ThermoStatFactory.getInstance();
        robotVacuumFactory = RobotVacuumFactory.getInstance();
    }

    @Test
    public void DeveRetornarExcecaoParaNomesVazioSmartLight() {
        try {
            smartLightFactory.createDevice("");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be empty", e.getMessage());
        }
    }

    @Test
    public void DeveRetornarExcecaoParaNomesVazioThermoStat() {
        try {
            thermoStatFactory.createDevice("");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be empty", e.getMessage());
        }
    }

    @Test
    public void DeveRetornarExcecaoParaNomesVazioRobotVacuum() {
        try {
            robotVacuumFactory.createDevice("");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be empty", e.getMessage());
        }
    }

    @Test
    public void DeveRetornarExcecaoParaNomesBrancoSmartLight() {
        try {
            smartLightFactory.createDevice(" ");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be blank", e.getMessage());
        }
    }

    @Test
    public void DeveRetornarExcecaoParaNomesBrancoThermoStat() {
        try {
            thermoStatFactory.createDevice(" ");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be blank", e.getMessage());
        }
    }

    @Test
    public void DeveRetornarExcecaoParaNomesBrancoRobotVacuum() {
        try {
            robotVacuumFactory.createDevice(" ");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be blank", e.getMessage());
        }
    }

    @Test
    public void DeveRetornarSmartLightQuandoNomeValido() {
        try {
            var device = smartLightFactory.createDevice("Luz da Sala");
            assert device != null;
            assert device.getName().equals("Luz da Sala");
            var assertDeviceToString = "Smart Light: Luz da Sala\nColor: White\nBrightness: 50\n";
            assert device.toString().equals(assertDeviceToString);
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    public void DeveRetornarThermoStatQuandoNomeValido() {
        try {
            var device = thermoStatFactory.createDevice("Termostato da Sala");
            assert device != null;
            assert device.getName().equals("Termostato da Sala");
            var assertDeviceToString = "Thermostat: Termostato da Sala\nTemperature: 20\nHumidity: 50\nConsumption: 2" +
                    ".0\n";
            assert device.toString().equals(assertDeviceToString);
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    public void DeveRetornarRobotVacuumQuandoNomeValido() {
        try {
            var device = robotVacuumFactory.createDevice("Aspirador da Sala");
            assert device != null;
            assert device.getName().equals("Aspirador da Sala");
            var assertDeviceToString = "Dirty Level: 0\nArea to clean: All\nNoise Level: 0\n";
            assert device.toString().equals(assertDeviceToString);
        } catch (RuntimeException e) {
            fail();
        }
    }

}
