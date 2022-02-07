package lab4.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lab4.Model.CarSelling;
import lab4.Service.CarSellingService;

@RestController
public class CarSellingController {
	
	@Autowired
	private CarSellingService service;
	
	@GetMapping("/ListCarsSelling")
	public List<CarSelling> listSellingPositions(){
		return service.listAll();
	}
	
	@GetMapping("/ListCarsSelling/{code}")
	public ResponseEntity<CarSelling> selectPosition(@PathVariable Integer code){
		try {
	        CarSelling position = service.get(code);
	        return new ResponseEntity<CarSelling>(position, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<CarSelling>(HttpStatus.NOT_FOUND);
	    }  
	}
	
	@PostMapping("/ListCarsSelling")
	public void insertPosition(@RequestBody CarSelling position){
		service.save(position);
	}
	
	@PutMapping("/ListCarsSelling/{code}")
	public ResponseEntity<?> updatePosition(@RequestBody CarSelling position, @PathVariable Integer code) {
	    try {
	        CarSelling existPosition = service.get(code);
	        service.save(position);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/ListCarsSelling/{code}")
	public void delete(@PathVariable Integer code) {
	    service.delete(code);
	}
}
