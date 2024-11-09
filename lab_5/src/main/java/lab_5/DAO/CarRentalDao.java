package lab_5.DAO;

import lab_5.Renter;
import lab_5.Car;
import lab_5.CarRental;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CarRentalDao {
    private final Connection connection;
    static final String TABLE_NAME = "car_rental";

    public CarRentalDao() {
        try {
            connection = DataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CarRental add(CarRental carRental) throws SQLException {
        String insertPerson = String.format("insert into %s (id, car_vin, renter_id, pick_up_location, drop_off_location, start_date, end_date) values (?,?,?,?,?,?,?);", TABLE_NAME);
        try (PreparedStatement ps = connection.prepareStatement(insertPerson, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setObject(1, carRental.hashCode());
            ps.setString(2, carRental.getCar().getVin());
            ps.setObject(3, carRental.getRenter().getDocumentId());
            ps.setObject(4, carRental.getPickUpLocation());
            ps.setObject(5, carRental.getDropOffLocation());
            ps.setObject(6, carRental.getStartDate());
            ps.setObject(7, carRental.getEndDate());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return carRental;
            } else {
                throw new IllegalArgumentException("Error while creating carRental " + carRental);
            }
        }
    }

    public List<CarRental> getAll() throws SQLException {
        String getAll = """
            SELECT car.make, car.vin AS car_vin, car.plate_number, car.release_date, car.price_per_day, car.mileage,
                   renter.first_name, renter.last_name, renter.document_id, renter.driver_licence,
                   car_rental.pick_up_location, car_rental.drop_off_location, car_rental.start_date, car_rental.end_date
            FROM car_rental
            JOIN car ON car_rental.car_vin = car.vin
            JOIN renter ON car_rental.renter_id = renter.document_id;
        """;



        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(getAll);
        return getSortedByNumber(rs);
    }

    private List<CarRental> getSortedByNumber(ResultSet rs) throws SQLException {
        Set<CarRental> result = new TreeSet<>();
        while (rs.next()) {
            CarRental carRental = fromResultSet(rs);
            result.add(carRental);
        }
        return result.stream().toList();
    }


    private CarRental fromResultSet(ResultSet rs) throws SQLException {
        return CarRental.builder()
                .car(new Car( rs.getString("make"), rs.getString("car_vin"), rs.getString("plate_number"),rs.getDate("release_date").toLocalDate(), rs.getDouble("price_per_day"), rs.getInt("mileage")))
                .renter(new Renter(rs.getString("first_name"), rs.getString("last_name"), rs.getString("document_id"), rs.getString("driver_licence")))
                .pickUpLocation(rs.getString("pick_up_location"))
                .dropOffLocation(rs.getString("drop_off_location"))
                .startDate(rs.getDate("start_date").toLocalDate())
                .endDate(rs.getDate("end_date").toLocalDate())
                .build();
    }

}
