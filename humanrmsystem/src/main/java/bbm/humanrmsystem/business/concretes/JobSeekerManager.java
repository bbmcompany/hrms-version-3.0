package bbm.humanrmsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbm.humanrmsystem.business.abstracts.JobSeekerService;
import bbm.humanrmsystem.core.utilities.abstracts.EmailCheckService;
import bbm.humanrmsystem.core.utilities.abstracts.EmailVerificationService;
import bbm.humanrmsystem.core.utilities.abstracts.IdentityCheckService;
import bbm.humanrmsystem.core.utilities.abstracts.MernisVerificationService;
import bbm.humanrmsystem.core.utilities.results.DataResult;
import bbm.humanrmsystem.core.utilities.results.ErrorResult;
import bbm.humanrmsystem.core.utilities.results.Result;
import bbm.humanrmsystem.core.utilities.results.SuccessDataResult;
import bbm.humanrmsystem.core.utilities.results.SuccessResult;
import bbm.humanrmsystem.dataAccess.abstracts.JobSeekerDao;
import bbm.humanrmsystem.entities.concretes.EmailVerification;
import bbm.humanrmsystem.entities.concretes.JobSeeker;
import bbm.humanrmsystem.entities.concretes.MernisVerification;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private EmailCheckService emailCheckService;
	private IdentityCheckService identityCheckService;
	private EmailVerificationService emailVerificationService;
	private MernisVerificationService mernisVerificationService;


	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, EmailCheckService emailCheckService,
			IdentityCheckService identityCheckService, EmailVerificationService emailVerificationService,
			MernisVerificationService mernisVerificationService
			) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.emailCheckService = emailCheckService;
		this.identityCheckService = identityCheckService;
		this.emailVerificationService = emailVerificationService;
		this.mernisVerificationService = mernisVerificationService;
	}

	@Override
	public Result register(JobSeeker jobSeeker, EmailVerification emailVerification, MernisVerification mernisVerification) {

		Result result = new SuccessResult("Kayit basarili.");

		if (emailCheckService.emailIsItUsed(jobSeeker.getEmail())) {
			result = new ErrorResult("Email sisteme kayitli.");
			return result;
		}if (identityCheckService.identityIsItUsed(jobSeeker.getIdentityNumber())) {
			result = new ErrorResult("Kimlik numarasi sisteme kayitli.");
			return result;
		}if(emailVerification.isEmailBool() == false) {
			result = new ErrorResult("Email onayi gerekiyor.");
			return result;
		}if(mernisVerification.isMernisBool() == false){
			result = new ErrorResult("Mernis onayi gerekiyor.");
			
		}else {
			this.mernisVerificationService.mernisVerification();
			this.emailVerificationService.sendMailJobSeeker(jobSeeker);
			this.jobSeekerDao.save(jobSeeker);
			
		}
		return result;

	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {

		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Data getirildi.");
	}

}
