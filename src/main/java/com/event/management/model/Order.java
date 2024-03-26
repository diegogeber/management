package com.event.management.model;

public class Order {
	
	public Order(int amount, String demand, boolean buffet, boolean mainDishes, boolean deserts, boolean appetizers, boolean cold, boolean hot, boolean soda){
        this.amount = amount;
        this.demand = demand;
        this.buffet = buffet;
        this.mainDishes = mainDishes;
        this.deserts = deserts;
        this.appetizers = appetizers;
        this.cold = cold;
        this.hot = hot;
        this.soda = soda;
    }

    public int amount;
    public String demand;
    public boolean buffet;
    public boolean mainDishes;
    public boolean deserts;
    public boolean appetizers;
    public boolean cold;
    public boolean hot;
    public boolean soda;
    
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDemand() {
		return demand;
	}
	public void setDemand(String demand) {
		this.demand = demand;
	}
	public boolean isBuffet() {
		return buffet;
	}
	public void setBuffet(boolean buffet) {
		this.buffet = buffet;
	}
	public boolean isMainDishes() {
		return mainDishes;
	}
	public void setMainDishes(boolean mainDishes) {
		this.mainDishes = mainDishes;
	}
	public boolean isDeserts() {
		return deserts;
	}
	public void setDeserts(boolean deserts) {
		this.deserts = deserts;
	}
	public boolean isAppetizers() {
		return appetizers;
	}
	public void setAppetizers(boolean appetizers) {
		this.appetizers = appetizers;
	}
	public boolean isCold() {
		return cold;
	}
	public void setCold(boolean cold) {
		this.cold = cold;
	}
	public boolean isHot() {
		return hot;
	}
	public void setHot(boolean hot) {
		this.hot = hot;
	}
	public boolean isSoda() {
		return soda;
	}
	public void setSoda(boolean soda) {
		this.soda = soda;
	}
}
