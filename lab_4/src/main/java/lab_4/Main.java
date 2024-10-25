package lab_4;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Car car = new Car("Toyota", "JTHBE96S280012345", "AB1234CD", LocalDate.parse("2018-06-15"), 49.9, 50000);

        Renter renter = new Renter("John", "Doe", "1234567890", "D123456789");

        CarRental carRental = new CarRental.Builder()
                .setCar(car)
                .setRenter(renter)
                .setPickUpLocation("Los Angeles Airport")
                .setDropOffLocation("San Francisco Downtown")
                .setStartDate(LocalDate.parse("2024-09-20"))
                .setEndDate(LocalDate.parse("2024-09-25"))
                .build();

        System.out.println(carRental.toString());
        System.out.println(carRental.hashCode());

    }
}