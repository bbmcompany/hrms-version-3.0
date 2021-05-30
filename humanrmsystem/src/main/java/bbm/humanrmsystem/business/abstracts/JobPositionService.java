package bbm.humanrmsystem.business.abstracts;

import java.util.List;

import bbm.humanrmsystem.core.utilities.results.DataResult;
import bbm.humanrmsystem.core.utilities.results.Result;
import bbm.humanrmsystem.entities.concretes.JobPosition;

public interface JobPositionService {
	
	public Result add(JobPosition jobPosition);
	public DataResult<List<JobPosition>> getAll();

}
