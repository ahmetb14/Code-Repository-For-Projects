package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateJobExperienceService;
import kodlamaio.hrms.core.utilites.converters.DtoConverterService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateJobExperienceDao;
import kodlamaio.hrms.entities.concretes.CandidateJobExperience;

import kodlamaio.hrms.entities.dtos.CandidateJobExperienceDto;

@Service
public class CandidateJobExperienceManager implements CandidateJobExperienceService {

	private CandidateJobExperienceDao candidateJobExperienceDao;
	private CandidateCvDao candidateCvDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public CandidateJobExperienceManager(CandidateJobExperienceDao candidateJobExperienceDao,
			CandidateCvDao candidateCvDao, DtoConverterService dtoConverterService) {

		super();
		this.candidateJobExperienceDao = candidateJobExperienceDao;
		this.candidateCvDao = candidateCvDao;
		this.dtoConverterService = dtoConverterService;

	}

	@Override
	public DataResult<List<CandidateJobExperience>> orderedCandidateCvJobExperience(int id) {

		if (!this.candidateCvDao.existsById(id)) {
			return new ErrorDataResult<>(" -> İş Arayan Cv Bilgileri Sistemde Bulunamadı Lütfen Tekrar Deneyiniz!");
		}

		return new SuccessDataResult<List<CandidateJobExperience>>(
				this.candidateJobExperienceDao.getJobExperienceOrderByExitDateDesc(id),
				" -> İş Arayanın Tecrübe Bilgileri Sistemden Başarıyla Listelendi!");

	}

	@Override
	public DataResult<List<CandidateJobExperience>> getAll() {

		return new SuccessDataResult<List<CandidateJobExperience>>(this.candidateJobExperienceDao.findAll(),
				" -> İş Arayanın Deneyim Bilgileri Sistemden Başarıyla Listelendi!");

	}

	@Override
	public Result add(CandidateJobExperienceDto jobExp) {

		this.candidateJobExperienceDao.save((CandidateJobExperience) this.dtoConverterService.dtoClassConverter(jobExp,
				CandidateJobExperience.class));

		return new SuccessResult(" -> İşlem Başarılı!");

	}

	@Override
	public DataResult<List<CandidateJobExperience>> getById(int id) {

		return new SuccessDataResult<List<CandidateJobExperience>>(this.candidateJobExperienceDao.getById(id),
				" -> İşlem Başarılı!");

	}

	@Override
	public Result update(CandidateJobExperienceDto jobExp) {

		CandidateJobExperience ref = this.candidateJobExperienceDao.findById(jobExp.getId());

		if (jobExp.getWorkplaceName() != null) {
			ref.setWorkplaceName(jobExp.getWorkplaceName());
		}

		if (jobExp.getEntryDate() != null) {
			ref.setEntryDate(jobExp.getEntryDate());
		}

		if (jobExp.getExitDate() != null) {
			ref.setExitDate(jobExp.getExitDate());
		}

		if (jobExp.getJobDetail() != null) {
			ref.setJobDetail(jobExp.getJobDetail());
		}

		this.candidateJobExperienceDao.save(ref);

		return new SuccessResult("id:" + ref.getWorkplaceName());

	}

}
