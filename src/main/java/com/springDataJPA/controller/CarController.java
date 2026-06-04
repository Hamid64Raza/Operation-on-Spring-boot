package com.springDataJPA.controller;

import com.springDataJPA.entity.Car;
import com.springDataJPA.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/getCars")
    public ResponseEntity<List<Car>> getCars(){
       List<Car> carsList= carService.getCars();
       return  new ResponseEntity<>(carsList,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(
            @PathVariable long id,
            @RequestBody Car car) {

        Car updatedCar = carService.updateCar(id, car);

        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    @DeleteMapping("/delete/car/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable Long id){
        Car car =carService.deleteCarById(id);
        if(null!=car) {
            return new ResponseEntity<>(car, HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>("There is No Car with id: "+id,HttpStatus.NOT_FOUND);
        }

    }



}



