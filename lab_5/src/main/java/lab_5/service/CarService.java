package lab_5.service;

import lab_4.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarService{
    private final List<Car> cars;

    public CarService(List<Car> cars) {
        this.cars = cars;
    }

    public Car findByPlateNumber (String plateNum){
        return cars.stream()
                .filter(car -> car.getPlateNumber().equals(plateNum))
                .toList().get(0);
    }

    public List<Car> findParticularlyByPlateNumber (String plateNum){
        return cars.stream()
                .filter(car -> car.getPlateNumber().contains(plateNum))
                .toList();
    }

    public Car findByVin (String vin){
        return cars.stream()
                .filter(car -> car.getVin().equals(vin))
                .toList().get(0);
    }

    public List<Car> findParticularlyByVin (String vin){
        return cars.stream()
                .filter(car -> car.getVin().contains(vin))
                .toList();
    }

    public List<Car> findByMake (String make){
        return cars.stream()
                .filter(car -> car.getMake().equals(make))
                .collect(Collectors.toList());
    }
}
