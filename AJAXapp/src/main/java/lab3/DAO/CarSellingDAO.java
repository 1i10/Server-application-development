package lab3.DAO;

import java.util.List;

import lab3.Model.CarSelling;

public interface CarSellingDAO {
	
	public List<CarSelling> listSellingPositions();
	
	public CarSelling selectPosition(Integer code);
	
	public Integer insertPosition(CarSelling position);
	
	public Integer deletePosition(Integer code);
	
	public Integer updatePosition(CarSelling position, Integer code);
}
