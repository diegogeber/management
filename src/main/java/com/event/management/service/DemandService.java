package com.event.management.service;

import org.springframework.stereotype.Service;

import com.event.management.enumerator.TypeDemandEnum;
import com.event.management.model.Order;

@Service
public class DemandService {
	
	public void avaliateDemand(TypeDemandEnum typeOrder, int amount, boolean hasBuffet,
			boolean mainDishes, boolean deserts, boolean appetizers, boolean cold, boolean hot, boolean soda) {
		Order order = new Order(amount, typeOrder.name() , hasBuffet, mainDishes, deserts, appetizers, cold, hot, soda);
	    
	    ccfs(order);
	}

	private void ccfs(Order order) {
		if("CCFS".equals(order.demand)){
	        System.out.println("Order Demand Campus Catering Full Service");
	    }

	    if("CCFS".equals(order.demand) && order.buffet){
	        
	        System.out.println("Buffet Selected");

	        if(order.mainDishes){
	            System.out.println(Integer.valueOf(order.amount).toString() + " 10\" plates");
	            System.out.println(Integer.valueOf(order.amount).toString() + " Utensil Kit");
	            System.out.println(Integer.valueOf(order.amount).toString() + " Dinner Napkin");
	        }
	        
	        if(order.deserts){
	            System.out.println(Integer.valueOf(order.amount).toString() + " 6\" plates");
	            System.out.println(Integer.valueOf(order.amount).toString() + " Beverage Napkin");
	            System.out.println(Integer.valueOf(order.amount).toString() + " Forks");
	        }

	        if(order.appetizers){
	            System.out.println(Integer.valueOf(order.amount).toString() + " 8\" plates");
	            System.out.println(Integer.valueOf(order.amount).toString() + " Dinner Napkins");
	            System.out.println(Integer.valueOf(order.amount).toString() + " Forks");
	        }

	    }

	    if("CCFS".equals(order.demand) && (order.cold || order.hot)){
	        
	        System.out.println("Beverage Selected");

	        if(order.cold){
	            System.out.println(Integer.valueOf(order.amount).toString() + " Beverage Napkin");
	            System.out.println(Integer.valueOf(order.amount).toString() + " Cold Cup");
	            System.out.println(Integer.valueOf(order.amount).toString() + " 1 drip tray for each container");
	        }
	        
	        if(order.hot){
	            System.out.println(Integer.valueOf(order.amount).toString() + " Beverage Napkin");
	            System.out.println(Integer.valueOf(order.amount).toString() + " Hot Cup");
	            System.out.println(Integer.valueOf(order.amount).toString() + " Stir Cup");
	            System.out.println(Integer.valueOf(order.amount).toString() + " 1 drip tray for each container");
	        }
	    }
	}
}
