package bbm.humanrmsystem.core.utilities.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbm.humanrmsystem.core.utilities.abstracts.IdentityCheckService;
import bbm.humanrmsystem.dataAccess.abstracts.JobSeekerDao;
import bbm.humanrmsystem.entities.concretes.JobSeeker;

@Service
public class IdentityCheckManager implements IdentityCheckService {

	private JobSeekerDao jobSeekerDao;
	private List<String> identities = new ArrayList<String>();

	@Autowired
	public IdentityCheckManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public List<String> identityCheckDataBase() {

		List<JobSeeker> jobSeekerGetAll = this.jobSeekerDao.findAll();
		int numberOfidentities = jobSeekerGetAll.size();

		for (int i = 0; i < numberOfidentities; i++) {

			identities.add(jobSeekerGetAll.get(i).getIdentityNumber());
		}
		return identities;

	}

	@Override
	public boolean identityIsItUsed(String identity) {

		boolean IsItUsed = false;

		if (this.identityCheckDataBase().contains(identity)) {
			IsItUsed = true;
		}
		return IsItUsed;
	}

}
