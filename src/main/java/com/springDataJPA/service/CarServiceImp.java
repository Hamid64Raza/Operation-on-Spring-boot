package com.springDataJPA.service;


import com.springDataJPA.entity.Car;
import com.springDataJPA.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImp implements CarService {
private  CarRepository carRepository;
  public  CarServiceImp(CarRepository carRepository){
      this.carRepository=carRepository;
  }
    @Override
    public Car saveCar(Car car) {
        Car savedCar=carRepository.save(car);

        return savedCar;
    }
}
