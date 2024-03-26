package com.event.management.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.event.management.enumerator.TypeDemandEnum;
import com.event.management.model.Order;

@Service
public class DemandService {
	
	public String avaliateDemand(TypeDemandEnum typeOrder, int amount, boolean hasBuffet,
			boolean mainDishes, boolean deserts, boolean appetizers, boolean cold, boolean hot, boolean soda, boolean eightInchPlates) {
		Order order = new Order(amount, typeOrder.name() , hasBuffet, mainDishes, deserts, appetizers, cold, hot, soda);
	    
	    return ccfs(order, eightInchPlates);
	}

	private String ccfs(Order order, boolean eightInchPlates) {
		String name = UUID.randomUUID().toString();
		String fileName = name + ".txt";
		try {
			BufferedWriter  writer = new BufferedWriter(new FileWriter(fileName));
	
		    if("CCFS".equals(order.demand) && order.buffet){
		        
		        System.out.println("Buffet Selected");
				
			        if(order.mainDishes){
			        	System.out.println(Integer.valueOf(order.amount).toString() + " 10\" plates");
			            System.out.println(Integer.valueOf(order.amount).toString() + " Utensil Kit");
			            System.out.println(Integer.valueOf(order.amount).toString() + " Dinner Napkin");
			        	
			        	writer.write(Integer.valueOf(order.amount).toString() + " 10\" plates");
			        	writer.newLine();
			            writer.write(Integer.valueOf(order.amount).toString() + " Utensil Kit");
			            writer.newLine();
			            writer.write(Integer.valueOf(order.amount).toString() + " Dinner Napkin");
			            writer.newLine();
			        }
			        
			        if(order.deserts){
			        	writer.write(Integer.valueOf(order.amount).toString() + " 6\" plates");
			        	writer.newLine();
			        	writer.write(Integer.valueOf(order.amount).toString() + " Beverage Napkin");
			        	writer.newLine();
			        	writer.write(Integer.valueOf(order.amount).toString() + " Forks");
			        	writer.newLine();
			        	
			            System.out.println(Integer.valueOf(order.amount).toString() + " 6\" plates");
			            System.out.println(Integer.valueOf(order.amount).toString() + " Beverage Napkin");
			            System.out.println(Integer.valueOf(order.amount).toString() + " Forks");
			        }
		
			        if(order.appetizers){
			        	if(eightInchPlates) {
			        		writer.write(Integer.valueOf(order.amount).toString() + " 8\" plates");
				        	writer.newLine();
				        	System.out.println(Integer.valueOf(order.amount).toString() + " 8\" plates");
			        	}
			        	
			        	writer.write(Integer.valueOf(order.amount).toString() + " Dinner Napkins");
			        	writer.newLine();
			        	writer.write(Integer.valueOf(order.amount).toString() + " Forks");
			        	writer.newLine();
			        	
			            
			            System.out.println(Integer.valueOf(order.amount).toString() + " Dinner Napkins");
			            System.out.println(Integer.valueOf(order.amount).toString() + " Forks");
			        }
	
		    }
	
		    if("CCFS".equals(order.demand) && (order.cold || order.hot)){
		        
		        System.out.println("Beverage Selected");
	
		        if(order.cold){
		        	writer.write(Integer.valueOf(order.amount).toString() + " Beverage Napkin");
		        	writer.newLine();
		        	writer.write(Integer.valueOf(order.amount).toString() + " Cold Cup");
		        	writer.newLine();
		        	writer.write(Integer.valueOf(order.amount).toString() + " 1 drip tray for each container");
		        	writer.newLine();
		        	
		            System.out.println(Integer.valueOf(order.amount).toString() + " Beverage Napkin");
		            System.out.println(Integer.valueOf(order.amount).toString() + " Cold Cup");
		            System.out.println(Integer.valueOf(order.amount).toString() + " 1 drip tray for each container");
		        }
		        
		        if(order.hot){
		        	writer.write(Integer.valueOf(order.amount).toString() + " Beverage Napkin");
		        	writer.newLine();
		        	writer.write(Integer.valueOf(order.amount).toString() + " Hot Cup");
		        	writer.newLine();
		        	writer.write(Integer.valueOf(order.amount).toString() + " Stir Cup");
		        	writer.newLine();
		        	writer.write(Integer.valueOf(order.amount).toString() + " 1 drip tray for each container");
		        	writer.newLine();
		        	
		        	
		            System.out.println(Integer.valueOf(order.amount).toString() + " Beverage Napkin");
		            System.out.println(Integer.valueOf(order.amount).toString() + " Hot Cup");
		            System.out.println(Integer.valueOf(order.amount).toString() + " Stir Cup");
		            System.out.println(Integer.valueOf(order.amount).toString() + " 1 drip tray for each container");
		        }
		    }
		    
		    writer.close();
		    
		    
		} catch (IOException e) {
            // Trata exceções de E/S (Input/Output)
            e.printStackTrace();
        }
		
		return fileName;
	}
}
