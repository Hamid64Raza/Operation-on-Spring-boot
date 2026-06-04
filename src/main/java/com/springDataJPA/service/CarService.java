package com.springDataJPA.service;

import com.springDataJPA.entity.Car;

import java.util.List;

public interface CarService {

    public  Car saveCar(Car car);
    public List<Car> getCars();

    Car updateCar(long id, Car car);

    public  Car deleteCarById(Long id);



}
