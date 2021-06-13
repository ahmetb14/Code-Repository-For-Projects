package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemUserService;
import kodlamaio.hrms.business.constants.CallbackMessages;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemUserDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.SystemUser;
import kodlamaio.hrms.entities.dtos.SystemUserDto;

@Service
public class SystemUserManager implements SystemUserService {

	private SystemUserDao systemUserDao;
	private UserDao userDao;

	@Autowired
	public SystemUserManager(SystemUserDao systemUserDao, UserDao userDao) {

		super();
		this.systemUserDao = systemUserDao;
		this.userDao = userDao;

	}

	@Override
	public DataResult<List<SystemUserDto>> getAll() {

		return new SuccessDataResult<List<SystemUserDto>>(this.systemUserDao.getSystemUsers(),
				" -> Sistem Kullanıcıları Sistemden Başarıyla Listelendi!");

	}

	@Override
	public DataResult<SystemUser> add(SystemUser systemUser) {

		if (userDao.existsById(systemUser.getUser().getId())) {

			return new SuccessDataResult<SystemUser>(this.systemUserDao.save(systemUser),
					CallbackMessages.systemUser);

		}

		return new ErrorDataResult<>(" -> İstenen Kullanıcı Sistemde Bulunamadı Lütfen Tekrar Deneyiniz!");

	}

}
