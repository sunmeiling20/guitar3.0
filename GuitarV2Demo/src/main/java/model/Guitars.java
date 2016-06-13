package model;

import java.util.Map;

public class Guitars {
	private String number;
	private double price;
	Guitar guitar;

	public Guitars(String number, double price, Guitar guitar) {
		this.number = number;
		this.price = price;
		this.guitar = guitar;
	}

	
	

	


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Guitar getGuitar() {
		return guitar;
	}

	public void setGuitar(Guitar guitar) {
		this.guitar = guitar;
	}
	

}
