package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	@Autowired
	private UserDao userDao;

	public UserManager() {

	}

	@Override
	public DataResult<List<User>> getAll() {

		return new SuccessDataResult<List<User>>(userDao.findAll(), " -> Kullanıcılar Sistemden Başarıyla Listelendi!");

	}

	@Override
	public User add(User user) {

		return this.userDao.save(user);

	}

}
