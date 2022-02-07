package com.lab2.CarsSellingRESTjdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarSellingController {
	
	@Autowired
	private CarSellingDAO csDAO;
	
	@GetMapping("/ListCarsSelling")
	public List<CarSelling> listSellingPositions(){
		return csDAO.listSellingPositions();
	}
	
	@GetMapping("/ListCarsSelling/{code}")
	public CarSelling selectPosition(@PathVariable Integer code){
		return csDAO.selectPosition(code);
	}
	
	@PostMapping("/ListCarsSelling")
	public String insertPosition(@RequestBody CarSelling position){
		return csDAO.insertPosition(position) + " position saved successfully";
	}
	
	@PutMapping("/ListCarsSelling/{code}")
	public String updatePosition(@RequestBody CarSelling position, @PathVariable Integer code) {
	   return csDAO.updatePosition(position, code) + " position updated successfully";    
	}
	
	@DeleteMapping("/ListCarsSelling/{code}")
	public String delete(@PathVariable Integer code) {
	    return csDAO.deletePosition(code) + " position delete from the database";
	}
}
