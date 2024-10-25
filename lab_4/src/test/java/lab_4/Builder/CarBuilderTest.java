package lab_4.Builder;

import lab_4.Car;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CarBuilderTest {

    @Test
    void build() {
        CarBuilder<Car> builder = new CarBuilder<>();
        Car car = builder
                .setMake("Toyota")
                .setVin("JTHBE96S280012345")
                .setPlateNumber("AB1234CD")
                .setReleaseDate(LocalDate.parse("2018-06-15"))
                .setPricePerDay(49.9)
                .setMileage(50000)
                .build(new Car());
        assertAll(() -> {
            assertEquals("Toyota", car.getMake());
            assertEquals("JTHBE96S280012345", car.getVin());
            assertEquals("AB1234CD", car.getPlateNumber());
            assertEquals(LocalDate.parse("2018-06-15"), car.getReleaseDate());
            assertEquals(49.9, car.getPricePerDay());
            assertEquals(50000, car.getMileage());

        });
    }
}