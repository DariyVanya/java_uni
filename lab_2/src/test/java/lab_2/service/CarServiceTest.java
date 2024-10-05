package lab_2.service;

import lab_2.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    private Car car1;
    private Car car2;
    private Car car3;

    private CarService carService;


    @BeforeEach
    void setUp() {
        this.car1 = new Car("Toyota",
                "JTHBE96S280012345",
                "AB1234CD",
                LocalDate.parse("2018-06-15"),
                49.9,
                50000);

        this.car2 = new Car("Nissan",
                "ABCDF26S281112225",
                "AB1224CD",
                LocalDate.parse("2018-07-11"),
                39.9,
                100000);

        this.car3 = new Car("Toyota",
                "GGHHE111280022222",
                "AA11111AA",
                LocalDate.parse("2020-07-20"),
                69.9,
                20000);

        List<Car> cars = List.of(car1, car2, car3);

        this.carService = new CarService(cars);
    }


    @Test
    void findByPlateNumber() {
        Car res = carService.findByPlateNumber("AA11111AA");
        assertEquals(car3, res, "Third car");
    }

    @Test
    void findByVin() {
        Car res = carService.findByVin("ABCDF26S281112225");
        assertEquals(car2, res, "Second car");
    }

    @Test
    void findByMake() {
        List<Car> res = carService.findByMake("Toyota");
        assertEquals(List.of(car1, car3), res, "2 cars");
    }
}