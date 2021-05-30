package bbm.humanrmsystem.business.abstracts;

import java.util.List;



import bbm.humanrmsystem.core.utilities.results.DataResult;
import bbm.humanrmsystem.core.utilities.results.Result;
import bbm.humanrmsystem.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	public Result add(JobAdvertisement jobAdvertisement);
	public DataResult<List<JobAdvertisement>> getAll();
	public DataResult<List<JobAdvertisement>> getByIsActive();
	public DataResult<List<JobAdvertisement>> getAllSortedByDeadline();
	
	public DataResult<List<JobAdvertisement>> getByEmployer_CompanyNameAndIsActive(String companyName);
	
	public Result update(int id , boolean isAvtice);
	
	
	
	

}
