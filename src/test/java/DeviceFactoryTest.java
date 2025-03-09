import org.junit.jupiter.api.Test;
import org.nashi.devices.entities.SmartLight;
import org.nashi.devices.factories.DeviceFactory;

import static org.junit.jupiter.api.Assertions.fail;

public class DeviceFactoryTest {

    @Test
    void deveRetornarExceptionDeTypeVazio() {
        try {
            DeviceFactory.createDevice("", "Test Device");
            fail("Should throw an exception of empty type");
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Type cannot be empty");
        }
    }

    @Test
    void deveRetornarExceptionDeNomeVazio() {
        try {
            DeviceFactory.createDevice("TestDevice", "");
            fail("Should throw an exception of empty name");
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Name cannot be empty");
        }
    }

    @Test
    void deveRetornarExceptionDeTypeEmBranco() {
        try {
            DeviceFactory.createDevice(" ", "Test Device");
            fail("Should throw an exception of blank type");
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Type cannot be blank");
        }
    }

    @Test
    void deveRetornarExceptionDeNomeEmBranco() {
        try {
            DeviceFactory.createDevice("invalid_devices.TestDevice", " ");
            fail("Should throw an exception of blank name");
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Name cannot be blank");
        }
    }

    @Test
    void deveRetornarDispositivoNaoEncontrado() {
        try {
            DeviceFactory.createDevice("NotADevice", "Not a device");
            fail("Should throw an exception of device not found");
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Device type not found");
        }
    }

    @Test
    void deveRetornarTipoDeDispositivoInvalido() {
        try {
            DeviceFactory.createDevice("invalid_devices.TestDevice", "Invalid Test Device");
            fail("Should throw an exception of invalid device");
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("The type is not a valid device");
        }
    }

    @Test
    void deveRetornarExceptionDeConstrutorSemParametros() {
        try {
            var Type = "invalid_devices.TestDeviceNoConstructorArg";
            DeviceFactory.createDevice(Type, "Test Device");
            fail("Should throw an exception of constructor with no parameters");
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("The device do not have a constructor with no parameters");
        }
    }

    @Test
    void deveFazerOCastParaDeviceEspecifico() {
        try {
            var device = (SmartLight) DeviceFactory.createDevice("SmartLight", "Room Light");
            assert device.getName().equals("Room Light");
        } catch (Exception e) {
            fail();
        }
    }
}
