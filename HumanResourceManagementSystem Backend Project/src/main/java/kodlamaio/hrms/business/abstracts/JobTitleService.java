package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleService {

	DataResult<JobTitle> add(JobTitle title);

	List<JobTitle> getAll();

	List<JobTitle> findJobTitles(String title);

}
