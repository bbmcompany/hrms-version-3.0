package bbm.humanrmsystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bbm.humanrmsystem.business.abstracts.CityService;
import bbm.humanrmsystem.business.abstracts.EmployerService;
import bbm.humanrmsystem.business.abstracts.JobAdvertisementService;
import bbm.humanrmsystem.business.abstracts.JobPositionService;
import bbm.humanrmsystem.business.abstracts.JobSeekerService;
import bbm.humanrmsystem.core.utilities.results.DataResult;
import bbm.humanrmsystem.core.utilities.results.Result;
import bbm.humanrmsystem.entities.concretes.City;
import bbm.humanrmsystem.entities.concretes.EmailVerification;
import bbm.humanrmsystem.entities.concretes.Employer;
import bbm.humanrmsystem.entities.concretes.HrmsVerification;
import bbm.humanrmsystem.entities.concretes.JobAdvertisement;
import bbm.humanrmsystem.entities.concretes.JobPosition;
import bbm.humanrmsystem.entities.concretes.JobSeeker;
import bbm.humanrmsystem.entities.concretes.MernisVerification;

@RestController
@RequestMapping("/hrms")
public class HrmsControllers {
	
	private JobSeekerService jobSeekerService;
	private JobAdvertisementService jobAdvertisementService;
	private EmployerService employerService;
	private JobPositionService JobPositionService;
	private CityService cityService;
	
	@Autowired
	public HrmsControllers(JobSeekerService jobSeekerService, JobAdvertisementService jobAdvertisementService, EmployerService employerService,
			JobPositionService JobPositionService, CityService cityService) {
		super();
		this.jobSeekerService = jobSeekerService;
		this.jobAdvertisementService = jobAdvertisementService;
		this.employerService = employerService;
		this.JobPositionService = JobPositionService;
		this.cityService = cityService;
	}
	
	@GetMapping("/jobSeekerGetAll")
	public DataResult<List<JobSeeker>> jobSeekergetAll(){
		return this.jobSeekerService.getAll();
	}
	
	@PostMapping("/jobSeekerRegister")
	public Result add(@RequestBody JobSeeker jobSeeker, EmailVerification emailVerification, MernisVerification mernisVerification) {
		return this.jobSeekerService.register(jobSeeker , emailVerification, mernisVerification);
	}
	
	@GetMapping("/jobAdvertisementGetAll")
	public DataResult<List<JobAdvertisement>> jobAdvertisementGetAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/jobAdvertisementGetAllActive")
	public DataResult<List<JobAdvertisement>> jobAdvertisementGetAllActiv(){
		return this.jobAdvertisementService.getByIsActive();
	}
	
	@PostMapping("/jobAdvertisementAdd")
	public Result jobAdvertisementAdd(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/employerGetAll")
	public DataResult<List<Employer>> employerGetAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/employerRegister")
	public Result employerAdd(@RequestBody Employer employer, HrmsVerification hrmsVerification, EmailVerification emailVerification) {
		return this.employerService.register(employer,hrmsVerification, emailVerification);
	}
	
	@GetMapping("/jobPositionGetAll")
	public DataResult<List<JobPosition>> jobPositionGetAll(){
		return this.JobPositionService.getAll();
	}
	
	@PostMapping("/jobPositionAdd")
	public Result jobPositionAdd(@RequestBody JobPosition jobPosition) {
		return this.JobPositionService.add(jobPosition);
	}
	
	@GetMapping("/cityGetAll")
	public DataResult<List<City>> cityGetAll(){
		return this.cityService.getAll();
	}
	
	@PostMapping("/cityAdd")
	public Result cityAdd(@RequestBody City city) {
		return this.cityService.add(city);
	}
	
	@GetMapping("/jobAdvertisementGetAllSortedByDeadline")
	public DataResult<List<JobAdvertisement>> getAllSortedByDeadline(){
		return this.jobAdvertisementService.getAllSortedByDeadline();
	}
	
	@GetMapping("/jobAdvertisementgetBycompanyNameAndIsActive")
	public DataResult<List<JobAdvertisement>> getBycompanyNameAndIsActive(@RequestParam("companyName") String companyName){
		return this.jobAdvertisementService.getByEmployer_CompanyNameAndIsActive(companyName);
	}
	
	@PostMapping("/jobAdvertisementIsActive")
	public Result update(int id , boolean isAvtice) {
		return this.jobAdvertisementService.update(id, isAvtice);
	}
	
	

}
