package bbm.humanrmsystem.business.abstracts;

import java.util.List;

import bbm.humanrmsystem.core.utilities.results.DataResult;
import bbm.humanrmsystem.core.utilities.results.Result;
import bbm.humanrmsystem.entities.concretes.City;


public interface CityService {
	
	public Result add(City city);
	public DataResult<List<City>> getAll();

}
