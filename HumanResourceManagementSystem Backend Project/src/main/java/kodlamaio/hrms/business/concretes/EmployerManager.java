package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailVerifyService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.EmailVerify;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailVerifyService emaiVerifyService;
	private UserService userService;

	public EmployerManager(EmployerDao employerDao, EmailVerifyService emailVerifyService, UserService userService) {

		super();
		this.employerDao = employerDao;
		this.emaiVerifyService = emailVerifyService;
		this.userService = userService;

	}

	@Override
	public DataResult<Employer> add(Employer employer) {

		if (!companyNameValid(employer)) {
			return new ErrorDataResult<Employer>(null, " -> Şirket Adı Alanı Boş Bırakılamaz!");
		} else if (!webSiteValid(employer)) {
			return new ErrorDataResult<Employer>(null, " -> WebSite Adresi Alanı Boş Bırakılamaz!");
		} else if (!isRealEmployer(employer)) {
			return new ErrorDataResult<Employer>(null, " -> Geçersiz Email Adresi, Lütfen Tekrar Deneyin!");
		} else if (!passwordNullValid(employer)) {
			return new ErrorDataResult<Employer>(null, " -> Şifre Alanı Boş Bırakılamaz!");

		} else if (!isRealPhoneNumber(employer)) {
			return new ErrorDataResult<Employer>(null, " -> Geçersiz Telefon Numarası Lütfen Tekrar Deneyin!");

		} else if (!isEmailAlreadyRegistered(employer)) {
			return new ErrorDataResult<Employer>(null, " -> Bu Email Adresi Sistemde Zaten Mevcut, Tekrar Deneyin!");
		}

		User savedUser = this.userService.add(employer);
		this.emaiVerifyService.generateCode(new EmailVerify(), savedUser.getId());
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),
				" -> İş Veren Hesabı Eklendi! Doğrulama Kodu Gönderildi: " + employer.getId());

	}

	private boolean companyNameValid(Employer employer) {

		if (employer.getCompanyName().isBlank() || employer.getCompanyName() == null) {
			return false;
		}
		return true;

	}

	private boolean webSiteValid(Employer employer) {

		if (employer.getWebAdress().isBlank() || employer.getWebAdress() == null) {
			return false;
		}
		return true;

	}

	private boolean isRealEmployer(Employer employer) {

		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(employer.getEmail());
		if (!matcher.matches()) {
			return false;
		} else if (!employer.getEmail().contains(employer.getWebAdress())) {
			return false;
		}
		return true;

	}

	private boolean isEmailAlreadyRegistered(Employer employer) {

		if (employerDao.findAllByEmail(employer.getEmail()).stream().count() != 0) {
			return false;
		}
		return true;

	}

	private boolean passwordNullValid(Employer employer) {

		if (employer.getPassword().isBlank() || employer.getPassword() == null) {
			return false;
		}
		return true;

	}

	private boolean isRealPhoneNumber(Employer employer) {

		String patterns = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

		Pattern pattern = Pattern.compile(patterns);
		Matcher matcher = pattern.matcher(employer.getPhoneNumber());
		if (!matcher.matches()) {
			return false;
		}
		return true;

	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),
				" İş Verenler Listesi Sistemden Listelendi!");
	}

}
