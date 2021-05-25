package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@Entity
@Table(name = "candidates")
public class Candidate extends User {

	public Candidate(Integer id, String email, String password, String firstName, String lastName, Date birthDate,
			String identificationNumber) {

		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.identificationNumber = identificationNumber;

	}

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "identification_number")
	private String identificationNumber;

	@Column(name = "birth_date")
	private Date birthDate;
}
