package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateJobExperienceService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateJobExperienceDao;
import kodlamaio.hrms.entities.concretes.CandidateJobExperience;

@Service
public class CandidateJobExperienceManager implements CandidateJobExperienceService {

	private CandidateJobExperienceDao candidateJobExperienceDao;
	private CandidateCvDao candidateCvDao;

	@Autowired
	public CandidateJobExperienceManager(CandidateJobExperienceDao candidateJobExperienceDao,
			CandidateCvDao candidateCvDao) {

		super();
		this.candidateJobExperienceDao = candidateJobExperienceDao;
		this.candidateCvDao = candidateCvDao;

	}

	@Override
	public DataResult<List<CandidateJobExperience>> orderedCandidateCvJobExperience(int id) {

		if (!this.candidateCvDao.existsById(id)) {

			return new ErrorDataResult<>(" -> İstenen Cv Bulunamadı Lütfen Tekrar Deneyiniz!");

		}

		return new SuccessDataResult<List<CandidateJobExperience>>(

				this.candidateJobExperienceDao.getJobExperienceOrderByExitDateDesc(id),
				" -> İş Arayanın Tecrübe Bilgileri Sistemden Başarıyla Listelendi!");

	}

	@Override
	public DataResult<List<CandidateJobExperience>> getAll() {

		return new SuccessDataResult<List<CandidateJobExperience>>(this.candidateJobExperienceDao.findAll(),
				" -> İş Adayının Deneyimleri Sistemden Başarıyla Listelendi!");

	}

}
