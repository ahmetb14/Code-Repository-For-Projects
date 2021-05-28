package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailVerifyService;
import kodlamaio.hrms.core.utilites.GenerateRandomCode;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmailVerifyDao;
import kodlamaio.hrms.entities.concretes.EmailVerify;

@Service
public class EmailVerifyManager implements EmailVerifyService {

	private EmailVerifyDao emailVerifyDao;

	@Autowired
	public EmailVerifyManager(EmailVerifyDao emailVerifyDao) {

		super();
		this.emailVerifyDao = emailVerifyDao;

	}

	@Override
	public Result verify(String verificationCode, Integer id) {

		EmailVerify ref = emailVerifyDao.findByUserId(id).get();

		if (ref.getCode().equals(verificationCode)) {
			ref.setVerified(true);
			return new SuccessDataResult<EmailVerify>(this.emailVerifyDao.save(ref),
					" -> Doğrulama Kodu Geçerli, İşlem Başarılı!");
		}

		return new ErrorDataResult<EmailVerify>(null,
				" -> Doğrulama Kodu Geçersiz, İşlem Başarısız Lütfen Tekrar Deneyin!");

	}

	@Override
	public void generateCode(EmailVerify code, Integer id) {

		EmailVerify code_ = code;
		code.setCode(null);
		code.setVerified(false);
		if (code.isVerified() == false) {
			GenerateRandomCode generator = new GenerateRandomCode();
			String code_create = generator.Create(id);
			code.setCode(code_create);
			code.setUserId(id);

			emailVerifyDao.save(code);

		}

		return;

	}

}
