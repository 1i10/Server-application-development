package com.lab2.CarsSellingRESTjdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CarSellingDAOImpl implements CarSellingDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CarSelling> listSellingPositions(){
		String sql = "select *from CarsSelling";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<CarSelling>(CarSelling.class));
	}
	
	@Override
	public CarSelling selectPosition(Integer code) {
		String sql = "select *from CarsSelling where code = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<CarSelling>(CarSelling.class), code);
	}
	
	@Override
	public Integer insertPosition(CarSelling position) {
		String sql = "insert into CarsSelling(manufacturer, model, color, transmission, "
        		+ "body_type, price) values(?, ?, ?, ?, ?, ?)";
		
		String manufacturer = position.getManufacturer();
     	String model = position.getModel();
     	String color = position.getColor();
     	String transmission = position.getTransmission();
     	String body_type = position.getBody_type();
     	float price = position.getPrice();
		
		
		return jdbcTemplate.update(sql, new Object[] {manufacturer, model, color, transmission, body_type, price});
	}
	
	@Override
	public Integer deletePosition(Integer code) {
		String sql = "delete from CarsSelling where code = ?";
		
		return jdbcTemplate.update(sql, code);
	}
	
	@Override
	public Integer updatePosition(CarSelling position, Integer code){
		String sql = "update CarsSelling set manufacturer = ?, model = ?, color = ?, " + 
        		"transmission = ?, body_type = ?, price = ? where code = ?";
		
		String manufacturer = position.getManufacturer();
     	String model = position.getModel();
     	String color = position.getColor();
     	String transmission = position.getTransmission();
     	String body_type = position.getBody_type();
     	float price = position.getPrice();
     	
		return jdbcTemplate.update(sql, new Object[] {manufacturer, model, color, transmission, body_type, price, code});
	}
}
