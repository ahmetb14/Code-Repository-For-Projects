package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
public class Employer extends User {

	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_address")
	private String webAdress;
	
	@Column(name = "phone_number")
	private String phoneNumber;

}
