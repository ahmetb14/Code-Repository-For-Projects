package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.EmailVerify;

public interface EmailVerifyService {

	void generateCode(EmailVerify code, Integer id);

	Result verify(String verificationCode, Integer id);

}
