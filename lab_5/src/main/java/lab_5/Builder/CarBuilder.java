package lab_5.Builder;
import lab_5.Car;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import static jakarta.validation.Validation.buildDefaultValidatorFactory;
import java.time.LocalDate;
import java.util.Set;


public class CarBuilder {
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
    // перевірка дати (завтра не може бути)
    private LocalDate releaseDate;

    @NotNull(message = "pricePerDay cannot be null")
    @Min(value = 0, message = "pricePerDay cannot be less than 0")
    private double pricePerDay;

    @NotNull(message = "mileage cannot be null")
    @Min(value = 0, message = "mileage cannot be less than 0")
    @Max(value = 100_000, message = "mileage cannot be greater than 100_000")
    private int mileage;


    public CarBuilder setMake(String make) {
        this.make = make;
        return this;
    }

    public CarBuilder setVin(String vin) {
        this.vin = vin;
        return this;
    }
    public CarBuilder setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
        return this;
    }

    public CarBuilder setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public CarBuilder setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
        return this;
    }

    public CarBuilder setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }


    public Car build() {
        ValidatorFactory factory = buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Car car = new Car(this.make, this.vin, this.plateNumber, this.releaseDate, this.pricePerDay, this.mileage);

        Set<ConstraintViolation<CarBuilder>> violations = validator.validate(this);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<CarBuilder> violation : violations) {
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