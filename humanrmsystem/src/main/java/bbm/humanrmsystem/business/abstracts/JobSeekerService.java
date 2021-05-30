package bbm.humanrmsystem.business.abstracts;

import java.util.List;

import bbm.humanrmsystem.core.utilities.results.DataResult;
import bbm.humanrmsystem.core.utilities.results.Result;
import bbm.humanrmsystem.entities.concretes.EmailVerification;
import bbm.humanrmsystem.entities.concretes.JobSeeker;
import bbm.humanrmsystem.entities.concretes.MernisVerification;

public interface JobSeekerService {
	
	public Result register(JobSeeker jobSeeker, EmailVerification emailVerification, MernisVerification mernisVerification);
	public DataResult<List<JobSeeker>> getAll();

}
