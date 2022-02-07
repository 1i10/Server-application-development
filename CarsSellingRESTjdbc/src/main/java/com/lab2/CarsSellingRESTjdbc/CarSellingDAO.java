package com.lab2.CarsSellingRESTjdbc;

import java.util.List;

public interface CarSellingDAO {
	
	public List<CarSelling> listSellingPositions();
	
	public CarSelling selectPosition(Integer code);
	
	public Integer insertPosition(CarSelling position);
	
	public Integer deletePosition(Integer code);
	
	public Integer updatePosition(CarSelling position, Integer code);
}
