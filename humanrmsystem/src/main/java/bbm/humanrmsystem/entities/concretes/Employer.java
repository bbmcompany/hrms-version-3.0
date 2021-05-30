package bbm.humanrmsystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","JobAdvertisement"})
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
public class Employer extends User{
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "password_repeat")
	private String passwordRepeat;
	
	@Column(name = "website")
	private String website;
	
	public Employer(String email, String password, String companyName, String website, String phoneNumber) {
		super(email, password);
		this.companyName = companyName;
		this.website = website;
		this.phoneNumber = phoneNumber;
	}
	
	
	

}
