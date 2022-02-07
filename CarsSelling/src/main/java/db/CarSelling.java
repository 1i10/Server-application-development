package db;


public class CarSelling {
	protected int code;
	protected String manufacturer;
	protected String model;
	protected String color;
	protected String transmission;
	protected String body_type;
	protected float price;
	
	public CarSelling() {	
	}
	
	public CarSelling(int code) {
		this.code = code;
	}
	
	public CarSelling(int code, String manufacturer, String model, String color, 
			String transmission, String body_type, float price) {
		this(manufacturer, model, color, transmission, body_type, price);
		this.code = code;
	}
	
	public CarSelling(String manufacturer, String model, String color, String transmission,
			String body_type, float price) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.color = color;
		this.transmission = transmission;
		this.body_type = body_type;
		this.price = price;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
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
