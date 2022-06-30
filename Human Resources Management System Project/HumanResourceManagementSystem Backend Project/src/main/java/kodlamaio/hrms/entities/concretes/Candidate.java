package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "candidates")
public class Candidate extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "identification_number")
	private String identificationNumber;

	@Column(name = "birth_date")
	private Date birthDate;

	@OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Favourites> favourites;

}
