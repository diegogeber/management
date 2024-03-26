package com.event.management.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class DemandService {

	public String ccfullservice(int amount, boolean hasBuffet,
			boolean mainDishes, boolean deserts, boolean appetizers, boolean cold, boolean hot, 
			boolean soda, boolean hasEightInchPlates, boolean hasSixInchPlates) {
		String name = UUID.randomUUID().toString();
		String fileName = name + ".txt";
		
		try {
			BufferedWriter  writer = new BufferedWriter(new FileWriter(fileName));
			int tenInchPlates = 0;
			int utensilKit = 0;
			int dinnerNapkin = 0;
			int sixInchPlates = 0;
			int beverageNapkin = 0;
			int forks = 0;
			int eightInchPlates = 0;
			int coldCup = 0;
			int oneDripTrayContainer = 0;
			int hotCup = 0;
			int stirStick = 0;
			
		    if(hasBuffet){
			        if(mainDishes){
			        	tenInchPlates = tenInchPlates + amount;
			        	utensilKit = utensilKit + amount;
			        	dinnerNapkin = dinnerNapkin + amount;
			        }
			        
			        if(deserts){
			        	if(hasSixInchPlates) {
			        		sixInchPlates = sixInchPlates + amount;
			        	}
			        	
			        	beverageNapkin = beverageNapkin + amount;
			        	forks = forks + 0;
			        }
		
			        if(appetizers){
			        	if(hasEightInchPlates) {
			        		eightInchPlates = eightInchPlates + amount;
			        	}
			        	
			        	dinnerNapkin = dinnerNapkin + amount;
			        	forks = forks + amount;
			        }
		    }
	
		    if(cold || hot){
		        if(cold){
		        	beverageNapkin = beverageNapkin + amount;
		        	coldCup = coldCup + amount;
		        	oneDripTrayContainer = oneDripTrayContainer + amount;
		        }
		        
		        if(hot){
		        	
		        	beverageNapkin = beverageNapkin + amount;
		        	hotCup = hotCup + amount;
		        	stirStick = stirStick + amount;
		        	oneDripTrayContainer = oneDripTrayContainer + amount;
		        }
		    }
		   
		    writer.write(Integer.valueOf(tenInchPlates).toString() + " 10\" plates");
        	writer.newLine();
            writer.write(Integer.valueOf(utensilKit).toString() + " Utensil Kit");
            writer.newLine();
            writer.write(Integer.valueOf(dinnerNapkin).toString() + " Dinner Napkin");
            writer.newLine();
            writer.write(Integer.valueOf(sixInchPlates).toString() + " 6\" plates");
        	writer.newLine();
        	writer.write(Integer.valueOf(beverageNapkin).toString() + " Beverage Napkin");
        	writer.newLine();
        	writer.write(Integer.valueOf(forks).toString() + " Forks");
        	writer.newLine();
        	writer.write(Integer.valueOf(eightInchPlates).toString() + " 8\" plates");
        	writer.newLine();
        	writer.write(Integer.valueOf(coldCup).toString() + " Cold Cup");
        	writer.newLine();
        	writer.write(Integer.valueOf(oneDripTrayContainer).toString() + " 1 drip tray for each container");
        	writer.newLine();
        	writer.write(Integer.valueOf(hotCup).toString() + " Hot Cup");
        	writer.newLine();
        	writer.write(Integer.valueOf(stirStick).toString() + " Stir Stick");
        	writer.newLine();
		    writer.close();
		    
		} catch (IOException e) {
            // Trata exceções de E/S (Input/Output)
            e.printStackTrace();
        }
		
		return fileName;
	}

	public String kwFullService(int amount, boolean deserts, boolean appetizers, boolean ampm, boolean coldBeverage,
			boolean hotBeverage) {
		
		String name = UUID.randomUUID().toString();
		String fileName = name + ".txt";
		try {
			BufferedWriter  writer = new BufferedWriter(new FileWriter(fileName));
			int hotCup = 0;
			int stirSticks = 0;
			int beverageNapkins = 0;
			int coldCup = 0;
			int sixInchPlates = 0;
			int dinnerNapkin = 0;
			int fork = 0;
			
			if(deserts) {
				beverageNapkins = beverageNapkins + amount;
				sixInchPlates = sixInchPlates + amount;
			}
			
			if(appetizers) {
				dinnerNapkin = dinnerNapkin + amount;
			}
			
			if(ampm) {
				dinnerNapkin = dinnerNapkin + amount;
				sixInchPlates = sixInchPlates + amount;
				fork = fork + amount;
			}
			
			if(coldBeverage) {
				beverageNapkins = beverageNapkins + amount;
				coldCup = coldCup + amount;
			}
			
			if(hotBeverage) {
				hotCup = hotCup + amount;
				stirSticks = stirSticks + amount;
				beverageNapkins = beverageNapkins + amount;
			}
			
			writer.write(Integer.valueOf(hotCup).toString() + " Hot Cup");
        	writer.newLine();
        	writer.write(Integer.valueOf(stirSticks).toString() + " Stir Sticks");
        	writer.newLine();
        	writer.write(Integer.valueOf(beverageNapkins).toString() + " Beverage Napkins");
        	writer.newLine();
        	writer.write(Integer.valueOf(coldCup).toString() + " Cold Cup");
        	writer.newLine();
        	writer.write(Integer.valueOf(sixInchPlates).toString() + " 6 inch plates");
        	writer.newLine();
        	writer.write(Integer.valueOf(dinnerNapkin).toString() + " Dinner Napkin");
        	writer.newLine();
        	writer.write(Integer.valueOf(fork).toString() + " Fork");
        	writer.close();
			
		}catch (IOException e) {
            // Trata exceções de E/S (Input/Output)
            e.printStackTrace();
        }
		
		return fileName;
	}
}
