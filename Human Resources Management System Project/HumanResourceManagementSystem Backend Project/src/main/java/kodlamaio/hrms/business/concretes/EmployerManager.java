package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailVerifyService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;

import kodlamaio.hrms.core.utilites.business.BusinessEngine;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.ErrorResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;

import kodlamaio.hrms.entities.concretes.EmailVerify;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailVerifyService emailVerificationService;
	private UserService userService;

	public EmployerManager(EmployerDao employerDao, EmailVerifyService emailVerificationService,
			UserService userService) {

		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.userService = userService;

	}

	@Override
	public DataResult<Employer> add(Employer employer) {

		Result engine = BusinessEngine.run(companyNameChecker(employer), webSiteChecker(employer),
				passwordNullChecker(employer), isRealEmployer(employer), isRealPhoneNumber(employer),
				isEmailAlreadyRegistered(employer));

		if (!engine.isSuccess()) {

			return new ErrorDataResult(null, engine.getMessage());

		}

		User savedUser = this.userService.add(employer);

		this.emailVerificationService.generateCode(new EmailVerify(), savedUser.getId());

		return new SuccessDataResult<Employer>(this.employerDao.save(employer),
				" -> İş Veren Hesabı Başarıyla Sisteme Eklendi Doğrulama Kodu Gönderildi ID: " + employer.getId());

	}

	private Result companyNameChecker(Employer employer) {

		if (employer.getCompanyName().isBlank() || employer.getCompanyName() == null) {

			return new ErrorResult(" -> Şirket Adı Alanını Doldurmak Zorunludur Lütfen Tekrar Deneyiniz!");

		}

		return new SuccessResult();

	}

	private Result webSiteChecker(Employer employer) {

		if (employer.getWebAdress().isBlank() || employer.getWebAdress() == null) {

			return new ErrorResult(" -> Web Site Adresi Doldurmak Zorunludur Lütfen Tekrar Deneyiniz!");

		}

		return new SuccessResult();

	}

	private Result isRealEmployer(Employer employer) {

		String regex = "^(.+)@(.+)$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(employer.getEmail());

		if (!matcher.matches()) {

			return new ErrorResult(" -> Girilen Email Adresi Sistemde Zaten Kayıtlı Lütfen Tekrar Deneyiniz!");

		} else if (!employer.getEmail().contains(employer.getWebAdress())) {

			return new ErrorResult(" -> Domain Adresi Girmek Zorunludur Lütfen Tekrar Deneyiniz!");

		}

		return new SuccessResult();

	}

	private Result isEmailAlreadyRegistered(Employer employer) {

		if (employerDao.findAllByEmail(employer.getEmail()).stream().count() != 0) {

			return new ErrorResult(" -> Girilen Email Adresi Sistemde Zaten Kayıtlı Lütfen Tekrar Deneyiniz!");

		}

		return new SuccessResult();

	}

	private Result passwordNullChecker(Employer employer) {

		if (employer.getPassword().isBlank() || employer.getPassword() == null) {

			return new ErrorResult(" -> Şifre Bilgisi Alanını Doldurmak Zorunludur Lütfen Tekrar Deneyiniz!");

		}

		return new SuccessResult();

	}

	private Result isRealPhoneNumber(Employer employer) {

		String patterns = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

		Pattern pattern = Pattern.compile(patterns);

		Matcher matcher = pattern.matcher(employer.getPhoneNumber());

		if (!matcher.matches()) {

			return new ErrorResult(" -> Geçersiz Telefon Numarası Lütfen Tekrar Deneyiniz!");

		}

		return new SuccessResult();

	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),
				" -> İş Verenler Sistemden Başarıyla Listelendi!");

	}

	@Override
	public Employer findByEmployerId(int id) {

		return this.employerDao.findById(id);

	}

	@Override
	public Employer update(Employer employer) {

		return this.employerDao.save(employer);

	}

}
