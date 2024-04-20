package com.example.foodtrucks.controller;

import com.example.foodtrucks.service.FoodTruckAPIService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "basicAuth")
        public class FoodTruckAPIController {

    private final FoodTruckAPIService foodTruckAPIService;

    @Autowired
    public FoodTruckAPIController(FoodTruckAPIService foodTruckAPIService) {
        this.foodTruckAPIService = foodTruckAPIService;
    }

    @Operation(summary = "This method is used to get all food truck stuck.")
    @GetMapping("/food-trucks")
    public String getFoodTruckData() {
        return foodTruckAPIService.getFoodTruckData();
    }

    @Operation(summary = "Find stuck by location description.")
    @GetMapping("/food-trucks/search")
    public String searchFoodTrucksByLocationDescription(@RequestParam(required = false) String locationDescription) {
        if (locationDescription == null || locationDescription.isEmpty()) {
            return foodTruckAPIService.getFoodTruckData();
        } else {
            return foodTruckAPIService.getFoodTruckDataByLocationDescription(locationDescription);
        }
    }


}
