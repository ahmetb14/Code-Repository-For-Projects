package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.dtos.abstracts.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDto extends UserDto {

	private int id;

	private String company_name;

	private String webAddress;

	private String phoneNumber;

}
