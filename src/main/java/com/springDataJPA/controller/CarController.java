package com.springDataJPA.controller;

import com.springDataJPA.entity.Car;
import com.springDataJPA.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CarController {
    private CarService carService;
    public  CarController(CarService carService){
        this.carService=carService;
    }

    @PostMapping("/saveCar")
    public ResponseEntity<Car> saveCar(@RequestBody Car car){
        Car carResult= carService.saveCar(car);
        return  new ResponseEntity<>(carResult, HttpStatus.OK);
    }

}



