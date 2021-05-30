package bbm.humanrmsystem.core.utilities.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbm.humanrmsystem.core.utilities.abstracts.EmailCheckService;
import bbm.humanrmsystem.dataAccess.abstracts.JobSeekerDao;
import bbm.humanrmsystem.entities.concretes.JobSeeker;

@Service
public class EmailCheckManager implements EmailCheckService{

	private JobSeekerDao jobSeekerDao;
	private List<String> emails = new ArrayList<String>();
	
	@Autowired
	public EmailCheckManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public List<String> emailCheckDataBase() {
		
		
		List<JobSeeker> jobSeekerGetAll = this.jobSeekerDao.findAll();
		int numberOfEmail = jobSeekerGetAll.size();
		
		for(int i = 0 ; i < numberOfEmail ; i++) {
			
			emails.add(jobSeekerGetAll.get(i).getEmail());
		}
		return emails;
		
		
	}

	@Override
	public boolean emailIsItUsed(String email) {
		boolean IsItUsed = false;
		
		if(this.emailCheckDataBase().contains(email)){
			IsItUsed = true;
		}
		return IsItUsed;
		
	}
	
	
	
	

}
