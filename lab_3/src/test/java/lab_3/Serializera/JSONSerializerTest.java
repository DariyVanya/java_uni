package lab_3.Serializera;

import lab_3.service.CarService;
import lab_3.Car;
import lab_3.CarRental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class JSONSerializerTest {
    private JSONSerializer<Car> jsonSerializer;
    private Car car;
    private CarService carService;
    @BeforeEach
    void setUp() {
        jsonSerializer = new JSONSerializer<Car>(Car.class);
        car = new Car("Toyota", "JTHBE96S280012345", "AB1234CD", LocalDate.parse("2018-06-15"), 49.9, 50000);

    }
    @Test
    void serialize() throws IOException {
        String jsonString = jsonSerializer.serialize(car);

        assertAll(() -> {
            assertNotNull(jsonString);
            assertTrue(jsonString.contains("""
                    "make":"Toyota\""""), "Toyota expected");
            assertTrue(jsonString.contains("""
                    "vin":"JTHBE96S280012345\""""), "JTHBE96S280012345 expected");
            assertTrue(jsonString.contains("""
                    "plateNumber":"AB1234CD\""""), "AB1234CD expected");
            assertTrue(jsonString.contains("""
                    "releaseDate":"2018-06-15\""""), "2018-06-15 expected");
            assertTrue(jsonString.contains("""
                    "pricePerDay":49.9"""), "49.9 expected");
            assertTrue(jsonString.contains("""
                    "mileage":50000"""), "50000 expected");
        });
    }
}