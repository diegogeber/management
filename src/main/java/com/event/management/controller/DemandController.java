package com.event.management.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
    @GetMapping("/demand/campus-catering-full-service")
    public ResponseEntity<byte[]> createDemandCCFS(
    		@RequestParam(name = "amount") int amount,
    		@RequestParam(name = "hasBuffet") boolean buffet,
    		@RequestParam(name = "mainDishes") boolean mainDishes,
    		@RequestParam(name = "deserts") boolean deserts,
    		@RequestParam(name = "eightInchPlates") boolean eightInchPlates,
    		@RequestParam(name = "appetizers") boolean appetizers,
    		@RequestParam(name = "coldBeverage") boolean coldBeverage,
    		@RequestParam(name = "hotBeverage") boolean hotBeverage
    		
    		) throws IOException {
        String fileName = demandService.avaliateDemand(TypeDemandEnum.CCFS, amount, buffet, mainDishes, deserts, appetizers, coldBeverage, hotBeverage, false, eightInchPlates);
        File file = new File(fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setContentDispositionFormData("filename", fileName);
        
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("Arquivo não encontrado: " + file.getPath());
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        try (InputStream inputStream = new FileInputStream(file)) {
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
        }
        file.delete();
        return new ResponseEntity<>(outputStream.toByteArray() , headers, HttpStatus.OK);
    }
}
