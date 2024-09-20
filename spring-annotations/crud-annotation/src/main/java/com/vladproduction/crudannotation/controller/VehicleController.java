package com.vladproduction.crudannotation.controller;

import com.vladproduction.crudannotation.model.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    //------------------[GET]------------------
    // http://localhost:8084/api/vehicles
    // http://localhost:8084/api/vehicles/car
    // http://localhost:8084/api/vehicles/car-bmw
//    @GetMapping(value = {"/car", "/car-bmw"})
    @GetMapping
    public Vehicle getVehicle(){
        Vehicle vehicle = new Vehicle(1L, "BMW", 50000.00);
        return vehicle;
    }


    //------------------[POST]------------------
    /*{
    "id": 1,
    "brand": "BMW-X6",
    "price": 50500.0
    }*/
    // http://localhost:8084/api/vehicles/create
    //response Status:201
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping(value = "create",
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle){
        System.out.println(vehicle.getId());
        System.out.println(vehicle.getBrand());
        System.out.println(vehicle.getPrice());
        System.out.println("vehicle created");
        return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
    }


    //------------------[PUT]------------------
    /*{
    "brand":"BMW-X6(updated)",
    "price":50555.00
    }*/
    //http://localhost:8084/api/vehicles/update/1
    //response Status:200
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @PutMapping("/update/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle candidate){
        System.out.println(id);
        System.out.println(candidate.getBrand());
        System.out.println(candidate.getPrice());
        candidate.setId(id);
        return ResponseEntity.ok(candidate);
    }

    //------------------[DELETE]------------------
    //http://localhost:8084/api/vehicles/delete/1
    //response Status:200
    //vehicle deleted
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long id){
        System.out.println(id);
        return ResponseEntity.ok("vehicle deleted");
    }


    //------------------@PathVariable------------------
    // http://localhost:8084/api/vehicles/1
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> pathVariableDemo(@PathVariable Long id){
        System.out.println(id);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        return ResponseEntity.ok(vehicle);
    }

    //------------------@PathVariable------------------
    // http://localhost:8084/api/vehicles/1/bmw
    @GetMapping("/{id}/{brand}")
    public ResponseEntity<Vehicle> pathVariableDemo(@PathVariable Long id,
                                                    @PathVariable("brand") String brandVehicle){
        System.out.println(id);
        System.out.println(brandVehicle);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setBrand(brandVehicle);
        return ResponseEntity.ok(vehicle);
    }


    //------------------@RequestParam------------------
    // http://localhost:8084/api/vehicles/query?id=101&brand=Audi&price=20000
    @GetMapping("/query")
    public ResponseEntity<Vehicle> requestParamDemo(@RequestParam Long id,
                                                    @RequestParam String brand,
                                                    @RequestParam double price){
        System.out.println(id);
        System.out.println(brand);
        System.out.println(price);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setBrand(brand);
        vehicle.setPrice(price);
        return ResponseEntity.ok(vehicle);
    }
    /*{
    "id": 101,
    "brand": "Audi",
    "price": 20000.0
    }
    response Status:200
    101
    Audi
    20000.0*/

}
