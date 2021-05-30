package bbm.humanrmsystem.business.abstracts;

import java.util.List;

import bbm.humanrmsystem.core.utilities.results.DataResult;
import bbm.humanrmsystem.core.utilities.results.Result;
import bbm.humanrmsystem.entities.concretes.EmailVerification;
import bbm.humanrmsystem.entities.concretes.Employer;
import bbm.humanrmsystem.entities.concretes.HrmsVerification;

public interface EmployerService {
	
	public Result register(Employer employer, HrmsVerification hrmsVerification, EmailVerification emailVerification);
	public DataResult<List<Employer>> getAll();

}
