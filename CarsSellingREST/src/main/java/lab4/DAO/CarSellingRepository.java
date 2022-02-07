package lab4.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import lab4.Model.CarSelling;

public interface CarSellingRepository extends JpaRepository<CarSelling, Integer> {

}
