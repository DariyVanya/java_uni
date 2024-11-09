package lab_5.DAO;

import lab_5.Renter;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RenterDao {
    private final Connection connection;
    static final String TABLE_NAME = "renter";

    public RenterDao() {
        try {
            connection = DataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Renter add(Renter renter) throws SQLException {
        String insertPerson = String.format("insert into %s (first_name, last_name, document_id, driver_licence) values (?,?,?,?);", TABLE_NAME);
        try (PreparedStatement ps = connection.prepareStatement(insertPerson, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setObject(1, renter.getFirstName());
            ps.setString(2, renter.getLastName());
            ps.setObject(3, renter.getDocumentId());
            ps.setObject(4, renter.getDriverLicense());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return renter;
            } else {
                throw new IllegalArgumentException("Error while creating renter " + renter);
            }
        }
    }

    public List<Renter> getAll() throws SQLException {
        String getAll = String.format("select * from %s;", TABLE_NAME);

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(getAll);
        return getSortedByNumber(rs);
    }

    private List<Renter> getSortedByNumber(ResultSet rs) throws SQLException {
        Set<Renter> result = new TreeSet<>();
        while (rs.next()) {
            Renter renter = fromResultSet(rs);
            result.add(renter);
        }
        return result.stream().toList();
    }


    private Renter fromResultSet(ResultSet rs) throws SQLException {
        return Renter.builder()
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .documentId(rs.getString("document_id"))
                .driverLicense(rs.getString("driver_licence"))
                .build();
    }

}
