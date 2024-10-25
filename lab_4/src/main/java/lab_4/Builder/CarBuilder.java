package lab_4.Builder;
import jakarta.validation.*;
import lab_4.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Set;
import static jakarta.validation.Validation.buildDefaultValidatorFactory;

public class CarBuilder<T extends Car> {
    @NotNull(message = "Make cannot be null")
    @Length(min = 3, max = 30, message = "Make must be between 3 and 30 characters")
    private String make;

    @Length(min = 17, message = "Vin is too short, minimum 17 characters is required")
    @Length(max = 17, message = "Vin is too long, maximum 17 characters is required")
    @NotNull(message = "vin cannot be null")
    @NotEmpty(message = "vin cannot be empty string")
    private String vin;

    @NotNull(message = "plateNumber cannot be null")
    @NotEmpty(message = "plateNumber cannot be empty string")
    @Length(min = 6, message = "plateNumber is too short, minimum 6 characters is required")
    @Length(max = 8, message = "plateNumber is too long, maximum 8 characters is required")
    private String plateNumber;

    @NotNull(message = "releaseDate cannot be null")
    private LocalDate releaseDate;

    @NotNull(message = "pricePerDay cannot be null")
    @Min(value = 0, message = "pricePerDay cannot be less than 0")
    private double pricePerDay;

    @NotNull(message = "mileage cannot be null")
    private int mileage;


    public CarBuilder<T> setMake(String make) {
        this.make = make;
        return this;
    }

    public CarBuilder<T> setVin(String vin) {
        this.vin = vin;
        return this;
    }
    public CarBuilder<T> setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
        return this;
    }

    public CarBuilder<T> setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public CarBuilder<T> setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
        return this;
    }

    public CarBuilder<T> setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }


    public T build(T car) {
        ValidatorFactory factory = buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        car.setMake(this.make);
        car.setVin(this.vin);
        car.setPlateNumber(this.plateNumber);
        car.setReleaseDate(this.releaseDate);
        car.setPricePerDay(this.pricePerDay);
        car.setMileage(this.mileage);

        Set<ConstraintViolation<CarBuilder<T>>> violations = validator.validate(this);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<CarBuilder<T>> violation : violations) {
                sb
                        .append("\nField: ")
                        .append(violation.getPropertyPath())
                        .append("\nInvalid value: ")
                        .append(violation.getInvalidValue())
                        .append("\nProblem: ")
                        .append(violation.getMessage())
                        .append("\n");
            }
            throw new IllegalArgumentException(sb.toString());
        }
        return car;
    }
}