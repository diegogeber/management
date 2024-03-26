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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.event.management.service.DemandService;

@RestController
public class DemandController {
	
	@Autowired
	DemandService svc;
	
	
    @GetMapping("/demand/campus-catering-full-service")
    public ResponseEntity<byte[]> createDemandCCFS(
    		@RequestParam(name = "amount") int amount,
    		@RequestParam(name = "hasBuffet") boolean buffet,
    		@RequestParam(name = "mainDishes") boolean mainDishes,
    		@RequestParam(name = "deserts") boolean deserts,
    		@RequestParam(name = "eightInchPlates") boolean eightInchPlates,
    		@RequestParam(name = "sixInchPlates") boolean sixInchPlates,
    		@RequestParam(name = "appetizers") boolean appetizers,
    		@RequestParam(name = "coldBeverage") boolean coldBeverage,
    		@RequestParam(name = "hotBeverage") boolean hotBeverage
    		
    		) throws IOException {
        String fileName = svc.ccfullservice(amount, buffet, mainDishes, deserts, appetizers, coldBeverage, hotBeverage, false, eightInchPlates, sixInchPlates);
        return convertFile(fileName);
    }

	private ResponseEntity<byte[]> convertFile(String fileName) throws FileNotFoundException, IOException {
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
    
    @GetMapping("/demand/campus-catering-express")
    public String createDemandCCE(
    		@RequestParam(name = "amount") int amount,
    		@RequestParam(name = "sandwich") boolean sandwich,
    		@RequestParam(name = "burrito") boolean burrito,
    		@RequestParam(name = "bowls") boolean bowls,
    		@RequestParam(name = "coldBeverage") boolean coldBeverage,
    		@RequestParam(name = "hotBeverage") boolean hotBeverage,
    		@RequestParam(name = "soda") boolean soda
    		
    		
    		) throws IOException {
        
        return "Em construção";
    }
    
    @GetMapping("/demand/kw-full-service")
    public ResponseEntity<byte[]> createDemandKWFS(
    		@RequestParam(name = "amount") int amount,
    		@RequestParam(name = "deserts") boolean deserts,
    		@RequestParam(name = "appetizers") boolean appetizers,
    		@RequestParam(name = "am-pm-break") boolean ampm,
    		@RequestParam(name = "coldBeverage") boolean coldBeverage,
    		@RequestParam(name = "hotBeverage") boolean hotBeverage
    		) throws IOException {
        
    	String fileName = svc.kwFullService(amount, deserts,appetizers,ampm,coldBeverage,hotBeverage);
    	return convertFile(fileName);
    }
    
    
}
