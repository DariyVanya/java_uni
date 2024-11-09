package lab_5;

import lab_5.Builder.CarBuilder;
import lab_5.Car;
import lab_5.Renter;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 * Клас, що представляє оренду автомобіля.
 */
@Data
@Builder
public class CarRental implements Comparable<CarRental> {
    private Car car;
    private Renter renter;
    private String pickUpLocation;
    private String dropOffLocation;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;

    public CarRental(Car car, Renter renter, String pickUpLocation, String dropOffLocation, LocalDate startDate, LocalDate endDate, double totalPrice) {
        this.car = car;
        this.renter = renter;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
    }

    public CarRental(){

    }

    @Override
    public String toString() {
        return "CarRental{" +
                "car=" + car +
                ", renter=" + renter +
                ", pickUpLocation='" + pickUpLocation + '\'' +
                ", dropOffLocation='" + dropOffLocation + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }

    @Override
    public int compareTo(CarRental o) {
        if (o.car.equals(car)){
            if (o.renter.equals(renter)){
                return this.pickUpLocation.compareTo(o.pickUpLocation);
            }
            return renter.compareTo(o.renter);
        }
        return car.compareTo(o.car);
    }
}
