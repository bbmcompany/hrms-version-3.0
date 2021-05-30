package bbm.humanrmsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbm.humanrmsystem.business.abstracts.EmployerService;
import bbm.humanrmsystem.core.utilities.abstracts.EmailCheckService;
import bbm.humanrmsystem.core.utilities.results.DataResult;
import bbm.humanrmsystem.core.utilities.results.ErrorResult;
import bbm.humanrmsystem.core.utilities.results.Result;
import bbm.humanrmsystem.core.utilities.results.SuccessDataResult;
import bbm.humanrmsystem.core.utilities.results.SuccessResult;
import bbm.humanrmsystem.dataAccess.abstracts.EmployerDao;
import bbm.humanrmsystem.entities.concretes.EmailVerification;
import bbm.humanrmsystem.entities.concretes.Employer;
import bbm.humanrmsystem.entities.concretes.HrmsVerification;


@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmailCheckService emailCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailCheckService emailCheckService) {
		super();
		this.employerDao = employerDao;
		this.emailCheckService = emailCheckService;
	}

	@Override
	public Result register(Employer employer, HrmsVerification hrmsVerification ,EmailVerification emailVerification) {

		Result result = new SuccessResult("Kayit basarili.");

		if (emailCheckService.emailIsItUsed(employer.getEmail())) {
			result = new ErrorResult("Email sisteme kayitli.");
			return result;
		}if(emailVerification.isEmailBool() == false){
			result = new ErrorResult("Email onayi gerekiyor.");
			return result;
			
		}if(hrmsVerification.isHrmsBool() == false){
			result = new ErrorResult("Hrms onayi gerekiyor.");
			return result;
		}else {
			this.employerDao.save(employer);
			
		}
		return result;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data getirildi.");
	}

}
