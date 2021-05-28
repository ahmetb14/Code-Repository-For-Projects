package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmailVerifyService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilites.IdentityValidation;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.EmailVerify;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class CandidateManager implements CandidateService {

	@Autowired
	private CandidateDao candidateDao;
	private EmailVerifyService emailVerificationService;
	private UserService userService;

	public CandidateManager(CandidateDao candidateDao, EmailVerifyService emailVerificationService,
			UserService userService) {

		super();
		this.candidateDao = candidateDao;
		this.emailVerificationService = emailVerificationService;
		this.userService = userService;

	}

	@Override
	public DataResult<Candidate> add(Candidate candidate) {

		if (!firstNameChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null, " -> Ad Alanı Boş Bırakılamaz!");
		} else if (!lastNameChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null, " -> Soyad Alanı Boş Bırakılamaz!");
		}

		else if (!IdentityValidation.isRealPerson(candidate.getIdentificationNumber())) {
			return new ErrorDataResult<Candidate>(null, " -> TC Kimlik Numarası Doğrulanmadı, Tekrar Deneyin!");
		} else if (candidate.getIdentificationNumber().isBlank()) {
			return new ErrorDataResult<Candidate>(null, " -> TC Kimlik Numarası Alanı Boş Bırakılamaz!");
		}

		else if (!birthDateChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null, " -> Doğum Tarihi Alanı Boş Bırakılamaz!");
		}

		else if (!emailNullChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null, " -> Email Alanı Boş Bırakılamaz!");
		} else if (!isRealEmail(candidate)) {
			return new ErrorDataResult<Candidate>(null, " -> Girilen Email Adresi Doğru Değildir!");
		}

		else if (!passwordNullChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null, " -> Şifre Alanı Boş Bırakılamaz!");
		}

		else if (candidateDao.findAllByEmail(candidate.getEmail()).stream().count() != 0) {
			return new ErrorDataResult<Candidate>(null, " -> Bu Email Adresi Sistemde Zaten Mevcut!");
		} else if (candidateDao.findAllByIdentificationNumber(candidate.getIdentificationNumber()).stream()
				.count() != 0) {
			return new ErrorDataResult<Candidate>(null, " -> Bu TC Kimlik Numarası Sistemde Zaten Mevcut!");
		}
		User savedUser = this.userService.add(candidate);
		this.emailVerificationService.generateCode(new EmailVerify(), savedUser.getId());
		return new SuccessDataResult<Candidate>(this.candidateDao.save(candidate),
				" -> İş Arayan Hesabı Eklendi! Doğrulama Kodu Gönderildi: " + candidate.getId());

	}

	private boolean firstNameChecker(Candidate candidate) {
		
		if (candidate.getFirstName().isBlank() || candidate.getFirstName().equals(null)) {
			return false;
		}
		return true;
		
	}

	private boolean lastNameChecker(Candidate candidate) {
		
		if (candidate.getLastName().isBlank() || candidate.getLastName().equals(null)) {
			return false;
		}
		return true;
		
	}

	private boolean birthDateChecker(Candidate candidate) {
		
		if (candidate.getBirthDate().equals(null)) {
			return false;
		}
		return true;
		
	}

	private boolean emailNullChecker(Candidate candidate) {
		
		if (candidate.getEmail().isBlank() || candidate.getEmail().equals(null)) {
			return false;
		}
		return true;
		
	}

	private boolean passwordNullChecker(Candidate candidate) {
		
		if (candidate.getPassword().isBlank() || candidate.getPassword().equals(null)) {
			return false;
		}
		return true;
		
	}

	private boolean isRealEmail(Candidate candidate) {
		
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(candidate.getEmail());
		if (!matcher.matches()) {
			return false;
		}
		return true;

	}

	@Override
	public List<Candidate> getAll() {

		return this.candidateDao.findAll();
		
	}

	private boolean firstNameValid(Candidate candidate) {
		
		if (candidate.getFirstName().isBlank() || candidate.getFirstName().equals(null)) {
			return false;
		}
		return true;
		
	}

	private boolean lastNameValid(Candidate candidate) {
		
		if (candidate.getLastName().isBlank() || candidate.getLastName().equals(null)) {
			return false;
		}
		return true;
		
	}

	private boolean birthDateValid(Candidate candidate) {
		
		if (candidate.getBirthDate().equals(null)) {
			return false;
		}
		return true;
		
	}

	private boolean emailNullValid(Candidate candidate) {
		
		if (candidate.getEmail().isBlank() || candidate.getEmail().equals(null)) {
			return false;
		}
		return true;
		
	}

	private boolean passwordNullValid(Candidate candidate) {
		
		if (candidate.getPassword().isBlank() || candidate.getPassword().equals(null)) {
			return false;
		}
		return true;
		
	}

}
