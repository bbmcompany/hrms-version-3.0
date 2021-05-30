package bbm.humanrmsystem.core.utilities.abstracts;

import bbm.humanrmsystem.entities.concretes.Employer;
import bbm.humanrmsystem.entities.concretes.JobSeeker;

public interface EmailVerificationService {
	
	public void sendMailJobSeeker(JobSeeker jobSeeker);
	public void sendMailEmployer(Employer employer);

}
