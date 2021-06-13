package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {

	@JsonIgnore
	private int id;

	private int employerId;

	private int jobtitleId;

	private int cityId;

	private String description;

	private int quota;

	private LocalDateTime appealExpirationDate;

	private LocalDateTime createdDate = LocalDateTime.now();

	private Double minSalary;

	private Double maxSalary;

	private boolean isActive;

	private int workHourId;

	private int workTypeId;

}
