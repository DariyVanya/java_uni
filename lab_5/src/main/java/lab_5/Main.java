package lab_5;

import java.sql.SQLException;
import java.time.LocalDate;

import lab_5.Builder.CarBuilder;

import lab_5.*;
import lab_5.DAO.CarDao;
import lab_5.DAO.CarRentalDao;
import lab_5.DAO.DataSource;
import lab_5.DAO.RenterDao;

public class Main {

    public static void main(String[] args) throws SQLException {
        DataSource.createTablesStructure();
        Car car = new CarBuilder()
                .setMake("Nissan")
                .setVin("JTHBE933380012245")
                .setPlateNumber("AB1324CD")
                .setReleaseDate(LocalDate.parse("2012-02-12"))
                .setPricePerDay(43.9)
                .setMileage(50000)
                .build();

        Car car2 = new CarBuilder()
                .setMake("Toyota")
                .setVin("JTHBE453380012245")
                .setPlateNumber("AB1544CD")
                .setReleaseDate(LocalDate.parse("2012-04-12"))
                .setPricePerDay(44.9)
                .setMileage(40000)
                .build();

        CarDao carDao = new CarDao();
//        carDao.add(car2);

        Renter renter = Renter.builder()
                .firstName("Aboba")
                .lastName("Abiba")
                .documentId("AB1228CD")
                .driverLicense("AB1324CD")
                .build();

        RenterDao renterDao = new RenterDao();
//        renterDao.add(renter);
        System.out.println(car.hashCode());
        CarRental carRental = CarRental.builder()
                .car(car2)
                .renter(renter)
                .pickUpLocation("whereEver")
                .dropOffLocation("whereEver")
                .startDate(LocalDate.parse("2012-03-11"))
                .endDate(LocalDate.parse("2012-03-13"))
                .build();
        CarRentalDao carRentalDao = new CarRentalDao();
//        carRentalDao.add(carRental);

        Car car_ = carDao.getAll().get(1);
        Renter renter_ = renterDao.getAll().get(0);
        carRental = CarRental.builder()
                .car(car_)
                .renter(renter_)
                .pickUpLocation("whereEver")
                .dropOffLocation("whereEver")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now())
                .build();
        carRentalDao.add(carRental);

        System.out.println(carRentalDao.getAll());

    }
}