package lab_5;

import lab_5.comapators.CarComparator;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
/**
 * Клас, що представляє автомобіль для оренди.
 */
@Getter
@Setter
public class Car implements Comparable<Car> {
    private String make;
    private String vin;
    private String plateNumber;
    private LocalDate releaseDate;
    private double pricePerDay;
    private int mileage;

    public Car(String make, String vin, String plateNumber, LocalDate releaseDate, double pricePerDay, int mileage) {
        this.make = make;
        this.vin = vin;
        this.plateNumber = plateNumber;
        this.releaseDate = releaseDate;
        this.pricePerDay = pricePerDay;
        this.mileage = mileage;
    }

    public Car() {

    }


    @Override

    public String toString() {
        return "Car{" +
               "make='" + make + '\'' +
               ", vin='" + vin + '\'' +
               ", plateNumber='" + plateNumber + '\'' +
               ", releaseDate='" + releaseDate + '\'' +
               ", pricePerDay=" + pricePerDay + '\'' +
               ", mileage=" + mileage +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return vin.equals(car.vin);
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, vin, plateNumber, releaseDate);
    }


    @Override
    public int compareTo(Car o) {
        if (o.make.equals(make)){
            if (o.vin.equals(vin)){
                return this.plateNumber.compareTo(o.plateNumber);
            }
            return vin.compareTo(o.vin);
        }
        return make.compareTo(o.make);
    }
}