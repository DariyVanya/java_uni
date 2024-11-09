package lab_3;

import lombok.Getter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 * Клас, що представляє оренду автомобіля.
 */
@Getter
public class CarRental {
    private Car<lab_4.Car> car;
    private Renter renter;
    private String pickUpLocation;
    private String dropOffLocation;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;

    private CarRental(Builder builder) {
        this.car = builder.car;
        this.renter = builder.renter;
        this.pickUpLocation = builder.pickUpLocation;
        this.dropOffLocation = builder.dropOffLocation;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.totalPrice = builder.totalPrice;
    }

    public static class Builder {
        private Car<lab_4.Car> car;
        private Renter renter;
        private String pickUpLocation;
        private String dropOffLocation;
        private LocalDate startDate;
        private LocalDate endDate;
        private double totalPrice;

        /**
         * Встановлює автомобіль, який орендується
         *
         * @return об'єкт
         */
        public Builder setCar(Car<lab_4.Car> car) {
            this.car = car;
            return this;
        }

        /**
         * Встановлює орендаря, який орендує
         *
         * @return об'єкт
         */
        public Builder setRenter(Renter renter) {
            this.renter = renter;
            return this;
        }

        /**
         * Встановлює локацію орендування
         *
         * @return об'єкт
         */
        public Builder setPickUpLocation(String pickUpLocation) {
            this.pickUpLocation = pickUpLocation;
            return this;
        }

        /**
         * Встановлює локацію закінчення оренди
         *
         * @return об'єкт
         */
        public Builder setDropOffLocation(String dropOffLocation) {
            this.dropOffLocation = dropOffLocation;
            return this;
        }

        /**
         * Встановлює дату початку оренди
         *
         * @return об'єкт
         */
        public Builder setStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * Встановлює дату кінця оренди
         *
         * @return об'єкт
         */
        public Builder setEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public CarRental build() {
            this.totalPrice = this.car.getPricePerDay() * calculateDays(startDate, endDate);
            return new CarRental(this);
        }

        /**
         * Рахує дні між двома датами
         * Використовується для підрахунку кінцевої вартості
         *
         * @return к-сть днів
         */
        private long calculateDays(LocalDate startDate, LocalDate endDate) {

            return ChronoUnit.DAYS.between(startDate, endDate);
        }
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
}
