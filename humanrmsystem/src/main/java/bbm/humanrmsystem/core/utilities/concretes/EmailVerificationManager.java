package bbm.humanrmsystem.core.utilities.concretes;


import org.springframework.stereotype.Service;

import bbm.humanrmsystem.core.utilities.abstracts.EmailVerificationService;
import bbm.humanrmsystem.entities.concretes.Employer;
import bbm.humanrmsystem.entities.concretes.JobSeeker;

@Service
public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public void sendMailJobSeeker(JobSeeker jobSeeker) {
		System.out.println("Onay maili yollandi : " + jobSeeker.getEmail());
		
	}

	@Override
	public void sendMailEmployer(Employer employer) {

		System.out.println("Onay maili yollandi : " + employer.getEmail());
		
	}

	

}
