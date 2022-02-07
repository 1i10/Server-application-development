package com.lab2.CarsSellingRESTjdbc;


public class CarSelling {
	private Integer code;
	private String manufacturer;
	private String model;
	private String color;
	private String transmission;
	private String body_type;
	private float price;

	public CarSelling() {
	}

	public CarSelling(String manufacturer, String model, String color, String transmission, String body_type,
			float price) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.color = color;
		this.transmission = transmission;
		this.body_type = body_type;
		this.price = price;
	}
	
	public CarSelling(Integer code, String manufacturer, String model, String color, String transmission, String body_type,
			float price) {
		this.code = code;
		this.manufacturer = manufacturer;
		this.model = model;
		this.color = color;
		this.transmission = transmission;
		this.body_type = body_type;
		this.price = price;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getBody_type() {
		return body_type;
	}

	public void setBody_type(String body_type) {
		this.body_type = body_type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
