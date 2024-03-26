package com.event.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.event.management.enumerator.TypeDemandEnum;
import com.event.management.service.DemandService;

@RestController
public class DemandController {
	
	@Autowired
	DemandService demandService;
	
	
    @PostMapping("/demand/campus-catering-full-service")
    public String createDemand(
    		@RequestParam(name = "amount") int amount,
    		@RequestParam(name = "hasBuffet") boolean buffet,
    		@RequestParam(name = "mainDishes") boolean mainDishes,
    		@RequestParam(name = "deserts") boolean deserts,
    		@RequestParam(name = "appetizers") boolean appetizers,
    		@RequestParam(name = "coldBeverage") boolean coldBeverage,
    		@RequestParam(name = "hotBeverage") boolean hotBeverage
    		
    		) {
        demandService.avaliateDemand(TypeDemandEnum.CCFS, amount, buffet, mainDishes, deserts, appetizers, coldBeverage, hotBeverage, false);
        return "Demand created successfully!";
    }
}
