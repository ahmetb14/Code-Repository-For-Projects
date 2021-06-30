package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateTalentService;
import kodlamaio.hrms.core.utilites.converters.DtoConverterService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateTalentDao;
import kodlamaio.hrms.entities.concretes.CandidateTalent;
import kodlamaio.hrms.entities.dtos.CandidateTalentDto;

@Service
public class CandidateTalentManager implements CandidateTalentService {

	private CandidateTalentDao candidateTalentDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public CandidateTalentManager(CandidateTalentDao candidateTalentDao, DtoConverterService dtoConverterService) {

		this.candidateTalentDao = candidateTalentDao;
		this.dtoConverterService = dtoConverterService;

	}

	@Override
	public DataResult<List<CandidateTalent>> getAll() {

		return new SuccessDataResult<List<CandidateTalent>>(this.candidateTalentDao.findAll(),
				" -> İş Arayanın Yetenek Bilgileri Sistemden Başarıyla Listelendi!");

	}

	@Override
	public Result add(CandidateTalentDto talent) {

		if (this.candidateTalentDao.existsCvIdAndTalentId(talent.getCvId(), talent.getTalentId()) != null) {

			return new ErrorResult(" -> Girilen İçerik Önceden Sisteme Eklenmiş Lütfen Tekrar Deneyiniz!");

		} else {

			this.candidateTalentDao
					.save((CandidateTalent) this.dtoConverterService.dtoClassConverter(talent, CandidateTalent.class));
			return new SuccessResult(" -> İşlem Başarılı!");

		}
	}

}
