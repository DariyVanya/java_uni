package lab_3.comapators;

import lab_2.Car;

import java.util.Comparator;

public class CarComparator {
    public static Comparator<Car> byMake() {
        return Comparator.comparing(Car::getMake);
    }

    public static Comparator<Car> byPlateNumber() {
        return Comparator.comparing(Car::getPlateNumber);
    }

    public static Comparator<Car> byPricePerDay() {
        return Comparator.comparing(Car::getPricePerDay);
    }

    public static Comparator<Car> byMileage() {
        return Comparator.comparing(Car::getMileage);
    }
}
