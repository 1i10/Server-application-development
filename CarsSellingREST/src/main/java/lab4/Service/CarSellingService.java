package lab4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab4.DAO.CarSellingRepository;
import lab4.Model.CarSelling;

@Service
public class CarSellingService {
	
	@Autowired
	private CarSellingRepository repo;
	
	public List<CarSelling> listAll(){
		return repo.findAll();
	}
	
	public void save(CarSelling carSelling) {
		repo.save(carSelling);
	}
	
	public CarSelling get(Integer code) {
		return repo.findById(code).get();
	}
	
	public void delete(Integer code) {
		repo.deleteById(code);
	}
	
}
