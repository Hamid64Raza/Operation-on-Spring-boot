package com.springDataJPA.service;


import com.springDataJPA.entity.Car;
import com.springDataJPA.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImp implements CarService {
    private CarRepository carRepository;

    public CarServiceImp(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car saveCar(Car car) {
        Car savedCar = carRepository.save(car);

        return savedCar;
    }

    @Override
    public List<Car> getCars() {
        List<Car> carsResult = carRepository.findAll();
        return carsResult;
    }


    @Override
    public Car updateCar(long id, Car car) {

        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {

            Car existingCar = optionalCar.get();

            existingCar.setBrand(car.getBrand());
            existingCar.setModel(car.getModel());
            existingCar.setPrice(car.getPrice());

            return carRepository.save(existingCar);
        }

        throw new RuntimeException("Car not found with id: " + id);
    }

    @Override
    public Car deleteCarById(Long id) {
        Optional<Car> car=carRepository.findById(id);
        carRepository.deleteById(id);
        if(car.isPresent()){
            return car.get();
        }else {
            return null;
        }



    }


}


