package bbm.humanrmsystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import bbm.humanrmsystem.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
