package lab_3.Serializera;

import lab_3.Car;
import lab_3.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class XMLSerializerTest {
    private XMLSerializer<Car> xmlSerializer;
    private Car car;
    private CarService carService;
    @BeforeEach
    void setUp() {
        xmlSerializer = new XMLSerializer<Car>(Car.class);
        car = new Car("Toyota", "JTHBE96S280012345", "AB1234CD", LocalDate.parse("2018-06-15"), 49.9, 50000);

    }
    @Test
    void serialize() throws IOException {
        String xmlString = xmlSerializer.serialize(car);

        assertAll(() -> {
            assertNotNull(xmlString);
            assertTrue(xmlString.contains("<make>Toyota</make>"), "Toyota expected");
            assertTrue(xmlString.contains("<vin>JTHBE96S280012345</vin>"), "JTHBE96S280012345 expected");
            assertTrue(xmlString.contains("<plateNumber>AB1234CD</plateNumber>"), "AB1234CD expected");
            assertTrue(xmlString.contains("<releaseDate>2018-06-15</releaseDate>"), "2018-06-15 expected");
            assertTrue(xmlString.contains("<pricePerDay>49.9</pricePerDay>"), "49.9 expected");
            assertTrue(xmlString.contains("<mileage>50000</mileage>"), "50000 expected");
        });
    }
}