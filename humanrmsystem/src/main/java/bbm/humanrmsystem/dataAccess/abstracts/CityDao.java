package bbm.humanrmsystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import bbm.humanrmsystem.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{
	
}
