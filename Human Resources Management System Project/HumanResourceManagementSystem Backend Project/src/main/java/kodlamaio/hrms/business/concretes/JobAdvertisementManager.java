package kodlamaio.hrms.business.concretes;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.specifications.JobAdvertisementSpecification;
import kodlamaio.hrms.core.utilites.business.BusinessEngine;
import kodlamaio.hrms.core.utilites.converters.DtoConverterService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private EmployerDao employerDao;
	private CityDao cityDao;
	private DtoConverterService dtoConverterService;
	private ModelMapper modelMapper;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, EmployerDao employerDao, CityDao cityDao,
			DtoConverterService dtoConverterService) {

		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerDao = employerDao;
		this.cityDao = cityDao;
		this.dtoConverterService = dtoConverterService;
		this.modelMapper = new ModelMapper();

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {

		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(), " -> Data Listelendi!");

	}

	@Override
	public Result add(JobAdvertisementDto jobAdvertisement) {

		Result engine = BusinessEngine.run(findEmployer(jobAdvertisement), findCity(jobAdvertisement),
				descriptionNullChecker(jobAdvertisement), ifMinSalaryNull(jobAdvertisement),
				ifMaxSalaryNull(jobAdvertisement), minSalaryChecker(jobAdvertisement),
				maxSalaryChecker(jobAdvertisement), ifMinSalaryEqualsMaxSalary(jobAdvertisement),
				ifQuotaSmallerThanOne(jobAdvertisement), appealExpirationChecker(jobAdvertisement));

		if (!engine.isSuccess()) {

			return new ErrorResult(engine.getMessage());

		}
		
		this.jobAdvertisementDao.save(
				(JobAdvertisement) dtoConverterService.dtoClassConverter(jobAdvertisement, JobAdvertisement.class));

		return new SuccessResult(" -> İşlem Başarılı Eklendi!");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getFilter(JobAdvertisement postByFilterDto, int pageNumber,
			int pageSize) {

		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);

		Specification<JobAdvertisement> spec1 = JobAdvertisementSpecification.jobAdsFilter(postByFilterDto);

		Page<JobAdvertisement> result = this.jobAdvertisementDao.findAll(spec1, pageable);

		List<JobAdvertisement> active = new ArrayList<>();

		for (JobAdvertisement post : result) {

			if (post.isActive() == true && post.isConfirmed() == true) {

				active.add(post);

			}
		}

		Type listType = new TypeToken<List<JobAdvertisement>>() {
		}.getType();

		List<JobAdvertisement> dto = modelMapper.map(active, listType);

		return new SuccessDataResult<List<JobAdvertisement>>(dto);

	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActive() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByIsActive(true),
				" -> İşlem Başarılı!");

	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActiveSorted() {

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findAllByIsActiveOrderByCreatedDateDesc(true), " -> İşlem Başarılı!");

	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActiveAndCompanyName(int id) {

		if (!this.employerDao.existsById(id)) {

			return new ErrorDataResult(" -> İş Veren Sistemde Bulunamadı Lütfen Tekrar Deneyiniz!");

		} else {

			return new SuccessDataResult<List<JobAdvertisement>>(
					this.jobAdvertisementDao.getEmployersActiveJobAdvertisement(id), " -> İşlem Başarılı!");

		}

	}

	@Override
	public DataResult<JobAdvertisement> setJobAdvertisementDisabled(int id) {

		if (!this.jobAdvertisementDao.existsById(id)) {

			return new ErrorDataResult(" -> İş Veren Sistemde Bulunamadı Lütfen Tekrar Deneyiniz!");

		}

		JobAdvertisement ref = this.jobAdvertisementDao.getOne(id);

		ref.setActive(false);

		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(ref),
				" -> İş İlanı Sistemde Pasif Olarak Ayarlandı!");

	}

	private Result findEmployer(JobAdvertisementDto jobAdvertisement) {

		if (!this.employerDao.existsById(jobAdvertisement.getEmployerId())) {

			return new ErrorResult(" -> İş Veren Sistemde Bulunamadı Lütfen Tekrar Deneyiniz!");

		}

		return new SuccessResult();

	}

	private Result findCity(JobAdvertisementDto jobAdvertisement) {

		if (!this.cityDao.existsById(jobAdvertisement.getCityId())) {

			return new ErrorResult(" -> İstenen Şehir Bilgisi Sistemde Bulunamadı Lütfen Tekrar Deneyiniz!");

		}

		return new SuccessResult();

	}

	private Result descriptionNullChecker(JobAdvertisementDto jobAdvertisement) {

		if (jobAdvertisement.getDescription().isEmpty()) {

			return new ErrorResult(" -> İş Tanımı Alanı Boş Bırakılamaz Lütfen Tekrar Deneyiniz!");

		}

		return new SuccessResult();

	}

	private Result ifMinSalaryNull(JobAdvertisementDto jobAdvertisement) {

		if (jobAdvertisement.getMinSalary() == null) {

			return new ErrorResult(" -> Minimum Maaş Girilmek Zorundadır!");

		}

		return new SuccessResult();

	}

	private Result ifMaxSalaryNull(JobAdvertisementDto jobAdvertisement) {

		if (jobAdvertisement.getMaxSalary() == null) {

			return new ErrorResult(" -> Maksimum Maaş Girilmek Zorundadır!");

		}

		return new SuccessResult();

	}

	private Result minSalaryChecker(JobAdvertisementDto jobAdvertisement) {

		if (jobAdvertisement.getMinSalary() == 0) {

			return new ErrorResult(" -> Minimum Maaş Alanına Sıfır Değeri Verilemez!");

		}

		return new SuccessResult();

	}

	private Result maxSalaryChecker(JobAdvertisementDto jobAdvertisement) {

		if (jobAdvertisement.getMaxSalary() == 0) {

			return new ErrorResult(" -> Maksimum Maaş Alanına Sıfır Değeri Verilemez!");

		}

		return new SuccessResult();

	}

	private Result ifMinSalaryEqualsMaxSalary(JobAdvertisementDto jobAdvertisement) {

		if (jobAdvertisement.getMinSalary() >= jobAdvertisement.getMaxSalary()) {

			return new ErrorResult(" -> Minimum Maaş Değeri Maksimum Maaş Değerine Eşit Olamaz!");

		}

		return new SuccessResult();

	}

	private Result ifQuotaSmallerThanOne(JobAdvertisementDto jobAdvertisement) {

		if (jobAdvertisement.getQuota() < 1) {

			return new ErrorResult(" -> Açık Pozisyon Adedi Birden Küçük Olamaz!");

		}

		return new SuccessResult();

	}

	private Result appealExpirationChecker(JobAdvertisementDto jobAdvertisement) {

		if (jobAdvertisement.getAppealExpirationDate() == null) {

			return new ErrorResult(" -> Son Başvuru Tarihi Girilmek Zorundadır!");

		}

		return new SuccessResult();

	}

	@Override
	public DataResult<List<JobAdvertisement>> getConfirmedJobAdvertisements() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getConfirmedJobAdvertisements(),
				" -> Onaylanmış İş İlanları Sistemden Başarıyla Listelendi!");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getWaitingJobAdvertisements() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getWaitingJobAdvertisements(),
				" -> Onaylanmış İş İlanları Sistemden Başarıyla Listelendi!");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getOneJobAds(int id) {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getOneById(id),
				" -> İş İlani Detayı Sistemden Başarıyla Geldi!");

	}

	@Override
	public Result confirmJobAd(int id) {

		if (this.jobAdvertisementDao.existsById(id)) {

			JobAdvertisement ref = this.jobAdvertisementDao.getOne(id);

			ref.setConfirmed(true);

			jobAdvertisementDao.save(ref);

			return new SuccessResult(" -> Başarılı Şekilde İş İlanı Hrms Personeli Tarafından Onaylandı!");

		}

		return new ErrorResult(" -> İş İlanı Sistemde Bulunamadı Lütfen Tekrar Deneyiniz!");

	}

	@Override
	public DataResult<List<JobAdvertisement>> getConfirmedJobAdvertisementsWithPageable(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getConfirmedJobAdvertisements(pageable));

	}

}
