package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateTalentService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateTalentDao;
import kodlamaio.hrms.entities.concretes.CandidateTalent;

@Service
public class CandidateTalentManager implements CandidateTalentService {

	private CandidateTalentDao candidateTalentDao;

	@Autowired
	public CandidateTalentManager(CandidateTalentDao candidateTalentDao) {

		this.candidateTalentDao = candidateTalentDao;

	}

	@Override
	public DataResult<List<CandidateTalent>> getAll() {

		return new SuccessDataResult<List<CandidateTalent>>(this.candidateTalentDao.findAll(),
				" -> İş Arayanın Yetenekleri Sistemden Başarıyla Listelendi!");

	}

}
