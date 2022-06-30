package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name = "job_titles")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisement" })
public class JobTitle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@OneToMany(mappedBy = "jobtitle")
	private List<JobAdvertisement> jobAdvertisement;

}
