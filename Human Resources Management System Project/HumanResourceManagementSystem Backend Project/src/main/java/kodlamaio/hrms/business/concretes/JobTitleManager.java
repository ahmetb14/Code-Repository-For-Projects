package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;

@Service
public class JobTitleManager implements JobTitleService {

	@Autowired
	private JobTitleDao jobTitleDao;

	public JobTitleManager() {

	}

	@Override
	public DataResult<List<JobTitle>> getAll() {

		return new SuccessDataResult<List<JobTitle>>(jobTitleDao.findAll(),
				" -> İş Pozisyonları Sistemden Listelendi!");

	}

	@Override
	public DataResult<JobTitle> add(JobTitle title) {

		if (jobTitleDao.findAllByTitle(title.getTitle()).stream().count() != 0) {

			return new ErrorDataResult<JobTitle>(null,
					" -> Bu İş Pozisyonu Sistemde Zaten Mevcut Lütfen Tekrar Deneyiniz!");

		}

		return new SuccessDataResult<JobTitle>(this.jobTitleDao.save(title),
				" -> Girilen İş Pozisyonu Sisteme Başarıyla Eklendi!");

	}

	@Override
	public DataResult<List<JobTitle>> findJobTitles(String title) {

		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findJobTitles(title),
				" -> İstenen Girdiler Sistemden Listelendi!");

	}

}
