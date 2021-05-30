package bbm.humanrmsystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import bbm.humanrmsystem.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

}
